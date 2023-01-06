import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { UsuarioComponent } from './usuario/usuario.component';
import { CriarUsuarioComponent } from './criar-usuario/criar-usuario.component';
import {UsuarioRoutingModule} from "./usuario-routing.module";
import {ReactiveFormsModule} from "@angular/forms";



@NgModule({
  declarations: [
    UsuarioComponent,
    CriarUsuarioComponent
  ],
  imports: [
    CommonModule,
    UsuarioRoutingModule,
    ReactiveFormsModule,
  ]
})
export class UsuarioModule { }
