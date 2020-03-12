import { TestBed } from '@angular/core/testing';

import { HardAuthService } from './hard-auth.service';

describe('HardAuthService', () => {
  let service: HardAuthService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(HardAuthService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
