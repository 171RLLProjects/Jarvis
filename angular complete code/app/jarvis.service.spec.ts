import { TestBed, inject } from '@angular/core/testing';

import { JarvisService } from './jarvis.service';

describe('JarvisService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [JarvisService]
    });
  });

  it('should be created', inject([JarvisService], (service: JarvisService) => {
    expect(service).toBeTruthy();
  }));
});
