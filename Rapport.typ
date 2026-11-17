#import "@preview/sourcecraft:0.1.0": setup-sourceuml, source-diagram
#show: setup-sourceuml
#set page(
  paper: "a4",
  numbering: "1",
)

// Define the authors variable
#let authors = (
  (
    name: "Rim Yassir",
    email: "Rim.yassir@grenoble-inp.org",
  ),
  (
    name: "Ryme Ait Si Hammou",
    email: "ryme.ait-si-hammou@grenoble-inp.org",
  ),
  (
    name: "Térence Zimmermann",
    email: "Terence.zimmermann@grenoble-inp.org",
  ),
  (
    name: "Gabriel Carsenat",
    email: "Gabriel.carsenat@grenoble-inp.org",
  ),
)

#show link: it => text(fill: rgb("#dc601d"))[
  #underline(stroke: 0.5pt + rgb("#dc601d"), it)
]

// Center-align the title and author block
#align(center)[
  #text(size: 24pt, weight: "bold")[Compte-Rendu TPL 2A POO]\
  #text(size:20pt)[Robots Pompiers - Groupe X]
  #v(1.5em)
  

  // Loop over the authors array
  #grid(
    columns: authors.map(_ => 1fr),
    gutter: 1em,
    ..authors.map(author => [
      #strong(author.name) \
      // #emph(author.affiliation) \
      
    ]),
    ..authors.map(author => [
      #link("mailto:" + author.email, "[Email]")
    ])
  )
]

#outline(
  title: [Table des matières:],
  depth: 3,         // How many heading levels to include
  indent: 1.5em,    // Indent sub-headings
)

#pagebreak()

= Introduction

== Structure du projet

Le projet est decoupe en paquets relatifs aux differents objets traites:


#import "@preview/treet:0.1.1": *

```python
/
├── src/ #code source
│   ├── jeu #tous les objets relatifs a la carte et a ses elements
│       └── robots #implementation de tous les robots
│   ├── io
│   └── simulation #relatifs au systeme de simulation et au controle des robots
│       ├── events
│       └── strategie
├── lib/ #librairie graphique
├── doc/ #documentation sur la librairie graphique (voir "make docu")
├── sprites/ #images pour l'affichage des robots
├── README.md
└── Documentation.typ```

== Pour les développeurs


=== Comment build/test?
Dans le Makefile plusieurs commandes de build et d'executions sont mises en place pour build/tester les objets mis en place. Les tests ne sont pas automatises mais permettent de verifier le bon chargement des valeurs depuis la carte.

```sh
make exeNomTest

make exeTest
```

=== Comment acceder a la documentation du GUI?
Pour acceder a la documentation rapidement (necessite python3):
```sh
make docu
#Puis cliquer sur le lien http://localhost:3000 dans la console
```

=== Bug vscode sur linux
Pour ceux qui développent sur linux/ubuntu, pensez à utiliser le terminal de l'OS plutôt que celui interne à VsCode. Sinon on peut avoir une erreur du type:
```txt java: symbol lookup error: /snap/core20/current/lib/x86_64-linux-gnu/libpthread.so.0: undefined symbol: __libc_pthread_init, version GLIBC_PRIVATE
make: *** [Makefile:47: exeAffichage] Error 127```

#pagebreak()

= Objets Mis en Oeuvre
== Robots

Les robots sont stockes dans le package `robots`\
Les robots sont instancies par leur `String nomTypeRobot` via la classe a vocation statique ```java RobotFactory```.

La classe Robot prenant trop de place pour ce compte-rendu fournit le constructeur basique de la classe auxquel toutes les classes filles se referent ainsi que certaines fonctions basique d'utilite generale pour tous les robots ou des utilitaires de calcul statiques.

De sorte que l'ajout d'un nouveau robot se fait aisement:
Les particularites de chaque type de robot etant alors gerees dans les sous classes comme celle qui suit.

#raw(read("src/jeu/robots/RobotRoues.java"), lang: "java", block: true)
La classe parente implemente ensuite par ex: \
```java estTraversable(Case case) -> getVitesse(case.nature)>0 ```

La creation d'un robot via RobotFactory se fait ainsi:
```java
//dans l'ordre (String typeRobot, Position p, double vitesse);
//n'importe quelle vitesse negative se voit remplacer par la valeur par defaut
//une vitesse fournie est limitee par le max autorise du robot.
Robot r = RobotFactory.createRobot("ROUES", new Position(0,0), -1);

```


== Evenements

Les evenements sont dans le package `event`:\
Tous les evenements descendent d'une classe abstraite Evenement.

#let src = (
  read("src/simulation/events/Evenement.java"),
).join("\n\n")

#source-diagram(src, grammar: "java")

L'evenement implemente l'interface ```java Comparable<Evenement>```\
Qui permet son insertion rapide dans le heap d'attente en log(n) et de sortir les elements a executer en O(1).

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