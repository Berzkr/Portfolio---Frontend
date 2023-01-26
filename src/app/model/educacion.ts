export class Educacion {

    id?: number;
    nombreEdu: string;
    descripcionEdu: string;
    fechaInicioEdu: string;
    fechaFinEdu: string;
    logoEdu: string;
    
    constructor (nombreEdu: string, descripcionEdu: string, fechaInicioEdu: string, fechaFinEdu: string, logoEdu: string) {

        this.nombreEdu = nombreEdu;
        this.descripcionEdu = descripcionEdu;
        this.fechaInicioEdu = fechaInicioEdu;
        this.fechaFinEdu = fechaFinEdu;
        this.logoEdu = logoEdu;

    }

}
