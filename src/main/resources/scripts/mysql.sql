## Use to run mysql db docker image, optional if you're not using a local mysqldb
# docker run --name mysqldb -p 3306:3306 -e MYSQL_ALLOW_EMPTY_PASSWORD=yes -d mysql

# connect to mysql and run as root user
#Create Databases
CREATE DATABASE dev;

#Create database service accounts
CREATE USER 'devuser'@'%' IDENTIFIED BY 'dev';

#Database grants
grant create, select, insert, update, delete, drop, alter on dev.* to 'devuser'@'%';