package com.example.openaccessbackend.model;

import  java.util.Arrays
import javax.persistence.*;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "trivia_questions")

public class trivia_questions {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String question;

    @Column
    private String incorrect;

    @Column
    private String correct;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "answer_id")
    private Answer answer;





public trivia_questions() {

	public trivia_questions((String question, String[] incorrect, String correct) {
        this.question = question;
        this.incorrect = incorrect;
        this.correct = correct;

    }
    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String[] getIncorrect() {
        return incorrect;
    }

    public void setIncorrect(String[] incorrect) {
        this.incorrect = incorrect;
    }

    public String[] getCorrect() {
        return correct;
    }

    public void setCorrect(String[] correct) {
        this.correct = correct;

}
    public Long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Question [id=" + id + ", question="
                + question + ", incorrect=" + Arrays
                .toString(incorrect) + ", correct="
                + correct + "]";
}
}