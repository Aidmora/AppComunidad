

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
    EstadoCivil TEXT CHECK(length(EstadoCivil) <= 100) NOT NULL,
    CedulaJaver TEXT CHECK(length(CedulaJaver) <= 60) NOT NULL,
    CelularJaver TEXT CHECK(length(CelularJaver) <= 60) NOT NULL,
    CorreoJaver TEXT CHECK(length(CorreoJaver) <= 100) NOT NULL,
    fotoJaver TEXT CHECK(length(fotoJaver) <= 200) NOT NULL,
    Estado TEXT DEFAULT '1',
    FechaRegistro DATETIME DEFAULT (datetime('now')),
    FechaModificacion DATETIME DEFAULT (datetime('now'))
);


INSERT INTO USUARIO_COMUNIDAD (NombreJaver, ApellidoJaver, EstadoCivil, CedulaJaver, CelularJaver, CorreoJaver, fotoJaver)
VALUES ('Josef', 'Mora', 'Soltero', '1724681513', '0992107227', 'josef@gmail.com', 'ic_imagen_autor');

INSERT INTO USUARIO_COMUNIDAD (NombreJaver, ApellidoJaver, EstadoCivil, CedulaJaver, CelularJaver, CorreoJaver, fotoJaver)
VALUES ('Steffy', 'Lucio', 'Soltera', '1724567113', '0995467898', 'steffy@gmail.com', 'ic_imagen_autor');


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
