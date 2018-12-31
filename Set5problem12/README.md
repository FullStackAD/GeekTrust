Set5
This project solves two problems in the problem set 5. Problem 1: A Golden Crown Problem 2: Breaker of Chains

Getting Started
The solution zip file contains Set5Problem12 project folder.
To view the project source code, import the project to the IDE, by selecting the Set5Problem12 folder.

The project follows standard maven project structure.

Running the tests
Tests can be run on the jar (CLI) or from the IDE.

From CLI
run the following command from the directory Set5Problem12
>mvn clean install

This will create the Set5Problem12.jar in the target directory inside Set5Problem12

The application expects either problem1 or problem2 as an argument.

To Run Problem1

>java -cp target/Set5problem12.jar problem.set.q.Problem1

To Run Problem2

>java -cp target/Set5problem12.jar problem.set.q.Problem2

After running the command, the application asks for inputs from the CLI.

Inputs need to added via CLI 

For Problem1:

Input must be the messages sent by Shan in format
toKingdom, "Message" 
as is given in PDF
eg.
--------------------------------------------------
>Air, “Let’s swing the sword together”
>Land, “Die or play the tame of thrones”
>Ice, “Ahoy! Fight for me with men and money”
>Water, “Summer is coming”
>Fire, “Drag on Martin!”
--------------------------------------------------

For Problem2

Input is just the competing kingdoms separated by Space
eg.

--------------------------------------------------
>Ice Space Air
--------------------------------------------------

From IDE
To We just need to run the main class in Problem1 or Problem2 depending on what we need to Execute.


For Test Cases

They are in the package test.

Only for scanner inputs we have used the  System.rules
 (https://stefanbirkner.github.io/system-rules/) library.
 
 This has been added as a dependency in pom file.