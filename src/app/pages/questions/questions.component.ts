import { Component, OnInit } from '@angular/core';
import { Question } from '../shared/question';
import { QuizService } from '../shared/quiz.service';
// import { HttpClient } from '@angular/common/http';


@Component({
  selector: 'app-questions',
  templateUrl: './questions.component.html',
  styleUrls: ['./questions.component.css']
})
export class QuestionsComponent implements OnInit {

  // private moonURL = 'https://open-access-backend.herokuapp.com/api/question/';
// let's make the URL routes available to class 


public questions: any = [];
public currentQuestion: number = 0;
public currentA: number = 0;
public score: number=0;
correct: number = 0;
wrong: number = 0;
correctAnswer: any = [];
currentAnswer=0;


constructor(private quizService: QuizService) { }

ngOnInit(): void {
  this.getAllQuestions();
}
getAllQuestions(){
this.quizService.getQuestion().subscribe(res => {
this.questions = res;

})

}
nextQuestion(){

  this.currentQuestion++;
  this.currentA++;
}
previousQuestion(){
  this.currentQuestion--;
this.currentA++;
}
answer(current:number,option:any){
  if (option.correct) {
  this.score +=10
  this.correct ++;
  this.currentQuestion++;
} else {

  this.score-=10;
  this.currentQuestion++;
  this.wrong ++; 
}
}
restart(){
  this.getAllQuestions()
  this.score=0;
  this.currentQuestion=0;
  
}

}
