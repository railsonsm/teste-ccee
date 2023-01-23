import { Component, Inject, OnInit } from '@angular/core';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog';
import { concat, Subscription } from 'rxjs';
import { Body } from 'src/shared/model/body';
import { UploadService } from 'src/shared/service/upload.service';

@Component({
  selector: 'app-loader-upload',
  templateUrl: './loader-upload.component.html',
  styleUrls: ['./loader-upload.component.scss'],
})
export class LoaderUploadComponent implements OnInit {
  constructor(
    public dialogRef: MatDialogRef<LoaderUploadComponent>,
    @Inject(MAT_DIALOG_DATA) public data: Body[],
    private service: UploadService
  ) {}

  total = 0;
  sent = 0;
  uploadFileSubscription: Subscription | undefined;

  ngOnInit(): void {
    this.total = this.data.filter(e => !e.uploaded).length ?? 0;
    this.uploadFile();

    this.uploadFileSubscription = this.service.uploadFileData$.subscribe(
      (response) => {
        this.data.forEach((element) => {
          if (response == element.id) {
            element.uploaded = true;
          }
        });
      }
    );
  }

  uploadFile() {
    var observables: any = [];
    this.data
      .filter((element: Body) => !element.uploaded)
      .forEach((element: Body) =>
        observables.push(this.service.uploadFile(element.file, element.id))
      );

    concat(...observables).subscribe((element) => {
      this.sent = this.sent + 1;
      //
      if (this.sent == this.total) {
        this.dialogRef.close(this.data);
      }
    });
  }

  //

  // }
}
