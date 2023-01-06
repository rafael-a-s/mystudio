import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {UsuarioComponent} from "./usuario/usuario.component";
import {CriarUsuarioComponent} from "./criar-usuario/criar-usuario.component";

export const routes: Routes = [
  {
    path: '',
    component: UsuarioComponent,
  },
  {
    path: 'criar-usuario',
    component: CriarUsuarioComponent
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
})
export class UsuarioRoutingModule {}
