import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';
import { catchError, Observable } from 'rxjs';
import { Usuario } from '../model/usuario';
import { UsuarioService } from '../usuario.service';

@Component({
  selector: 'app-listar-usuario',
  templateUrl: './listar-usuario.component.html',
  styleUrls: ['./listar-usuario.component.css']
})
export class ListarUsuarioComponent implements OnInit {

  @Input() usuarios$: Observable<Usuario[]>;
  @Output() delete = new EventEmitter(false)

  constructor(private usuarioService: UsuarioService) {
    this.usuarios$ = this.usuarioService.list()
    .pipe(
      catchError(error => {
        console.log(error)
        return ([])
      })
    )
  }

  ngOnInit(): void {
    this.usuarios$.subscribe()
  }

  apagarRegistro(user : Usuario){
    this.usuarioService.delete(user.id || '').subscribe();
  }

}
