-- Tabla ROL
CREATE TABLE USUARIO_ROL (
    IdRol               INTEGER         PRIMARY KEY     NOT NULL,
    Nombre              TEXT            CHECK(length(Nombre) <= 100) NOT NULL,
    Correo              TEXT            CHECK(length(Correo) <= 200) NOT NULL,
    Celular             TEXT            CHECK(length(Celular) <= 100) NOT NULL,
    Estado              TEXT            DEFAULT '1',
    FechaRegistro       DATETIME        DEFAULT (datetime('now')),
    FechaModificacion   DATETIME        DEFAULT (datetime('now'))
);

CREATE TABLE USUARIO (
    IdUsuario           INTEGER         PRIMARY KEY     NOT NULL,
    IdRol               INTEGER         NOT NULL,
    Nombre              TEXT            CHECK(length(Nombre) <= 100) NOT NULL,
    Correo              TEXT            CHECK(length(Correo) <= 200) NOT NULL,
    Celular             TEXT            CHECK(length(Celular) <= 100) NOT NULL,
    Estado              TEXT            DEFAULT '1',
    FechaRegistro       DATETIME        DEFAULT (datetime('now')),
    FechaModificacion   DATETIME        DEFAULT (datetime('now')),
    CONSTRAINT FK_IdRol FOREIGN KEY(IdRol) REFERENCES USUARIO_ROL(IdRol)
);

CREATE TABLE REGISTRO_USUARIO(
    IdRegistroUsuario       INTEGER         PRIMARY KEY     NOT NULL,
    IdUsuario               INTEGER         NOT NULL,
    ResultadoInicioSesion   TEXT,
    EstadoSesion            TEXT,
    FechaIngreso            DATETIME        DEFAULT (datetime('now')),
    FechaCierre             DATETIME        DEFAULT (datetime('now')),

    CONSTRAINT FK_IdUsuario FOREIGN KEY(IdUsuario) REFERENCES USUARIO(IdUsuario)
);
