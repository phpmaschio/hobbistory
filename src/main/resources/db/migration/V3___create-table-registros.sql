create table registros(
    id int not null primary key,
    descricao varchar(100) not null,
    data_registro timestamp not null,
    criado_em timestamp not null,
    passatempo_id int not null,
    foreign key(passatempo_id) references passatempos(id)
);