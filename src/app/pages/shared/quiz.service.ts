import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class QuizService {
  // Properties localhost:9092
moonURL = 'https://open-access-backend.herokuapp.com/api/question?';


  constructor(private http: HttpClient) { }

    // Helper Methods

 getQuiz() {
   return this.http.get(`${this.moonURL}/api/questions`)
 }
 getQuestion(id: string) {
  return this.http.get(`${this.moonURL}/api/questions/${id}`);
}
addNewQuestion(text: string, a: string, b: string, c: string, correct: string){
  const quizQuestion ={
    "text": text,
    "a": a,
    "b": b,
    "c": c,       
    "correct": correct, 
    };
    console.log(quizQuestion);
    this.http.post(`${this.moonURL}/api/questions`, quizQuestion).subscribe(response=> console.log(response));
  }
 
}