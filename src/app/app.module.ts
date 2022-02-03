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
// import { QuizComponent } from './pages/quiz/quiz.component';
// import { RegisterComponent } from './pages/register/register.component';
// import { ScoreComponent } from './pages/score/score.component';
import { RouterModule } from '@angular/router';
// import { quizRoutes } from './pages/routes';
import { QuizService } from './pages/shared/quiz.service';
import { AutismComponent } from './pages/neurodiversity/autism/autism.component';
import { AdhdComponent } from './pages/neurodiversity/adhd/adhd.component';
import { BiPolarComponent } from './pages/neurodiversity/bi-polar/bi-polar.component';
import { TouretteComponent } from './pages/neurodiversity/tourette/tourette.component';
import { DyslexiaComponent } from './pages/neurodiversity/dyslexia/dyslexia.component';
import { ResourcesComponent } from './pages/resources/resources.component';
import { NeurodiversityComponent } from './pages/neurodiversity/neurodiversity.component';




@NgModule({
  declarations: [
    AppComponent,
    HomepageComponent,
    NavbarComponent,
    QuestionsComponent,
    // QuizComponent,
    // RegisterComponent,
    // ScoreComponent,
    AutismComponent,
    AdhdComponent,
    BiPolarComponent,
    TouretteComponent,
    DyslexiaComponent,
    ResourcesComponent,
    NeurodiversityComponent,
    
    

  ],
  imports: [
    BrowserModule,
    NgbModule,
    FormsModule,
    Ng2SearchPipeModule,
    HttpClientModule,
    AppRoutingModule,
    RouterModule,
    
  ],
  providers: [QuizService],
  bootstrap: [AppComponent]
})
export class AppModule { }
