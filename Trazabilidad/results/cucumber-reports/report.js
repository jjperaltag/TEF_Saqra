$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("src/test/resources/feature/Agendamiento.feature");
formatter.feature({
  "line": 1,
  "name": "El usuario puede agendar la visita de Tecnico",
  "description": "",
  "id": "el-usuario-puede-agendar-la-visita-de-tecnico",
  "keyword": "Feature"
});
formatter.scenarioOutline({
  "line": 3,
  "name": "Como Usuario Activo, me logueo al sistema y programo un agendamiento",
  "description": "",
  "id": "el-usuario-puede-agendar-la-visita-de-tecnico;como-usuario-activo,-me-logueo-al-sistema-y-programo-un-agendamiento",
  "type": "scenario_outline",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 2,
      "name": "@SmokeTest"
    }
  ]
});
formatter.step({
  "comments": [
    {
      "line": 4,
      "value": "#Scenario Outline: Como Cliente Activo, me logueo al sistema"
    }
  ],
  "line": 5,
  "name": "Se ejecuta el servicio REST PENDIENTE, INGRESAR, INTOA \"\u003cId_Agendar\u003e\"",
  "keyword": "Given "
});
formatter.step({
  "line": 6,
  "name": "Soy Cliente e ingreso al sistema \"\u003cId_Agendar\u003e\"",
  "keyword": "And "
});
formatter.step({
  "line": 7,
  "name": "Hacemos login seleccionando el tipo_documento y numero_documento \"\u003cId_Agendar\u003e\"",
  "keyword": "When "
});
formatter.step({
  "comments": [
    {
      "line": 8,
      "value": "#Given Me logue con mi SMS y ubico mi \"\u003cId_Agendar\u003e\""
    }
  ],
  "line": 9,
  "name": "Agendo pedido de visita, en la fecha de hoy  y turno mañana, donde recibire al tecnico, en la direccion registrada. \"\u003cId_Agendar\u003e\"",
  "keyword": "When "
});
formatter.step({
  "line": 10,
  "name": "Se programa visita en fecha seleccionada \"\u003cId_Agendar\u003e\"",
  "keyword": "When "
});
formatter.step({
  "line": 11,
  "name": "Se confirma el agendamiento \"\u003cId_Agendar\u003e\"",
  "keyword": "Then "
});
formatter.examples({
  "line": 12,
  "name": "",
  "description": "",
  "id": "el-usuario-puede-agendar-la-visita-de-tecnico;como-usuario-activo,-me-logueo-al-sistema-y-programo-un-agendamiento;",
  "rows": [
    {
      "cells": [
        "Id_Agendar"
      ],
      "line": 13,
      "id": "el-usuario-puede-agendar-la-visita-de-tecnico;como-usuario-activo,-me-logueo-al-sistema-y-programo-un-agendamiento;;1"
    },
    {
      "cells": [
        "1"
      ],
      "line": 14,
      "id": "el-usuario-puede-agendar-la-visita-de-tecnico;como-usuario-activo,-me-logueo-al-sistema-y-programo-un-agendamiento;;2"
    }
  ],
  "keyword": "Examples"
});
formatter.scenario({
  "line": 14,
  "name": "Como Usuario Activo, me logueo al sistema y programo un agendamiento",
  "description": "",
  "id": "el-usuario-puede-agendar-la-visita-de-tecnico;como-usuario-activo,-me-logueo-al-sistema-y-programo-un-agendamiento;;2",
  "type": "scenario",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 2,
      "name": "@SmokeTest"
    }
  ]
});
formatter.step({
  "comments": [
    {
      "line": 4,
      "value": "#Scenario Outline: Como Cliente Activo, me logueo al sistema"
    }
  ],
  "line": 5,
  "name": "Se ejecuta el servicio REST PENDIENTE, INGRESAR, INTOA \"1\"",
  "matchedColumns": [
    0
  ],
  "keyword": "Given "
});
formatter.step({
  "line": 6,
  "name": "Soy Cliente e ingreso al sistema \"1\"",
  "matchedColumns": [
    0
  ],
  "keyword": "And "
});
formatter.step({
  "line": 7,
  "name": "Hacemos login seleccionando el tipo_documento y numero_documento \"1\"",
  "matchedColumns": [
    0
  ],
  "keyword": "When "
});
formatter.step({
  "comments": [
    {
      "line": 8,
      "value": "#Given Me logue con mi SMS y ubico mi \"\u003cId_Agendar\u003e\""
    }
  ],
  "line": 9,
  "name": "Agendo pedido de visita, en la fecha de hoy  y turno mañana, donde recibire al tecnico, en la direccion registrada. \"1\"",
  "matchedColumns": [
    0
  ],
  "keyword": "When "
});
formatter.step({
  "line": 10,
  "name": "Se programa visita en fecha seleccionada \"1\"",
  "matchedColumns": [
    0
  ],
  "keyword": "When "
});
formatter.step({
  "line": 11,
  "name": "Se confirma el agendamiento \"1\"",
  "matchedColumns": [
    0
  ],
  "keyword": "Then "
});
formatter.match({
  "arguments": [
    {
      "val": "1",
      "offset": 56
    }
  ],
  "location": "Steps.ejecuto_servicios_api(int)"
});
formatter.result({
  "duration": 18699926501,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "1",
      "offset": 34
    }
  ],
  "location": "Steps.ingreso_al_sistema(int)"
});
