#language: pt
#Author: Hilario Bina
#Version: 1.0
#Encoding: UTF-8
@Movimentacao
@Teste
Funcionalidade: Movimentacao

  @Teste4
  Cenario: 04 - Inserir Movimentacao com Sucesso
    Dado que estou logado no site do Senhor Barriga
    Quando insiro uma movimentacao
    Entao deve ser retornardo o valor "201"
    
  @Teste5
  Cenario: 05 - validar campo Data Transação Obrigatorio
    Dado que estou logado no site do Senhor Barriga
    Quando insiro uma movimentacao sem o campo Data Transacao
    Entao deve ser retornardo a mensagem "Data da Movimentação é obrigatório"  