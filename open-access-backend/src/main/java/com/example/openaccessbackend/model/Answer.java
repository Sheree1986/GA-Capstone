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
@Table(
        name = "answers"
)
public class Answer {
    @Id
    @Column
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private Long id;
    @Column
    private String text;
    @Column
    private String correct;
    @OneToMany(
            mappedBy = "answer",
            orphanRemoval = true
    )
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<Question> questionList;
    @ManyToOne
    @JoinColumn(
            name = "user_id"
    )
    @JsonIgnore
    private User user;

    public Answer(Long id, String text, String correct) {
        this.id = id;
        this.text = text;
        this.correct = correct;
    }

    public Answer() {
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return this.text;
    }

    public void setName(String text) {
        this.text = text;
    }

    public String getDescription() {
        return this.correct;
    }

    public void setDescription(String correct) {
        this.correct = correct;
    }

    public String toString() {
        return "Answer{id=" + this.id + ", text='" + this.text + "', correct='" + this.correct + "'}";
    }

    public List<Question> getQuestionList() {
        return this.questionList;
    }

    public void setQuestionList(List<Question> questionList) {
        this.questionList = questionList;
    }

    public User getUser() {
        return this.user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
