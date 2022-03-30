The project is made with the help of Maven and Docker. 
Database Oracle v12.2.0.1 is installed with docker. 
Follow below commands for Oracale installation: 

- Login to Docker Hub
     docker login     
- Download Oracle Image
    docker pull store/oracle/database-enterprise:12.2.0.1
- Run Image
    docker run -d -p 1521:1521 --name oracle store/oracle/database-enterprise:12.2.0.1
- Connect to container
    docker exec -it oracle bash -c "source /home/oracle/.bashrc; sqlplus /nolog"

Once the above command executes it will connect you to the SQL Plus terminal. Execute following commands to create the user to work on  
    connect sys as sysdba;
Above command will prompt you to enter the password. Enter Oradoc_db1 as default password
