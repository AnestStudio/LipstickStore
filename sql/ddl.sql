drop table product_image;
drop table product;
drop table brand;
drop table category;

create table brand (
    brand_id          bigint identity primary key,
    brand_name        nvarchar(150),
    brand_description nvarchar(2000),
)
go

create table category (
    category_id          bigint identity primary key,
    category_name        nvarchar(150),
    category_description nvarchar(2000)
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

drop table user_address;
drop table user_detail;
drop table user_role;
drop table [user];

create table [user] (
    user_id    bigint identity primary key,
    username   varchar(100) unique not null,
    password   varchar(100) not null,
    full_name  nvarchar(100) not null,
    created_at datetime2(6) not null,
    status     int          not null,
    deleted    bit          not null
)
go

create table user_address (
    user_address_id        bigint identity primary key,
    user_id                bigint references [user],
    receiver_name          nvarchar(100) not null,
    receiver_mobile        varchar(12) not null,
    user_address_detail    nvarchar(255) not null,
    user_address_wards     nvarchar(100) not null,
    user_address_districts nvarchar(100) not null,
    user_address_provinces nvarchar(100) not null,
    default_address        bit not null
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



create table [order_status] (
    order_status_id bigint identity primary key,
    order_status    nvarchar(100)
)
go

create table [order] (
    order_id           bigint identity primary key,
    user_id            bigint references [user],
    order_status_id    bigint references [order_status],
    order_shipped_date datetime2(6),
    order_created_at   datetime2(6) not null,
    order_discount     float not null,
    order_total_amount decimal not null,
    order_note         nvarchar(1500),
    receiver_name      nvarchar(100) not null,
    receiver_mobile    varchar(12) not null,
    shipping_address   nvarchar(1000)  not null
)
go

create table [order_detail] (
    order_detail_id bigint identity primary key,
    order_id        bigint references [order],
    product_id      bigint references product,
    product_name    nvarchar(255) not null,
    product_color   nvarchar(255) not null,
    product_image   varchar(255) not null,
    product_price   decimal not null,
    quantity        int not null,
    amount          decimal not null,
)
