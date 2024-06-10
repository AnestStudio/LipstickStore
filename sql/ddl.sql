drop table product_image;
drop table product;
drop table brand;
drop table category;

create table brand (
    brand_id          bigint identity primary key,
    brand_name        nvarchar(150),
    brand_description nvarchar(1000),
)
go

create table category (
    category_id          bigint identity primary key,
    category_name        nvarchar(150),
    category_description nvarchar(1000)
)
go

create table product (
    product_id                bigint identity primary key,
    product_name              nvarchar(255) not null,
    product_color             nvarchar(255),
    product_image             varchar(255),
    product_price             decimal,
    product_quantity          int,
    product_short_description nvarchar(500),
    product_description       nvarchar(max),
    category_id               bigint references category,
    brand_id                  bigint references brand
)
go

create table product_image (
    product_image_id bigint identity primary key,
    product_image    varchar(255),
    product_id       bigint references product,
)
go

create table role (
    role_id   bigint identity primary key,
    role_name nvarchar(150)
)
go

create table [user] (
    user_id    bigint identity primary key,
    username   varchar(100) unique not null,
    password   varchar(100) not null,
    created_at datetime2(6) not null,
    status     int          not null,
    deleted    bit          not null
)
go

create table user_address (
    user_address_id   bigint identity primary key,
    user_id           bigint references [user],
    receiver_name     varchar(100),
    receiver_mobile   varchar(11),
    user_address_name varchar(255),
    default_address   bit
)
go

create table user_detail (
    user_detail_id bigint identity primary key,
    user_id        bigint references [user],
    gender         int,
    dob            varchar(11),
    mobile         varchar(15) unique ,
    email          varchar(255) unique
)
go

create table user_role (
    user_role_id bigint identity primary key,
    user_id      bigint references [user],
    role_id      bigint references role
)
