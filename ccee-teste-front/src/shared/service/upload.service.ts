import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';
import { concatMap, timeout, catchError, delay, tap } from 'rxjs/operators';
import { Subject, Subscription } from 'rxjs';
import { Body } from '../model/body';

@Injectable({
  providedIn: 'root',
})
export class UploadService {
  constructor(private http: HttpClient) {}

  private source = new Subject<String>();
  uploadFileData$ = this.source.asObservable();

  uploadFile(file: any, index: String) {
    const formData: FormData = new FormData();
    formData.append('file', file,);
    return this.http.post(environment.url.uploadFile, formData).pipe(tap(suss => {
      this.source.next(index);
    }));
  }
}
