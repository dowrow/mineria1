
package es.uam.eps.bmi.search.indexing;

import es.uam.eps.bmi.search.TextDocument;
import es.uam.eps.bmi.search.parsing.TextParser;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipInputStream;

public class LuceneIndexing implements Index {

    @Override
    public void build(String inputCollectionPath, String outputIndexPath, TextParser textParser) {
        try {
            ZipFile zipFile = new ZipFile(inputCollectionPath);
            /*ZipInputStream zis = new ZipInputStream(new BufferedInputStream(new FileInputStream(inputCollectionPath)));
            ZipEntry entry = null;
            System.out.println();*/
            
            System.out.println(zipFile.entries());
            //Enumeration zipEntries = zipFile.entries();
            
            
            /*while ((entry = zis.getNextEntry()) != null) {
                System.out.println(entry.getName());                
            }*/
            
        } catch (Exception e) {
            e.printStackTrace();
           System.out.println("error");
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
        li.build("C:/Users/dani/Desktop/clueweb-1K/docs.zip", "index", tp);
    }

    @Override
    public String getPath() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
