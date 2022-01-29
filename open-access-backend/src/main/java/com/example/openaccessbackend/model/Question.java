package com.example.openaccessbackend.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;



@Entity
@Table(
        name = "questions"
)
public class Question {
    @Id
    @Column
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private Long id;
    @Column
    private String question;
    @Column
    private String incorrect;
    @Column
    private String correct;
    @ManyToOne
    @JoinColumn(
            name = "user_id"
    )
    @JsonIgnore
    private User user;
    @JsonIgnore
    @ManyToOne
    @JoinColumn(
            name = "answer_id"
    )
    private Answer answer;

    public Question() {
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getQuestion() {
        return this.question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getIncorrect() {
        return this.incorrect;
    }

    public void setIncorrect(String incorrect) {
        this.incorrect = incorrect;
    }

    public String getCorrect() {
        return this.correct;
    }

    public void setCorrect(String correct) {
        this.correct = correct;
    }

    public Answer getAnswer() {
        return this.answer;
    }

    public void setAnswer(Answer answer) {
        this.answer = answer;
    }

    public User getUser() {
        return this.user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}


