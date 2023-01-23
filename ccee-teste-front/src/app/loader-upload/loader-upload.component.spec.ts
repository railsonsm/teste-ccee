import { ComponentFixture, TestBed } from '@angular/core/testing';

import { LoaderUploadComponent } from './loader-upload.component';

describe('LoaderUploadComponent', () => {
  let component: LoaderUploadComponent;
  let fixture: ComponentFixture<LoaderUploadComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ LoaderUploadComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(LoaderUploadComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
