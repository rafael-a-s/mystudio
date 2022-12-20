import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';
import { Usuario } from '../../model/usuario';
import { UsuarioService } from '../../services/usuario.service';

@Component({
  selector: 'app-usuario-list',
  templateUrl: './usuario-list.component.html',
  styleUrls: ['./usuario-list.component.css']
})
export class UsuarioListComponent implements OnInit {
  @Input() user : Usuario[] = [];
  @Output() add = new EventEmitter(false)
  @Output() edit = new EventEmitter(false)
  @Output() delete = new EventEmitter(false)
  readonly displayedColumns = ['nome','email','acoes' ];

  constructor(private userService : UsuarioService) { }

  ngOnInit(): void {
  }

  onAdd(){
    this.add.emit(true)
  }
  onEdit(user : Usuario){
    console.log('usuario delete')
    this.edit.emit(user)
  }
  onDelete(user : Usuario){
    console.log('usuario list')
    this.delete.emit(user)
  }
}
