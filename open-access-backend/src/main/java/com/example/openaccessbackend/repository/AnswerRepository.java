package com.example.openaccessbackend.repository;

import com.example.openaccessbackend.model.Answer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface AnswerRepository extends JpaRepository<Answer, Long> {
    Answer findByName(String answerText);

    List<Answer> findByUserId(Long userId);

    Answer findByUserIdAndName(Long userId, String answerName);

    Answer findByIdAndUserId(Long answerId, Long userId);
}
