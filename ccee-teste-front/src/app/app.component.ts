import { Component } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { ChartConfiguration, ChartData, ChartEvent, ChartType } from 'chart.js';
import { Body } from 'src/shared/model/body';
import { AgenteService } from 'src/shared/service/agente.service';
import * as x from 'xml2js';
import { LoaderUploadComponent } from './loader-upload/loader-upload.component';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss'],
})
export class AppComponent {
  file: any;
  agentes = [];
  body: Body[] = [];
  displayedColumns: string[] = ['id', 'arquivo', 'enviado'];
  submited = true;
  barChartData: any = null;

  constructor(private service: AgenteService, public dialog: MatDialog) {
    this.carregar();
  }

  onFileChange(e: any) {

    this.submited = false;
    var name = e.target.files[0].name;
    const reader = new FileReader();

    reader.onload = (e: any) => {


      let xml = e.target.result;
      x.parseString(xml, (_: any, r: any) => {
        this.removePrecoMedio(r);
        this.body = [...this.body,new Body(new Date().getTime().toString(), r, this.createFileXml(r), name)];
      });
    };
    reader.readAsText(e.target.files[0]);
    e.target.value = null;
  }

  createFileXml(result: any){
    var builder = new x.Builder();
    var stringXml = builder.buildObject(result);
    return new Blob([stringXml], { type: '.xml' });
  }

  removePrecoMedio(result: any) {
    result.agentes.agente.forEach((ag: any) => {
      ag.regiao?.forEach((re: any) => {
        re.precoMedio.valor = null;
      });
    });
  }

  openDialog(): void {
    const dialogRef = this.dialog.open(LoaderUploadComponent, {
      width: '250px',
      data:  this.body,
    });

    dialogRef.afterClosed().subscribe(result => {
      this.body = result;
      this.submited = true;
      this.carregar();
    });
  }

  carregar() {
    var corpo: any = [];
    this.service.grafico().subscribe(r => {
      this.barChartData = {};
      this.barChartData.labels = r.ano
      r.dados.forEach((e: any) => {
        corpo.push({'label': e.sigla, 'data': e.valores})

      });
      this.barChartData = this.setarDados(r.ano, corpo)
    })
    this.service.litar().subscribe(r => {
      this.agentes = r;
    })
  }

  public barChartOptions: ChartConfiguration['options'] = {
    responsive: true,
    // We use these empty structures as placeholders for dynamic theming.
    scales: {
      x: {},
      y: {
        min: 10
      }
    },
    plugins: {
      legend: {
        display: true,
      },
    }
  };
  public barChartType: ChartType = 'bar';


  setarDados(anos : any, dados: any): ChartData<'bar'>{
    return  {
    labels: [ ...anos],
    datasets: dados
  };
  }


}
