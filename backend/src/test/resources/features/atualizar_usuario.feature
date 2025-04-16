Feature: Atualização completa de usuários

  Scenario: Atualizar completamente um usuario
    Given que desejo atualizar um usuario
    When eu envio uma requisicao PUT para "/users/2"
    Then o sistema deve retornar status 200 e um campo updatedAt no PUT
