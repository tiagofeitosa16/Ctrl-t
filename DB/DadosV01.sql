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

select * from professor where nome like %Tiago%;

delete from professor;
drop table professor;
