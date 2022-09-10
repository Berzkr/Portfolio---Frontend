export class Proyecto {

    id?: number;
    nombreP: string;
    descripcionP: string;
    imagenP: string;
    fechaP: string;
    
    constructor (nombreP: string, descripcionP: string, imagenP: string, fechaP: string) {

        this.nombreP = nombreP;
        this.descripcionP = descripcionP;
        this.imagenP = imagenP;
        this.fechaP = fechaP;

    }

}
