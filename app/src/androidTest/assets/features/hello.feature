Feature: Hello World

  Scenario: Encontrandonos en Hello mostramos mensaje Hello

    Given encontrandonos en pantalla Hello
    And ocultaremos mensaje de pantalla
    And mostraremos botones Say Hello y Go Bye activados
    When al pulsar boton Say Hello
    Then mostramos mensaje de pantalla Hello World
    And mostramos botones Say Hello y Go Bye activados


  Scenario: Pasar a Bye sin mostrar mensaje en Hello y Bye

    Given  encontrandonos en pantalla Hello
    And ocultaremos mensaje de pantalla
    And mostraremos botones Say Hello y Go Bye activados
    When al pulsar boton Go Bye
    Then iniciamos pantalla Bye
    And ocultamos mensaje de pantalla
    And mostramos botones Say Bye y Go Hello activados

  Scenario: Pasar a Bye mostrando mensaje Hello en Hello y Bye

    Given  encontrandonos en pantalla Hello
    And mostraremos mensaje de pantalla Hello World
    And mostraremos botones Say Hello y Go Bye activados
    When al pulsar boton Go Bye
    Then iniciamos pantalla Bye
    And mostramos mensaje de pantalla Hello World
    And mostramos botones Say Bye y Go Hello activados


  Scenario: Encontrandonos en Bye retornar a Hello sin mostrar mensaje en Hello y Bye

    Given encontrandonos en pantalla Bye
    And ocultaremos mensaje de pantalla
    And mostraremos botones Say Bye y Go Hello activados
    When al pulsar botones Go Hello o Back
    Then finalizamos pantalla Bye
    And resumimos pantalla Hello
    And ocultamos mensaje de pantalla
    And mostramos botones Say Hello y Go Bye activados

  Scenario: Pasar a Bye mostrando mensaje Hello en Hello y retornar a Hello sin mostrar mensaje en Bye y Hello

    Given encontrandonos en pantalla Bye mientras mostramos mensaje Hello World en pantalla Hello
    And ocultaremos mensaje de pantalla
    And mostraremos botones Say Bye y Go Hello activados
    When al pulsar botones Go Hello
    Then finalizamos pantalla Bye
    And resumimos pantalla Hello
    And ocultamos mensaje de pantalla
    And mostramos botones Say Hello y Go Bye activados

  Scenario: Mostrando mensaje de Bye en Bye volver a Hello mostrando mensaje Hello

    Given encontrandonos en pantalla Bye
    And mostraremos mensaje de pantalla Bye World
    And mostraremos botones Say Bye y Go Hello activados
    When al pulsar boton  Back
    Then finalizamos pantalla Bye
    And resumimos pantalla Hello
    And mostramos mensaje de pantalla Hello World
    And mostramos botones Say Hello y Go Bye activados

  Scenario: Mostrando mensaje de Bye en Bye retornar a Hello mostrando mensaje Bye

    Given encontrandonos en pantalla Bye
    And mostraremos mensaje de pantalla Bye World
    And mostraremos botones Say Bye y Go Hello activados
    When al pulsar boton Go Hello
    Then finalizamos pantalla Bye
    And resumimos pantalla Hello
    And mostramos mensaje de pantalla Bye World
    And mostramos botones Say Hello y Go Bye activados

  Scenario: Encontrandonos en Bye mostramos mensaje Bye

    Given encontrandonos en pantalla Bye
    And ocultaremos mensaje de pantalla
    And mostraremos botones Say Bye y Go Hello activados
    When al pulsar boton Say Bye
    Then mostramos mensaje de pantalla Bye World
    And mostramos botones Say Bye y Go Hello activados

  Scenario: Encontrandonos en Bye mostrando Hello mostramos mensaje Bye

    Given encontrandonos en pantalla Bye
    And mostraremos mensaje de pantalla Hello World
    And mostraremos botones Say Bye y Go Hello activados
    When al pulsar boton Say Bye
    Then mostramos mensaje de pantalla Bye World
    And mostramos botones Say Bye y Go Hello activados

  Scenario: Encontrandonos en Hello mostrando Bye mostramos mensaje Hello

    Given encontrandonos en pantalla Hello
    And mostraremos mensaje de pantalla Bye World
    And mostraremos botones Say Hello y Go Bye activados
    When al pulsar boton Say Hello
    Then mostramos mensaje de pantalla Hello World
    And mostramos botones Say Hello y Go Bye activados
