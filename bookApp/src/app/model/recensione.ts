import { Libro } from './libro';
import { User } from '../user';

export interface Recensione {

    idRecensione :number;
    testo:string;
    libro:Libro;
    user:User;
}