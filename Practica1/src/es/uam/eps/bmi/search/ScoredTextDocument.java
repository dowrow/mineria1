
package es.uam.eps.bmi.search;

public class ScoredTextDocument {
    String docId;
    double score;
    
    public ScoredTextDocument (String docId, double score) {
        this.docId = docId;
        this.score = score;
    }
    
    public String getDocId() {
        return docId;
    }
    
    public double getScore() {
        return score;
    }
    
}
