create table users
(
    id        int auto_increment primary key,
    full_name varchar(50) null,
    email     varchar(50) null,
    password  varchar(50) null,
    createdAt datetime null,
    updatedAt datetime null
);

create table authorities
(
    id        int auto_increment primary key,
    user_id   int         not null,
    username  varchar(50) not null,
    authority varchar(50) not null,
    constraint authorities_user_id_fk foreign key (user_id) references users (id)
);

create index user_id on authorities (user_id);



