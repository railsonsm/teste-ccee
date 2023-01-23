import { Agentes } from './agentes';

export class Body {
  id: String;
  fileName?: String;
  file: any;
  uploaded?: boolean = false;

  constructor(
    id: String,
    xml = {},
    file = {},
    fileName = '',
    uploaded?: boolean
  ) {
    this.id = id;
    this.uploaded = uploaded;
    this.file = file;
    this.fileName = fileName;
  }
}
