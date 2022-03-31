The project is made with the help of Maven and Docker. 
Database Oracle v12.2.0.1 is installed with docker. 
Follow below commands for Oracale installation: 

- Login to Docker Hub:
     docker login
- Download Oracle Image:
    docker pull store/oracle/database-enterprise:12.2.0.1
- Run Image:
    docker run -d -p 1521:1521 --name oracle store/oracle/database-enterprise:12.2.0.1
- Connect to container:
    docker exec -it oracle bash -c "source /home/oracle/.bashrc; sqlplus /nolog"

Once the above command executes it will connect you to the SQL Plus terminal. Execute following commands to create the user to work on:
    connect sys as sysdba;
Above command will prompt you to enter the password: Oradoc_db1

Container Database (CDB)
Username: SYS
Role: SYSDBA
Password: Oradoc_db1
Host: localhost
SID: ORCLCDB

Pluggable Database (PDB)
Username: SYS
Role: SYSDBA
Password: Oradoc_db1
Host: localhost
Service Name: ORCLPDB1.localdomain


//SQL query for Table creation
  CREATE TABLE SYS.ORDERS
   ("ORDERS_ID" NUMBER GENERATED ALWAYS AS IDENTITY MINVALUE 1 MAXVALUE 99999 INCREMENT BY 1 START WITH 1 CACHE 20 NOORDER  NOCYCLE  NOKEEP  NOSCALE , 
	"FIRST_NAME" VARCHAR2(50 BYTE) NOT NULL, 
	"LAST_NAME" VARCHAR2(50 BYTE)NOT NULL, 
	"CITY" VARCHAR2(50 BYTE)NOT NULL, 
	"ADDRESS" VARCHAR2(50 BYTE)NOT NULL, 
	"EMAIL" VARCHAR2(50 BYTE)NOT NULL, 
	"ITEM_QUANTITY" NUMBER NOT NULL, 
	"TOTAL_PRICE" NUMBER NOT NULL, 
	"DATETIME" DATE DEFAULT CURRENT_TIMESTAMP
   )


//SQL query for example data
Insert into SYS.ORDERS (FIRST_NAME,LAST_NAME,CITY,ADDRESS,EMAIL,ITEM_QUANTITY,TOTAL_PRICE)
   values ('O''Neal','LastName','City1','addr1','email1',2,2);
Insert into SYS.ORDERS (FIRST_NAME,LAST_NAME,CITY,ADDRESS,EMAIL,ITEM_QUANTITY,TOTAL_PRICE)
     values ('Another','Name','City2','addr2','email2',4,5);
