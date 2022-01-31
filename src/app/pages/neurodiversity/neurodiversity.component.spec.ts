import { ComponentFixture, TestBed } from '@angular/core/testing';
import { NeurodiversityComponent } from './neurodiversity.component';

describe('NeurodiversityComponent', () => {
  let component: NeurodiversityComponent;
  let fixture: ComponentFixture<NeurodiversityComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ NeurodiversityComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(NeurodiversityComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
