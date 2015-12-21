# Craftbukkit tutorial
Deze tutorial is samengesteld uit een minecraft workshop van [Java4Kids](https://java4kids.java.net/minecraft-workshop/mar2013) en de [Plugin Tutorial](http://wiki.bukkit.org/Plugin_Tutorial) van Bukkit

## Stap 1: installeer
Download en installeer het volgende

* [Java JDK 7+](https://www.oracle.com/technetwork/java/javase/downloads/index.html) 
* [Eclipse for Java Developers](https://eclipse.org/downloads/)
* [Apache Maven](https://maven.apache.org/install.html)

## Stap 2: maak een Project

* Start Eclipse
* Kies een workspace folder (meestal ergens in je gebruikers Documents directory)
* `File` > `New` > `New Maven Project`
* check `Create simple project` 
* `Next`
* `Group id` naam volgens [package naamconventie](https://nl.wikipedia.org/wiki/Java_package)
* `Artifact id` naam van dit project volgens de classe naamconventie, b.v. `Plugin` 

## Stap 3: voeg Bukkit dependency toe

* Open `pom.xml` and open `pom.xml` tab to edit it
* Voeg een blok `properties` toe om de java versie op 1.7 te zetten

```xml
<properties>
	<maven.compiler.source>1.7</maven.compiler.source>
	<maven.compiler.target>1.7</maven.compiler.target>
  </properties>
``` 