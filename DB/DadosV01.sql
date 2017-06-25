create database Dados;
use Dados; 

create table professor (
	id_professor bigint not null unique auto_increment,
    sexo char not null,
    cpf varchar(11) not null,
    siape varchar(50) not null,
    nome varchar(128) not null,
    data_cadastro date not null,
    data_nascimento date not null,
    titulo int not null,
	vinculo int not null,
	primary key(id_professor)
);


create table usuario(
	id_usuario bigint auto_increment,
    nome varchar(60) not null,
    usuario varchar(15) not null unique,
    senha varchar(60) not null,
    id_grupo bigint,
    primary key(id_usuario)
);

insert into usuario(nome, usuario, senha, id_grupo) values('Administrador do Sistema', 'ADM', MD5('ADMSystem'), 1);

select * from professor where nome like '%Tia%';

delete from professor;
drop table professor;
