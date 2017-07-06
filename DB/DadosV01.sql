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

create table Turma(
    codigo bigint not null unique auto_increment,
    descricao varchar(255),
    graduacao int not null, -- 1 = Superior, 2 - Técnico
    ano_letivo varchar(20) not null,
    primary key (codigo)
);

create table equipamento(
    codigo bigint not null unique auto_increment,
    descricao varchar(255),
    numero_tombamento int not null,
    data_cadastro date not null, 
    estatus int not null, 
    inativo int not null,
    primary key(codigo)
);


insert into usuario(nome, usuario, senha, id_grupo) values('Administrador do Sistema', 'ADM', MD5('ADMSystem'), 1);


