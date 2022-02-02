import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DyslexiaComponent } from './dyslexia.component';

describe('DyslexiaComponent', () => {
  let component: DyslexiaComponent;
  let fixture: ComponentFixture<DyslexiaComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ DyslexiaComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(DyslexiaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
