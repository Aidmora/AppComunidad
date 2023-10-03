

CREATE TABLE USUARIO_ROL (
    IdRol INTEGER PRIMARY KEY NOT NULL,
    Nombre TEXT CHECK(length(Nombre) <= 100) NOT NULL,
    Estado TEXT DEFAULT '1',
    FechaRegistro DATETIME DEFAULT (datetime('now')),
    FechaModificacion DATETIME DEFAULT (datetime('now'))
);


CREATE TABLE USUARIO_COMUNIDAD (
    IdUsuarioCom INTEGER PRIMARY KEY NOT NULL,
    NombreJaver TEXT CHECK(length(NombreJaver) <= 100) NOT NULL,
    ApellidoJaver TEXT CHECK(length(ApellidoJaver) <= 100) NOT NULL,
    EstadoCivil TEXT CHECK(length(EstadoCivil) <= 100) ,
    CedulaJaver TEXT CHECK(length(CedulaJaver) <= 60) ,
    CelularJaver TEXT CHECK(length(CelularJaver) <= 60) ,
    CorreoJaver TEXT CHECK(length(CorreoJaver) <= 100) ,
    fotoJaver TEXT CHECK(length(fotoJaver) <= 200) ,
    Estado TEXT DEFAULT '1',
    FechaRegistro DATETIME DEFAULT (datetime('now')),
    FechaModificacion DATETIME DEFAULT (datetime('now'))
);

INSERT INTO USUARIO_COMUNIDAD (NombreJaver, ApellidoJaver, EstadoCivil, CedulaJaver, CelularJaver, CorreoJaver, fotoJaver)
VALUES ('Nelson', 'Aguagallo', '', '', '', '', '');
INSERT INTO USUARIO_COMUNIDAD (NombreJaver, ApellidoJaver, EstadoCivil, CedulaJaver, CelularJaver, CorreoJaver, fotoJaver)
VALUES ('Brayan', 'Alcívar', 'Soltero', '070215511-0', '', '', '');
INSERT INTO USUARIO_COMUNIDAD (NombreJaver, ApellidoJaver, EstadoCivil, CedulaJaver, CelularJaver, CorreoJaver, fotoJaver)
VALUES ('Edison', 'Alcívar', 'Casado', '171779860-5', '', '', '');
INSERT INTO USUARIO_COMUNIDAD (NombreJaver, ApellidoJaver, EstadoCivil, CedulaJaver, CelularJaver, CorreoJaver, fotoJaver)
VALUES ('Jonathan', 'Alcívar', 'Casado', '171779859-7', '', '', '');
INSERT INTO USUARIO_COMUNIDAD (NombreJaver, ApellidoJaver, EstadoCivil, CedulaJaver, CelularJaver, CorreoJaver, fotoJaver)
VALUES ('Marco', 'Andrade', 'Soltero', '070267512-5', '', '', '');
INSERT INTO USUARIO_COMUNIDAD (NombreJaver, ApellidoJaver, EstadoCivil, CedulaJaver, CelularJaver, CorreoJaver, fotoJaver)
VALUES ('Fanny', 'Andrade', '', '170135881-2', '', '', '');
INSERT INTO USUARIO_COMUNIDAD (NombreJaver, ApellidoJaver, EstadoCivil, CedulaJaver, CelularJaver, CorreoJaver, fotoJaver)
VALUES ('Gladys', 'Angulo', '', '100069029-5', '', '', '');
INSERT INTO USUARIO_COMUNIDAD (NombreJaver, ApellidoJaver, EstadoCivil, CedulaJaver, CelularJaver, CorreoJaver, fotoJaver)
VALUES ('Gaby', 'Cachago', 'Soltera', '171932675-1', '', '', '');
INSERT INTO USUARIO_COMUNIDAD (NombreJaver, ApellidoJaver, EstadoCivil, CedulaJaver, CelularJaver, CorreoJaver, fotoJaver)
VALUES ('Ana', 'Centeno', 'Soltera', '172275949-3', '', '', '');
INSERT INTO USUARIO_COMUNIDAD (NombreJaver, ApellidoJaver, EstadoCivil, CedulaJaver, CelularJaver, CorreoJaver, fotoJaver)
VALUES ('Elizabeth', 'Centeno', 'Soltera', '', '', '', '');
INSERT INTO USUARIO_COMUNIDAD (NombreJaver, ApellidoJaver, EstadoCivil, CedulaJaver, CelularJaver, CorreoJaver, fotoJaver)
VALUES ('Cristina', 'Cortez', 'Casada', '171522114-7', '', '', '');
INSERT INTO USUARIO_COMUNIDAD (NombreJaver, ApellidoJaver, EstadoCivil, CedulaJaver, CelularJaver, CorreoJaver, fotoJaver)
VALUES ('Karina', 'Chávez', '', '171765754-6', '', '', '');
INSERT INTO USUARIO_COMUNIDAD (NombreJaver, ApellidoJaver, EstadoCivil, CedulaJaver, CelularJaver, CorreoJaver, fotoJaver)
VALUES ('Ana', 'Chiriboga', '', '070231819-7', '', '', '');
INSERT INTO USUARIO_COMUNIDAD (NombreJaver, ApellidoJaver, EstadoCivil, CedulaJaver, CelularJaver, CorreoJaver, fotoJaver)
VALUES ('Norma', 'Erazo', '', '170851006-8', '', '', '');
INSERT INTO USUARIO_COMUNIDAD (NombreJaver, ApellidoJaver, EstadoCivil, CedulaJaver, CelularJaver, CorreoJaver, fotoJaver)
VALUES ('Patricia', 'Estrella', '', '170817261-2', '', '', '');
INSERT INTO USUARIO_COMUNIDAD (NombreJaver, ApellidoJaver, EstadoCivil, CedulaJaver, CelularJaver, CorreoJaver, fotoJaver)
VALUES ('Mikjal', 'González', 'Soltera', '', '', '', '');
INSERT INTO USUARIO_COMUNIDAD (NombreJaver, ApellidoJaver, EstadoCivil, CedulaJaver, CelularJaver, CorreoJaver, fotoJaver)
VALUES ('Mikjael', 'González', 'Soltero', '', '', '', '');
INSERT INTO USUARIO_COMUNIDAD (NombreJaver, ApellidoJaver, EstadoCivil, CedulaJaver, CelularJaver, CorreoJaver, fotoJaver)
VALUES ('Susana', 'Gordillo', '', '170796058-7', '', '', '');
INSERT INTO USUARIO_COMUNIDAD (NombreJaver, ApellidoJaver, EstadoCivil, CedulaJaver, CelularJaver, CorreoJaver, fotoJaver)
VALUES ('Cinthia', 'Guacollantes', '', '172334511-0', '', '', '');
INSERT INTO USUARIO_COMUNIDAD (NombreJaver, ApellidoJaver, EstadoCivil, CedulaJaver, CelularJaver, CorreoJaver, fotoJaver)
VALUES ('Mishell', 'Guacollantes', 'Soltera', '172424725-7', '', '', '');
INSERT INTO USUARIO_COMUNIDAD (NombreJaver, ApellidoJaver, EstadoCivil, CedulaJaver, CelularJaver, CorreoJaver, fotoJaver)
VALUES ('Zoila', 'Guerrero', 'Casada', '', '', '', '');
INSERT INTO USUARIO_COMUNIDAD (NombreJaver, ApellidoJaver, EstadoCivil, CedulaJaver, CelularJaver, CorreoJaver, fotoJaver)
VALUES ('Verónica', 'Guevara', '', '', '', '', '');
INSERT INTO USUARIO_COMUNIDAD (NombreJaver, ApellidoJaver, EstadoCivil, CedulaJaver, CelularJaver, CorreoJaver, fotoJaver)
VALUES ('Galo', 'Jacóme', '', '170555317-8', '', '', '');
INSERT INTO USUARIO_COMUNIDAD (NombreJaver, ApellidoJaver, EstadoCivil, CedulaJaver, CelularJaver, CorreoJaver, fotoJaver)
VALUES ('Pilar', 'Jarrin', 'Casada', '170978673-3', '0991991165', 'sarahlit5728@gmail.com', '');
INSERT INTO USUARIO_COMUNIDAD (NombreJaver, ApellidoJaver, EstadoCivil, CedulaJaver, CelularJaver, CorreoJaver, fotoJaver)
VALUES ('Narvaéz', 'Lovato', '', '', '', '', '');
INSERT INTO USUARIO_COMUNIDAD (NombreJaver, ApellidoJaver, EstadoCivil, CedulaJaver, CelularJaver, CorreoJaver, fotoJaver)
VALUES ('Santiago', 'Lovato', 'Casado', '', '8322406684', '', '');
INSERT INTO USUARIO_COMUNIDAD (NombreJaver, ApellidoJaver, EstadoCivil, CedulaJaver, CelularJaver, CorreoJaver, fotoJaver)
VALUES ('Yoshua', 'Lovato', 'Soltero', '', '', '', '');
INSERT INTO USUARIO_COMUNIDAD (NombreJaver, ApellidoJaver, EstadoCivil, CedulaJaver, CelularJaver, CorreoJaver, fotoJaver)
VALUES ('Ofir', 'Lovato', 'Soltera', '', '', '', '');
INSERT INTO USUARIO_COMUNIDAD (NombreJaver, ApellidoJaver, EstadoCivil, CedulaJaver, CelularJaver, CorreoJaver, fotoJaver)
VALUES ('Ariel', 'Mora', 'Soltero', '172468152-1', '0995468359', 'arielabc389@gmail.com', 'ic_imagen_autor');
INSERT INTO USUARIO_COMUNIDAD (NombreJaver, ApellidoJaver, EstadoCivil, CedulaJaver, CelularJaver, CorreoJaver, fotoJaver)
VALUES ('Iosef', 'Mora', 'Soltero', '172468151-3', '0992626980', 'josefisraelopen@gmail.com', '');
INSERT INTO USUARIO_COMUNIDAD (NombreJaver, ApellidoJaver, EstadoCivil, CedulaJaver, CelularJaver, CorreoJaver, fotoJaver)
VALUES ('Heriberto José', 'Mora', 'Casado', '170176185-8', '', '', '');
INSERT INTO USUARIO_COMUNIDAD (NombreJaver, ApellidoJaver, EstadoCivil, CedulaJaver, CelularJaver, CorreoJaver, fotoJaver)
VALUES ('José Iván', 'Mora', 'Casado', '170916492-3', '0985710286', 'ribz5727@gmail.com', '');
INSERT INTO USUARIO_COMUNIDAD (NombreJaver, ApellidoJaver, EstadoCivil, CedulaJaver, CelularJaver, CorreoJaver, fotoJaver)
VALUES ('Alicia', 'Mosquera', '', '', '', '', '');
INSERT INTO USUARIO_COMUNIDAD (NombreJaver, ApellidoJaver, EstadoCivil, CedulaJaver, CelularJaver, CorreoJaver, fotoJaver)
VALUES ('Karina', 'Mosquera', '', '171624024-5', '', '', '');
INSERT INTO USUARIO_COMUNIDAD (NombreJaver, ApellidoJaver, EstadoCivil, CedulaJaver, CelularJaver, CorreoJaver, fotoJaver)
VALUES ('Narcisa', 'Narváez', '', '', '', '', '');
INSERT INTO USUARIO_COMUNIDAD (NombreJaver, ApellidoJaver, EstadoCivil, CedulaJaver, CelularJaver, CorreoJaver, fotoJaver)
VALUES ('Pedro', 'Ortiz', 'Casado', '', '', '', '');
INSERT INTO USUARIO_COMUNIDAD (NombreJaver, ApellidoJaver, EstadoCivil, CedulaJaver, CelularJaver, CorreoJaver, fotoJaver)
VALUES ('Navarrete', 'Paredes', '', '172184345-4', '', '', '');
INSERT INTO USUARIO_COMUNIDAD (NombreJaver, ApellidoJaver, EstadoCivil, CedulaJaver, CelularJaver, CorreoJaver, fotoJaver)
VALUES ('Carla', 'Paredes', '', '172184345-4', '', '', '');
INSERT INTO USUARIO_COMUNIDAD (NombreJaver, ApellidoJaver, EstadoCivil, CedulaJaver, CelularJaver, CorreoJaver, fotoJaver)
VALUES ('Jacqueline', 'Pila', '', '171046088-0', '', '', '');
INSERT INTO USUARIO_COMUNIDAD (NombreJaver, ApellidoJaver, EstadoCivil, CedulaJaver, CelularJaver, CorreoJaver, fotoJaver)
VALUES ('Isabel', 'Pinto', '', '', '', '', '');
INSERT INTO USUARIO_COMUNIDAD (NombreJaver, ApellidoJaver, EstadoCivil, CedulaJaver, CelularJaver, CorreoJaver, fotoJaver)
VALUES ('Jacqueline', 'Ramos', '', '', '', '', '');
INSERT INTO USUARIO_COMUNIDAD (NombreJaver, ApellidoJaver, EstadoCivil, CedulaJaver, CelularJaver, CorreoJaver, fotoJaver)
VALUES ('Esperanza', 'Riascos', '', '170581775-5', '', '', '');
INSERT INTO USUARIO_COMUNIDAD (NombreJaver, ApellidoJaver, EstadoCivil, CedulaJaver, CelularJaver, CorreoJaver, fotoJaver)
VALUES ('Raquel', 'Rivera', '', '170928333-5', '', '', '');
INSERT INTO USUARIO_COMUNIDAD (NombreJaver, ApellidoJaver, EstadoCivil, CedulaJaver, CelularJaver, CorreoJaver, fotoJaver)
VALUES ('Juan', 'Torres', '', '', '', '', '');
INSERT INTO USUARIO_COMUNIDAD (NombreJaver, ApellidoJaver, EstadoCivil, CedulaJaver, CelularJaver, CorreoJaver, fotoJaver)
VALUES ('Familia', 'Guevara Torres', '', '', '', '', '');
INSERT INTO USUARIO_COMUNIDAD (NombreJaver, ApellidoJaver, EstadoCivil, CedulaJaver, CelularJaver, CorreoJaver, fotoJaver)
VALUES ('Alejandro', 'Vargas', '', '', '', '', '');
INSERT INTO USUARIO_COMUNIDAD (NombreJaver, ApellidoJaver, EstadoCivil, CedulaJaver, CelularJaver, CorreoJaver, fotoJaver)
VALUES ('Camila', 'Valarezo', '', '', '', '', '');
INSERT INTO USUARIO_COMUNIDAD (NombreJaver, ApellidoJaver, EstadoCivil, CedulaJaver, CelularJaver, CorreoJaver, fotoJaver)
VALUES ('Mónica', 'Velazco', '', '', '', '', '');
INSERT INTO USUARIO_COMUNIDAD (NombreJaver, ApellidoJaver, EstadoCivil, CedulaJaver, CelularJaver, CorreoJaver, fotoJaver)
VALUES ('Samara', 'Aguagallo', '', '', '', '', '');
INSERT INTO USUARIO_COMUNIDAD (NombreJaver, ApellidoJaver, EstadoCivil, CedulaJaver, CelularJaver, CorreoJaver, fotoJaver)
VALUES ('Sarah y Dannah', 'Alcívar', '', '', '', '', '');
INSERT INTO USUARIO_COMUNIDAD (NombreJaver, ApellidoJaver, EstadoCivil, CedulaJaver, CelularJaver, CorreoJaver, fotoJaver)
VALUES ('Victoria', 'Aguiar', '', '', '', '', '');
INSERT INTO USUARIO_COMUNIDAD (NombreJaver, ApellidoJaver, EstadoCivil, CedulaJaver, CelularJaver, CorreoJaver, fotoJaver)
VALUES ('Daena', 'Andino', '', '', '', '', '');
INSERT INTO USUARIO_COMUNIDAD (NombreJaver, ApellidoJaver, EstadoCivil, CedulaJaver, CelularJaver, CorreoJaver, fotoJaver)
VALUES ('Ana e Israel', 'Campos', '', '', '', '', '');
INSERT INTO USUARIO_COMUNIDAD (NombreJaver, ApellidoJaver, EstadoCivil, CedulaJaver, CelularJaver, CorreoJaver, fotoJaver)
VALUES ('Yemima', 'Garcés', '', '', '', '', '');
INSERT INTO USUARIO_COMUNIDAD (NombreJaver, ApellidoJaver, EstadoCivil, CedulaJaver, CelularJaver, CorreoJaver, fotoJaver)
VALUES ('Paula', 'Torres', '', '', '', '', '');
INSERT INTO USUARIO_COMUNIDAD (NombreJaver, ApellidoJaver, EstadoCivil, CedulaJaver, CelularJaver, CorreoJaver, fotoJaver)
VALUES ('Samuel', 'Cuadros', '', '', '', '', '');
INSERT INTO USUARIO_COMUNIDAD (NombreJaver, ApellidoJaver, EstadoCivil, CedulaJaver, CelularJaver, CorreoJaver, fotoJaver)
VALUES ('Stely', 'Vargas', '', '', '', '', '');

CREATE TABLE USUARIO (
    IdUsuario INTEGER PRIMARY KEY NOT NULL,
    IdRol INTEGER NOT NULL,
    Nombre TEXT CHECK(length(Nombre) <= 100) NOT NULL,
    Correo TEXT CHECK(length(Correo) <= 200) NOT NULL,
    Celular TEXT CHECK(length(Celular) <= 100) NOT NULL,
    Estado TEXT DEFAULT '1',
    FechaRegistro DATETIME DEFAULT (datetime('now')),
    FechaModificacion DATETIME DEFAULT (datetime('now')),
    CONSTRAINT FK_IdRol FOREIGN KEY(IdRol) REFERENCES USUARIO_ROL(IdRol)
);


CREATE TABLE USUARIO_CREDENCIAL (
    IdUsuario INTEGER NOT NULL,
    Contrasena TEXT CHECK(length(Contrasena) <= 300) NOT NULL,
    Estado TEXT DEFAULT '1',
    FechaRegistro DATETIME DEFAULT (datetime('now')),
    FechaModificacion DATETIME DEFAULT (datetime('now')),
    CONSTRAINT FK_IdUsuario FOREIGN KEY(IdUsuario) REFERENCES USUARIO(IdUsuario)
);


INSERT INTO USUARIO_CREDENCIAL (IdUsuario, Contrasena)
VALUES (1, '119ce1ac2e100ee9ce9d3b3b7f0debcf');


CREATE TABLE REGISTRO_USUARIO (
    IdRegistroUsuario INTEGER PRIMARY KEY NOT NULL,
    IdUsuario INTEGER NOT NULL,
    ResultadoInicioSesion TEXT,
    EstadoSesion TEXT,
    FechaIngreso DATETIME DEFAULT (datetime('now')),
    FechaCierre DATETIME DEFAULT (datetime('now')),
    CONSTRAINT FK_IdUsuario FOREIGN KEY(IdUsuario) REFERENCES USUARIO(IdUsuario)
);


INSERT INTO USUARIO (IdRol, Nombre, Correo, Celular, Estado)
VALUES (1, 'Ariel Mora', 'arielabc389@gmail.com', '0995468359', '1');


INSERT INTO USUARIO_ROL (IdRol, Nombre)
VALUES (1, 'Admin');
INSERT INTO USUARIO_ROL (IdRol, Nombre)
VALUES (2, 'Javer');
