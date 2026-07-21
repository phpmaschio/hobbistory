create table usuarios(
    id int generated always as identity primary key,
    login varchar(50) not null unique,
    criado_em timestamp not null 
);