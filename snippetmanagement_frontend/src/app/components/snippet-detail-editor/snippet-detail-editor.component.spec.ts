import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { SnippetDetailEditorComponent } from './snippet-detail-editor.component';

describe('SnippetDetailEditorComponent', () => {
  let component: SnippetDetailEditorComponent;
  let fixture: ComponentFixture<SnippetDetailEditorComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ SnippetDetailEditorComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SnippetDetailEditorComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
