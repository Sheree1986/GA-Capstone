import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class QuizService {
  // Properties localhost:9092
moonURL = 'https://open-access-backend.herokuapp.com/';


  constructor(private http: HttpClient) { }

    // Helper Methods

 getQuiz() {
   return this.http.get(`${this.moonURL}/api/questions`)
 }
 getQuestion(id: string) {
  return this.http.get(`${this.moonURL}/api/questions/${id}`);
}
addNewQuestion(text: string, imageTitle: string, answer1: string, answer2: string, answer3: string, correct: string){
  const quizQuestion ={
    "text": text,
    "imageTitle": imageTitle,
    "answer1": answer1,
    "answer2": answer2,
    "answer3": answer3,
    "correct": correct, 
    };
    console.log(quizQuestion);
    this.http.post(`${this.moonURL}/api/questions`, quizQuestion).subscribe(response=> console.log(response));
  }
 
}