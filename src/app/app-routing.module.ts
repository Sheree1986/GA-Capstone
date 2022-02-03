import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomepageComponent } from './pages/homepage/homepage.component';
import { AdhdComponent } from './pages/neurodiversity/adhd/adhd.component';
import { AutismComponent } from './pages/neurodiversity/autism/autism.component';
import { BiPolarComponent } from './pages/neurodiversity/bi-polar/bi-polar.component';
import { DyslexiaComponent } from './pages/neurodiversity/dyslexia/dyslexia.component';
import { NeurodiversityComponent } from './pages/neurodiversity/neurodiversity.component';
import { TouretteComponent } from './pages/neurodiversity/tourette/tourette.component';
import { QuestionsComponent } from './pages/questions/questions.component';
import { ResourcesComponent } from './pages/resources/resources.component';


const routes: Routes = [
  {

    
    // When the user goes to http://localhost:4200/question display the questions component
    path: 'question', component: QuestionsComponent},
    {path: '', component: HomepageComponent},
    {path: 'resources', component: ResourcesComponent},



// { path: '', redirectTo: 'home', pathMatch: 'full' },

{path: 'neurodiversity', component: NeurodiversityComponent,
children: [
  {path: 'adhd', component: AdhdComponent},
  {path: 'autism', component: AutismComponent},
  {path: 'bipolar', component: BiPolarComponent},
  {path: 'tourette', component: TouretteComponent},
  {path: 'dyslexia', component: DyslexiaComponent},
]},

];



@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
   
  
})
export class AppRoutingModule { }
