import { animate, style, transition, trigger } from '@angular/animations';
import { Component, OnInit } from '@angular/core';
import { QuizService } from '../quiz.service';

@Component({
  selector: 'app-quiz',
  templateUrl: './quiz.component.html',
  styleUrls: ['./quiz.component.css'],

  animations:[  
    trigger('answer', [
      transition('void => *', [style({ opacity: 0, transform: 'translateY(-3rem)'}), animate(300)])
    ])
  ]
})
export class QuizComponent implements OnInit {
  quizzes = [];

  currentQuiz:number;
  answerSelected = false;
  right = 0;
  wrong = 0;
  prevAnswered = [];
  
  result = false;
  resultStatus = 'Display Score';
  
  
    constructor(private quizService: QuizService) { }
  
    ngOnInit(): void {
      this.quizzes = this.quizService.getQuizzes();
      this.currentQuiz = this.getRandom();
      
      this.prevAnswered.push(this.currentQuiz);
    }
  
    onAnswer(option: boolean){
      this.answerSelected = true;
      setTimeout(() => {
        let newQuiz = this.getRandom();
         while(this.prevAnswered.includes(newQuiz) && this.prevAnswered.length < 20){
          newQuiz = this.getRandom();
         }
         this.currentQuiz = newQuiz;
          this.prevAnswered.push(this.currentQuiz);
        
          this.answerSelected = false;
      }, 300);
  
      if(option){
        this.right++;
      }else{
        this.wrong++;
      }
      
    }

    getRandom(){
      return Math.floor(Math.random() * this.quizzes.length);
    }
  
    displayScore(){
      this.result = true;
      this.resultStatus = 'Restart';    
    }
    restartGame(){
      this.prevAnswered = [];
      this.prevAnswered.push(this.getRandom());
      this.right = 0;
      this.wrong = 0;
    }
  

}
