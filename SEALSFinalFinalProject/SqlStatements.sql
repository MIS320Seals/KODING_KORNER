/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  Lauren
 * Created: Apr 12, 2017
 */


ALTER TABLE sakila.customer
ADD username varchar(100) NOT NULL,
ADD password varchar(100) NOT NULL;

Update sakila.customer
set username = email
where username like '';

Update sakila.customer 
set password = CONCAT(first_name , '_' , last_name)
where password like '';

Update sakila.customer
set username = 'hi'
where customer_id = 1;

update sakila.customer 
set password = 'hi'
where customer_id = 1;

create Table cart(
cart_id int NOT NULL AUTO_INCREMENT,
customer_id SMALLINT,
film_id SMALLINT,
title VARCHAR(255),
price DECIMAL(3,2),
date_added TIMESTAMP Default CURRENT_TIMESTAMP,
PRIMARY KEY (cart_id))

create Table wishlist(
cart_id int NOT NULL AUTO_INCREMENT,
customer_id SMALLINT,
film_id SMALLINT,
title VARCHAR(255),
price DECIMAL(3,2),
date_added TIMESTAMP Default CURRENT_TIMESTAMP,
PRIMARY KEY (cart_id))