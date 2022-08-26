INSERT INTO `ims`.`customers` (`first_name`, `surname`) VALUES ('Hannah', 'Montanna');
SELECT * FROM ims.customers;
SELECT * FROM ims.customers ORDER BY customer_id DESC LIMIT 1;
SELECT * FROM ims.customers WHERE customer_id = 1;
UPDATE ims.customers SET first_name = Tony, surname = Montanna WHERE customer_id = 1;
DELETE FROM ims.customers WHERE customer_id = 1;

INSERT into ims.items( title, price_decimal, stock) VALUES ( "Handheld Fan Rechargeable Blue", 12.99, 21);
SELECT * FROM ims.items;
SELECT * FROM ims.items WHERE item_id = 1;
UPDATE ims.items SET title = 'Apple iPhone 13 Pink', price_decimal = 629.99, stock = 30 WHERE item_id =3;
DELETE FROM ims.items WHERE item_id = 1;

INSERT INTO ims.orders(fk_customer_id) VALUES (1);
SELECT * FROM ims.orders;
SELECT * FROM ims.orders ORDER BY order_id DESC LIMIT 1;
SELECT * FROM ims.orders WHERE order_id = 1;
UPDATE ims.orders SET fk_customer_id = 1 WHERE order_id =1;
DELETE FROM ims.orders WHERE order_id = 1;

INSERT into ims. orders_items(fk_order_id, fk_item_id, quantity) VALUES (1,1,4);
SELECT * FROM ims.orders_items;
SELECT * FROM ims.orders_items ORDER BY order_item_id DESC LIMIT 1;
UPDATE ims.orders_items set fk_order_id = 1, fk_item_id = 1, quantity = 7 WHERE order_item_id =1;
DELETE FROM ims.order_items WHERE order_item_id = 1;