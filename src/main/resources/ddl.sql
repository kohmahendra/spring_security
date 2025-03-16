create table users
(
    id                 int          not null
        primary key,
    created_date_time  datetime(6)  null,
    email              varchar(255) not null,
    first_name         varchar(255) not null,
    last_name          varchar(255) not null,
    modified_date_time datetime(6)  null,
    password           varchar(255) not null,
    constraint users_email_uk
        unique (email)
);

create table users_seq
(
    next_val bigint null
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



