--Creación de tablas

create table Clientes(

    cedula varchar(25) not null,
    nombre varchar(50) not null,
    apellido varchar(50) not null,
    telefono varchar(20) not null,
    primary key (cedula)
);

create table Historias(

    idHistoria serial primary key,
    cedulaCliente varchar(25) not null,
    oi varchar(10) not null,
    od varchar(10) not null,
    add varchar(10) not null,
    dp varchar(10) not null,
    foreign key (cedulaCliente) references Clientes (cedula) on delete cascade
);

--Agregar datos de testeo

