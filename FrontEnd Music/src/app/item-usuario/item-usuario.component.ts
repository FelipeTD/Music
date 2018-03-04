import { Component, OnInit } from '@angular/core';
import { UsuarioService } from '../usuario/usuario.service';
import { FormControl } from '@angular/forms';

@Component({
  selector: 'app-item-usuario',
  templateUrl: './item-usuario.component.html',
  styleUrls: ['./item-usuario.component.css']
})
export class ItemUsuarioComponent implements OnInit {

  usuarios = [ ];

  constructor(private usuarioService: UsuarioService) { }

  ngOnInit() {
    this.list();
  }

  list() {
    this.usuarioService.list().subscribe(usuarios => this.usuarios = usuarios);
  }

  create(frm: FormControl) {
    this.usuarioService.create(frm.value)
      .subscribe(() => {
        frm.reset();
        this.list();
      });
  }

}
