create database lab2;

#Tablas
create table Cliente 
(identificacion varchar(30) not null,
nombre varchar(255) not null,
direccion varchar(100) not null,
telefono varchar(30) not null,
correo varchar(100) not null,
fecha_creacion varchar(60) null,
primary key (identificacion));

create table Tarjeta
(numero varchar(100) not null unique,
cvv varchar(3) not null,
fecha_vencimiento varchar(60) not null,
tipo_de_tarjeta varchar(200) not null,
fecha_creacion varchar(60) null,
primary key (numero));

SET @@global.time_zone = '+00:00';
SET @@session.time_zone = '+00:00';



create table Transaccion
(id int NOT NULL AUTO_INCREMENT,
cliente_id varchar(30) not null,
tarjeta_id varchar(100) not null,
valor double unsigned not null,
fecha_creacion datetime null,
primary key (id),
FOREIGN KEY (cliente_id) REFERENCES Cliente(identificacion),
FOREIGN KEY (tarjeta_id) REFERENCES Tarjeta(numero));


# Registros de prueba

insert into Cliente values ('12345', 'Pepito Perez', 'Calle 34A', 'Medellin', '3204365743', 'pperez@gmail.com', now());

insert into Tarjeta values ('5390700823285988', '333', '2021-03-10', 'Visa', now());

insert into Transaccion (cliente_id, tarjeta_id, valor, fecha_creacion) values ('12345', '5390700823285988', '5000', now());

select * from lab2.cliente;

select * from transaccion;