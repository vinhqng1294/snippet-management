import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { SnippetDetailComponent } from './components/snippet-detail/snippet-detail.component';


const routes: Routes = [
  {path: 'snippet/:id', component: SnippetDetailComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes, {onSameUrlNavigation: 'ignore'})],
  exports: [RouterModule]
})
export class AppRoutingModule { }
