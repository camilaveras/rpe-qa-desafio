Feature: Listagem de usuários

  Scenario: Listar usuarios da pagina 2
    When eu envio uma requisicao GET para "/users?page=2"
    Then o sistema deve retornar status 200 e uma lista de usuarios
