# Questionnaire
HUM Technical task


# Prerequisites

•	Java 8 

•	Maven 3.5.3

•	Windows/Linux

•	Postman 5.5.4

•	Git

•	Docker (optional)

•	Jenkins (optional)

# Server Details
•	Embedded Apache Tomcat

# Technologies
•	Spring Boot 2.2.1
# Installation
•	Clone codebase from Git Repository using below command

Git clone https://github.com/nareshthota247/questionnaire.git.

•	Run the below command in command prompt from the root project folder 

mvnw clean package -Dmaven.test.skip=true

•	Please notice the generated jar file in the location target folder.

•	Run the below command from the same location i.e root project folder 

java -jar target/hum.jar

•	Now can test using postman or swagger using the URL: http://www.localhost:8082/hum/swagger-ui.html


