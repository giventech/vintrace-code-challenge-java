# How to Run

This is a step-by-step guide how to run the example:

## Installation

* The example is implemented in Java 8. See    https://www.java.com/en/download/help/download_options.xml . The
   examples need to be compiled so you need to install a JDK (Java Development Kit). A JRE (Java Runtime Environment) is not
   sufficient. After the installation you should be able to execute   `java` and `javac` on the command line.
    It also need maven install to be able to run the build phase
   
## Build

Change to the directory `vintrace-code-challenge-java` and run `mvn clean package` 

## Run 
-----
    java -cp target/exerciseone-1.0-SNAPSHOT.jar devproblem.WineTest
    

## Output 
------

 ![image](https://user-images.githubusercontent.com/17228294/89143038-8911bc00-d58c-11ea-9053-54b24a778027.png)
   
## UI/UX Design

Design approach is mobile first.
The mobile design presented would fit in full screen rearraging columns bas on breakpoint


Feature inline edit

## Tech Stack 
ReactJS
** Axios for promise base calls as it is supported by most browsers
** React router for page Flow
** React Hooks manage access to API and state

Spring Boot
** Spring DATA 
** Spring REST
** React hook manage access to API and state

## Tech Stack 

## UI Logic 

Server (Third Party Event)
1) On HTTP Code 200 LOAD/RENDER Data in state
2) Loading, when we are loading paginated data

User Events 

3) On Load more trigger infinite scrolling appending 
4) Edit and Save document in the file 

Data flows 


## Backend service layer 




Infinite loop
https://www.youtube.com/watch?v=NZKUirTtxcg
https://bezkoder.com/react-hooks-crud-axios-api/