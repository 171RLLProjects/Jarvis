import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { FlightclasslistComponent } from './flightclasslist.component';

describe('FlightclasslistComponent', () => {
  let component: FlightclasslistComponent;
  let fixture: ComponentFixture<FlightclasslistComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ FlightclasslistComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(FlightclasslistComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
