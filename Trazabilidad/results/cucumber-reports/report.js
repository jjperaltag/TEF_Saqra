$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("src/test/resources/feature/ValidacionAcceso.feature");
formatter.feature({
  "line": 1,
  "name": "Iniciar Sesion en el sistema",
  "description": "",
  "id": "iniciar-sesion-en-el-sistema",
  "keyword": "Feature"
});
formatter.scenarioOutline({
  "line": 4,
  "name": "Como Cliente Activo, me logueo al sistema",
  "description": "",
  "id": "iniciar-sesion-en-el-sistema;como-cliente-activo,-me-logueo-al-sistema",
  "type": "scenario_outline",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 3,
      "name": "@SmokeTest"
    }
  ]
});
formatter.step({
  "line": 5,
  "name": "Soy Cliente e ingreso al sistema \"\u003cId_ValidarAcceso\u003e\"",
  "keyword": "Given "
});
formatter.step({
  "line": 6,
  "name": "Hacemos login seleccionando el tipo_documento y numero_documento \"\u003cId_ValidarAcceso\u003e\"",
  "keyword": "When "
});
formatter.step({
  "line": 7,
  "name": "El inicio de sesión es exitoso \"\u003cId_ValidarAcceso\u003e\"",
  "keyword": "Then "
});
formatter.examples({
  "line": 8,
  "name": "",
  "description": "",
  "id": "iniciar-sesion-en-el-sistema;como-cliente-activo,-me-logueo-al-sistema;",
  "rows": [
    {
      "cells": [
        "Id_ValidarAcceso"
      ],
      "line": 9,
      "id": "iniciar-sesion-en-el-sistema;como-cliente-activo,-me-logueo-al-sistema;;1"
    },
    {
      "cells": [
        "5"
      ],
      "line": 10,
      "id": "iniciar-sesion-en-el-sistema;como-cliente-activo,-me-logueo-al-sistema;;2"
    }
  ],
  "keyword": "Examples"
});
formatter.scenario({
  "line": 10,
  "name": "Como Cliente Activo, me logueo al sistema",
  "description": "",
  "id": "iniciar-sesion-en-el-sistema;como-cliente-activo,-me-logueo-al-sistema;;2",
  "type": "scenario",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 3,
      "name": "@SmokeTest"
    }
  ]
});
formatter.step({
  "line": 5,
  "name": "Soy Cliente e ingreso al sistema \"5\"",
  "matchedColumns": [
    0
  ],
  "keyword": "Given "
});
formatter.step({
  "line": 6,
  "name": "Hacemos login seleccionando el tipo_documento y numero_documento \"5\"",
  "matchedColumns": [
    0
  ],
  "keyword": "When "
});
formatter.step({
  "line": 7,
  "name": "El inicio de sesión es exitoso \"5\"",
  "matchedColumns": [
    0
  ],
  "keyword": "Then "
});
formatter.match({
  "arguments": [
    {
      "val": "5",
      "offset": 34
    }
  ],
  "location": "Steps.ingreso_al_sistema(int)"
});
formatter.result({
  "duration": 20346888700,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "5",
      "offset": 66
    }
  ],
  "location": "Steps.seleccion_tipo_documento_y_numero_documento(int)"
});
formatter.result({
  "duration": 22976592000,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "5",
      "offset": 32
    }
  ],
  "location": "Steps.inicio_de_sesion_es_exitoso(int)"
});
formatter.result({
  "duration": 12193642900,
  "status": "passed"
});
});