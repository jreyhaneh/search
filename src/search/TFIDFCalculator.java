package search;

import java.util.ArrayList;
import java.util.List;

public class TFIDFCalculator {
	public double tf(List<String> doc, String term) {
	    double result = 0;
	    for (String word : doc) {
	       if (term.equalsIgnoreCase(word))
	              result++;
	       }
	    return result / doc.size();
	}
	public double idf(List<ArrayList<String>> docs, String term) {
	    double n = 0;
	    for (List<String> doc : docs) {
	        for (String word : doc) {
	            if (term.equalsIgnoreCase(word)) {
	                n++;
	                break;
	            }
	        }
	         }
	    return Math.log(docs.size() / n);
	}
	public double tfIdf(List<String> doc,List <ArrayList<String>> docs, String term) {
	    return tf(doc, term) * idf(docs, term);
	}

}
