--Archivo de conexion de base de datos MYSQL

/*
Tabla para almacenar la informacion de acceso de los usuarios.
*/
CREATE TABLE usuarios (
    id INT AUTO_INCREMENT PRIMARY KEY,      --identificador unico del usuario con llave primaria
    nombre VARCHAR(255) NOT NULL,           --nombre del usuario
    correo VARCHAR(255) UNIQUE NOT NULL,    --el correo electronico del usuario
    contrasena VARCHAR(255) NOT NULL        --La contrasena del usuario
);

/*
Tabla para almacenar la informacion de las tareas.
*/
CREATE TABLE tareas (
    id INT AUTO_INCREMENT PRIMARY KEY,                                              -- Identificador unico para cada tarea
    id_usuario INT NOT NULL,                                                        -- Llave foranea que referencia al usuario
    descripcion TEXT NOT NULL,                                                      -- Descripcion de la tarea
    estado ENUM('pendiente', 'en_progreso', 'completada') DEFAULT 'pendiente',      -- Estado de la tarea
    fecha_inicio DATETIME,                                                          -- Fecha y hora de inicio de la tarea
    fecha_fin DATETIME,                                                             -- Fecha y hora de finalizacion de la tarea
    FOREIGN KEY (id_usuario) REFERENCES usuarios(id) ON DELETE CASCADE
);

/*
Tabla para almacenar las sesiones del metodo pomodoro de las tareas.
*/
CREATE TABLE pomodoro (
    id INT AUTO_INCREMENT PRIMARY KEY,  -- Identificador único para cada sesión Pomodoro
    id_tarea INT NOT NULL,              -- Llave foranea que referencia a la tarea
    duracion INT NOT NULL,              -- Duración de la sesion en minutos
    descanso INT NOT NULL,              -- Duracion del descanso en minutos
    sesion_actual INT NOT NULL,         -- Numero de la sesión actual
    fecha_inicio DATETIME NOT NULL,     -- Fecha y hora de inicio de la sesion
    FOREIGN KEY (id_tarea) REFERENCES tareas(id) ON DELETE CASCADE
);

