package com.example.SpringJpaLearn.Repositories;import com.example.SpringJpaLearn.Models.Question;import org.springframework.data.jpa.repository.JpaRepository;import org.springframework.data.jpa.repository.Query;import java.util.List;public interface QuestionRepository extends JpaRepository<Question, Integer> {//    List<Question> findByContent(String content);////    List<Question> findAll();////    boolean existsQuestionByContent(String content);}