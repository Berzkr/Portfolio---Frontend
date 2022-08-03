import { TestBed } from '@angular/core/testing';

import { SvPersonaService } from './sv-persona.service';

describe('SvPersonaService', () => {
  let service: SvPersonaService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(SvPersonaService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
