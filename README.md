# Mini project in spring boot with mysql and docker compose
This Project uses inMemory authentication for two hard-coded users:

Admin: username: admin password: admin

User: username: user password: user 

# Requirements



•	Apache Maven 3.6.2

•	For building and running the application you need:

		Database Configuration

		Database Name: sample
		
		Username: root
		
		Password: root
		

##Using MySQL database

```bash
spring.datasource.url = jdbc:mysql://mysql-standalone:3306/sample

spring.datasource.username = root

spring.datasource.password = root

```



## Building the application

Steps:

1.Build an executable JAR file that contains all the necessary dependencies, classes, and resources with:

```bash
mvn clean
```

```bash
mvn install
```




Notice the jar file created inside target folder


2.Run the docker command with:

```bash
docker-compose up
```



3.Access  URL

Go to following link

```bash

http://localhost:8085/api/public

This page is available to all public

```

Go to following link

```bash

http://localhost:8085/api/listall

This is accessible to authenticated uses only not to public

```

Go to following link
 
```bash

http://localhost:8085/api/load

This performs batch task only accessible to admin 

```
 
 

4.Check the database sample and the table userdto. 
```bash
go to terminal
docker exec -it mysql-standalone bash
mysql -u root -proot
use sample
show * from userdto
```

