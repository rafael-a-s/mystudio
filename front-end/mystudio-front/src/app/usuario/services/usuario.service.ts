import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { first, tap } from 'rxjs';
import { Usuario } from '../model/usuario';

@Injectable({
  providedIn: 'root'
})
export class UsuarioService {

  private readonly API = 'api/usuario';
  constructor(private httpClient: HttpClient) { }

  list(){
    return this.httpClient.get<Usuario[]>(this.API).pipe(
      first(),
      tap(usuario => console.log(usuario))
    );
  }

  save(record: Partial<Usuario>){
    if(record.id){
     return this.update(record);
    }
    return this.create(record);
  }

  loadById(id : String){
    return this.httpClient.get<Usuario>(`${this.API}/${id}`);
  }

  private create(record: Partial<Usuario>){
    return this.httpClient.post<Usuario>(this.API, record); //Ele vai retorna um obsevavle de curso
  }
  private update(record: Partial<Usuario>){
    return this.httpClient.put<Usuario>(`${this.API}/${record.id}`, record);
  }

  private delete(record : Partial<Usuario>){
    console.log('service')
    return this.httpClient.delete<Usuario>(`${this.API}/${record.id}`);
  }
}
