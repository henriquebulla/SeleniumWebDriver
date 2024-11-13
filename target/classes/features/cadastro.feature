Feature: Validação de alerta do formulário

  Scenario: Nome obrigatório
    Given que o formulário foi aberto
    When eu clico no botão de cadastrar
    Then devo ver o alerta "Nome eh obrigatorio"

  Scenario: Sobrenome obrigatório
    Given que o formulário foi aberto
    When eu preencho o nome e clico no botão de cadastrar
    Then devo ver o alerta "Sobrenome eh obrigatorio"

  Scenario: Gênero obrigatório
    Given que o formulário foi aberto
    When eu preencho o nome e o sobrenome e clico no botão de cadastrar
    Then devo ver o alerta "Sexo eh obrigatorio"

  Scenario: Validar vegetariano
    Given que o formulário foi aberto
    When eu preencho o nome, sobrenome e seleciono as opções de sexo e comida
    Then devo ver o alerta "Tem certeza que voce eh vegetariano?"
