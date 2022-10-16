export class Persona {
    
    id?: number;
    nombre: string;
    apellido: string;
    acercaDe: string;
    img: string;
    banner: string;
    face: string;
    insta: string;
    twit: string;
    linked: string;
    git: string;

    constructor(nombre: string, apellido: string, acercaDe: string, img: string, banner: string,
                face: string, insta: string, twit: string, linked: string, git: string) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.acercaDe = acercaDe;
        this.img = img;
        this.banner = banner;
        this.face = face;
        this.insta = insta;
        this.twit = twit;
        this.linked = linked;
        this.git = git;
    }

}