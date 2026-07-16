create table usuarios(
    id int not null primary key,
    login varchar(50) not null unique,
    criado_em timestamp not null 
);