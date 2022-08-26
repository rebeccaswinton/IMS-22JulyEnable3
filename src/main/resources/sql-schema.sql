drop schema ims;

<<<<<<< 
=======
create database ims;
use ims;
create table customers (
id bigint primary key auto_increment not null,
first_name varchar(225) not null,
surname varchar(225) not null
);
create table items (
item_id bigint primary key auto_increment not null,
`title` varchar(80) not null, 
`price_decimal` decimal(10,2) not null, 
`stock` int
);
create table orders (
order_id bigint primary key auto_increment not null,
fk_customer_id bigint not null,
foreign key (fk_customer_id) references customers(id)
);
create table orders_items (
order_item_id bigint primary key auto_increment not null,
fk_order_id bigint not null,
fk_item_id bigint not null,
quantity int not null,
foreign key (fk_order_id) references orders(order_id),
foreign key (fk_item_id) references items(item_id)
>>>>>>> controllerTest
);
