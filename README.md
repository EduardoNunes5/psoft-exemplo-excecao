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


Será mostrada outra forma de lidar com as respostas HTTP sem utilizar explicitamente o ResponseEntity.
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

// por padrao, se nao usar nenhuma anotacao para identificar a 
// resposta, sera 200 (OK). Assim, nossa resposta http sera criada
// baseada no objeto de retorno e no codigo de status passado pela anotacao ou codigo 200


```

As exceções estão no pacote exception, a classe que contém a anotação @RestControllerAdvice é a ExceptionHandlerAdvice.
Então qualquer requisição passada para os controllers, será tratada por lá, através de seus métodos que contém a anotação @ExceptionHandling
```java
//Anotacao que faz com que essa classe seja
//conhecida globalmente entre todos os controllers
@RestControllerAdvice 
public class ExceptionHandlerAdvice {

    //qualquer exceção lançada de classe que estenda EntityNotFound, será tratada aqui
    //retornando status 404 (NOT_FOUND) e a mensagem que foi repassada para o construtor
    // do EntityNotFoundException será colocada no objeto CustomErrorResponse e entregue ao cliente.
    @ExceptionHandler(EntityNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public CustomResponseError trataNaoEncontrado(EntityNotFoundException enf) {
        return new CustomResponseError(enf.getMessage());
    }
}

.
.
.

// como essa classe estende EntityNotFound, ela sera tratada no metodo trataNaoEncontrado
// caso seja lancada uma excecao deste tipo
public class UsuarioNaoEncontradoException extends EntityNotFoundException {

    public UsuarioNaoEncontradoException(String username) {
        super(String.format("Usuario %s não encontrado", username));
    }

    public UsuarioNaoEncontradoException(Long id) {
        super(String.format("Usuario com o id %d não encontrado", id));
    }
}

```

URL SWAGGER = http://localhost:8080/swagger-ui/index.html