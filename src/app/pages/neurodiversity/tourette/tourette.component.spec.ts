import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TouretteComponent } from './tourette.component';

describe('TouretteComponent', () => {
  let component: TouretteComponent;
  let fixture: ComponentFixture<TouretteComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ TouretteComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(TouretteComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
