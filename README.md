# Description:
Enhance the previous program, so that it also saves in a new record of a table using plain JDBC in a
MySQL database:

* the file path
* the result of the addition
* the timestamp at program execution

# Objective:
Evaluate JDBC library knowledge, SQL language and programming style.
# Table format: 
* FILENAME VARCHAR (128)
* FILEVALUE FLOAT
* PROCESSDATE TIMESTAMP

# Important notes: 
the program must create the table automatically if it does not exist in its
first run. The program code must use standard ANSI-SQL (not propietary SQL code) to
perform SQL operations. The connection string, user name and password to connect to
database must be configurable in an external text file (.properties or .xml ).


# Precondition
* The Server MySQL must be running.
* The DB must be created (for example comviva)
* Download tomcat 8

# War:
 - application.properties file are setup the db configuration.
 - download dependences, compile and generate target folder:
```sh
 - mvn compile
```
 - test:
```sh
    mvn test
```
 - genrate comviva3-0.0.1-SNAPSHOT.war in folder /target/ : 
 ```sh
    mvn package
```

# Deployment in tomcat
 - Copy our WAR file from target/comviva3-0.0.1-SNAPSHOT.war to the tomcat8/webapps/ folder
 - From a terminal navigate to tomcat8/bin folder and execute
    - catalina.sh run (on Unix-based systems)
 - Go to http://localhost:8080/comviva3-0.0.1-SNAPSHOT
 - Endpoints: 
    - GET  ->   /comviva/list
    - POST ->   /process-file/process
        - body:
            {
                "path": "/home/hernan/workspace/eclipse-workspace/comviva/files/test1.txt"
            }