package tutorial;

import com.hp.hpl.jena.query.Query;
import com.hp.hpl.jena.query.QueryExecution;
import com.hp.hpl.jena.query.QueryExecutionFactory;
import com.hp.hpl.jena.query.QueryFactory;
import com.hp.hpl.jena.query.ResultSet;
import com.hp.hpl.jena.query.ResultSetFactory;
import com.hp.hpl.jena.query.Syntax;
import com.hp.hpl.jena.rdf.model.Model;
import com.hp.hpl.jena.util.FileManager;

public class SparqlTest {
	public static final String resource_URL = "http://home.eps.hw.ac.uk/~qz1/ontologies/wirelessnetwork_user.owl";
	
	public static final String resource_NS = resource_URL + "#";
	
	
	public static ResultSet runQuery() {
		Model model = FileManager.get().loadModel(resource_URL);
		
		String queryString = "" +
				"PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>\n" +
				"PREFIX owl: <http://www.w3.org/2002/07/owl#>\n" +
				"PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>\n" +
				"PREFIX xsd: <http://www.w3.org/2001/XMLSchema#>\n" +
				"PREFIX wgs84_pos:<http://www.w3.org/2003/01/geo/wgs84_pos#>\n" +
				"PREFIX user:<http://home.eps.hw.ac.uk/~qz1/ontologies/wirelessnetwork_user.owl#>\n" +
				"PREFIX core:<http://home.eps.hw.ac.uk/~qz1/ontologies/wirelessnetwork_core.owl#>\n" +
				"PREFIX qos:<http://home.eps.hw.ac.uk/~qz1/ontologies/wirelessnetwork_qos.owl#>\n" +
				"SELECT  ?x ?y ?z\n" +
				"WHERE {\n" +
				"?x wgs84_pos:lat ?z .\n" +
				"?x wgs84_pos:long ?y.\n" +
				"FILTER ((?z >=30.688716) && (?z<=30.689233) && (?y >= 111.283040) && (?y <= 111.283727)).\n" +
				"} \n";
		
		Query query = QueryFactory.create(queryString, Syntax.syntaxARQ ) ;
		
		try(QueryExecution qexec = QueryExecutionFactory.create(query, model)) { 
			ResultSet results = qexec.execSelect();
			results = ResultSetFactory.copyResults(results);

			return results;
		}
		
	}
	

}
