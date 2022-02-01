import { Routes } from '@angular/router';

import { RegisterComponent } from './register/register.component';
import { ScoreComponent } from './score/score.component';

export const quizRoutes: Routes =[
    {path:'register', component:RegisterComponent},

    {path:'score', component:ScoreComponent},
    {path:'',redirectTo:'/register',pathMatch:'full'},

]