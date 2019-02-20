# playlist

**Instalação**
<br />
Para executar o projeto, entre na pasta e execute os seguintes comandos:
<br />
```
$ mvn clean install
$ docker build -t ifood:latest .
$ docker run -p 8080:8080 ifood:latest
```

**Após executar o serviço, segue o manual abaixo dos endpoints**
<br />
<br />
API responsavel por listar sugestoes de musicas baseado com a temperatura da cidade passando o nome da cidade.
<br />
<br />
**Request:**
<br />
`GET: localhost:8080/cidade?nome=New York`
<br />
<br />
**Response: 200(OK)**
<br />
```
{
    "temperatura": -2,
    "clima": "CLASSICAL",
    "tracks": {
        "items": [
            {
                "nome": "Sonata No. 14 \"Moonlight\" in C-Sharp Minor\", Op. 27 No. 2: I. Adagio sostenuto"
            },
            {
                "nome": "No Women No Cry - Acoustic Cover"
            },
            {
                "nome": "Wonderwall - Acoustic Cover"
            },
            {
                "nome": "L'Amour Toujours - Acoustic Cover"
            },
            {
                "nome": "Notebook for Anna Magadalena Bach: Minuet in F Major, BWV Anh. 113"
            },
            {
                "nome": "Cello Suite No. 1 in G Major, BWV 1007: I. Prélude"
            },
            {
                "nome": "Material Girl - Acoustic Cover"
            },
            {
                "nome": "Like a Prayer - Acoustic Cover"
            },
            {
                "nome": "Piano Sonata No. 2 in B Flat Minor, Op. 35, \"Funeral March\""
            },
            {
                "nome": "Gymnopedie"
            }
        ]
    }
}
```


**Após executar o serviço, segue o manual abaixo dos endpoints**
<br />
<br />
API responsavel por listar sugestoes de musicas baseado com a temperatura da cidade passando latitude e longitude.
<br />
<br />
**Request:**
<br />
`GET: localhost:8080/coordenadas?lat=40.730610&lon=-73.935242`
<br />
<br />
**Response: 200(OK)**
<br />
```
{
    "temperatura": -2,
    "clima": "CLASSICAL",
    "tracks": {
        "items": [
            {
                "nome": "Sonata No. 14 \"Moonlight\" in C-Sharp Minor\", Op. 27 No. 2: I. Adagio sostenuto"
            },
            {
                "nome": "No Women No Cry - Acoustic Cover"
            },
            {
                "nome": "Wonderwall - Acoustic Cover"
            },
            {
                "nome": "L'Amour Toujours - Acoustic Cover"
            },
            {
                "nome": "Notebook for Anna Magadalena Bach: Minuet in F Major, BWV Anh. 113"
            },
            {
                "nome": "Cello Suite No. 1 in G Major, BWV 1007: I. Prélude"
            },
            {
                "nome": "Material Girl - Acoustic Cover"
            },
            {
                "nome": "Like a Prayer - Acoustic Cover"
            },
            {
                "nome": "Piano Sonata No. 2 in B Flat Minor, Op. 35, \"Funeral March\""
            },
            {
                "nome": "Gymnopedie"
            }
        ]
    }
}
```
