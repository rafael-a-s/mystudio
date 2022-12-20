import { Usuario } from './../usuario/model/usuario';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class AutenticacaoService {

  constructor(private http: HttpClient) { }

 autenticar(email : string , senha: string): Observable<Usuario>{
  return this.http.post<Usuario>('http://localhost:8080', {
    email: email,
    senha: senha
  })
 }

}
