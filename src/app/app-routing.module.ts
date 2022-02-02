import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { QuestionsComponent } from './pages/questions/questions.component';

const routes: Routes = [
  {

    
    // When the user goes to http://localhost:4200/cities display the cities component
    path: 'question',
    component: QuestionsComponent
  
},

  {
    path: 'dataset/answerList.response',
    component: QuestionsComponent
  },
];
//   {
//     path: '**',
//     component: FourOhFourComponent
//   }
// ];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
   
  
})
export class AppRoutingModule { }
