create table titulo (
	id_titulo bigint not null unique auto_increment,
    nome varchar(20) not null,
    data_criacao date default now(),
    primary key(id_titulo)
);


create table professor (
	id_professor bigint not null unique auto_increment,
    sexo char not null,
    cpf varchar(11) not null,
    siape varchar(50) not null,
    nome varchar(128) not null,
    data_cadastro date default now(),
    data_nascimento date not null,
    id_titulo int not null,
    foreign key(id_titulo) references titulo(id_titulo),
	primary key(id_professor)
);

create table cargo(
nome varchar(20) not null,
data_criacao date not null,
id_cargo bigint not null unique auto_increment,
primary key(id_cargo)
);

create table professor_cargo(
id_cargo int not null,
id_professor int not null,
foreign key(id_cargo) references cargo(id_cargo),
foreign key(id_professor) references professor(id_professor)
);