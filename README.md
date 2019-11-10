# Products
## Configuration
### Database configuration
- Create a PostrgreSQL database.

- Create the database schema according to the file `products.sql`.

- In the `application.properties` file, modify the database data (url, username and password).

    `spring.datasource.url=jdbc:postgresql://192.168.1.61:5432/products2`
    
    `spring.datasource.username=postgres`
    
    `spring.datasource.password=123456`

### Port configuration

- In the application.properties file, set the port.

     `server.port=8080`