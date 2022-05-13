package com.example.SpringJpaLearn;

import com.example.SpringJpaLearn.Models.Quiz;
import com.example.SpringJpaLearn.Repositories.QuizRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.text.SimpleDateFormat;
import java.util.Date;


@SpringBootApplication
public class SpringJpaLearnApplication {
	SimpleDateFormat dateTimeFormat = new SimpleDateFormat("yyyy-MM-dd");
	public static void main(String[] args) {
		SpringApplication.run(SpringJpaLearnApplication.class, args);
	}

	@Bean
	public CommandLineRunner runner(QuizRepository quizRepository) {

			return args -> {
				quizRepository.save(new Quiz("Quiz1", dateTimeFormat.parse("2020-01-12")));
				quizRepository.save(new Quiz("Quiz2", dateTimeFormat.parse("2022-02-10")));
			};
	}
}
