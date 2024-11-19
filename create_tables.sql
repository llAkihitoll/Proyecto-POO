--Archivo de conexion de base de datos MYSQL

/*
Tabla para almacenar la informacion de acceso de los usuarios.
*/
CREATE TABLE usuarios (
    id INT AUTO_INCREMENT PRIMARY KEY,      --identificador unico del usuario con llave primaria
    nombre VARCHAR(255) NOT NULL,           --nombre del usuario
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
/*
Tabla para almacenar los horarios que los usuarios tienen asignados.
*/
CREATE TABLE horarios (
    id INT AUTO_INCREMENT PRIMARY KEY,  -- Identificador unico para cada horario
    id_usuario INT NOT NULL,            
    dia_semana ENUM('Lunes', 'Martes', 'Miércoles', 'Jueves', 'Viernes', 'Sábado', 'Domingo') NOT NULL,
    hora_inicio TIME NOT NULL,          -- Hora de inicio del horario
    hora_fin TIME NOT NULL,             -- Hora de fin del horario
    FOREIGN KEY (id_usuario) REFERENCES usuarios(id) ON DELETE CASCADE
);
/*
Tabla para almacenar los badges que se pueden obtener.
*/
CREATE TABLE badges (
    id INT AUTO_INCREMENT PRIMARY KEY,  -- Identificador unico para cada badge
    nombre VARCHAR(255) NOT NULL,       -- Nombre del badge
    descripcion TEXT NOT NULL           -- Descripcion del badge
);
/*
Tabla para almacenar los badges que tienen los usuarios.
*/
CREATE TABLE usuarios_badges (
    id_usuario INT NOT NULL,            -- Llave foranea que referencia al usuario
    id_badge INT NOT NULL,              -- Llave foranea que referencia al badge
    fecha_obtencion DATETIME NOT NULL,  -- Fecha en la que el usuario obtuvo el badge
    PRIMARY KEY (id_usuario, id_badge), -- Llave primaria compuesta por ambas columnas
    FOREIGN KEY (id_usuario) REFERENCES usuarios(id) ON DELETE CASCADE,
    FOREIGN KEY (id_badge) REFERENCES badges(id) ON DELETE CASCADE
);