package com.example.demo;

import com.example.demo.domain.Address;
import com.example.demo.domain.Employee;
import com.example.demo.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

	@Autowired
	private EmployeeRepository employeeRepository;

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Override
	public void run(String... args) {
		Address address = new Address(5, "pun", "591237");
		Employee emp = new Employee(11, "Abc", "cse", "pune", address);

		try {
			System.out.println("Start");
			employeeRepository.save(emp);
			System.out.println("Records are successfully added..");

			System.out.println("reading");
			Employee emploee = employeeRepository.findById(11).orElse(null);
			System.out.println(emploee.getDepartment());
			System.out.println(emploee.getAddress().getCity());

		} catch (Exception e) {
			System.out.println("in exception");
			e.printStackTrace();
		}
	}
}
