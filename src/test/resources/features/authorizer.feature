# language: pt
  @Authorizer
  Funcionalidade: Autorização de Débito online
    Para possibilitar o uso de uma solução para autorizar operações de débito para instituições financeiras
    Como um usuário do sistema
    Quero gerenciar de forma online os débitos feitos no comércio utilizando o cartão de débito
  Cenário: Débito online com sucesso
    Dado que tenho cartao de debito ativo com conta corrente ativa com saldo "200,00"
    Quando executo um lancamento de “50,00”
    Então obtenho o retorno “AUTHORIZED”
    E verifico o saldo atualizado “150,00”