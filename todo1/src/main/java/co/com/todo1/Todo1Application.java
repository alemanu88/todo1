package co.com.todo1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@EnableAutoConfiguration
@Configuration
@PropertySource(value = "classpath:application.properties")
@ComponentScan(basePackages = { "co.com.todo1" })
@SpringBootApplication
public class Todo1Application {

	public static void main(String[] args) {
		SpringApplication.run(Todo1Application.class, args);
	}


}
