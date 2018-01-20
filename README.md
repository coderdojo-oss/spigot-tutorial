# Spigot tutorial
Deze tutorial was van origine samengesteld uit een minecraft workshop van [Java4Kids](https://java4kids.java.net/minecraft-workshop/mar2013) en de [Plugin Tutorial](http://wiki.bukkit.org/Plugin_Tutorial) van Bukkit. Later is dit herschreven naar Spigot op basis van de [Workshop van Devoxx4kids](https://github.com/devoxx4kids/materials/blob/master/workshops/minecraft/readme-spigot.asciidoc)

## Stap 1: installeer
Download en installeer het volgende

* [Java JDK 8+](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html) 
* [Eclipse IDE for Java Developers](http://www.eclipse.org/downloads/packages/eclipse-ide-java-ee-developers/oxygen2)
* [Spigot](https://getbukkit.org/download/spigot)

## Stap 2: maak een Project

* Start Eclipse
* Kies een workspace folder (meestal ergens in je gebruikers Documents directory)
* `File` > `New` > `New Maven Project`
* check `Create simple project` 
* `Next`
* `Group id` naam volgens [package naamconventie](https://nl.wikipedia.org/wiki/Java_package), b.v, `io.github.coderdojooss`
* `Artifact id` naam van dit project volgens de klasse naamconventie, b.v. `MijnPlugin` 

## Stap 3: voeg de Spigot dependency toe

Open het `pom.xml` bestand en open het `pom.xml` tab om het te wijzigen.
Voeg een blok `<properties>` toe voor `</project>` om de java versie op 1.8 te zetten.

```xml
<properties>
  <maven.compiler.source>1.8</maven.compiler.source>
  <maven.compiler.target>1.8</maven.compiler.target>
</properties>
``` 

Voeg een blok `<repositories>` toe voor `</project>` om de spigot repository toe te voegen, hier zijn de spigot dependencies te downloaden.

```xml
<repositories>
    <repository>
        <id>spigot-repo</id>
        <url>https://hub.spigotmc.org/nexus/content/repositories/snapshots/</url>
    </repository>
</repositories>
``` 

Voeg een blok `<dependencies>` toe voor `</project>` om de spigot dependency toe te voegen, dit is de daadwerkelijke spigot en bukkit API package. We voegen deze toe als `provided` omdat deze bij het draaien in een spigot server al aanwezig zijn.

```xml
<dependencies>
    <!--Spigot API-->
    <dependency>
           <groupId>org.spigotmc</groupId>
           <artifactId>spigot-api</artifactId>
           <version>1.10.2-R0.1-SNAPSHOT</version>
           <scope>provided</scope>
    </dependency>
    <!--Bukkit API-->
    <dependency>
            <groupId>org.bukkit</groupId>
            <artifactId>bukkit</artifactId>
            <version>1.10.2-R0.1-SNAPSHOT</version>
            <scope>provided</scope>
    </dependency>
</dependencies>
```
Zie het resultaat [pom.xml](/pom.xml)

## Stap 4: Bouw het project
* Selecteer het project
* `Run` > `Run as..` > `3 Maven build`
* `Goals:` `package` invullen > `Run`
* Het resultaat is een `.jar` bestand in de `target` folder (die moet je wellicht ff refreshen)

## Stap 5: Implementeer de Plugin API
Als eerste verwacht Bukkit een hoofdklasse die extend van de `JavaPlugin`

* `File` > `New` > `Class` 
* Package: `io.github.coderdojooss`
* Name: `MijnPlugin`
* Superclass: `JavaPlugin` > `Browse...` en selecteer de enige gevonden class `Ok` > `Finish`

Nu hebben we een class die er als volgt uit ziet

```java
package io.github.coderdojooss;

import org.bukkit.plugin.java.JavaPlugin;

public class MijnPlugin extends JavaPlugin {

}
```

In de klasse zelf (tussen de `{` en `}`) kunnen we methodes implementeren van JavaPlugin uit de Bukkit API. 

* `rechtermuis` > `Source` > `Override/Implement methods...` 
* Deselecteer alles en selecteer van `JavaPlugin` de methode `onEnable` 
* Vervang de TODO tekst in deze methode met `getLogger().info("ik is hier");`

Het resultaat is hier te vinden in [MijnPlugin.java](/src/main/java/io/github/coderdojooss/MijnPlugin.java):

Als tweede verwacht Bukkit een `plugin.yml` bestand aan de root in de plugin jar. De conventie van Maven is om dergelijk niet Java bestanden te plaatsen in de folder `src/main/resources`. 
* `File` > `New` > `File` 
* selecteer `src/main/resources` 
* File name: `plugin.yml` > `Finish`

Bukkit verwacht de volgende inhoud (om aan te geven welke class deze plugin moet laden):

```yml
name: Plugin
main: io.github.coderdojooss.MijnPlugin
version: 0.0.1
```

Bouw het project zoals in Stap 4 beschreven. De `jar` uit de target folder is nu te plaatsen in de plugins folder van je Spigot server. 

## Stap 6: Spigot server starten met onze plugin

* plaats `spigot-1.10.2.jar` in een eigen folder (nieuw aanmaken)
* start de server met `java -jar spigot-1.10.2.jar` 
* na de eerste keer starten in `eula.txt` de regel `eula=false` aanpassen naar `eula=true`
* start de server (dit triggert het aanmaken van de benodigde folders/bestanden)
* stop de server (ctrl-c)
* plaats je plugin jar in de `plugins` folder
* start de server

Bij het starten van je Spigot server zie je nu een stukjes logging voorbij komen waarin staat dat jouw Plugin wordt geladen en de tekst die aan de info methode van de Logger is gevoerd: `ik is hier`

je kunt nu inloggen vanuit minecraft op `localhost`

## Mogelijke vervolgstappen

* [https://www.spigotmc.org/wiki/using-the-event-api/]
* [https://www.spigotmc.org/wiki/create-a-simple-command/]
* [https://www.spigotmc.org/wiki/recipe-example/]
* [https://github.com/devoxx4kids/materials/blob/master/workshops/minecraft/readme-spigot.asciidoc]

## Ore Mushrooms
[https://github.com/devoxx4kids/materials/blob/master/workshops/minecraft/readme-spigot.asciidoc#ore-shrooms]

## Cat Arrows
[https://github.com/devoxx4kids/materials/blob/master/workshops/minecraft/readme-spigot.asciidoc#cat-arrows]

## Arrow Teleport
Schiet een arrow op iets en teleport jezelf naar die locatie.

