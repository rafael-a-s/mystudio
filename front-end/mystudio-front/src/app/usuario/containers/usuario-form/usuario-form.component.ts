import { Location } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { NonNullableFormBuilder } from '@angular/forms';
import { MatSnackBar } from '@angular/material/snack-bar';
import { ActivatedRoute } from '@angular/router';
import { Usuario } from '../../model/usuario';
import { UsuarioService } from '../../services/usuario.service';

@Component({
  selector: 'app-usuario-form',
  templateUrl: './usuario-form.component.html',
  styleUrls: ['./usuario-form.component.css']
})
export class UsuarioFormComponent implements OnInit {

  form = this.formBuilder.group({
    id: '',
    nome: [''],
    email: [''],
    senha: ['']
  });

constructor( private formBuilder : NonNullableFormBuilder,
             private service : UsuarioService,
             private _snackBar: MatSnackBar,
             private location : Location,
             private route : ActivatedRoute) {

}

ngOnInit(): void {
  const user : Usuario = this.route.snapshot.data['user'];
  this.form.setValue({
    id: user.id,
    nome: user.nome,
    email: user.email,
    senha: user.senha
    })
}

onSubmit(){
  this.service.save(this.form.value).subscribe(result => this.onSuccess(), error => {
   this.onError()
  });
}
onCancel(){
  this.location.back()
}
private onSuccess()
{
  this._snackBar.open('Usuario salvo com sucesso', '', {duration : 3000});
  this.onCancel()
}
private onError(){
  this._snackBar.open('Erro ao salvar usuario.', '', {duration : 3000});
}

}
