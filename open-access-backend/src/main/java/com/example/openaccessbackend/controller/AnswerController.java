package com.example.openaccessbackend.controller;

import com.example.openaccessbackend.model.Answer;
import com.example.openaccessbackend.model.Question;
import com.example.openaccessbackend.service.AnswerService;
import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping(
        path = {"/api"}
)
public class AnswerController {
    private AnswerService answerService;
    private static final Logger LOGGER = Logger.getLogger(AnswerController.class.getName());

    public AnswerController() {
    }

    @Autowired
    public void setAnswerService(AnswerService answerService) {
        this.answerService = answerService;
    }

    @GetMapping({"/Answers"})
    public List<Answer> getAnsQuestions() {
        LOGGER.info("calling getAnsQuestions method from controller");
        return this.answerService.getAnswers();
    }

    @GetMapping(
            path = {"/answers/{answerId}"}
    )
    public Answer getAnswer(@PathVariable Long answerId) {
        LOGGER.info("calling getAnswer method from controller");
        return this.answerService.getAnswer(answerId);
    }

    @PostMapping(
            path = {"/answers"}
    )
    public Answer createAnswer(@RequestBody Answer answerObject) {
        LOGGER.info("calling createAnswer method from controller");
        return this.answerService.createAnswer(answerObject);
    }

    @PutMapping(
            path = {"/answers/{answerId}"}
    )
    public Answer updateAnswer(@PathVariable("answerId") Long answerId, @RequestBody Answer answerObject) {
        LOGGER.info("calling updateAnswer method from controller");
        return this.answerService.updateAnswer(answerId, answerObject);
    }

    @DeleteMapping(
            path = {"/answers/{answerId}"}
    )
    public String deleteAnswer(@PathVariable("answerId") Long answerId) {
        LOGGER.info("calling deleteAnswer method from controller");
        return this.answerService.deleteAnswer(answerId);
    }

    @PostMapping({"/answers/{answerId}/questions"})
    public Question createAnsQuestion(@PathVariable("answerId") Long answerId, @RequestBody Question questionObject) {
        LOGGER.info("calling createQuestion method from controller");
        return this.answerService.createAnsQuestion(answerId, questionObject);

    }

    @GetMapping({"/answers/{answerId}/questions"})
    public List<Question> getAnsQuestions(@PathVariable("answerId") Long answerId) {
        LOGGER.info("calling getAnsQuestions method from controller");
        return this.answerService.getAnsQuestions(answerId);
    }

    @GetMapping({"/answers/{answerId}/questions/{questionId}"})
    public Question getAnsQuestions(@PathVariable("answerId") Long answerId, @PathVariable("questionId") Long questionId) {
        LOGGER.info("calling getAnsQuestion method from controller");
        return this.answerService.getAnsQuestions(answerId, questionId);
    }

    @PutMapping({"/answers/{answerId}/questions/{questionId}"})
    public Question updateAnsQuestions(@PathVariable("answerId") Long answerId, @PathVariable("questionId") Long questionId, @RequestBody Question questionObject) {
        LOGGER.info("calling updateAnsQuestion method from controller");
        return this.answerService.updateAnsQuestions(answerId, questionId, questionObject);
    }

    @DeleteMapping({"/answers/{answerId}/questions/{questionId}"})
    public Optional<Question> deleteAnsQuestions(@PathVariable("answerId") Long answerId, @PathVariable("questionId") Long questionId) {
        LOGGER.info("calling deleteAnsQuestions method from controller");
        return this.answerService.deleteAnsQuestions(answerId, questionId);
    }
}
