create table products (
       id bigint not null auto_increment,
        category varchar(255),
        name varchar(100),
        price bigint,
        primary key (id)
    ) engine=InnoDB DEFAULT CHARSET=utf8;