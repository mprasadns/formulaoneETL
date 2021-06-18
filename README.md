**Project Description**
Objective of this project is to extract the given file and load the result in a csv file with fastest lap drivers.

**EXECUTING THIS APPLICATION**
There is main class "FormulaOneETL" which contains **"main method"**, which can be used to execute the program.

Steps to execute the program:
1. Go to the director where the "FormulaOneETL.class" file exists
2. Enter the command "java FormulaOneETL"
3. In the same directory one can see output.csv file

**DOCKER**
Also docker file has been created to containerise application.

**OUTPUT OF THIS APPLICATION**
The application will output csv named "output.csv" file in the application. 

**General description on Test**
 - Test names defined in a Behaviour fashion, for example, test states what is the unit behaviour of the component 
 responsibility and this responsibility could be implemented by more than one method in the class

**Extractor**
Description: This domain will load the data from the csv file. Note that if you give blank or null
file then it will load default file, which is stored inside the resource location.

**Transform**
Business domain to transform the data from 

**Integration Test**
 - First test shows the behaviour of just getting the average, without consideration to any ordering
 - Second behaviour test shows that ascending order is important
 
**Unit Test**
 - Pojo class "FormulaOneDriver" will not going to have any unit test, because:
    - POJO class doesn't have behaviour that contributes to functionality
    - POJO Unit test is just over doing TDD, without much of an use
  - Test shouldGetListOfDrivers shows container class for the Collection 
    class has been able to return this value, also while thinking from TDD
    this test helped as the first one to be there.
  -  Even though one of the test looks similar to Integration test, in real world
     unit test will have more number of tests than the IT tests
     
**Load**
 - An ouput file will be created at the same loction where the execution of the program happened.
 - If the location needed to be changed, please provide the file name with complete path in the command
 


     