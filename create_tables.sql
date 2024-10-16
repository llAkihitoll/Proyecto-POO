--Archivo de conexion de base de datos MYSQL

/*
Tabla para almacenar la informacion de acceso de los usuarios.
*/
CREATE TABLE usuarios (
    id INT AUTO_INCREMENT PRIMARY KEY,      --identificador unico del usuario
    nombre VARCHAR(255) NOT NULL,           --nombre del usuario
    correo VARCHAR(255) UNIQUE NOT NULL,    --el correo electronico del usuario
    contrasena VARCHAR(255) NOT NULL        --La contrasena del usuario
);
