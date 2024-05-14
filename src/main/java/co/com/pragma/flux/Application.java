package co.com.pragma.flux;

import co.com.pragma.flux.junior.GreetingDemo;
import co.com.pragma.flux.senior.WebClientDemo;
import co.com.pragma.flux.trainee.BasicDemo;
import co.com.pragma.flux.util.ReactiveUtil;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);

        var traineeDemo = new BasicDemo();
        traineeDemo.demonstrateMapWithFluxOfStrings();
        traineeDemo.demonstrateFlatMapWithSingleValueFlux();
        traineeDemo.demonstrateFlatMapWithMultipleFluxes();

        var juniorDemo = new GreetingDemo();
        var sayHello = juniorDemo.sayHello();
        ReactiveUtil.subscribe(sayHello, "sayHello");

        var seniorDemo = new WebClientDemo();
        var resource = seniorDemo.getResource();
        ReactiveUtil.subscribe(resource, "getResource");
    }
}
