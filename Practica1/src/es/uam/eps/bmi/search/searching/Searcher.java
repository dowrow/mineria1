
package es.uam.eps.bmi.search.searching;

import es.uam.eps.bmi.search.ScoredTextDocument;
import es.uam.eps.bmi.search.indexing.Index;
import java.util.List;

public interface Searcher {
    void build (Index index);
    List<ScoredTextDocument> search (String query);
}
