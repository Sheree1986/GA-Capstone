import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { HomepageComponent } from './pages/homepage/homepage.component';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { NavbarComponent } from './pages/navbar/navbar.component';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { Ng2SearchPipeModule } from 'ng2-search-filter';
import { AppRoutingModule } from './app-routing.module';
import { QuestionsComponent } from './pages/questions/questions.component';
// import { NeurodiversityComponent } from './neurodiversity/neurodiversity.component';
// import { QuizComponent } from './pages/quiz/quiz.component';
import { RegisterComponent } from './pages/register/register.component';
import { ScoreComponent } from './pages/score/score.component';
import { RouterModule } from '@angular/router';
import { quizRoutes } from './pages/routes';
import { QuizService } from './pages/shared/quiz.service';




@NgModule({
  declarations: [
    AppComponent,
    HomepageComponent,
    NavbarComponent,
    QuestionsComponent,
    // NeurodiversityComponent,
    // QuizComponent,
    RegisterComponent,
    ScoreComponent

  ],
  imports: [
    BrowserModule,
    NgbModule,
    FormsModule,
    Ng2SearchPipeModule,
    HttpClientModule,
    AppRoutingModule,
    RouterModule.forRoot(quizRoutes),
    
  ],
  providers: [QuizService],
  bootstrap: [AppComponent]
})
export class AppModule { }
