Feature: Atualização parcial de usuários

  Scenario: Atualizar parcialmente um usuario
    When eu envio uma requisicao PATCH para "/users/2"
    Then o sistema deve retornar status 200 e um campo updatedAt no Patch
