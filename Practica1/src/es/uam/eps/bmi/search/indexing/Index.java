/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.uam.eps.bmi.search.indexing;

import es.uam.eps.bmi.search.TextDocument;
import es.uam.eps.bmi.search.parsing.TextParser;
import java.util.List;

/**
 *
 * @author eps
 */
public interface Index {
    void build (String inputCollectionPath, String outputIndexPath, TextParser textParser);
    
    void load (String indexPath);
    
    List<String> getDocIds();
    
    TextDocument getDocument (String docId);
    
    List<String> getTerms();
    
    List<Posting> getTermsPosting (String term);
}
