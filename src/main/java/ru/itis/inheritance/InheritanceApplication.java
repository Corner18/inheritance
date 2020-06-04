package ru.itis.inheritance;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ru.itis.inheritance.services.HumanService;
import ru.itis.inheritance.services.StudentService;


@SpringBootApplication
public class InheritanceApplication implements ApplicationRunner {

	@Autowired
	HumanService humanService;

	@Autowired
	StudentService studentService;

	public static void main(String[] args) {
		SpringApplication.run(InheritanceApplication.class, args);
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
		System.out.println("Все люди " + humanService.findAll());
		System.out.println("Человек по имени " + humanService.findByName("Настя"));
		System.out.println("Человек по айди 1 " + humanService.findById(1L));
		System.out.println("Студенты");
		System.out.println("Все студенты" + studentService.findAll());
		System.out.println("Все студенты по названию университета" + studentService.findAllByNameOfUniversity("КФУ"));
		System.out.println("Студент по имени" + studentService.findByName("Алия"));
		System.out.println("Студент по айди" + studentService.findById(3L));
	}

}
