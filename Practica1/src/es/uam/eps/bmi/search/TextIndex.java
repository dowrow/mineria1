/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.uam.eps.bmi.search;

import es.uam.eps.bmi.search.indexing.LuceneIndexing;
import es.uam.eps.bmi.search.indexing.Posting;
import es.uam.eps.bmi.search.parsing.HTMLSimpleParser;
import es.uam.eps.bmi.search.parsing.TextParser;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Collections;

public class TextIndex {
    /*
     * Recibe dos argumentos: Ruta a docs.zip y ruta donde almacenar el índice
     */
    public static void main (String args[]) throws Exception {
        
        if (args.length != 3) {
            System.out.println(args.length);
            System.out.println("Recibe 3 argumentos: Ruta a docs.zip y ruta donde almacenar el índice y el ultimo donde se almacena la estadistica");
            return;
        }

        LuceneIndexing li = new LuceneIndexing();
        TextParser tp = new HTMLSimpleParser();
        System.out.println("Construyendo índice...");
        li.build(args[0], args[1], tp);
  
        System.out.println("Cargando índice en RAM...");
        li.load(args[1]);
        
        /*System.out.println("Lista de ids: ");
        System.out.println(li.getDocIds());*/
        
        /*System.out.println("Lista de TextDocuments: ");
        for (String id : li.getDocIds()) {
            TextDocument document = li.getDocument(id);
            System.out.println(document);
        }
        
        System.out.println("Lista de terminos: ");*/
        
        FileWriter fw = new FileWriter(args[2]);
        
        ArrayList<FrecObject> listaFrecuencias = new ArrayList<>();
        for (String term: li.getTerms()) {
            int nDocs = 0;
            int termFrequency = 0;
            //System.out.println("Posting para termino " + term);
            for (Posting p : li.getTermsPosting(term)) {
                termFrequency += p.getTermFrequency();
                nDocs++;
                //System.out.println(p.getDocId() + " " + p.getTermFrequency() + " " + p.getTermPositions());
                
            }
            listaFrecuencias.add(new FrecObject(term,termFrequency,nDocs));
        }
        Collections.sort(listaFrecuencias, new FrecObject());
        for(FrecObject fo : listaFrecuencias){
            fw.write(fo.getPalabla() + "\t" + fo.getFrecuencia() +"\t" + fo.getnFicheros() + "\n");
        }
        //
    }
    
}




