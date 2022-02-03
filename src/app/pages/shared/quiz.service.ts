import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Question } from './question';

@Injectable({
  providedIn: 'root'
})
export class QuizService {
  // Properties localhost:9092
  private moonUrl = "https://open-access-backend.herokuapp.com/api/question/";
// let's make the URL routes available to class 
  
constructor(private http: HttpClient) { }
  
getQuestions(): Observable<Question[]>{
    return this.http.get<Question[]>(`${this.moonUrl}`);
  }

}