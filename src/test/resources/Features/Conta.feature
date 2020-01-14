#language: pt
#Author: Hilario Bina
#Version: 1.0
#Encoding: UTF-8
@Teste
Funcionalidade: Conta

  @Teste1
  Cenario: 01 - Criar Nova Conta com Sucesso
    Dado que estou logado no site do Senhor Barriga
    Quando crio uma nova conta
    Entao deve ser retornardo o valor "201"
    
  @Teste2
  Cenario: 02 - Alterar Conta com sucesso
    Dado que estou logado no site do Senhor Barriga
    Quando altero uma conta ja criada
    Entao deve ser retornardo o valor "200"  
    
    