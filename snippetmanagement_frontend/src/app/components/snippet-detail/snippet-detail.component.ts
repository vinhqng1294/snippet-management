import { Component, OnInit, OnChanges, Input } from '@angular/core';
import { Snippet } from 'src/app/models/snippet/snippet';
import { ActivatedRoute } from '@angular/router';
import { SnippetService } from 'src/app/services/snippet/snippet.service';

@Component({
  selector: 'app-snippet-detail',
  templateUrl: './snippet-detail.component.html',
  styleUrls: ['./snippet-detail.component.scss']
})
export class SnippetDetailComponent implements OnInit {
  @Input('selectedSnippet') snippet: Snippet;

  constructor(
    private route: ActivatedRoute,
    private snippetService: SnippetService
  ) {}

  ngOnInit() {
    this.getSnippetById();
  }

  getSnippetById(): void {
    this.route.params.subscribe(params => {
      this.snippetService
        .getSnippetById(params.id)
        .subscribe(data => (this.snippet = data));
    });
  }
}
