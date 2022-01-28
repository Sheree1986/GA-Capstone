package com.example.openaccessbackend.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;



@Entity
@Table(name = "questions")

public class Question {
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

    @OneToMany(
            mappedBy = "answerList",
            orphanRemoval = true
    )
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<Answer> answerList;
    @ManyToOne
    @JoinColumn(
            name = "user_id"
    )
    @JsonIgnore
    private User user;

    public Question(Long id, String question, String incorrect, String  correct) {
        this.id = id;
        this.question = question;
        this.incorrect = incorrect;
        this.correct = correct;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
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
    public String toString() {
        return "Category{id=" + this.id + ", name='" + this.name + "', description='" + this.description + "'}";
    }

    public Answer<Answer> getAnswerList() {
        return this.answerList;
    }

    public void setAnswerList(List<Answer> answerList) {
        this.answerList = answerList;
    }

    public User getUser() {
        return this.user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}

}