# credit-jee-rest
Mini-projet crédit calculateur on utilisant web service (REST)
* Maven
  - Dans le fichier .pom se trouvent toutes les bibliothèques utilisées dans le projet et leur version.
* Resteasy
	- Il est responsable de traiter toutes les demandes REST.

* INSTALLATION
	- Pour que le projet marche sur votre machine vous devez : 
	- Importer la base de donnée credit.sql #(dans votre moteur de base donnée Mysql)
	- Dans le fichier CreditRest --> src --> main --> java --> db --> DB.java 
	- Modifier: DriverManager.getConnection("jdbc:mysql://localhost:3306/credit", "root" , "") pour quel soit compatible avec votre base de donné
#### Mon Email ayoub.hrik@gmail.com
