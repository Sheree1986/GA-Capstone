package com.example.openaccessbackend.service;

import com.example.openaccessbackend.exception.InformationExistException;
import com.example.openaccessbackend.exception.InformationNotFoundException;
import com.example.openaccessbackend.model.Answer;
import com.example.openaccessbackend.model.Question;
import com.example.openaccessbackend.repository.AnswerRepository;
import com.example.openaccessbackend.repository.QuestionRepository;
import com.example.openaccessbackend.security.MyUserDetails;
import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class AnswerService {
    private AnswerRepository answerRepository;
    private QuestionRepository questionRepository;
    private static final Logger LOGGER = Logger.getLogger(AnswerService.class.getName());

    public AnswerService() {
    }

    @Autowired
    public void setAnswerRepository(AnswerRepository answerRepository) {
        this.answerRepository = answerRepository;
    }

    @Autowired
    public void seQuestionRepository(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    public List<Answer> getAnswers() {
        LOGGER.info("calling getAnswers method from service");
        MyUserDetails userDetails = (MyUserDetails)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        System.out.println(userDetails.getUser().getId());
        List<Answer> categories = this.answerRepository.findByUserId(userDetails.getUser().getId());
        if (categories.isEmpty()) {
            throw new InformationNotFoundException("no categories found for user id " + userDetails.getUser().getId());
        } else {
            return categories;
        }
    }

    public Answer getAnswer(Long answerId) {
        LOGGER.info("calling getAnswer method from service");
        MyUserDetails userDetails = (MyUserDetails)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Answer answer = this.answerRepository.findByIdAndUserId(answerId, userDetails.getUser().getId());
        if (answer == null) {
            throw new InformationNotFoundException("answer with id " + answerId + " not found");
        } else {
            return answer;
        }
    }

    public Answer createAnswer(Answer answerObject) {
        LOGGER.info("calling createAnswer method from service");
        MyUserDetails userDetails = (MyUserDetails)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Answer answer = this.answerRepository.findByUserIdAndName(userDetails.getUser().getId(), answerObject.getName());
        if (answer != null) {
            throw new InformationExistException("answer with name " + answer.getName() + " already exists");
        } else {
            answerObject.setUser(userDetails.getUser());
            return (Answer)this.answerRepository.save(answerObject);
        }
    }

    public Answer updateAnswer(Long answerId, Answer answerObject) {
        LOGGER.info("calling updateAnswer method from service");
        MyUserDetails userDetails = (MyUserDetails)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Answer answer = this.answerRepository.findByIdAndUserId(answerId, userDetails.getUser().getId());
        if (answer == null) {
            throw new InformationNotFoundException("answer with id " + answerId + " not found");
        } else {
            answer.setName(answerObject.getName());
            answer.setDescription(answerObject.getDescription());
            return (Answer)this.answerRepository.save(answer);
        }
    }

    public String deleteAnswer(Long answerId) {
        LOGGER.info("calling deleteAnswer method from service");
        MyUserDetails userDetails = (MyUserDetails)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Answer answer = this.answerRepository.findByIdAndUserId(answerId, userDetails.getUser().getId());
        if (answer == null) {
            throw new InformationNotFoundException("answer with id " + answerId + " not found");
        } else {
            this.answerRepository.deleteById(answerId);
            return "answer with id " + answerId + " has been successfully deleted";
        }
    }

    public Question createAnsQuestion(Long answerId, Question questionObject) {
        LOGGER.info("calling createQuestion method from service");
        MyUserDetails userDetails = (MyUserDetails)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Answer answer = this.answerRepository.findByIdAndUserId(answerId, userDetails.getUser().getId());
        if (answer == null) {
            throw new InformationNotFoundException("answer with id " + answerId + " not found");
        } else {
            Question question = this.questionRepository.findByUserIdAndName(userDetails.getUser().getId(), questionObject.getQuestion());
            if (question != null) {
                throw new InformationExistException("question with name " + questionObject.getQuestion() + " already exists");
            } else {
                questionObject.setUser(userDetails.getUser());
                questionObject.setAnswer(answer);
                return (Question)this.questionRepository.save(questionObject);
            }
        }
    }

    public List<Question> getAnsQuestions(Long answerId) {
        LOGGER.info("calling getQuestions method from service");
        MyUserDetails userDetails = (MyUserDetails)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Answer answer = this.answerRepository.findByIdAndUserId(answerId, userDetails.getUser().getId());
        if (answer == null) {
            throw new InformationNotFoundException("answer with id " + answerId + " not found");
        } else {
            return answer.getQuestionList();
        }
    }

    public Question getAnsQuestions(Long answerId, Long questionId) {
        LOGGER.info("calling getQuestion method from service");
        MyUserDetails userDetails = (MyUserDetails)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Answer answer = this.answerRepository.findByIdAndUserId(answerId, userDetails.getUser().getId());
        if (answer == null) {
            throw new InformationNotFoundException("answer with id " + answerId + " not found");
        } else {
            Optional<Question> question = this.questionRepository.findByAnswerId(answerId).stream().filter((i) -> {
                return i.getId().equals(questionId);
            }).findFirst();
            if (!question.isPresent()) {
                throw new InformationNotFoundException("question with id " + questionId + " does not exist");
            } else {
                return (Question)question.get();
            }
        }
    }

    public Question updateAnsQuestions(Long answerId, Long questionId, Question questionObject) {
        LOGGER.info("calling updateQuestion method from service");
        MyUserDetails userDetails = (MyUserDetails)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Answer answer = this.answerRepository.findByIdAndUserId(answerId, userDetails.getUser().getId());
        if (answer == null) {
            throw new InformationNotFoundException("answer with id " + answerId + " does not exist");
        } else {
            Optional<Question> question = this.questionRepository.findByAnswerId(answerId).stream().filter((i) -> {
                return i.getId().equals(questionId);
            }).findFirst();
            if (!question.isPresent()) {
                throw new InformationNotFoundException("question with id " + questionId + " does not exist");
            } else {
                Question question1 = this.questionRepository.findByUserIdAndNameAndIdIsNot(userDetails.getUser().getId(),
                        questionObject.getQuestion(), questionId);
                if (question1 != null) {
                    throw new InformationExistException("question with id " + questionId + " already exists");
                } else {
                    ((Question)question.get()).setQuestion(questionObject.getQuestion());
                    ((Question)question.get()).setIncorrect(questionObject.getIncorrect());
                    ((Question)question.get()).setCorrect(questionObject.getCorrect());
                    return (Question)this.questionRepository.save((Question)question.get());
                }
            }
        }
    }

    public Optional<Question> deleteAnsQuestions(Long answerId, Long questionId) {
        LOGGER.info("calling deleteQuestion method from service");
        MyUserDetails userDetails = (MyUserDetails)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Answer answer = this.answerRepository.findByIdAndUserId(answerId, userDetails.getUser().getId());
        if (answer == null) {
            throw new InformationNotFoundException("answer with id " + answerId + " does not exist");
        } else {
            Optional<Question> question = this.questionRepository.findByAnswerId(answerId).stream().filter((i) -> {
                return i.getId().equals(questionId);
            }).findFirst();
            if (!question.isPresent()) {
                throw new InformationExistException("question with id " + questionId + " does not exist");
            } else {
                this.questionRepository.deleteById(((Question)question.get()).getId());
                return question;
            }
        }
    }
}
