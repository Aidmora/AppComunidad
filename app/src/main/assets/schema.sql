
-- Creación de la tabla USUARIO_ROL
CREATE TABLE USUARIO_ROL (
    IdRol INTEGER PRIMARY KEY NOT NULL,
    Nombre TEXT CHECK(length(Nombre) <= 100) NOT NULL,
    Estado TEXT DEFAULT '1',
    FechaRegistro DATETIME DEFAULT CURRENT_TIMESTAMP,
    FechaModificacion DATETIME DEFAULT CURRENT_TIMESTAMP
);

-- Creación de la tabla USUARIO_COMUNIDAD
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
    FechaRegistro DATETIME DEFAULT CURRENT_TIMESTAMP,
    FechaModificacion DATETIME DEFAULT CURRENT_TIMESTAMP
);

-- Creación de la tabla USUARIO
CREATE TABLE USUARIO (
    IdUsuario INTEGER PRIMARY KEY NOT NULL,
    IdRol INTEGER NOT NULL,
    Nombre TEXT CHECK(length(Nombre) <= 100) NOT NULL,
    Correo TEXT CHECK(length(Correo) <= 200) NOT NULL,
    Celular TEXT CHECK(length(Celular) <= 100) NOT NULL,
    Estado TEXT DEFAULT '1',
    FechaRegistro DATETIME DEFAULT CURRENT_TIMESTAMP,
    FechaModificacion DATETIME DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT FK_IdRol FOREIGN KEY(IdRol) REFERENCES USUARIO_ROL(IdRol)
);

-- Creación de la tabla INGRESOS_ENERO
CREATE TABLE INGRESOS_ENERO (
    IdMesEnero INTEGER PRIMARY KEY NOT NULL,
    NombreMes TEXT CHECK(LENGTH(NombreMes) <= 300) NOT NULL,
    AñoMes TEXT CHECK(LENGTH(AñoMes) <= 300) NOT NULL,
    IdUsuarioCom INTEGER NOT NULL,
    NombreJaverIngreso_E TEXT CHECK(LENGTH(NombreJaverIngreso_E) <= 300) NOT NULL,
    ApellidoJaverIngreso_E TEXT CHECK(LENGTH(ApellidoJaverIngreso_E) <= 300) NOT NULL,
    CedulaJaverIngreso_E TEXT CHECK(LENGTH(CedulaJaverIngreso_E) <= 300),
    SemanaFechaIngreso_E TEXT CHECK(LENGTH(SemanaFechaIngreso_E) <= 500) NOT NULL,
    MasserBaitHaM_E TEXT CHECK(LENGTH(MasserBaitHaM_E) <= 500) NOT NULL,
    RoshJodesh_E TEXT CHECK(LENGTH(RoshJodesh_E) <= 500) NOT NULL,
    TerumahYeladim_E TEXT CHECK(LENGTH(TerumahYeladim_E) <= 500) NOT NULL,
    Terreno_E TEXT CHECK(LENGTH(Terreno_E) <= 500) NOT NULL,
    Shuljan_E TEXT CHECK(LENGTH(Shuljan_E) <= 500) NOT NULL,
    Tzedaqah_E TEXT CHECK(LENGTH(Tzedaqah_E) <= 500) NOT NULL,
    Kaparah_E TEXT CHECK(LENGTH(Kaparah_E) <= 500) NOT NULL,
    Arriendo_E TEXT CHECK(LENGTH(Arriendo_E) <= 500) NOT NULL,
    TotalSemana_E DOUBLE NOT NULL,
    CONSTRAINT FK_IdUsuarioCom_E FOREIGN KEY (IdUsuarioCom) REFERENCES USUARIO_COMUNIDAD (IdUsuarioCom)
);
CREATE TABLE INGRESOS_FEBRERO (
    IdMesFebrero                INTEGER PRIMARY KEY                                 NOT NULL,
    NombreMes                   TEXT CHECK(LENGTH(NombreMes) <= 300)                NOT NULL,
    AñoMes                      TEXT CHECK(LENGTH(AñoMes) <= 300)                  NOT NULL,
    IdUsuarioCom                INTEGER                                             NOT NULL,
    NombreJaverIngreso_F        TEXT CHECK(LENGTH(NombreJaverIngreso_F) <= 300)     NOT NULL,
    ApellidoJaverIngreso_F      TEXT CHECK(LENGTH(ApellidoJaverIngreso_F) <= 300)   NOT NULL,
    CedulaJaverIngreso_F        TEXT CHECK(LENGTH(CedulaJaverIngreso_F) <= 300),
    SemanaFechaIngreso_F        TEXT CHECK(LENGTH(SemanaFechaIngreso_F) <= 500)     NOT NULL,
    MasserBaitHaM_F             TEXT CHECK(LENGTH(MasserBaitHaM_F) <= 500)          NOT NULL,
    RoshJodesh_F                TEXT CHECK(LENGTH(RoshJodesh_F) <= 500)             NOT NULL,
    TerumahYeladim_F            TEXT CHECK(LENGTH(TerumahYeladim_F) <= 500)         NOT NULL,
    Terreno_F                   TEXT CHECK(LENGTH(Terreno_F) <= 500)                NOT NULL,
    Shuljan_F                   TEXT CHECK(LENGTH(Shuljan_F) <= 500)                NOT NULL,
    Tzedaqah_F                  TEXT CHECK(LENGTH(Tzedaqah_F) <= 500)               NOT NULL,
    Kaparah_F                   TEXT CHECK(LENGTH(Kaparah_F) <= 500)                NOT NULL,
    Arriendo_F                  TEXT CHECK(LENGTH(Arriendo_F) <= 500)               NOT NULL,
    TotalSemana_F               DOUBLE                                             NOT NULL,
    CONSTRAINT FK_IdUsuarioCom_F FOREIGN KEY (IdUsuarioCom) REFERENCES USUARIO_COMUNIDAD (IdUsuarioCom)
);
CREATE TABLE INGRESOS_MARZO (
    IdMesMarzo                  INTEGER PRIMARY KEY                                 NOT NULL,
    NombreMes                   TEXT CHECK(LENGTH(NombreMes) <= 300)                NOT NULL,
    AñoMes                      TEXT CHECK(LENGTH(AñoMes) <= 300)                  NOT NULL,
    IdUsuarioCom                INTEGER NOT NULL,
    NombreJaverIngreso_M        TEXT CHECK(LENGTH(NombreJaverIngreso_M) <= 300)     NOT NULL,
    ApellidoJaverIngreso_M      TEXT CHECK(LENGTH(ApellidoJaverIngreso_M) <= 300)   NOT NULL,
    CedulaJaverIngreso_M        TEXT CHECK(LENGTH(CedulaJaverIngreso_M) <= 300),
    SemanaFechaIngreso_M        TEXT CHECK(LENGTH(SemanaFechaIngreso_M) <= 500)     NOT NULL,
    MasserBaitHaM_M             TEXT CHECK(LENGTH(MasserBaitHaM_M) <= 500)          NOT NULL,
    RoshJodesh_M                TEXT CHECK(LENGTH(RoshJodesh_M) <= 500)             NOT NULL,
    TerumahYeladim_M            TEXT CHECK(LENGTH(TerumahYeladim_M) <= 500)         NOT NULL,
    Terreno_M                   TEXT CHECK(LENGTH(Terreno_M) <= 500)                NOT NULL,
    Shuljan_M                   TEXT CHECK(LENGTH(Shuljan_M) <= 500)                NOT NULL,
    Tzedaqah_M                  TEXT CHECK(LENGTH(Tzedaqah_M) <= 500)               NOT NULL,
    Kaparah_M                   TEXT CHECK(LENGTH(Kaparah_M) <= 500)                NOT NULL,
    Arriendo_M                  TEXT CHECK(LENGTH(Arriendo_M) <= 500)               NOT NULL,
    TotalSemana_M               DOUBLE                                             NOT NULL,
    CONSTRAINT FK_IdUsuarioCom_M FOREIGN KEY (IdUsuarioCom) REFERENCES USUARIO_COMUNIDAD (IdUsuarioCom)
);

CREATE TABLE INGRESOS_ABRIL (
    IdMesAbril                  INTEGER PRIMARY KEY                                 NOT NULL,
    NombreMes                   TEXT CHECK(LENGTH(NombreMes) <= 300)                NOT NULL,
    AñoMes                      TEXT CHECK(LENGTH(AñoMes) <= 300)                  NOT NULL,
    IdUsuarioCom                INTEGER NOT NULL,
    NombreJaverIngreso_A        TEXT CHECK(LENGTH(NombreJaverIngreso_A) <= 300)     NOT NULL,
    ApellidoJaverIngreso_A      TEXT CHECK(LENGTH(ApellidoJaverIngreso_A) <= 300)   NOT NULL,
    CedulaJaverIngreso_A        TEXT CHECK(LENGTH(CedulaJaverIngreso_A) <= 300),
    SemanaFechaIngreso_A        TEXT CHECK(LENGTH(SemanaFechaIngreso_A) <= 500)     NOT NULL,
    MasserBaitHaM_A             TEXT CHECK(LENGTH(MasserBaitHaM_A) <= 500)          NOT NULL,
    RoshJodesh_A                TEXT CHECK(LENGTH(RoshJodesh_A) <= 500)             NOT NULL,
    TerumahYeladim_A            TEXT CHECK(LENGTH(TerumahYeladim_A) <= 500)         NOT NULL,
    Terreno_A                   TEXT CHECK(LENGTH(Terreno_A) <= 500)                NOT NULL,
    Shuljan_A                   TEXT CHECK(LENGTH(Shuljan_A) <= 500)                NOT NULL,
    Tzedaqah_A                  TEXT CHECK(LENGTH(Tzedaqah_A) <= 500)               NOT NULL,
    Kaparah_A                   TEXT CHECK(LENGTH(Kaparah_A) <= 500)                NOT NULL,
    Arriendo_A                  TEXT CHECK(LENGTH(Arriendo_A) <= 500)               NOT NULL,
    TotalSemana_A               DOUBLE                                            NOT NULL,
    CONSTRAINT FK_IdUsuarioCom_A FOREIGN KEY (IdUsuarioCom) REFERENCES USUARIO_COMUNIDAD (IdUsuarioCom)
);

CREATE TABLE INGRESOS_MAYO (
    IdMesMayo                  INTEGER PRIMARY KEY                                    NOT NULL,
    NombreMes                   TEXT CHECK(LENGTH(NombreMes) <= 300)                  NOT NULL,
    AñoMes                      TEXT CHECK(LENGTH(AñoMes) <= 300)                  NOT NULL,
    IdUsuarioCom                INTEGER NOT NULL,
    NombreJaverIngreso_MA        TEXT CHECK(LENGTH(NombreJaverIngreso_MA) <= 300)     NOT NULL,
    ApellidoJaverIngreso_MA      TEXT CHECK(LENGTH(ApellidoJaverIngreso_MA) <= 300)   NOT NULL,
    CedulaJaverIngreso_MA        TEXT CHECK(LENGTH(CedulaJaverIngreso_MA) <= 300),
    SemanaFechaIngreso_MA        TEXT CHECK(LENGTH(SemanaFechaIngreso_MA) <= 500)     NOT NULL,
    MasserBaitHaM_MA             TEXT CHECK(LENGTH(MasserBaitHaM_MA) <= 500)          NOT NULL,
    RoshJodesh_MA                TEXT CHECK(LENGTH(RoshJodesh_MA) <= 500)             NOT NULL,
    TerumahYeladim_MA            TEXT CHECK(LENGTH(TerumahYeladim_MA) <= 500)         NOT NULL,
    Terreno_MA                   TEXT CHECK(LENGTH(Terreno_MA) <= 500)                NOT NULL,
    Shuljan_MA                   TEXT CHECK(LENGTH(Shuljan_MA) <= 500)                NOT NULL,
    Tzedaqah_MA                  TEXT CHECK(LENGTH(Tzedaqah_MA) <= 500)               NOT NULL,
    Kaparah_MA                   TEXT CHECK(LENGTH(Kaparah_MA) <= 500)                NOT NULL,
    Arriendo_MA                  TEXT CHECK(LENGTH(Arriendo_MA) <= 500)               NOT NULL,
    TotalSemana_MA               DOUBLE                                             NOT NULL,
    CONSTRAINT FK_IdUsuarioCom_MA FOREIGN KEY (IdUsuarioCom) REFERENCES USUARIO_COMUNIDAD (IdUsuarioCom)
);
CREATE TABLE INGRESOS_JUNIO (
    IdMesJunio                  INTEGER PRIMARY KEY                                    NOT NULL,
    NombreMes                   TEXT CHECK(LENGTH(NombreMes) <= 300)                  NOT NULL,
    AñoMes                      TEXT CHECK(LENGTH(AñoMes) <= 300)                  NOT NULL,
    IdUsuarioCom                INTEGER NOT NULL,
    NombreJaverIngreso_J        TEXT CHECK(LENGTH(NombreJaverIngreso_J) <= 300)     NOT NULL,
    ApellidoJaverIngreso_J      TEXT CHECK(LENGTH(ApellidoJaverIngreso_J) <= 300)   NOT NULL,
    CedulaJaverIngreso_J        TEXT CHECK(LENGTH(CedulaJaverIngreso_J) <= 300),
    SemanaFechaIngreso_J        TEXT CHECK(LENGTH(SemanaFechaIngreso_J) <= 500)     NOT NULL,
    MasserBaitHaM_J             TEXT CHECK(LENGTH(MasserBaitHaM_J) <= 500)          NOT NULL,
    RoshJodesh_J                TEXT CHECK(LENGTH(RoshJodesh_J) <= 500)             NOT NULL,
    TerumahYeladim_J            TEXT CHECK(LENGTH(TerumahYeladim_J) <= 500)         NOT NULL,
    Terreno_J                   TEXT CHECK(LENGTH(Terreno_J) <= 500)                NOT NULL,
    Shuljan_J                   TEXT CHECK(LENGTH(Shuljan_J) <= 500)                NOT NULL,
    Tzedaqah_J                  TEXT CHECK(LENGTH(Tzedaqah_J) <= 500)               NOT NULL,
    Kaparah_J                   TEXT CHECK(LENGTH(Kaparah_J) <= 500)                NOT NULL,
    Arriendo_J                  TEXT CHECK(LENGTH(Arriendo_J) <= 500)               NOT NULL,
    TotalSemana_J               DOUBLE                                             NOT NULL,
    CONSTRAINT FK_IdUsuarioCom_J FOREIGN KEY (IdUsuarioCom) REFERENCES USUARIO_COMUNIDAD (IdUsuarioCom)
);
CREATE TABLE INGRESOS_JULIO (
    IdMesJulio                  INTEGER PRIMARY KEY                                    NOT NULL,
    NombreMes                   TEXT CHECK(LENGTH(NombreMes) <= 300)                  NOT NULL,
    AñoMes                      TEXT CHECK(LENGTH(AñoMes) <= 300)                  NOT NULL,
    IdUsuarioCom                INTEGER NOT NULL,
    NombreJaverIngreso_JU        TEXT CHECK(LENGTH(NombreJaverIngreso_JU) <= 300)     NOT NULL,
    ApellidoJaverIngreso_JU      TEXT CHECK(LENGTH(ApellidoJaverIngreso_JU) <= 300)   NOT NULL,
    CedulaJaverIngreso_JU        TEXT CHECK(LENGTH(CedulaJaverIngreso_JU) <= 300),
    SemanaFechaIngreso_JU       TEXT CHECK(LENGTH(SemanaFechaIngreso_JU) <= 500)     NOT NULL,
    MasserBaitHaM_JU             TEXT CHECK(LENGTH(MasserBaitHaM_JU) <= 500)          NOT NULL,
    RoshJodesh_JU                TEXT CHECK(LENGTH(RoshJodesh_JU) <= 500)             NOT NULL,
    TerumahYeladim_JU            TEXT CHECK(LENGTH(TerumahYeladim_JU) <= 500)         NOT NULL,
    Terreno_JU                   TEXT CHECK(LENGTH(Terreno_JU) <= 500)                NOT NULL,
    Shuljan_JU                   TEXT CHECK(LENGTH(Shuljan_JU) <= 500)                NOT NULL,
    Tzedaqah_JU                  TEXT CHECK(LENGTH(Tzedaqah_JU) <= 500)               NOT NULL,
    Kaparah_JU                   TEXT CHECK(LENGTH(Kaparah_JU) <= 500)                NOT NULL,
    Arriendo_JU                  TEXT CHECK(LENGTH(Arriendo_JU) <= 500)               NOT NULL,
    TotalSemana_JU               DOUBLE                                              NOT NULL,
    CONSTRAINT FK_IdUsuarioCom_JU FOREIGN KEY (IdUsuarioCom) REFERENCES USUARIO_COMUNIDAD (IdUsuarioCom)
);
CREATE TABLE INGRESOS_AGOSTO (
    IdMesAgosto                  INTEGER PRIMARY KEY                                    NOT NULL,
    NombreMes                   TEXT CHECK(LENGTH(NombreMes) <= 300)                  NOT NULL,
    AñoMes                      TEXT CHECK(LENGTH(AñoMes) <= 300)                  NOT NULL,
    IdUsuarioCom                INTEGER NOT NULL,
    NombreJaverIngreso_AG        TEXT CHECK(LENGTH(NombreJaverIngreso_AG) <= 300)     NOT NULL,
    ApellidoJaverIngreso_AG      TEXT CHECK(LENGTH(ApellidoJaverIngreso_AG) <= 300)   NOT NULL,
    CedulaJaverIngreso_AG        TEXT CHECK(LENGTH(CedulaJaverIngreso_AG) <= 300),
    SemanaFechaIngreso_AG       TEXT CHECK(LENGTH(SemanaFechaIngreso_AG) <= 500)     NOT NULL,
    MasserBaitHaM_AG             TEXT CHECK(LENGTH(MasserBaitHaM_AG) <= 500)          NOT NULL,
    RoshJodesh_AG                TEXT CHECK(LENGTH(RoshJodesh_AG) <= 500)             NOT NULL,
    TerumahYeladim_AG            TEXT CHECK(LENGTH(TerumahYeladim_AG) <= 500)         NOT NULL,
    Terreno_AG                   TEXT CHECK(LENGTH(Terreno_AG) <= 500)                NOT NULL,
    Shuljan_AG                   TEXT CHECK(LENGTH(Shuljan_AG) <= 500)                NOT NULL,
    Tzedaqah_AG                  TEXT CHECK(LENGTH(Tzedaqah_AG) <= 500)               NOT NULL,
    Kaparah_AG                   TEXT CHECK(LENGTH(Kaparah_AG) <= 500)                NOT NULL,
    Arriendo_AG                  TEXT CHECK(LENGTH(Arriendo_AG) <= 500)               NOT NULL,
    TotalSemana_AG               DOUBLE                                              NOT NULL,
    CONSTRAINT FK_IdUsuarioCom_AG FOREIGN KEY (IdUsuarioCom) REFERENCES USUARIO_COMUNIDAD (IdUsuarioCom)
);
CREATE TABLE INGRESOS_SEPTIEMBRE (
    IdMesSeptiembre                  INTEGER PRIMARY KEY                                    NOT NULL,
    NombreMes                   TEXT CHECK(LENGTH(NombreMes) <= 300)                  NOT NULL,
    AñoMes                      TEXT CHECK(LENGTH(AñoMes) <= 300)                  NOT NULL,
    IdUsuarioCom                INTEGER NOT NULL,
    NombreJaverIngreso_S        TEXT CHECK(LENGTH(NombreJaverIngreso_S) <= 300)     NOT NULL,
    ApellidoJaverIngreso_S      TEXT CHECK(LENGTH(ApellidoJaverIngreso_S) <= 300)   NOT NULL,
    CedulaJaverIngreso_S        TEXT CHECK(LENGTH(CedulaJaverIngreso_S) <= 300),
    SemanaFechaIngreso_S       TEXT CHECK(LENGTH(SemanaFechaIngreso_S) <= 500)     NOT NULL,
    MasserBaitHaM_S             TEXT CHECK(LENGTH(MasserBaitHaM_S) <= 500)          NOT NULL,
    RoshJodesh_S                TEXT CHECK(LENGTH(RoshJodesh_S) <= 500)             NOT NULL,
    TerumahYeladim_S            TEXT CHECK(LENGTH(TerumahYeladim_S) <= 500)         NOT NULL,
    Terreno_S                   TEXT CHECK(LENGTH(Terreno_S) <= 500)                NOT NULL,
    Shuljan_S                   TEXT CHECK(LENGTH(Shuljan_S) <= 500)                NOT NULL,
    Tzedaqah_S                  TEXT CHECK(LENGTH(Tzedaqah_S) <= 500)               NOT NULL,
    Kaparah_S                   TEXT CHECK(LENGTH(Kaparah_S) <= 500)                NOT NULL,
    Arriendo_S                  TEXT CHECK(LENGTH(Arriendo_S) <= 500)               NOT NULL,
    TotalSemana_S               DOUBLE                                             NOT NULL,
    CONSTRAINT FK_IdUsuarioCom_S FOREIGN KEY (IdUsuarioCom) REFERENCES USUARIO_COMUNIDAD (IdUsuarioCom)
);
CREATE TABLE INGRESOS_OCTUBRE (
    IdMesOctubre                  INTEGER PRIMARY KEY                                    NOT NULL,
    NombreMes                   TEXT CHECK(LENGTH(NombreMes) <= 300)                  NOT NULL,
    AñoMes                      TEXT CHECK(LENGTH(AñoMes) <= 300)                  NOT NULL,
    IdUsuarioCom                INTEGER NOT NULL,
    NombreJaverIngreso_O        TEXT CHECK(LENGTH(NombreJaverIngreso_O) <= 300)     NOT NULL,
    ApellidoJaverIngreso_O      TEXT CHECK(LENGTH(ApellidoJaverIngreso_O) <= 300)   NOT NULL,
    CedulaJaverIngreso_O        TEXT CHECK(LENGTH(CedulaJaverIngreso_O) <= 300),
    SemanaFechaIngreso_O       TEXT CHECK(LENGTH(SemanaFechaIngreso_O) <= 500)     NOT NULL,
    MasserBaitHaM_O             TEXT CHECK(LENGTH(MasserBaitHaM_O) <= 500)          NOT NULL,
    RoshJodesh_O                TEXT CHECK(LENGTH(RoshJodesh_O) <= 500)             NOT NULL,
    TerumahYeladim_O            TEXT CHECK(LENGTH(TerumahYeladim_O) <= 500)         NOT NULL,
    Terreno_O                   TEXT CHECK(LENGTH(Terreno_O) <= 500)                NOT NULL,
    Shuljan_O                   TEXT CHECK(LENGTH(Shuljan_O) <= 500)                NOT NULL,
    Tzedaqah_O                  TEXT CHECK(LENGTH(Tzedaqah_O) <= 500)               NOT NULL,
    Kaparah_O                   TEXT CHECK(LENGTH(Kaparah_O) <= 500)                NOT NULL,
    Arriendo_O                  TEXT CHECK(LENGTH(Arriendo_O) <= 500)               NOT NULL,
    TotalSemana_O               DOUBLE                                             NOT NULL,
    CONSTRAINT FK_IdUsuarioCom_O FOREIGN KEY (IdUsuarioCom) REFERENCES USUARIO_COMUNIDAD (IdUsuarioCom)
);
CREATE TABLE INGRESOS_NOVIEMBRE (
    IdMesNoviembre                  INTEGER PRIMARY KEY                                    NOT NULL,
    NombreMes                   TEXT CHECK(LENGTH(NombreMes) <= 300)                  NOT NULL,
    AñoMes                      TEXT CHECK(LENGTH(AñoMes) <= 300)                  NOT NULL,
    IdUsuarioCom                INTEGER NOT NULL,
    NombreJaverIngreso_N        TEXT CHECK(LENGTH(NombreJaverIngreso_N) <= 300)     NOT NULL,
    ApellidoJaverIngreso_N      TEXT CHECK(LENGTH(ApellidoJaverIngreso_N) <= 300)   NOT NULL,
    CedulaJaverIngreso_N        TEXT CHECK(LENGTH(CedulaJaverIngreso_N) <= 300),
    SemanaFechaIngreso_N       TEXT CHECK(LENGTH(SemanaFechaIngreso_N) <= 500)     NOT NULL,
    MasserBaitHaM_N             TEXT CHECK(LENGTH(MasserBaitHaM_N) <= 500)          NOT NULL,
    RoshJodesh_N                TEXT CHECK(LENGTH(RoshJodesh_N) <= 500)             NOT NULL,
    TerumahYeladim_N            TEXT CHECK(LENGTH(TerumahYeladim_N) <= 500)         NOT NULL,
    Terreno_N                   TEXT CHECK(LENGTH(Terreno_N) <= 500)                NOT NULL,
    Shuljan_N                   TEXT CHECK(LENGTH(Shuljan_N) <= 500)                NOT NULL,
    Tzedaqah_N                  TEXT CHECK(LENGTH(Tzedaqah_N) <= 500)               NOT NULL,
    Kaparah_N                   TEXT CHECK(LENGTH(Kaparah_N) <= 500)                NOT NULL,
    Arriendo_N                  TEXT CHECK(LENGTH(Arriendo_N) <= 500)               NOT NULL,
    TotalSemana_N               DOUBLE                                            NOT NULL,
    CONSTRAINT FK_IdUsuarioCom_N FOREIGN KEY (IdUsuarioCom) REFERENCES USUARIO_COMUNIDAD (IdUsuarioCom)
);
CREATE TABLE INGRESOS_DICIEMBRE (
    IdMesDiciembre              INTEGER PRIMARY KEY                                 NOT NULL,
    NombreMes                   TEXT CHECK(LENGTH(NombreMes) <= 300)                NOT NULL,
    AñoMes                      TEXT CHECK(LENGTH(AñoMes) <= 300)                   NOT NULL,
    IdUsuarioCom                INTEGER NOT NULL,
    NombreJaverIngreso_D        TEXT CHECK(LENGTH(NombreJaverIngreso_D) <= 300)     NOT NULL,
    ApellidoJaverIngreso_D      TEXT CHECK(LENGTH(ApellidoJaverIngreso_D) <= 300)   NOT NULL,
    CedulaJaverIngreso_D        TEXT CHECK(LENGTH(CedulaJaverIngreso_D) <= 300),
    SemanaFechaIngreso_D        TEXT CHECK(LENGTH(SemanaFechaIngreso_D) <= 500)     NOT NULL,
    MasserBaitHaM_D             TEXT CHECK(LENGTH(MasserBaitHaM_D) <= 500)          NOT NULL,
    RoshJodesh_D                TEXT CHECK(LENGTH(RoshJodesh_D) <= 500)             NOT NULL,
    TerumahYeladim_D            TEXT CHECK(LENGTH(TerumahYeladim_D) <= 500)         NOT NULL,
    Terreno_D                   TEXT CHECK(LENGTH(Terreno_D) <= 500)                NOT NULL,
    Shuljan_D                   TEXT CHECK(LENGTH(Shuljan_D) <= 500)                NOT NULL,
    Tzedaqah_D                  TEXT CHECK(LENGTH(Tzedaqah_D) <= 500)               NOT NULL,
    Kaparah_D                   TEXT CHECK(LENGTH(Kaparah_D) <= 500)                NOT NULL,
    Arriendo_D                  TEXT CHECK(LENGTH(Arriendo_D) <= 500)               NOT NULL,
    TotalSemana_D               DOUBLE                                             NOT NULL,
    CONSTRAINT FK_IdUsuarioCom_D FOREIGN KEY (IdUsuarioCom) REFERENCES USUARIO_COMUNIDAD (IdUsuarioCom)
);

-- Creación de la tabla USUARIO_CREDENCIAL
CREATE TABLE USUARIO_CREDENCIAL (
    IdUsuario INTEGER NOT NULL,
    Contrasena TEXT CHECK(length(Contrasena) <= 300) NOT NULL,
    Estado TEXT DEFAULT '1',
    FechaRegistro DATETIME DEFAULT CURRENT_TIMESTAMP,
    FechaModificacion DATETIME DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT FK_IdUsuario FOREIGN KEY(IdUsuario) REFERENCES USUARIO(IdUsuario)
);

-- Creación de la tabla REGISTRO_USUARIO
CREATE TABLE REGISTRO_USUARIO (
    IdRegistroUsuario INTEGER PRIMARY KEY NOT NULL,
    IdUsuario INTEGER NOT NULL,
    ResultadoInicioSesion TEXT,
    EstadoSesion TEXT,
    FechaIngreso DATETIME DEFAULT CURRENT_TIMESTAMP,
    FechaCierre DATETIME DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT FK_IdUsuario_RegistroUsuario FOREIGN KEY(IdUsuario) REFERENCES USUARIO(IdUsuario)
);
INSERT INTO USUARIO_ROL (IdRol, Nombre)
VALUES (1, 'Admin');
INSERT INTO USUARIO_ROL (IdRol, Nombre)
VALUES (2, 'Javer');



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
VALUES ('Stely', 'Vargas','', '', '', '', '');

INSERT INTO USUARIO (IdRol, Nombre, Correo, Celular, Estado)
VALUES (1, 'Ariel Mora', 'arielabc389@gmail.com', '0995468359', '1');

INSERT INTO USUARIO_CREDENCIAL (IdUsuario, Contrasena)
VALUES (1, '119ce1ac2e100ee9ce9d3b3b7f0debcf');


