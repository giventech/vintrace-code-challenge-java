# How to Run

This is a step-by-step guide how to run the example:

## Installation

* The example is implemented in Java 8. See    https://www.java.com/en/download/help/download_options.xml . The
   examples need to be compiled so you need to install a JDK (Java Development Kit). A JRE (Java Runtime Environment) is not
   sufficient. After the installation you should be able to execute   `java` and `javac` on the command line.
    It also need maven install to be able to run the build phase
   
## Build

Change to the directory `vintrace-code-challenge-java` and run `mvn clean package` 

## Run Exercise 1 
------------------
    java -cp target/exerciseone-1.0-SNAPSHOT.jar devproblem.WineTest
    
## Output 
------

 ![image](https://user-images.githubusercontent.com/17228294/89143038-8911bc00-d58c-11ea-9053-54b24a778027.png)
   

## Run Excercise 2
------------------
    mvn spring-boot:run 

This may take a few minutes at the build embed Node and Npm installation
## Output from browser)
----------
Ad can access the application on the port 8080 
http://localhost:8080
![image](https://user-images.githubusercontent.com/17228294/90369424-1c7bde80-e0af-11ea-88de-fd94b31f2d54.png)

## UI/UX Prototyping 

Design approach is mobile first. The design below have been thought of for the MVP
Real front implementation may differ based on User Feedback.

### Landing page
![image](https://user-images.githubusercontent.com/17228294/90465154-1b4fbd80-e152-11ea-9af5-dd3f99036b5c.png)

### Details and composition

![image](https://user-images.githubusercontent.com/17228294/90465225-45a17b00-e152-11ea-8211-e57655766151.png)

### Before load more
![image](https://user-images.githubusercontent.com/17228294/90465324-7b466400-e152-11ea-9aec-8356c395121b.png)

### After load more
![image](https://user-images.githubusercontent.com/17228294/90465269-5d78ff00-e152-11ea-9f2b-f3edb5c526cf.png)

### Optional edit fields
![image](https://user-images.githubusercontent.com/17228294/90465353-8f8a6100-e152-11ea-894b-54941c717590.png)

## Software Solution  

The technology stack includes the below:
1.  CSS responsive framework (Bootstrap 4,)
1.  SPA React (react DOM, react hooks, router, state and axios, (Todo: Unit tests))
2.  Spring boot ( Spring Data, Spring REST, JUnit+ Mockito, Open API Documentation)
3.  Filed Data Access via service layer 
4.  TODO: Unit testing via Jest or other

## UI Logic 

* On react hooks (Server respond Code 200 + JSON Data) UI Re-render the message when 
* On clicking  trigger loadmore  appending 
* On clicking edit and Save document in the file 

## REST-API  Backend with Spring Boot 

Swagger documentation:

http://localhost:8080/swagger-ui.html
REST API Unit Testing (Done via Mockito)

https://www.youtube.com/watch?v=NZKUirTtxcg
https://bezkoder.com/react-hooks-crud-axios-api/
