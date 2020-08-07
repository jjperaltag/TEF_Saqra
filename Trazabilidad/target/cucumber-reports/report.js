$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("Agendamiento.feature");
formatter.feature({
  "line": 1,
  "name": "El usuario puede agendar y reagendar la visita de Tecnico",
  "description": "",
  "id": "el-usuario-puede-agendar-y-reagendar-la-visita-de-tecnico",
  "keyword": "Feature"
});
formatter.scenarioOutline({
  "line": 5,
  "name": "Como Usuario Activo, me logueo al sistema y programo un reagendamiento",
  "description": "",
  "id": "el-usuario-puede-agendar-y-reagendar-la-visita-de-tecnico;como-usuario-activo,-me-logueo-al-sistema-y-programo-un-reagendamiento",
  "type": "scenario_outline",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 4,
      "name": "@SmokeTest"
    }
  ]
});
formatter.step({
  "line": 6,
  "name": "Me logue con mi SMS y ubico mi cita para reagendar \"\u003cId_Reagendar\u003e\"",
  "keyword": "Given "
});
formatter.step({
  "line": 7,
  "name": "Reagendo pedido de visita, al dia siguiente. \"\u003cId_Reagendar\u003e\"",
  "keyword": "When "
});
formatter.step({
  "line": 8,
  "name": "Se reprograma la visita en fecha seleccionada \"\u003cId_Reagendar\u003e\"",
  "keyword": "Then "
});
formatter.examples({
  "line": 9,
  "name": "",
  "description": "",
  "id": "el-usuario-puede-agendar-y-reagendar-la-visita-de-tecnico;como-usuario-activo,-me-logueo-al-sistema-y-programo-un-reagendamiento;",
  "rows": [
    {
      "cells": [
        "Id_Reagendar"
      ],
      "line": 10,
      "id": "el-usuario-puede-agendar-y-reagendar-la-visita-de-tecnico;como-usuario-activo,-me-logueo-al-sistema-y-programo-un-reagendamiento;;1"
    },
    {
      "cells": [
        "1"
      ],
      "line": 11,
      "id": "el-usuario-puede-agendar-y-reagendar-la-visita-de-tecnico;como-usuario-activo,-me-logueo-al-sistema-y-programo-un-reagendamiento;;2"
    }
  ],
  "keyword": "Examples"
});
formatter.scenario({
  "line": 11,
  "name": "Como Usuario Activo, me logueo al sistema y programo un reagendamiento",
  "description": "",
  "id": "el-usuario-puede-agendar-y-reagendar-la-visita-de-tecnico;como-usuario-activo,-me-logueo-al-sistema-y-programo-un-reagendamiento;;2",
  "type": "scenario",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 4,
      "name": "@SmokeTest"
    }
  ]
});
formatter.step({
  "line": 6,
  "name": "Me logue con mi SMS y ubico mi cita para reagendar \"1\"",
  "matchedColumns": [
    0
  ],
  "keyword": "Given "
});
formatter.step({
  "line": 7,
  "name": "Reagendo pedido de visita, al dia siguiente. \"1\"",
  "matchedColumns": [
    0
  ],
  "keyword": "When "
});
formatter.step({
  "line": 8,
  "name": "Se reprograma la visita en fecha seleccionada \"1\"",
  "matchedColumns": [
    0
  ],
  "keyword": "Then "
});
formatter.match({
  "arguments": [
    {
      "val": "1",
      "offset": 52
    }
  ],
  "location": "Steps.meLogueConMiSMSYUbicoMiCitaParaReagendar(int)"
});
