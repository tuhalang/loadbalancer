## LOAD BALANCE USING APACHE & TOMCAT
* Required: java
1. Install Apache
    ```shell script
    sudo apt-get install apache2
    ```
   - This will install in /etc/apache2
2. Download & install mod_jk
   ```shell script
    sudo apt-get install libapache2-mod-jk
    ```
3. Download tomcat https://tomcat.apache.org/download-80.cgi
4. Extract it and create folders server
5. Change port in file server.xml to avoid duplicate pore
    ```xhtml
    <Server port="9005" shutdown="SHUTDOWN">
    ``` 
   ```xhtml
    <Connector port="9009" protocol="AJP/1.3" redirectPort="9443"/>
    ```
6. Edit file /etc/libapache2-mod-jk/workers.properties to
    ```editorconfig
    worker.list=loadbalancer,status 
     
    worker.server1.port=8009
    worker.server1.host=localhost
    worker.server1.type=ajp13 
     
    worker.server2.port=9009
    worker.server2.host=localhost
    worker.server2.type=ajp13 
     
    worker.server1.lbfactor=1
    worker.server2.lbfactor=1 
     
    worker.loadbalancer.type=lb
    worker.loadbalancer.balance_workers=server1,server2 
     
    worker.status.type=status
    ```
7. Add the following to the Apache configurations located in /etc/apache2/sites-enabled/000-default.conf
    ```editorconfig
    JkMount /status status
    JkMount /* loadbalancer
    ```
8. Build & deploy project 
9. Run servers tomcat
    - Access: http://localhost/loadbalance  
    - Then access http://localhost/status to follow handle
    