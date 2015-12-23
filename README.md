# Craftbukkit tutorial
Deze tutorial is samengesteld uit een minecraft workshop van [Java4Kids](https://java4kids.java.net/minecraft-workshop/mar2013) en de [Plugin Tutorial](http://wiki.bukkit.org/Plugin_Tutorial) van Bukkit

## Stap 1: installeer
Download en installeer het volgende

* [Java JDK 7+](https://www.oracle.com/technetwork/java/javase/downloads/index.html) 
* [Eclipse IDE for Java Developers](https://eclipse.org/downloads/)

## Stap 2: maak een Project

* Start Eclipse
* Kies een workspace folder (meestal ergens in je gebruikers Documents directory)
* `File` > `New` > `New Maven Project`
* check `Create simple project` 
* `Next`
* `Group id` naam volgens [package naamconventie](https://nl.wikipedia.org/wiki/Java_package), b.v, `io.github.coderdojo-oss`
* `Artifact id` naam van dit project volgens de klasse naamconventie, b.v. `Plugin` 

## Stap 3: voeg de Bukkit dependency toe

Open het `pom.xml` bestand en open het `pom.xml` tab om het te wijzigen.
Voeg een blok `<properties>` toe voor `</project>` om de java versie op 1.7 te zetten.

```xml
<properties>
  <maven.compiler.source>1.7</maven.compiler.source>
  <maven.compiler.target>1.7</maven.compiler.target>
</properties>
``` 

Voeg een blok `<repositories>` toe voor `</project>` om de bukkit repository toe te voegen, hier zijn de bukkit dependencies op te downloaden.

```xml
<repositories>
  <repository>
    <id>bukkit-repo</id>
    <url>http://repo.bukkit.org/content/groups/public/</url>
  </repository>
</repositories>
``` 

Voeg een blok `<dependencies>` toe voor `</project>` om de bukkit dependency toe te voegen, dit is de daadwerkelijke bukkit API package. We voegen deze toe als `provided` omdat deze bij het runnen in de bukkit server aangeleverd wordt door bukkit.

```xml
<dependencies>
  <dependency>
   <groupId>org.bukkit</groupId>
   <artifactId>bukkit</artifactId>
   <version>1.7.9-R0.2</version>
   <type>jar</type>
   <scope>provided</scope>
  </dependency>
</dependencies>
```
Zie het resultaat [pom.xml](/pom.xml)

## Stap 4: Bouw het project
* Selecteer het project
* `Run` > `Run as..` > `3 Maven build`
* `Goals:` `package` invullen > `Run`
* Het resultaat is een `.jar` bestand in de `target` folder

## Stap 5: Implementeer de API
Als eerste verwacht Bukkit een hoofdklasse die extend van de `JavaPlugin`

* `File` > `New` > `Class` 
* Package: `io.github.coderdojo-oss`
* Name: `BukkitPlugin`
* Superclass: `JavaPlugin` > `Browse...` en selecteer de enige gevonden class `Ok` > `Finish`

Nu hebben we een class die er als volgt uit ziet

```java
package io.github.coderdojooss;

import org.bukkit.plugin.java.JavaPlugin;

public class BukkitPlugin extends JavaPlugin {

}
```

In de klasse zelf (tussen de `{` en `}`) kunnen we methodes implementeren van JavaPlugin uit de Bukkit API. 

* `rechtermuis` > `Source` > `Override/Implement methods...` 
* Deselecteer alles en selecteer van `JavaPlugin` de methode `onEnable` 
* Vervang de TODO tekst in deze methode met `getLogger().info("onEnable; ik ben geladen");`

Het resultaat is hier te vinden in [BukkitPlugin.java](/src/main/java/io/github/coderdojooss/BukkitPlugin.java):

Als tweede verwacht Bukkit een `plugin.yml` bestand aan de root in de plugin jar. De conventie van Maven is om dergelijk niet Java bestanden te plaatsen in de folder `src/main/resources`. 
* `File` > `New` > `File` 
* selecteer `src/main/resources` 
* File name: `plugin.yml` > `Finish`

Bukkit verwacht de volgende inhoud:

```yml
name: Plugin
main: io.github.coderdojooss.BukkitPlugin
version: 0.0.1
```

Bouw het project zoals in Stap 4 beschreven. De `jar` uit de target folder is nu te plaatsen in de plugins folder van je Bukkit server. Bij het starten van je Bukkit server zie je nu een stukjes logging voorbij komen waarin staat dat jouw Plugin wordt geladen en de tekst die aan de info methode van de Logger is gevoerd: `onEnable; ik ben geladen`
