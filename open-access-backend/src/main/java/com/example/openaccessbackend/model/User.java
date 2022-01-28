package com.example.openaccessbackend.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

@Entity
@Table(
        name = "users"
)
public class User {
    @Id
    @Column
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private Long id;
    private String userName;
    @Column(
            unique = true
    )
    private String emailAddress;
    @Column
    @JsonProperty(
            access = Access.WRITE_ONLY
    )
    private String password;
    @OneToOne(
            cascade = {CascadeType.ALL}
    )
    @JoinColumn(
            name = "profile_id",
            referencedColumnName = "id"
    )
    private UserProfile userProfile;
    @OneToMany(
            mappedBy = "user"
    )
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<Answer> anwserList;
    @OneToMany(
            mappedBy = "user"
    )
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<Question> questionList;

    public UserProfile getUserProfile() {
        return this.userProfile;
    }

    public void setUserProfile(UserProfile userProfile) {
        this.userProfile = userProfile;
    }

    public List<Question> getQuestionList() {
        return this.questionList;
    }

    public void setQuestionList(List<Question> questionList) {
        this.questionList = questionList;
    }

    public List<Answer> getAnswerList() {
        return this.answerList;
    }

    public void setAnswerList(List<Answer> answerList) {
        this.answerList = answerList;
    }

    public User() {
    }

    public User(Long id, String userName, String emailAddress, String password) {
        this.id = id;
        this.userName = userName;
        this.emailAddress = emailAddress;
        this.password = password;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return this.userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmailAddress() {
        return this.emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String toString() {
        return "User{id=" + this.id + ", userName='" + this.userName + "', emailAddress='" + this.emailAddress + "', password='" + this.password + "'}";
    }
}
