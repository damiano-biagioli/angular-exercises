export interface Libro {
    idLibro: number;
    nome: string;
    titoloCompleto: string;
    anno: number;
    isbn: string;
    punteggio: number;
    cover: string;
    author: string;
    listaRecensioni: any[];
    prezzo:number;
  }