package com.alisher.project;

import com.alisher.project.models.Customer;
import com.alisher.project.models.CustomerEmail;
import com.alisher.project.models.CustomerPhone;
import com.alisher.project.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@EnableConfigurationProperties
@EnableJpaAuditing
@EnableJpaRepositories
@SpringBootApplication
public class WebApplication implements CommandLineRunner {
    @Autowired
    private CustomerRepository customerRepository;

    public static void main(String[] args) {
        SpringApplication.run(WebApplication.class, args);
    }

    @Override
    @Transactional
    public void run(String... args) throws Exception {
        //todo
        Customer customer = Customer.builder()
                .customerId("asdfasdf")
                .phones(List.of(new CustomerPhone("some-string", LocalDateTime.now())))
                .emails(List.of(new CustomerEmail("some-email", LocalDateTime.now())))
//                .phones(Set.of("phone1", "phone2", "phone3"))
//                .emails(Set.of("mail1", "mail2", "mail3"))
                .build();
        customerRepository.save(customer);

//        Optional<Customer> customer1 = customerRepository.findById(43L);
//        Customer c = customer1.get();
//
//        System.out.println(c.getId() + ": ");
//        c.getEmails().forEach(m -> System.out.println("------ " + m.getEmail() +  " | " + m.getCreationTime()));
//        c.getPhones().forEach(m -> System.out.println("------ " + m.getPhone() +  " | " + m.getCreationTime()));
    }
}