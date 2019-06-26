
# Custom Services  
  
This project is designed to run as a java application.  
  
NOTES:  
it is assumed that Gradle is installed and set in the path, so Tasks are referred just with the command 'gradle'.  For example:  

    gradle tasks
    
If Gradle is not installed, the wrapper included can be used instead. Example for Windows:

    ./gradlew.bat tasks
and Linux:

    ./gradlew tasks

## Defaults
Port: 8080

## Run the project  
### Execute from code  
    gradle bootRun
Doing it this way omits the Task 'test'

### Build executable jar  
     gradle bootJar
This will compile, test and build the executable, which will be created in {project_home}/build/libs/  
  
Run it as a regular Java Application  
    ``java -jar custom-services-{version}.jar``

### Deploy in docker container
In the root dir (where Dockerfile is located) build a java image with to run the application. Example:
    docker build -t custom-services:0.0.1 .

Move the .jar file to a proper volume folder removing the version number from the name. Example:
    cp build/libs/custom-services-0.0.1-SNAPSHOT.jar ~/custom-services-volume/custom-services.jar

Next, run the image mounting the folder as a volume to /home/boot. Example:
    docker run -t -v /home/myuser/custom-services-volume:/home/boot -p 8080:8080 --name=cservices custom-services:0.0.1

Notes: it is recommended to match image version with the executale .jar version