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
  Cenário: Débito online com conta sem saldo para a compra
    Dado que tenho cartao de debito ativo com conta corrente ativa com saldo "150,00"
    Quando executo um lancamento de “200,00”
    Então obtenho o retorno “NON AUTHORIZED”
    E verifico o saldo atualizado “150,00”
  Cenário: Débito online com cartão inativo
    Dado que tenho cartao de debito inativo com conta corrente ativa com saldo "150,00"
    Quando executo um lancamento de “100,00”
    Então obtenho o retorno “NON AUTHORIZED”
    E verifico o saldo atualizado “150,00”
  Cenário: Débito online com conta corrente não ativa
    Dado que tenho cartao de debito ativo com conta corrente inativa com saldo "0,00"
    Quando executo um lancamento de “100,00”
    Então obtenho o retorno “NON AUTHORIZED”
    E verifico o saldo atualizado “0,00”
