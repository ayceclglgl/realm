# Realm
Simple API to support the creation and retrieval of User Realms.
- Creation: /service/user/realm 

- Retrieval: /service/user/realm/{id}

## Application Information
### DB
Default profile is set to "h2", can be changed to "mysql".

For mysql; change properties according to your environment.(url, username, password...)

"mysql.sql" file in "/realm/src/main/resources/scripts/" can be used as an example.
### Tomcat Deploy
To get WAR file; mvn clean package. WAR file is generated at \target\realm.war. 
Copy the WAR file from target/realm.war to the tomcat\webapps\folder.
Run Tomcat server.
Go to url with adding "realm" i.e localhost:8080/realm/service/user/realm or localhost:8080/realm/service/user/realm/{id}

# 
TODOs:

- jackson-core
- jackson-databind
- jackson-dataformat-xml 

are incompatible with spring-boot-starter-parent. Unfortunately their versions are overridden. 
