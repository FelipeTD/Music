import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';

import { AppComponent } from './app.component';
import { NavbarComponent } from './navbar/navbar.component';
import { ItemUsuarioComponent } from './item-usuario/item-usuario.component';
import { UsuarioService } from './usuario/usuario.service';
import { DataTableModule, ButtonModule, InputTextModule, InputMaskModule,
         CalendarModule } from 'primeng/primeng';


@NgModule({
  declarations: [
    AppComponent,
    NavbarComponent,
    ItemUsuarioComponent
  ],
  imports: [
    BrowserModule,
    BrowserAnimationsModule,
    FormsModule,
    HttpClientModule,
    DataTableModule,
    ButtonModule,
    InputTextModule,
    InputMaskModule,
    CalendarModule
  ],
  providers: [UsuarioService],
  bootstrap: [AppComponent]
})
export class AppModule { }
