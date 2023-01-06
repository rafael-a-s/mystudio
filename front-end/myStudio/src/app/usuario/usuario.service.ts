import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Usuario} from "./model/usuario";
@Injectable({
  providedIn: 'root'
})
export class UsuarioService {

  constructor(private httpClient:HttpClient) { }

  cadastrarNovoUsuario(usuario : Usuario){
    console.log(usuario)
    return this.httpClient.post<Usuario>('api/usuario', usuario );
  }


}
