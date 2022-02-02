import { ComponentFixture, TestBed } from '@angular/core/testing';

import { BiPolarComponent } from './bi-polar.component';

describe('BiPolarComponent', () => {
  let component: BiPolarComponent;
  let fixture: ComponentFixture<BiPolarComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ BiPolarComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(BiPolarComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
