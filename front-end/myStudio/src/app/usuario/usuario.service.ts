import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Usuario} from "./model/usuario";
@Injectable({
  providedIn: 'root'
})
export class UsuarioService {

  private readonly API = 'api/usuario';

  constructor(private httpClient:HttpClient) { }

  cadastrarNovoUsuario(usuario : Usuario){
    return this.httpClient.post<Usuario>(this.API, usuario );
  }

  list(){
    return this.httpClient.get<Usuario[]>(this.API);
  }

}
