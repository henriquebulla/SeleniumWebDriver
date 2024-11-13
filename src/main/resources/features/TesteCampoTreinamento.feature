Feature: Teste de campos do formulário

  Scenario: Teste do campo de texto
    Given que o formulário foi aberto
    When eu preencho o campo de nome com "Henrique" e o sobrenome com "Rezende Bulla"
    Then o campo de nome deve conter "Henrique"
    And o campo de sobrenome deve conter "Rezende Bulla"

  Scenario: Teste do campo de texto para área de sugestões
    Given que o formulário foi aberto
    When eu preencho o campo de sugestões com "Henrique\nRezende\nBulla"
    Then o campo de sugestões deve conter "Henrique\nRezende\nBulla"

  Scenario: Teste do botão de rádio
    Given que o formulário foi aberto
    When eu seleciono o rádio do sexo
    Then o botão de rádio para sexo deve estar selecionado

  Scenario: Teste do checkbox
    Given que o formulário foi aberto
    When eu seleciono o checkbox de comida favorita
    Then o checkbox deve estar selecionado

  Scenario: Teste do combo box de escolaridade
    Given que o formulário foi aberto
    When eu seleciono a escolaridade como "Mestrado"
    Then o combo box de escolaridade deve estar com "Mestrado"

  Scenario: Verificar valores do combo box
    Given que o formulário foi aberto
    Then o combo box de escolaridade deve conter 8 opções
    And o combo box de escolaridade deve conter a opção "Mestrado"

  Scenario: Verificar seleção múltipla do combo de esportes
    Given que o formulário foi aberto
    When eu seleciono os esportes "Natacao", "Corrida" e "O que eh esporte?"
    Then os esportes selecionados devem conter "Natacao", "Corrida", e "O que eh esporte?"

  Scenario: Interagir com botões
    Given que o formulário foi aberto
    When eu clico no botão simples
    Then o botão deve conter o texto "Obrigado!"

  Scenario: Buscar texto na página
    Given que o formulário foi aberto
    Then o título da página deve ser "Campo de Treinamento"
    And o texto da página deve conter "Cuidado onde clica, muitas armadilhas..."
