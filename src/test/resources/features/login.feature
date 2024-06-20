# language: es
# Test Automation backend for Tyba
# Summary: This feature contains test cases for rest api
# EP Authentication is deployed in https://reqres.in/

Característica: Autenticación en el sitio reqres por restapi

  Escenario: Autenticacion correcta
    Dado que "Andres" desea loguearse en reqres
    Cuando ingresa el email y contrasenia correcta
    Entonces verifica que el usuario se autentica correctamente

  Escenario: Autenticacion incorrecta
    Dado que "Andres" desea loguearse en reqres
    Cuando ingresa el email y contrasenia incorrecta
    Entonces verifica que el usuario no se autentica correctamente