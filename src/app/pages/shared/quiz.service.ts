import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Question } from './question';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class QuizService {
  
  // Properties localhost:9092
 moonUrl = environment.moonUrl
// let's make the URL routes available to class 
 
constructor(private http: HttpClient) { }
  
// getQuestions(): Observable<Question[]>{
//     return this.http.get<Question[]>(`${this.moonUrl}`);
//   }

// }

getQuestion() {
  return this.http.get(`${this.moonUrl}/api/question`)
}
getQuestionId(id: string) {
  return this.http.get(`${this.moonUrl}/api/question/${id}`);
}
}