Feature: Verificar que trazabilidad soporte a un usuario cuando este tenga mas de un producto

  @SmokeTest
  Scenario Outline: Como Cliente Activo, me logueo al sistema
    Given Soy Cliente e ingreso al sistema "<Id_Soporte>"
    When Hacemos login seleccionando el tipo_documento y numero_documento "<Id_Soporte>"
    When Validamos que tenga más de un producto "<Id_Soporte>"
    Then El inicio de sesión es exitoso "<Id_Soporte>"
    Examples:
      | Id_Soporte |
      |4|
