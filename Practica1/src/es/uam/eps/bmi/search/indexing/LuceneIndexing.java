
package es.uam.eps.bmi.search.indexing;

import es.uam.eps.bmi.search.TextDocument;
import es.uam.eps.bmi.search.parsing.TextParser;
import java.io.File;
import java.io.FileInputStream;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class LuceneIndexing implements Index {

    @Override
    public void build(String inputCollectionPath, String outputIndexPath, TextParser textParser) {
        try {
            File fichero = new File(inputCollectionPath);
            ZipInputStream zis = new ZipInputStream(new FileInputStream(fichero));
            ZipEntry entry = null;
            
            while ((entry = zis.getNextEntry()) != null) {
                System.out.println(entry.getName());                
            }
            
        } catch (Exception e) {
            
        }
        
    }

    @Override
    public void load(String indexPath) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<String> getDocIds() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public TextDocument getDocument(String docId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<String> getTerms() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Posting> getTermsPosting(String term) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public static void main (String args[]) {
        LuceneIndexing li = new LuceneIndexing();
        TextParser tp = null;
        li.build("ficherin", "index", tp);
    }
}
