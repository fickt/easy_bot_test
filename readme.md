По поводу запуска приложения.

Единственное возможно придётся поднять базу H2
с такими параметрами:
spring.datasource.url=jdbc:h2:mem:testdb
spring.datasource.driverClassName=org.h2.Driver
spring.datasource.username=sa
spring.datasource.password=password
spring.jpa.database-platform=org.hibernate.dialect.H2Dialect

Прочие подробности расписаны в application.properties

По эндпоинтам:
http://localhost:8080/v1/api и все производные от него /monitors, /computers, /harddrives, /laptops

Чтобы сильно не заморачиваться с проверкой, а действительно ли работает приложение, в src/main/resources/postman лежит файл
postman_collection_ease_bot.postman_collection.json, в нём 31 тест
