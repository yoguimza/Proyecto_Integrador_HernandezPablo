export class Proyecto {
    id?:number;
    nombrePr:String;
    descripcionPr:String;
    fotoPr:String;

    constructor(nombrePr:String, descripcionPr:String, fotoPr:String){
        this.nombrePr=nombrePr;
        this.descripcionPr=descripcionPr;
        this.fotoPr=fotoPr;
    }
}
