# Ruta webflux 11

Hoy vamos a llevar los conceptos y/o métodos aprendidos
y lo pondremos en marcha desde la forma básica hasta llevarlo a un siguiente nivel.
Recordemos que lo vamos a hacer sobre SpringBoot(WebFlux)

Archivo [BasicDemo.java](src%2Fmain%2Fjava%2Fco%2Fcom%2Fpragma%2Fflux%2Ftrainee%2FBasicDemo.java)

### Trainee: Recordemos algunos métodos de transformación

Transforma un flujo de string a enteros

Pasemos por cada componente del código:

### Explicación paso a paso

Paso 1: No olvides importar las librerías necesarias

```java
import reactor.core.publisher.Flux;
```

Paso 2: El método main es el punto de entrada del programa.
Efectúa una serie de llamadas a métodos para demostrar ciertos conceptos de programación reactiva con Flux.

### Invocación

````java
public static void main(String[] args) {
    SpringApplication.run(Application.class, args);

    var traineeDemo = new BasicDemo();
    traineeDemo.demonstrateMapWithFluxOfStrings();
    traineeDemo.demonstrateFlatMapWithSingleValueFlux();
    traineeDemo.demonstrateFlatMapWithMultipleFluxes();
}
````

Paso 3: El método demonstrateMapWithFluxOfStrings crea un Flux de cadenas de texto,
que luego son transformadas en un Flux de enteros por medio del método map.
Luego se suscribe a este Flux con el método subscribeToFlux.

````java
private static void demonstrateMapWithFluxOfStrings() {
    Flux<String> fluxOfStringNumbers = Flux.just("1", "2", "3");
    Flux<Integer> fluxOfIntegers = fluxOfStringNumbers.map(Integer::parseInt);
    ReactiveUtil.subscribe(fluxOfIntegers, "demostrateMapWithFluxOfStrings");
}
````

Paso 4: El método demonstrateFlatMapWithSingleValueFlux hace algo similar, pero en lugar de map usa flatMap, y permite la transformación a un nuevo Flux.

````java
private static void demonstrateFlatMapWithSingleValueFlux() {
    Flux<String> fluxOfStringNumbers = Flux.just("4", "5", "6");
    Flux<Integer> fluxOfIntegers = fluxOfStringNumbers.flatMap(s -> Flux.just(Integer.parseInt(s)));
    ReactiveUtil.subscribe(fluxOfIntegers, "demostrateFlatMapWithSingleValueFlux");
}
````

Paso 5: El método demonstrateFlatMapWithMultipleFluxes concatena dos Flux de cadenas de texto y luego los transforma en un Flux de enteros.

````java
private static void demonstrateFlatMapWithMultipleFluxes() {
    Flux<String> fluxOfStringNumbersOne = Flux.just("7", "8", "9");
    Flux<String> fluxOfStringNumbersTwo = Flux.just("10", "11", "12");
    Flux<Integer> fluxOfIntegers = Flux.concat(fluxOfStringNumbersOne, fluxOfStringNumbersTwo).flatMap(s -> Flux.just(Integer.parseInt(s)));
    ReactiveUtil.subscribe(fluxOfIntegers, "demostrateConcatAndFlatMap");
}
````

Paso 6: Eventualmente, todos estos métodos terminan llamando al método subscribeToFlux.
El método subscribeToFlux imprime un mensaje cuando comienza el proceso,
registra una Consumer para manejar cada número emitido por el Flux,
registra una Consumer para manejar cualquier error,
y registra un Runnable que se ejecutará cuando se complete el Flux.

````java
private static void subscribeToFlux(Flux<Integer> intFlux, String demoMethod) {
    System.out.println("\nStarting " + demoMethod + ":");
    intFlux.subscribe(number -> System.out.println("Next number: " + number), error -> System.err.println("Error: " + error), () -> System.out.println("End of flow for " + demoMethod));
}
````

Paso 7: el resultado final nos queda de esta manera:

````
Starting demostrateMapWithFluxOfStrings:
Next number: 1
Next number: 2
Next number: 3
End of flow for demostrateMapWithFluxOfStrings

Starting demostrateFlatMapWithSingleValueFlux:
Next number: 4
Next number: 5
Next number: 6
End of flow for demostrateFlatMapWithSingleValueFlux

Starting demostrateConcatAndFlatMap:
Next number: 7
Next number: 8
Next number: 9
Next number: 10
Next number: 11
Next number: 12
End of flow for demostrateConcatAndFlatMap
````

Paso 8: Asi que llego el momento que tu lo hagas, es tu turno, tu puedes!

# Junior: Ejercicio de Programación Reactiva con Spring WebFlux

## Descripción del Problema

En este ejercicio, se te proporciona un método sayHello() que se encarga de saludar a las personas
que se encuentran en un archivo de texto [people.txt](src%2Fmain%2Fresources%2Fpeople.txt).
Tu tarea es entender este método, modificarlo si es necesario.
Archivo [GreetingDemo.java](src%2Fmain%2Fjava%2Fco%2Fcom%2Fpragma%2Fflux%2Fjunior%2FGreetingDemo.java)

````Java

@SneakyThrows
public Flux<String> sayHello() {
    ResourceLoader resourceLoader = new DefaultResourceLoader();
    Resource resource = resourceLoader.getResource("people.txt");
    String people = resource.getContentAsString(StandardCharsets.UTF_8);
    // TODO
    return null;
}
````

## Especificaciones

El método **sayHello()** utiliza ResourceLoader para cargar un archivo de texto llamado [people.txt](src%2Fmain%2Fresources%2Fpeople.txt).
A continuación, convierte el contenido del archivo a un String, lo divide en líneas individuales,
y crea un Flujo (Flux) a partir de esas líneas utilizando **Flux.fromStream()**.

Después, para cada línea (que representa el nombre de una persona),
aplica una función de mapeo que concatena un saludo inicial **"Hola"**
y una frase final **"! ¿Cómo estás?"**, por cada nombre de persona.

Finalmente, este método devuelve el Flujo de cadenas de texto,
donde cada cadena es un saludo personalizado
para cada persona mencionada en el archivo [people.txt](src%2Fmain%2Fresources%2Fpeople.txt).

## Requerimientos de la Prueba

Tu objetivo es verificar que la pruebas unitaria sayHello() cumpla el caso con exito.
Asegúrate y considera que la prueba cubra lo que está descrito en las especificaciones:
Verifica que cada elemento del flujo de salida comienza con **"Hola"** y termina con **"! ¿Cómo estás?"**.
Piensa en cómo probarías el comportamiento de este método y diviértete en el intento.

### Invocación

````java
public static void main(String[] args) {
    SpringApplication.run(Application.class, args);

    var seniorDemo = new WebClientDemo();
    var resource = seniorDemo.getResource();
    ReactiveUtil.subscribe(resource, "getResource");
}
````

### Salida

````text
Starting sayHello:
Next: Hola Madella Lindenberg! ¿Cómo estás?
Next: Hola Giana Queyeiro! ¿Cómo estás?
Success, end of flow for sayHello
````

# Senior: Ejercicio de Cliente Web de Spring con Manejo de Excepciones

## Descripción del Problema

En este ejercicio, se te proporciona un método getResource() que hace una petición GET a una API usando WebClient de Spring,
maneja errores específicos y devuelve un objeto Mono de tipo String. Necesitas entender cómo funcionará este método,
para verificar su comportamiento correctamente.
Archivo [WebClientDemo.java](src%2Fmain%2Fjava%2Fco%2Fcom%2Fpragma%2Fflux%2Fsenior%2FWebClientDemo.java)

````Java
private final String BASE_URL = "https://example.com";
private final String ERROR_MESSAGE = "API not found";
WebClient webClient = WebClient.builder().baseUrl(BASE_URL).build();

public Mono<String> getResource() {
    Function<ClientResponse, Mono<? extends Throwable>> errorHandler = response -> Mono.error(new RuntimeException(ERROR_MESSAGE));
    // TODO
    return null;
}
````

## Especificaciones

El método getResource() utiliza WebClient para recuperar un recurso de una API.
Este primer configura el WebClient con un URL base.
Luego utiliza este cliente para enviar una petición GET a la ruta /api/resource.

Hay una función de manejo de errores, errorHandler, que crea y devuelve un Mono de Error cuando se invoca.
Esta se pasa a **.onStatus(HttpStatus::is4xxClientError, errorHandler)** para manejar cualquier error cliente 4xx.

Finalmente, el método recupera el cuerpo de la respuesta como un Mono de tipo String.

## Requerimientos de la Prueba

Tu objetivo es verificar que la prueba unitaria para getResource() cubran los siguientes casos:

1. Verifica que el método devuelve los datos esperados cuando la API responde con un estado 2xx.
2. Prueba lo que sucede cuando la API responde con un estado de error 4xx. Asegúrate de que tu prueba verifica que el mensaje de error es el esperado (en este caso, "API not found").
3. Piensa en cómo probarías este método si la API estuviera caída o inalcanzable.

### Invocación

````Java
    public static void main(String[] args) {
    SpringApplication.run(Application.class, args);

    var juniorDemo = new GreetingDemo();
    var sayHello = juniorDemo.sayHello();
    ReactiveUtil.subscribe(sayHello, "sayHello");
}
````

### Salida

````text
Starting getResource:
Error, end of flow for: getResource:java.lang.RuntimeException: API not found
````
