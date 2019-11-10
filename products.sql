-- Table role
create table role (
    id serial primary key,
    role varchar(20) not null unique
);

-- Create default roles
insert into role (role) values ('ADMIN');
insert into role (role) values ('USER');

-- Table users
create table users (
    id serial primary key,
    username varchar(50) not null unique,
    password varchar(256) not null,
    role_id integer not null,
    foreign key (role_id) references role(id)
);

-- Table item
create table item (
    id serial primary key,
    code integer not null unique,
    description varchar(256) not null,
    price decimal(11,2),
    state boolean default(true),
    creation_date date not null,
    creator integer not null
);

-- Table supplier
create table supplier (
    id serial primary key,
    name varchar(50),
    country varchar(50)
);

insert into supplier (name, country) values ('Ventas Pepe S.L.', 'Spain');
insert into supplier (name, country) values ('My Store', 'United Kingdom');

-- Table price_reduction
create table price_reduction (
    id serial primary key,
    price_reduction decimal(4,2),
    start_date date,
    end_date date,
    check (end_date >= start_date)
);

insert into price_reduction (price_reduction, start_date, end_date) values (5, '2019-11-01', '2019-11-10');
insert into price_reduction (price_reduction, start_date, end_date) values (10, '2019-11-11', '2019-11-20');

-- Table item_supplier
create table item_supplier (
    id serial primary key,
    item_id integer not null,
    supplier_id integer not null,
    foreign key (item_id) references item(id) on delete cascade,
    foreign key (supplier_id) references supplier(id)
);

-- Table item_pricereduction
create table item_pricereduction (
    id serial primary key,
    item_id integer not null,
    pricereduction_id integer not null,
    foreign key (item_id) references item(id) on delete cascade,
    foreign key (pricereduction_id) references price_reduction(id)
);

-- Table item_discontinued
create table item_discontinued (
    id serial primary key,
    item_id integer,
    user_id integer not null,
    reason varchar(256) not null,
    deactivation_date date not null default CURRENT_DATE,
    foreign key (item_id) references item(id) on delete cascade,
    foreign key (user_id) references users(id)
);
