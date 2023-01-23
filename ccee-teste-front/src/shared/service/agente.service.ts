import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Subject } from 'rxjs';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root',
})
export class AgenteService {
  constructor(private http: HttpClient) {}

  private source = new Subject<String>();
  uploadFileData$ = this.source.asObservable();

  litar() {

    return this.http.get<any>(environment.url.listar);
  }

  grafico() {

    return this.http.get<any>(environment.url.grafico);
  }
}
