package com.example.openaccessbackend.repository;

import com.example.openaccessbackend.model.Question;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;




public interface QuestionRepository extends JpaRepository<Question, Long> {

    List<Question> findByAnswerId(Long questionId);

    Question findByUserIdAndName(Long userId, String answerText);

    Question findByIdAndUserId(Long answerId, Long userId);

    Question findByUserIdAndNameAndIdIsNot(Long userId, String answerText, Long questionId);
}


