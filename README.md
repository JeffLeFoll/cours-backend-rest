# cours-backend-rest
Backend REST pour les cours JQuery-Ajax / Angular 2

## Instalation
```bash
Dans un terminal :
gradlew stage

Ou alors avec Eclipse (plugin) ou Intellij
```

## Démarrage
```bash
Dans un terminal linux : ./run.sh
Dans un terminal windows : ./run.bat
```

# Resources exposées par l'API
## Livre
```
get http://localhost:8080/livre  => renvoi tous les livres
get http://localhost:8080/livre/1 => renvoi le livre d'Id 1
put http://localhost:8080/livre/1 => met à jour le livre d'Id 1 (les nouvelles données sont à mettre dans le champ data)
post http://localhost:8080/livre/ => ajoute une nouveau livre (les nouvelles données sont à mettre dans le champ data)
```

## Film
```
get http://localhost:8080/film  => renvoi tous les films
get http://localhost:8080/film/1 => renvoi le film d'Id 1
put http://localhost:8080/film/1 => met à jour le film d'Id 1 (les nouvelles données sont à mettre dans le champ data)
post http://localhost:8080/film/ => ajoute une nouveau film (les nouvelles données sont à mettre dans le champ data)
```

## CD
```
get http://localhost:8080/cd  => renvoi tous les cds
get http://localhost:8080/cd/1 => renvoi le cd d'Id 1
put http://localhost:8080/cd/1 => met à jour le cd d'Id 1 (les nouvelles données sont à mettre dans le champ data)
post http://localhost:8080/cd/ => ajoute une nouveau cd (les nouvelles données sont à mettre dans le champ data)
```

