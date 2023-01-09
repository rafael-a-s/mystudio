import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormGroup} from "@angular/forms";
import {UsuarioService} from "../usuario.service";
import {Usuario} from "../model/usuario";
import {Router} from "@angular/router";

@Component({
  selector: 'app-criar-usuario',
  templateUrl: './criar-usuario.component.html',
  styleUrls: ['./criar-usuario.component.css']
})
export class CriarUsuarioComponent implements OnInit {

  novoUsuarioForm!: FormGroup;
  constructor(private usuarioService:UsuarioService,
              private formBuilder: FormBuilder,
              private routes: Router) { }

  ngOnInit(): void {
    this.novoUsuarioForm = this.formBuilder.group(
      {
        nome:[''],
        email:[''],
        senha:['']
      }
    );
  }

  cadastrar(){
    const usuario = this.novoUsuarioForm.getRawValue() as Usuario ;
    console.log(usuario)
    this.usuarioService.cadastrarNovoUsuario(usuario)
    .subscribe(
      result => this.routes.navigateByUrl('listar-usuario'),
      error => console.log(error)
    );
  }

}
