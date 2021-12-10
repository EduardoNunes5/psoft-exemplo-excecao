# Exemplo de tratamento de exceções

Esta é uma pequena api rest que realiza operações CRUD com usuários (create, read, update, delete) 
para mostrar uma das formas de tratamentos de exceção utilizando java com spring boot.  

Algumas anotações fornecidas pelo spring que serão utilizadas:

```java
@GetMapping
@PostMapping
@DeleteMapping
@PutMapping
```
Todas elas versões curtas para o @RequestMapping em suas respectivas formas:
```java
@RequestMapping(value = "", method = HttpMethod.GET)
@RequestMapping(value = "", method = HttpMethod.POST)
@RequestMapping(value = "", method = HttpMethod.DELETE)
@RequestMapping(value = "", method = HttpMethod.PUT)
```  

@RestControllerAdvice - utilizada para criar um tratador de exceções de controllers **global ou subconjunto de controllers**  
@ExceptionHandler  - utilizada para tratar exceções lançadas durante a execução de um método de um controlador


Será mostrada outra forma de lidar com as resposta HTTP sem utilizar explicitamente o ResponseEntity.
Podemos definir o código da resposta através da anotação @ResponseStatus.

```java
/*
 .
 .
 . Trocando por exemplo:
 */
@RequestMapping(value = "/", method = HttpMethod.POST)
public ResponseEntity<?> salvar(@RequestBody Object dto){
    return new ResponseEntity<>(dto,HttpStatus.CREATED);
}
//por:
@PostMapping
@ResponseStatus(HttpStatus.CREATED)
public Object salvar(@RequestBody Object dto){
    return dto;
}

// por padrão, se não usar nenhuma anotação para identificar a 
// resposta, será 200 (OK). Assim, nossa resposta http será criada
// baseada no objeto de retorno e no código de status passado pela anotação.


```

URL SWAGGER = http://localhost:8080/swagger-ui/index.html