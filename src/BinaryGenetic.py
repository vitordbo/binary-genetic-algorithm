import random as rd
import math as math
import matplotlib.pyplot as plt

def funcao(individuo):
  #aptidao
    valor = math.sqrt(individuo[0] ** 3 + 2 * individuo[1] ** 4)
    
    if(valor == 0):
        return -1
    
    return 1/valor

tupla = (1,0)
print(funcao(tupla))

def decimalParaBinario(decNumero):
    remstack = []

    if(decNumero == 0):
      return "000"
    while decNumero > 0:
        rem = decNumero % 2
        remstack.append(rem)
        decNumero = decNumero // 2

    binString = ""
    while len(remstack) != 0:
        binString = binString + str(remstack.pop())

    while(len(binString) < 3):
      binString = "0" + binString
      
    return binString

print(decimalParaBinario(6))

def binarioParaDecimal(numBinario): 
    
    binario = int(numBinario)
    
    decimal, i, n = 0, 0, 0
    while(binario != 0): 
        dec = binario % 10
        decimal = decimal + dec * pow(2, i) 
        binario = binario//10
        i += 1
    return decimal

print(binarioParaDecimal("100"))

def criarPopulacao(tamPopulacao):
    populacao = []
    for x in range(tamPopulacao):
        populacao.append((rd.randint(0,7),rd.randint(0,7)))

    return populacao

def selecao(populacao):
    selecionado = []

    sorteio = rd.sample(range(0, len(populacao)), len(populacao))
    cont = 0
    teste = 0
    while(teste != 2):
      temp = []

      for x in range(2):
        temp.append(populacao[sorteio[cont]])
        cont+=1


      if(temp[0][0] > temp[1][0]):
        selecionado.append(temp[0])
      else:
        selecionado.append(temp[1])



      teste+=1
        
    return selecionado

def cruzamento(selecionados):
    populacao = []
    populacao.append(selecionados[0][1])
    populacao.append(selecionados[1][1])

    corte = rd.randint(1,2)

    if(corte == 2):
        # primeiro par ordenado em binario
        x = decimalParaBinario(populacao[0][0])
        primeiraPartex = x[0:2]
        segundaPartex = x[2:3]

        y = decimalParaBinario(populacao[0][1])
        primeiraPartey = y[0:2]
        segundaPartey = y[2:3]

        # segundo par ordenado em binario
        x2 = decimalParaBinario(populacao[1][0])
        primeiraPartex2 = x2[0:2]
        segundaPartex2 = x2[2:3]

        y2 = decimalParaBinario(populacao[1][1])
        primeiraPartey2 = y2[0:2]
        segundaPartey2 = y2[2:3]

        # Fazendo Cruzameto X

        filho1 = (
            binarioParaDecimal(primeiraPartex + segundaPartex2), binarioParaDecimal(primeiraPartey + segundaPartey2))
        filho2 = (
            binarioParaDecimal(primeiraPartex2 + segundaPartex), binarioParaDecimal(primeiraPartey2 + segundaPartey))

        mutacao = rd.randint(0, 100)

        # ==================== Mutação =====================
        if (mutacao <= 2):
            filho1 = (filho1[0] >> 2, filho1[1] >> 2)
            filho2 = (filho2[0] >> 2, filho2[1] >> 2)

        populacao.append(filho1)
        populacao.append(filho2)

    else:
        # primeiro par ordenado em binario
        x = decimalParaBinario(populacao[0][0])
        primeiraPartex = x[0:1]
        segundaPartex = x[1:3]

        y = decimalParaBinario(populacao[0][1])
        primeiraPartey = y[0:1]
        segundaPartey = y[1:3]

        # segundo par ordenado em binario
        x2 = decimalParaBinario(populacao[1][0])
        primeiraPartex2 = x2[0:1]
        segundaPartex2 = x2[1:3]

        y2 = decimalParaBinario(populacao[1][1])
        primeiraPartey2 = y2[0:1]
        segundaPartey2 = y2[1:3]

        # Fazendo Cruzameto X

        filho1 = (
            binarioParaDecimal(primeiraPartex + segundaPartex2), binarioParaDecimal(primeiraPartey + segundaPartey2))
        filho2 = (
            binarioParaDecimal(primeiraPartex2 + segundaPartex), binarioParaDecimal(primeiraPartey2 + segundaPartey))

        mutacao = rd.randint(0, 100)

        # ==================== Mutação =====================
        if (mutacao <= 2):
            filho1 = (filho1[0] >> 2, filho1[1] >> 2)
            filho2 = (filho2[0] >> 2, filho2[1] >> 2)

        populacao.append(filho1)
        populacao.append(filho2)

    return populacao

plotgrafico = []
num = 0

def main(tamPopulacao):
    conteVezesRepetidas = 1
   
    MelhoresValoresEmCadaGeracao = []
    populacao = criarPopulacao(tamPopulacao)
    # verificar a populacao aplicado a funcao

    teste = False
    while(teste != True):
      resultadoV = []

      for individuo in populacao:
        resultadoV.append((funcao(individuo),individuo))
    
      resultadoV.sort()
      MelhoresValoresEmCadaGeracao.append(resultadoV[0][0])
      plotgrafico = MelhoresValoresEmCadaGeracao

      # Condicao de parada
      if (resultadoV[0][0] == -1):
        teste = True
        plt.plot(MelhoresValoresEmCadaGeracao)
        plt.title("Algoritmo Genetico")
        plt.show()


      # Mostrar interaçao e o resultado da geração
      print(f"Geração {conteVezesRepetidas}")
      print(resultadoV[0][0], " : ", resultadoV[0][1])


      selecionadosCruzamento = selecao(resultadoV)
      populacao = cruzamento(selecionadosCruzamento)
      conteVezesRepetidas+=1
      num = conteVezesRepetidas

main(4)