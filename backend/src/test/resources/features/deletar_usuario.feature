Feature: Remoção de usuários

  Scenario: Remover um usuario existente
    When eu envio uma requisicao DELETE para "/users/2"
    Then o sistema deve retornar status 204
