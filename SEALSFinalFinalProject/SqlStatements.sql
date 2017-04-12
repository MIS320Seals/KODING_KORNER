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

Update customer
set username = email
where username like '';

Update customer 
set password = CONCAT(first_name , '_' , last_name)
where password like '';

Update customer
set username = 'hi'
where customer_id = 1;

update customer 
set password = 'hi'
where customer_id = 1;
