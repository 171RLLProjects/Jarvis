import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AddflightclassComponent } from './addflightclass.component';

describe('AddflightclassComponent', () => {
  let component: AddflightclassComponent;
  let fixture: ComponentFixture<AddflightclassComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AddflightclassComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AddflightclassComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
