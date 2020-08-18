# How to Run

This is a step-by-step guide how to run the example:

## Installation

* The example is implemented in Java 8. See    https://www.java.com/en/download/help/download_options.xml . The
   examples need to be compiled so you need to install a JDK (Java Development Kit). A JRE (Java Runtime Environment) is not
   sufficient. After the installation you should be able to execute   `java` and `javac` on the command line.
    It also need maven install to be able to run the build phase
   
## Build

Change to the directory `vintrace-code-challenge-java` and run `mvn clean package` 

## Run Excercise 1 
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


## UI/UX Design

Design approach is mobile first. The design below have been thought of for the MVP
Real front implementation may differ based on User Feedback.
![image](https://user-images.githubusercontent.com/17228294/90465154-1b4fbd80-e152-11ea-9af5-dd3f99036b5c.png)
![image](https://user-images.githubusercontent.com/17228294/90465225-45a17b00-e152-11ea-8211-e57655766151.png)
![image](https://user-images.githubusercontent.com/17228294/90465269-5d78ff00-e152-11ea-9f2b-f3edb5c526cf.png)
![image](https://user-images.githubusercontent.com/17228294/90465324-7b466400-e152-11ea-9aec-8356c395121b.png)
![image](https://user-images.githubusercontent.com/17228294/90465353-8f8a6100-e152-11ea-894b-54941c717590.png)


## Tech Stack 
ReactJS

** Axios for promise base calls as it is supported by most browsers
** React router for page Flow
** React Hooks manage Synchronisation Between UI State, and REST API state


## UI Logic 

Server (Third Party Event)

* On HTTP Code 200 LOAD/RENDER Data in state
* Loading, when we are loading paginated data

-- User Events 

* On Load more trigger infinite scrolling appending 
* Edit and Save document in the file 

Data flows

* Files are being loaded from  the application root folder
and processed as JSON over HTTP for REACT Application rendering 


## REST-API  Backend with Spring Boot 

Swagger documentation:

http://localhost:8080/swagger-ui.html

REST API Unit Testing (Done via Mockito)

