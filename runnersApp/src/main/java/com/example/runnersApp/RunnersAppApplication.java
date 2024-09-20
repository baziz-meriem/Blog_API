package com.example.runnersApp;

import com.example.runnersApp.model.Content;
import com.example.runnersApp.model.Status;
import com.example.runnersApp.model.Type;
import com.example.runnersApp.model.User;
import com.example.runnersApp.repository.ContentRepo;
import com.example.runnersApp.repository.UserRepo;
import io.github.cdimascio.dotenv.Dotenv;
import jakarta.annotation.PostConstruct;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import java.time.LocalDateTime;
import java.util.Arrays;

@SpringBootApplication
public class RunnersAppApplication {
	private static final Logger log = LoggerFactory.getLogger(RunnersAppApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(RunnersAppApplication.class, args);
	}

	}



