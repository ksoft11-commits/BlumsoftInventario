# Blumsoft - Modulo de Inventario

## Descripcion
Blumsoft es un proyecto de software orientado a la gestion de productos de un inventario. Este modulo permite registrar, consultar, actualizar y eliminar productos mediante una conexion con una base de datos MySQL.

## Tecnologias utilizadas
- Java JDK 21.
- MySQL.
- MySQL Connector/J.
- JDBC.
- Visual Studio Code.

## Estructura del proyecto
- src: contiene el codigo fuente.
- conexion: establece la conexion con MySQL.
- modelo: contiene la clase Producto.
- dao: contiene las operaciones CRUD.
- principal: contiene el menu principal del programa.
- database: contiene el script SQL.
- lib: contiene el controlador MySQL Connector/J.

## Funcionalidades
1. Registrar productos.
2. Consultar productos.
3. Actualizar productos.
4. Eliminar productos.

## Base de datos
La base de datos se llama blumsoft_inventario y contiene la tabla producto, con los campos:
- id_producto
- nombre
- descripcion
- precio
- stock

Para crear la base de datos, ejecutar el archivo database/blumsoft.sql desde MySQL Workbench.

## Ejecucion del proyecto
1. Instalar Java JDK 21.
2. Instalar y ejecutar MySQL Server.
3. Crear la base de datos utilizando el script SQL ubicado en database/blumsoft.sql.
4. Configurar las variables de entorno BLUMSOFT_DB_USER y BLUMSOFT_DB_PASSWORD con las credenciales de MySQL.
5. Abrir la carpeta del proyecto en Visual Studio Code.
6. Compilar las clases Java.
7. Ejecutar la clase Main.

## Pruebas realizadas
Se verifico el funcionamiento de las cuatro operaciones CRUD y la conexion con MySQL mediante JDBC.