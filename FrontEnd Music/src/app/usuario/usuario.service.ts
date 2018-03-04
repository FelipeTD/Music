import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable()
export class UsuarioService {

  usuarioUrls = 'http://localhost:8080/usuarios';

  constructor(private http: HttpClient) { }

  list() {
          return this.http.get<any[]>(this.usuarioUrls);
  }

  create(usuario: any) {
    return this.http.post(this.usuarioUrls, usuario);
  }

}
