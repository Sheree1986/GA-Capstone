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

  questions: any;
  qId: any;
  // clickMe () {
  //   this.http
  //   .get(`https://open-access-backend.herokuapp.com/api/question/1`)
  //   .subscribe((response) => console.log(response));
  //   console.log("clickMe");
  // }
// let's make the URL routes available to class


constructor(private quizService: QuizService) { }

ngOnInit(): void {

this.quizService.getQuestion().subscribe(data => {
this.questions = data;
})
// this.quizService.getQuestionId().subscribe(data => {
//   this.qId = data;
// })
}

}

  // this.quizService.getQuestions().subscribe((questions: Question[]) => {
  //   this.questions = questions;
  
  // this.quizService.getQuestions().subscribe(data => {
    // this.questions =  data;
//   })
// }
// }
// questions: Question[] | undefined;
// constructor(private quizService: QuizService) { }

// ngOnInit(): void {
//   this.quizService.getQuestions().subscribe((data: Question[]) => {
//     console.log(data);
//     this.questions = data;

//updating read me