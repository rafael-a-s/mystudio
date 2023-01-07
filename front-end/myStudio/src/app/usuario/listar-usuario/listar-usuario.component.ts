import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { Usuario } from '../model/usuario';
import { UsuarioService } from '../usuario.service';

@Component({
  selector: 'app-listar-usuario',
  templateUrl: './listar-usuario.component.html',
  styleUrls: ['./listar-usuario.component.css']
})
export class ListarUsuarioComponent implements OnInit {

  usuarios: Observable<Usuario[]> = new Observable<Usuario[]>;

  constructor(private usuarioService: UsuarioService) { }

  ngOnInit(): void {
    this.usuarios = this.usuarioService.list();
  }

}
