#import "@preview/sourcecraft:0.1.0": setup-sourceuml, source-diagram
#show: setup-sourceuml

== Robots:

Les robots sont stockes dans le package `robots`\
Les robots sont instancies par leur `String nomTypeRobot` via la classe a vocation statique ```java RobotFactory```.

La classe Robot prenant trop de place pour ce compte-rendu fournit le constructeur basique de la classe auxquel toutes les classes filles se referent ainsi que certaines fonctions basique d'utilite generale pour tous les robots ou des utilitaires de calcul statiques.

De sorte que l'ajout d'un nouveau robot se fait aisement:
Les particularites de chaque type de robot etant alors gerees dans les sous classes comme celle qui suit.

#raw(read("src/robots/RobotRoues.java"), lang: "java", block: true)
La classe parente implemente ensuite par ex: \
```java estTraversable(Case case) -> getVitesse(case.nature)>0 ```

La creation d'un robot via RobotFactory se fait ainsi:
```java
//dans l'ordre (String typeRobot, Position p, double vitesse);
//n'importe quelle vitesse negative se voit remplacer par la valeur par defaut
//une vitesse fournie est limitee par le max autorise du robot.
Robot r = RobotFactory.createRobot("ROUES", new Position(0,0), -1);

```


== Evenements:

Les evenements sont dans le package `event`:\
Tous les evenements descendent d'une classe abstraite Evenement.

#let src = (
  read("src/simulation/Evenement.java"),
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