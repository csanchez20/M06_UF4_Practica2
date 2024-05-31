# M06_UF4_Practica2
# Pràctica de FastAPI: Relacions entre Categories, Subcategories i Productes

## Descripció
Aquesta pràctica consisteix en la implementació de la relació entre les taules `categoria`, `subcategoria` i `producte` utilitzant FastAPI. Es tractarà de reflectir les següents relacions:

- Una subcategoria pertany a una o moltes categories (una categoria pot tenir una o més subcategories).
- Un producte pertany a una única subcategoria (una subcategoria pot tenir un o molts productes).

## Passos Realitzats

### 1. Crear les Entitats
S'han creat les entitats `Categoria`, `Subcategoria` i `Producte` per mapejar les taules de la base de dades respectives, respectant les claus primàries i foranes.

### 2. Modificar l'Entitat `Producte`
S'ha modificat l'entitat `Producte` per incloure la relació amb `Subcategoria`.

### 3. Modificar el Repositori i el Servei de la Classe `Producte`
S'han incorporat mètodes per desar i esborrar productes en el repositori i el servei de `Producte`.

### 4. Crear Repositoris i Serveis per a `Categoria` i `Subcategoria`
S'han creat els repositoris i serveis per a les entitats `Categoria` i `Subcategoria`, incloent-hi mètodes de cerca (`find`), desar i esborrar.

### 5. Crear una Vista per Inserir Nous Productes
S'ha creat una vista amb un formulari per inserir nous productes, demanant:
- Nom del producte
- Descripció
- Unitats
- Preu
- Fabricant
- Subcategoria
- Categoria

### 6. Modificar el Controlador
S'ha modificat el controlador per afegir un mètode que permet desar a la base de dades la informació introduïda per l'usuari. També es permet editar lliurement la subcategoria i la categoria, amb validacions per assegurar que la subcategoria i la categoria corresponen correctament.

### 7. Validacions i Insercions Automàtiques
Si la subcategoria introduïda no es correspon amb la categoria introduïda, es llença un missatge d'error. Si tant la subcategoria com la categoria no existeixen, s'inseriran automàticament a les taules corresponents.