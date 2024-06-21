# language: es
# Test Automation backend for Tyba

Característica: Creacion de usuario en el sitio reqres por restapi

  Escenario: Creacion correcta
    Dado que "Andres" desea crear un usuario en reqres
    Cuando ingresa el email y contrasenia para el nuevo usuario
    Entonces verifica que el usuario se ha creado correctamente

  Escenario: Creacion incorrecta
    Dado que "Andres" desea crear un usuario en reqres
    Cuando ingresa solo el email para el nuevo usuario
    Entonces verifica que el usuario no se ha creado