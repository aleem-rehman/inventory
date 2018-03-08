# inventory
This is sample project implementing Resful webservice using spring boot and hibernate.

Folder Structure:
database: It has all the create table and insert data queries.
maven-inventory: It has all the source code for the application. It uses hibernate, springboot, maven based project.

How to run:
Pull the sources in eclispe Oxygen and build the maven project.

Following are the Restful Webservice functions:

Listing all the locations data where Warehouse or Office can exist:
http://localhost:8080/inventory-example/getLocations 

Adding a new Warehouse. The Location Id can be identified by getLocations service call. The duplicate entry is denied.
http://localhost:8080/inventory-example/addWarehouse?name=RestWhouse01&locationId=2
