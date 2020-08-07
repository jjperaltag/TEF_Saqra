Feature: Iniciar Sesion en el sistema

  @SmokeTest
  Scenario Outline: Como Cliente Activo, me logueo al sistema
    Given Soy Cliente e ingreso al sistema "<Id_ValidarAcceso>"
    When Hacemos login seleccionando el tipo_documento y numero_documento "<Id_ValidarAcceso>"
    Then El inicio de sesión es exitoso "<Id_ValidarAcceso>"
    Examples:
      | Id_ValidarAcceso |
      |1|
