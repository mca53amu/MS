Prerequisites-
Run MongoDB on port 27017

1-git init
2-git clone https://github.com/mca53amu/MS.git
3-cd MS
4-mvn clean install (This will create the jar file in the target folder after successfully running Unit Test cases)
5-cd target
6-java -jar MobileStoreApi-0.0.1-SNAPSHOT.jar (This will run the application on tomcat server at  port 8080)