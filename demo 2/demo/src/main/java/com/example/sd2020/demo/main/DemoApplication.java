package com.example.sd2020.demo.main;

		import com.example.sd2020.demo.model.Client;
		import com.example.sd2020.demo.controller.ClientController;
		import com.example.sd2020.demo.repository.BookRepository;
		import com.example.sd2020.demo.repository.ClientRepository;

		import org.springframework.boot.SpringApplication;
		import org.springframework.boot.autoconfigure.SpringBootApplication;
		import org.springframework.boot.autoconfigure.domain.EntityScan;
		import org.springframework.context.annotation.ComponentScan;
		import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication

@ComponentScan(basePackageClasses = ClientController.class)
@EntityScan(basePackageClasses = Client.class)
@EnableJpaRepositories(basePackageClasses = ClientRepository.class)


public class DemoApplication {

	private BookRepository bookRepository;

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

}
