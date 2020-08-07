Feature: El usuario ingresa a la pagina de Back Office
  @SmokeTest
  Scenario Outline: Como Usuario Activo, me logueo al sistema de Back Office
    Given Me logue con mi DNI y mi password "<Id_BackOffice>"

    Examples:
      | Id_BackOffice |
      |  1 |