import { Injectable } from '@angular/core';
import {
  Router, Resolve,
  RouterStateSnapshot,
  ActivatedRouteSnapshot
} from '@angular/router';
import { Observable, of } from 'rxjs';
import { Usuario } from '../model/usuario';
import { UsuarioService } from '../services/usuario.service';

@Injectable({
  providedIn: 'root'
})
export class UsuarioResolver implements Resolve<Usuario> {

  constructor(private usuarioService : UsuarioService){

  }


  resolve(route: ActivatedRouteSnapshot, state: RouterStateSnapshot): Observable<Usuario> {
    if(route.params && route.params['id']){
      return this.usuarioService.loadById(route.params['id'])
    }
    return of({id: '',version:'', active:'', nome: '', email:'', senha:''});
  }
}
