
drop database if exists RocnicEstatus;
create database RocnicEstatus;
use RocnicEstatus;


create table Perfiles(
IdPerfil int primary key  not null auto_increment ,
NombrePerfil varchar (20)
);

create table TipoReporte(
IdTipoReporte int primary key  not null auto_increment,
NombreTipoReporte varchar (20),
FechaCreacion datetime
);

/*create table EquipoLaboratorio(
IdEquipoLaboratorio int primary key,
IdLaboratorio int
);*/

create table EstatusReporte(
IdEstatusReporte int primary key not null auto_increment,
NombreEstatus varchar (20)
);

create table Perifericos(
IdPeriferico int primary key not null auto_increment,
NombrePerifericos varchar (20)
);

create table Usuarios(
IdUsuario int primary key not null auto_increment,
IdPerfil int,
Usuario varchar (20),
Contraseña varchar (20),
Nombre varchar (20), 
Boleta  varchar (10) ,
foreign key (IdPerfil) references Perfiles (IdPerfil) on delete cascade on update cascade
);

create table Laboratorio(
IdLaboratorio int primary key not null auto_increment,
NombreLaboratorio varchar(16) ,
NumeroEquipo int,
IdPeriferico int,
foreign key (IdPeriferico) references Perifericos (IdPeriferico) on delete cascade on update cascade
);


create table TipoError(
IdTipoError int primary key not null auto_increment,
NombreError varchar (20),
IdTipoReporte int,
foreign key (IdTipoReporte) references TipoReporte (IdTipoReporte) on delete cascade on update cascade
);



create table Reportes(
IdReporte int primary key not null auto_increment,
IdTipoReporte int,
IdLaboratorio int,
IdUsuario int,
IdTipoError int,
IdEstatusReporte int,
FechaCreacion datetime,
FechaActualizacion datetime,
UsuarioActualizacion datetime,
UsuarioCreacion datetime,
foreign key (IdTipoReporte) references TipoReporte (IdTipoReporte) on delete cascade on update cascade,
foreign key (IdLaboratorio) references Laboratorio (IdLaboratorio) on delete cascade on update cascade,
foreign key (IdUsuario) references Usuarios (IdUsuario) on delete cascade on update cascade,
foreign key (IdTipoError) references TipoError (IdTipoError) on delete cascade on update cascade,
foreign key (IdEstatusReporte) references EstatusReporte (IdEstatusReporte) on delete cascade on update cascade
);


INSERT INTO perifericos (NombrePeriferico) VALUES('CPU');












