# **shipping-rate**

To accept input from user to show details on shipping rate provided by participated company by using web scraping
(note that this project is not complete yet. Any comment/feedback is much appreciated). 

First thing need to have:

  1. Java 11
  2. Maven 3.5.3
  3. MySql 8.0.30
  
### 1) Installing packages

Clone this project first in your local.
Then run:
```
  mvn clean install
```


### 2) Creating the schema

Go inside `./sql` to find `shipping_rate.sql`.

In order to create the DB and schema, run the file:
```
source shipping_rate.sql;
```


### 3) Start the application

Start the spring boot application by using this command:
```
mvn spring-boot:run
```


### 4) Testing using SwaggerUI

Go to browser and access this url: `http://localhost:8080/swagger-ui`.

You can find the sample request body in `shipping_rate.postman_collection.json` file.


# Summary

Currently, able to store the data in the DB but scraping still in progress due to dynamically change HTML Element which blocking scraping process. Any feedback is much appreciated and welcomed :)


*Note to TM panels: 

    1. this application able to save the record in DB.
    2. due to time constraint, able to integrate with J&T API only.
    3. scraping process able to submit form button but unable to scrape the value due to empty div tag in origin code `<div id="content"></div>`. In the code, the devs override the div tag to show the table.
    4. for assignment #2, please find the file in parent folder named `assignment2.txt`. The solution is build on Javascript language.
