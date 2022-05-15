package com.example.SpringJpaLearn;

import com.example.SpringJpaLearn.Models.Question;
import com.example.SpringJpaLearn.Models.Quiz;
import com.example.SpringJpaLearn.Repositories.QuizRepository;
import com.example.SpringJpaLearn.Repositories.QuestionRepository;

import lombok.RequiredArgsConstructor;
import org.apache.tomcat.jni.Address;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import javax.websocket.Session;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.sql.Date;
import java.util.List;


@SpringBootApplication
@RequiredArgsConstructor
public class SpringJpaLearnApplication implements CommandLineRunner {
	SimpleDateFormat dateTimeFormat = new SimpleDateFormat("yyyy-MM-dd");
	private final QuizRepository quizRepository;
	private final QuestionRepository questionRepository;
	public static void main(String[] args) {
		SpringApplication.run(SpringJpaLearnApplication.class, args);
	}

//	@Bean
//	public CommandLineRunner runner(QuizRepository quizRepository, QuestionRepository questionRepository) {
//
//			return args -> {
//				// Tạo ra đối tượng Address có tham chiếu tới person
//				String quizName = "Quiz1";
//				String questionContent = "Who is Anya?";
//				quizRepository.save(new Quiz("Quiz2", dateTimeFormat.parse("2022-02-10"), null));
//				Question question1 = new Question(questionContent);
////				if (!quizRepository.existsQuizByName(quizName)) {
//					System.out.println("-------------------------Quiz " + quizName + " does not exist");
////					if (!questionRepository.existsQuestionByContent(questionContent))  {
//						System.out.println("-------------------------Question not exist");
//						Question question = new Question();
//						question.setContent("WHo is ANya?");
//						System.out.println("-------------------------Save and flush question");
//						questionRepository.saveAndFlush(question);
//						Quiz quiz = new Quiz("Quiz1", dateTimeFormat.parse("2022-01-12"), new ArrayList<>(){{add(question);}});
//						System.out.println("-------------------------------" + quiz.toString());
//						quizRepository.saveAndFlush(quiz);
//						System.out.println("-------------------------Save and flush quiz");
////					}
//					// Lưu vào db
//					// Chúng ta chỉ cần lưu address, vì cascade = CascadeType.ALL nên nó sẽ lưu luôn Person.
//
////				}
//
////				quiz.setQuestions(Collections.singletonList(question));
////				System.out.println("-----------------------------------------");
////				questionRepository.findAll().forEach(p -> {
////					System.out.println("**************************************");
////					System.out.println(p.getQuestionId());
////					System.out.println(p.getContent());
////				});
//
////				Question question1 = new Question("What is the capital of India?");
////				Question question2 = new Question("Who is Anya?");
////				Quiz quiz1 = new Quiz("Quiz1", dateTimeFormat.parse("2020-01-12"), null);
////				Quiz quiz2 = new Quiz("Quiz2", dateTimeFormat.parse("2022-02-10"), List.of(question1, question2));
////				quizRepository.save(quiz1);
////				quizRepository.save(quiz2);
////				questionRepository.save(question1);
////				questionRepository.save(question2);
//
//			};
//	}
	@Override
	public void run(String... args) throws Exception {
		Quiz quiz = new Quiz();
		quiz.setName("Quiz1");
		quiz.setCreateDate(dateTimeFormat.parse("2022-02-10"));
//		Quiz quiz = new Quiz("Quiz1", dateTimeFormat.parse("2022-02-10"));
		Quiz quiz2 = new Quiz("Quiz2", dateTimeFormat.parse("2022-02-10"));

		// Tạo ra đối tượng person
		Question question = new Question();
		question.setContent("Who is Anya");

		quiz.setQuestions(Collections.singleton(question));
		// Lưu vào db
		// Chúng ta chỉ cần lưu address, vì cascade = CascadeType.ALL nên nó sẽ lưu luôn Person.
		quizRepository.saveAndFlush(quiz);
		quizRepository.saveAndFlush(quiz2);


		// Vào:http://localhost:8080/h2-console/ để xem dữ liệu đã insert

		questionRepository.findAll().forEach(p -> {
			System.out.println("---------------------------------");
			System.out.println(p.getQuestionId());
			System.out.println(p.getContent());
		});


	}
}
