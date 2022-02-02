import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router} from '@angular/router';
import { DATA } from '../../data'
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-questions',
  templateUrl: './questions.component.html',
  styleUrls: ['./questions.component.css']
})
export class QuestionsComponent implements OnInit {
  dataset: any;
  datasetIndex: string = '';
  searchText: string = '';
  response: any;
  description: any;
  question: any;
 
 postArray: any = [];

// let's make the URL routes available to class 
  constructor(private route: ActivatedRoute, private router: Router, private http: HttpClient) { }

  ngOnInit(): void {
    this.route.paramMap.subscribe(params => {
      this.datasetIndex = params.get('id') || '';

      this.dataset = DATA.find(dataset => {
  
        return dataset.id === parseInt(this.datasetIndex);
        
  })
  this.getQuestionDetails()       
})
  }
getQuestionDetails() {
  console.log(this.dataset.name)
 this.http
  .get(`http://localhost:9092/api/questions`)
  .subscribe(response => {
    this.question = response
  })
}
}