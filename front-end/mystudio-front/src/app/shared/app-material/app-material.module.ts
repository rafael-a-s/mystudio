import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {MatGridListModule} from '@angular/material/grid-list';
import {MatIconModule} from '@angular/material/icon';


@NgModule({
  declarations: [],
  exports: [
    CommonModule,
    MatGridListModule,
    MatIconModule,
  ]
})
export class AppMaterialModule { }
