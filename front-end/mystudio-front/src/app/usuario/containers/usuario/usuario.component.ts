import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { catchError, Observable, of } from 'rxjs';
import { Usuario } from '../../model/usuario';
import { UsuarioService } from '../../services/usuario.service';


@Component({
  selector: 'app-usuario',
  templateUrl: './usuario.component.html',
  styleUrls: ['./usuario.component.css']
})
export class UsuarioComponent implements OnInit {

  user$: Observable<Usuario[]>;

  //@Input() user : Usuario[] = [];





  constructor(
    private router : Router,
    private route: ActivatedRoute,
    private usuarioService : UsuarioService
  ) {

    this.user$ = this.usuarioService.list()
    .pipe(
      catchError(error => {
        console.log("Erro ao carregar usuarios"+ error)
        return of([])
      })
    )
  }

  ngOnInit(): void {
  }

  onAdd(){
    this.router.navigate(['new'], {relativeTo : this.route})
  }

  onEdit(user : Usuario){
    this.router.navigate(['edit', user.id], {relativeTo : this.route})
  }

  onDelete(user : Usuario){
    console.log('usuario pai')
    this.router.navigate([user.id], {relativeTo : this.route})
  }
}
