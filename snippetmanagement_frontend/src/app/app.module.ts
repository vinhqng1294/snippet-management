import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { SnippetListComponent } from './components/snippet-list/snippet-list.component';
import { HttpClientModule } from '@angular/common/http';
import { SnippetService } from './services/snippet/snippet.service';
import { NavbarComponent } from './components/navbar/navbar.component';
import { SnippetDetailComponent } from './components/snippet-detail/snippet-detail.component';
import { FooterComponent } from './components/footer/footer.component';
import { SnippetDetailEditorComponent } from './components/snippet-detail-editor/snippet-detail-editor.component';

@NgModule({
  declarations: [
    AppComponent,
    SnippetListComponent,
    NavbarComponent,
    SnippetDetailComponent,
    FooterComponent,
    SnippetDetailEditorComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule
  ],
  providers: [SnippetService],
  bootstrap: [AppComponent]
})
export class AppModule { }
