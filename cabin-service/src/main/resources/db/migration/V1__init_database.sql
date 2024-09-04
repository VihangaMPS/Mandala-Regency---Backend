CREATE TABLE If NOT EXISTS category (
    id          integer not null primary key,
    name        varchar(255),
    description varchar(255)
);

CREATE TABLE If NOT EXISTS cabin (
    id          integer not null primary key,
    name        varchar(255),
    price       decimal,
    guestCount  integer,

    category_id integer references category
);







