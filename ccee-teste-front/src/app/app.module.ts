import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { MatToolbarModule } from '@angular/material/toolbar';
import { HttpClientModule } from '@angular/common/http';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { UploadService } from 'src/shared/service/upload.service';
import { MatTableModule } from '@angular/material/table';
import { MatButtonModule } from '@angular/material/button';
import {MatDialogModule} from '@angular/material/dialog';
import {MatProgressBarModule} from '@angular/material/progress-bar';
import { LoaderUploadComponent } from './loader-upload/loader-upload.component';
import { AgenteService } from 'src/shared/service/agente.service';
import { NgChartsConfiguration, NgChartsModule } from 'ng2-charts';
@NgModule({
  declarations: [AppComponent, LoaderUploadComponent],
  imports: [
    BrowserModule,
    AppRoutingModule,
    MatToolbarModule,
    BrowserAnimationsModule,
    HttpClientModule,
    MatTableModule,
    MatButtonModule,
    MatDialogModule,
    NgChartsModule,
    MatProgressBarModule
  ],
  providers: [UploadService, AgenteService, { provide: NgChartsConfiguration, useValue: { generateColors: false }}],
  bootstrap: [AppComponent],
})
export class AppModule {}
