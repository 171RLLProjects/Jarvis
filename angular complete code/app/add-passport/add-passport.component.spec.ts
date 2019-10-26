import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AddPassportComponent } from './add-passport.component';

describe('AddPassportComponent', () => {
  let component: AddPassportComponent;
  let fixture: ComponentFixture<AddPassportComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AddPassportComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AddPassportComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
