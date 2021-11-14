# airportDatabase V 0.1.0-Snapshot
Download all Airport CSVs from https://ourairports.com/data, parse it and insert it into a mysql database

# Prequesits

for windows-users which don't have skills in git, docker, maven and java, start with the following steps:
- Download and Install git for windows
  https://git-scm.com/downloads

- Download Docker for Windows
  https://hub.docker.com/editions/community/docker-ce-desktop-windows

- go into a folder where you want to download this project and open a command line in this path
- clone this rpository with
> git clone https://github.com/rentasad/airportDatabase.git


# How to start

in resources/config/ you find the config file for the project:

- [resources/config/downloadLinks.ini](resources/config/downloadLinks.ini)
  This file contains the download-links and files for the airports datas. 

- [resources/config/exampleConfigSqlExecution.ini](resources/config/exampleConfigSqlExecution.ini)
  example config file, contains the default configuration values for sql excecution and database connection. 
  Copy this file to "configSqlExecution.ini" and change the config values to connect to your mySql database instance

# Use Docker to connect to own local mysql container
in [/docker-compose.yml](/docker-compose.yml) you find a small example to provide a 
small mariadb-database docker-instance to use it for the database creation.

You yould start the containers with 
> docker-compose up

if you want to exit the container press STRG+C 

To start the containers in background use

> docker-compose -d up

After starting the container you could access the mySql-Database with phpmyadmin and 
http://localhost:8080

the default login is: root / notSecureChangeMe



# State of Project:
SNAPSHOT to 0.1.0
