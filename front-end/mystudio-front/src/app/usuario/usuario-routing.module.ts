import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { UsuarioComponent } from './containers/usuario/usuario.component';
import { UsuarioFormComponent } from './containers/usuario-form/usuario-form.component';
import { UsuarioResolver } from './guards/usuario.resolver';

const routes: Routes = [
  {path: '', component : UsuarioComponent },
  {path: 'new', component: UsuarioFormComponent, resolve:{user : UsuarioResolver}},
  {path: 'edit/:id', component: UsuarioFormComponent, resolve: {user : UsuarioResolver}}
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class UsuarioRoutingModule { }
