# Realm
Simple API to support the creation and retrieval of User Realms.  
# 
Default profile is set to "mysql", can be changed to "h2".

For mysql; change properties according to your environment.("spring.datasource.url", "spring.datasource.username" .. etc)
"/realm/src/main/resources/scripts/mysql.sql" file can be used as an example.
# 
TODOs:

- jackson-core
- jackson-databind
- jackson-dataformat-xml 

are incompatible with spring-boot-starter-parent. Unfortunately their versions are overridden. 

- RealmController

change the content-type implementation and do it in nice way.

