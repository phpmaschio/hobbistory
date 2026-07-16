create table passatempos(
    id int not null primary key,
    descricao varchar(100) not null,
    usuario_id int not null,
    foreign key(usuario_id) references usuarios(id),
    criado_em timestamp not null
);