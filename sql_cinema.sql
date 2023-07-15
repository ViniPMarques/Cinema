create table filme (
	idfilme serial not null primary key,
	titulo varchar(30) not null,
	diretor varchar(50) not null,
	idgenero integer not null,
	idsala integer not null,
	film varchar (255) not null,
	foreign key (idgenero) references genero (idgenero),
	foreign key (idsala) references sala (idsala)
)

create table genero (
	idgenero serial not null primary key,
	nome varchar(30) not null,
	classificacao varchar(30) not null
)

create table sala (
	idsala serial not null primary key,
	nome varchar(30) not null,
	cadeiras integer not null,
	vip boolean not null
)

create table usuario (
	idusuario serial not null primary key,
	login varchar(30) not null,
	senha varchar(30) not null
)

select * from usuario

insert into genero(nome, classificacao) values ('Comedia', 'Livre');
insert into genero(nome, classificacao) values ('Luta', '18+');
insert into genero(nome, classificacao) values ('Aventura', '14+');
insert into genero(nome, classificacao) values ('Drama', '16+');
select * from genero

insert into sala(nome, cadeiras, vip) values ('1A', 50, 'f');
insert into sala(nome, cadeiras, vip) values ('1B', 100, 't');
insert into sala(nome, cadeiras, vip) values ('1C', 75, 'f');
insert into sala(nome, cadeiras, vip) values ('2A', 50, 't');
insert into sala(nome, cadeiras, vip) values ('2B', 100, 'f');
select * from sala

insert into filme(titulo, diretor, idgenero, idsala, film) values ('Joker','Todd Phillips',4,2,'https://youtu.be/zAGVQLHvwOY');
insert into filme(titulo, diretor, idgenero, idsala, film) values ('Carros 3','Brian Fee',3,5,'https://youtu.be/BuvJZGLclAU');
insert into filme(titulo, diretor, idgenero, idsala, film) values ('Avatar 2','James Cameron',4,3,'https://youtu.be/d9MyW72ELq0');
select * from filme