# language: pt
  Funcionalidade: Autorização de Débito online
    Para possibilitar o uso de uma solução para autorizar operações de débito para instituições financeiras
    Como um usuário do sistema
    Quero gerenciar de forma online os débitos feitos no comércio utilizando o cartão de débito
  @Sucesso
  Cenário: Débito online com sucesso
    Dado que tenho cartão de débito ativo
    E tenho conta corrente ativa com saldo "200,00"
    Quando executo um lançamento de “50,00”
    Então obtenho o retorno “Autorizado”
    E verifico o saldo atualizado “150,00”