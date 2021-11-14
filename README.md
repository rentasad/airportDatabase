# airportDatabase
Download Airport.csv from https://ourairports.com/data, parse it and insert it into a mysql database
V 0.1.0-Snapshot

# How to use

in resources/config/ you find the config file for the project:

- [resources/config/downloadLinks.ini](resources/config/downloadLinks.ini)
  This file contains the download-links and files for the airports datas. 

- [resources/config/exampleConfigSqlExecution.ini](resources/config/exampleConfigSqlExecution.ini)
  example config file, contains the configuration values for sql excecution and database connection. 
  
Copy this file to "configSqlExecution.ini" and change the config values to connect to your mySql database instance

# Use Docker to connect to own local mysql container
in [/docker-compose.yml](/docker-compose.yml) you find a small example to provide a 
small mariadb-database docker-instance to use it for the database creation.

You yould start the containers with 
´ docker-compose up

if you want to exit the container press STRG+C 

To start the containers in background use

docker-compose -d up




# State of Project:
SNAPSHOT to 0.1.0
