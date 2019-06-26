
# Custom Services  
  
This project is designed to run as a java application.  
  
NOTES:  
it is assumed that Gradle is installed and set in the path, so Tasks are referred just with the command 'gradle'.  For example:  

    gradle tasks
    
If Gradle is not installed, the wrapper included can be used instead. Example for Windows:

    ./gradlew.bat tasks
and Linux:

    ./gradlew tasks
  
## Run the project  
### Execute from code  
    gradle bootRun
Doing it this way omits the Task 'test'

### Build executable jar  
     gradle bootJar
This will compile, test and build the executable, which will be created in {project_home}/build/libs/  
  
Run it as a regular Java Application  
    ``java -jar custom-services-{version}.jar``