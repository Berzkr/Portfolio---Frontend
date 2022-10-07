export class Experiencia {

    id?: number;
    nombreE: string;
    descripcionE: string;
    fechaInicioE: string;
    fechaFinE: string;
    logoE: string;
    
    constructor (nombreE: string, descripcionE: string, fechaInicioE: string, fechaFinE: string, logoE: string) {

        this.nombreE = nombreE;
        this.descripcionE = descripcionE;
        this.fechaInicioE = fechaInicioE;
        this.fechaFinE = fechaFinE;
        this.logoE = logoE;

    }

}
