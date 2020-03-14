import { Component, OnInit } from '@angular/core';
import { Snippet } from './models/snippet/snippet';
import { SnippetService } from './services/snippet/snippet.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent implements OnInit {
  title = 'webapp';
  snippets: Snippet[];

  constructor(private snippetService: SnippetService) {}

  ngOnInit() {
    this.getSnippets();
  }

  getSnippets(): void {
    this.snippetService.getSnippets().subscribe(data => {
      this.snippets = data;
    });
  }
}
