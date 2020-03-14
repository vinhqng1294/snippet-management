import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Snippet } from '../../models/snippet/snippet';
import { Observable, of } from 'rxjs';
import { tap, catchError } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class SnippetService {
  private snippetUrl: string;
  httpOptions = {
    headers: new HttpHeaders({ 'Content-Type': 'application/json' })
  };

  constructor(private http: HttpClient) {
    this.snippetUrl = 'http://localhost:8080/api/snippets/';
  }

  public getSnippets(): Observable<Snippet[]> {
    return this.http.get<Snippet[]>(this.snippetUrl, this.httpOptions).pipe(
      tap(_ => console.log(`fetched snippets successfully`)),
      catchError(_ => {
        console.error(`fetched snippets unsuccessfully`);
        return of([]);
      })
    );
  }

  public getSnippetById(id: number): Observable<Snippet> {
    const url = `${this.snippetUrl}/${id}`;
    return this.http.get<Snippet>(url, this.httpOptions).pipe(
      tap(_ => console.log(`snippet id:${id} fetched successfully`),
      catchError(_ => {
        console.error(`Cannot get snippet id:${id}`);
        return of(Snippet);
      }))
    );
  }

  public addSnippet(snippet: Snippet): Observable<Snippet> {
    const url = `${this.snippetUrl}/add`;
    return this.http.post<Snippet>(url, this.httpOptions).pipe(
      tap(_ => console.log(`snippet is added successfully`)),
      catchError(_ => {
        console.error(`add snippet failed`);
        return of(null);
      })
    );
  }
}
