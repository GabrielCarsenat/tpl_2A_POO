#import "@preview/sourcecraft:0.1.0": setup-sourceuml, source-diagram
#show: setup-sourceuml

== Robots:

Les robots sont stockes dans le package `robots`\
Tous les robots descendent d'une classe abstraite Robot.\
Les robots sont instancies par leur `String nomTypeRobot` via la classe a vocation statique ```java RobotFactory```.

#let src = (
  read("src/robots/Robot.java"),
  read("src/robots/RobotDrone.java"),
  read("src/robots/RobotPattes.java"),
  read("src/robots/RobotRoues.java"),
).join("\n\n")

#source-diagram(src, grammar: "java")

== Evenements:

Les evenements sont dans le package `event`:\
Tous les evenements descendent d'une classe abstraite Evenement.

#let src = (
  read("src/event/Evenement.java"),
).join("\n\n")

#source-diagram(src, grammar: "java")

L'evenement implemente l'interface ```java Comparable<Evenement>```\
Qui permet son insertion rapide dans le heap d'attente en log(n) et de sortir les elements en O(1).

== Carte
Le package `carte` contient tous les elements relatifs a la carte:

Le type ```java Case``` herite de ```java Position``` et lui ajoute un type de case.
Ceci permet d'implementer l'indexation dans une ```java HashTable```: des feux par leur position sans connaitre le type de la case. Mais aussi d'y acceder directement connaissant la case ou l'on est. 
#pagebreak()
Exemple d'utilisation:

```java
//on suppose Hashmap<Position, Incendie> incendies; declare et initialise

Incendies inc = incendies.get(new Position(0,0));

//mais aussi si on a:
Case c = carte.getCase(0,0);
System.out.println(c);
Incendie inc = incendies.get(c);

//dans ces deux cas on recupere une valeur nulle si l'incendie n'existe pas
```

== toString

Des override pour les methodes toString ont ete faites sur:

```java
Carte
Case
DonneesSimulation
```

ceci permet de verifier le bon chargement des valeurs apres lecture.