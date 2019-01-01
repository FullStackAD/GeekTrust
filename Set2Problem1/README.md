Set2
This project solves Problem 1: The two planets

Getting Started
The solution zip file contains Set2Problem1 project folder.
To view the project source code, import the project to the IDE, by selecting the Set2Problem1 folder.

The project follows standard maven project structure.

Running the tests
Tests can be run on the jar (CLI) or from the IDE.

From CLI
run the following command from the directory Set5Problem12
>mvn clean install

This will create the Set2Problem1.jar in the target directory inside Set5Problem12

The application expects either problem1 or problem2 as an argument.

To Run Problem1

>java -cp target/Set2Problem1.jar com.taraB.Problem1

Inputs need to added via CLI 

For Problem1:

Input must contain no of units followed by space then by the initial of Unit name
eg.
--------------------------------------------------
>52 H, 50 E, 10 AT, 3 SG
H-> Horses
E-> Elephants
AT->Armoured Tank
SG->Sling Guns
--------------------------------------------------

From IDE
To We just need to run the main class in Problem1.


For Test Cases


Only for scanner inputs we have used the  System.rules
 (https://stefanbirkner.github.io/system-rules/) library.
 
 This has been added as a dependency in pom file.