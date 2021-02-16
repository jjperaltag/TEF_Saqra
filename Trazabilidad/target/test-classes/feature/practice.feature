Feature: Practice

  @SmokeTest
  Scenario Outline: Como Cliente Activo, me logueo al sistema
    Given Soy Cliente e ingreso al sistema "<Id_Practice>"
   When Hacemos login seleccionando el tipo_documento y numero_documento "<Id_Practice>"
    When entonces entonces "<Id_Practice>"
  Then Ejemplo "<Id_Practice>"

    Examples:
      | Id_Practice |
      |5|

