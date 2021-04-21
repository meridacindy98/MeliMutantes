# Servicio mutant

Recibe como parámetro una secuencia de ADN, representada por un array de strings, y responde si la misma pertenece, o no, a un mutante. Se almacena la secuencia consultada en una base de datos, con el propósito de obtener estadísticas.

**URL** : `https://melimutantes.herokuapp.com/mutant`

**Método** : `POST`

**Ejemplo body:**
```json
{
  "dna":["ATGCGA",
         "CAGTGC",
         "TTATGT",
         "AGAAGG",
         "CCCCTA",
         "TCACTG"]
}
```

**Posibles respuestas** :  

  - 200: El humano es mutante. 
  - 403: El humano no es mutante.
  - 400: Input incorrecto. 

