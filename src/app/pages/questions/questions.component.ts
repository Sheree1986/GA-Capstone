import { Component, OnInit } from '@angular/core';
import { Question } from '../shared/question';
import { QuizService } from '../shared/quiz.service';
import { HttpClient } from '@angular/common/http';


@Component({
  selector: 'app-questions',
  templateUrl: './questions.component.html',
  styleUrls: ['./questions.component.css']
})
export class QuestionsComponent implements OnInit {

  // private moonURL = 'https://open-access-backend.herokuapp.com/api/question/';
// let's make the URL routes available to class 

  questions: Question[];
  clickMe () {
    this.http
    .get(`http://localhost:9092/api/question/1`)
    .subscribe((response) => console.log(response));
    console.log("clickMe");
  }
constructor(private quizService: QuizService, private http: HttpClient) { this.questions= [];}


ngOnInit(): void {


// }
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
//   });
// }
// }
}}