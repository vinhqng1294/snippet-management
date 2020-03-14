import { Component, OnInit, Input, OnChanges } from '@angular/core';
import { Snippet } from 'src/app/models/snippet/snippet';
import { SnippetService } from 'src/app/services/snippet/snippet.service';

@Component({
  selector: 'app-snippet-list',
  templateUrl: './snippet-list.component.html',
  styleUrls: ['./snippet-list.component.scss']
})
export class SnippetListComponent {
  @Input('snippets') snippets: Snippet[];
  selectedSnippet: Snippet;

  constructor(private snippetService: SnippetService) {}

  onSelect(snippet: Snippet): void {
    this.selectedSnippet = snippet;
  }
}
