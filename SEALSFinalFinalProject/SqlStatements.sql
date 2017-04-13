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



GO  
CREATE PROCEDURE sakila.getFilmsByCategory   
   @Category_id TINYINT     
AS    
select f.title,f.description,f.rating,f.release_year
from sakila.film as f 
join sakila.film_actor as FA
on f.film_id = fa.film_id
join sakila.film_category as FC
on fa.film_id = fc.film_id
where FC.category_id = @Category_id
go


create Table cart(
customer_id SMALLINT,
film_id SMALLINT,
title VARCHAR(255),
date_added TIMESTAMP Default CURRENT_TIMESTAMP)