Feature: Criação de usuários

  Scenario: Criar um usuario com sucesso
    Given que desejo criar um novo usuario
    When eu envio uma requisicao POST para "/users"
    Then o sistema deve retornar status 201 e um ID criado
