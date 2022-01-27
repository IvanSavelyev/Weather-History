Write a REST service with a single endpoint /weather.
When called, this service must query a database for today's weather (temperature) in the table "weather_history". If no record is found in the database for the current date, then it must read the current temperature value from page "yandex.ru". After reading temperature, it must insert a new record in "weather_history". In the end, it must return the temperature value back to the user.

Notes:
• You can use any Java framework to build a web service (e.g. Spring).
• You can use any database to keep historical data (e.g. PostgreSQL).
• You can use JDBC or JPA interfaces to interact with the database.
• To read a web page and extract temperature values, use standard Java classes (no need to use an additional library).
Table weather_history has two columns:
• weather_date DATE
• weather_value VARCHAR

## Installing

    git clone https://github.com/IvanSavelyev/Restaurant-Voting-System.git

## Run

    mvn spring-boot:run

## In memory DB credentials
    -jdbc:h2:mem:voting
    -jdbc:h2:tcp://localhost:9092/mem:weather
    -username=sa
    -password=

The full description of the application is available at the link (when the application is running)

Start the project (mvn spring-boot:run) and go to
[SWAGGER](http://localhost:8080/swagger-ui.html)