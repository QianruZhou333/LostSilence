/*******************************************************************************
 * @author: Qianru Zhou
 * @email: qz1@hw.ac.uk
 * @project: Lost Silence
 * @function: CSPARQL_Engine 
 ******************************************************************************/
package asleep.csparql;

import java.net.MalformedURLException;
import java.text.ParseException;

import org.apache.log4j.PropertyConfigurator;
import eu.larkc.csparql.cep.api.RdfStream;
import eu.larkc.csparql.core.engine.ConsoleFormatter;
import eu.larkc.csparql.core.engine.CsparqlEngine;
import eu.larkc.csparql.core.engine.CsparqlEngineImpl;
import eu.larkc.csparql.core.engine.CsparqlQueryResultProxy;
import asleep.streamer.UEStreamGenerator;

public class CSPARQL_Engine {

//	private static Logger logger = LoggerFactory.getLogger(CSPARQL_Engine.class);


	public static void main(String[] args) throws MalformedURLException {

//		PropertyConfigurator.configure(new URL("http://streamreasoning.org/configuration_files/csparql_readyToGoPack_log4j.properties"));
		PropertyConfigurator.configure("log4j_configuration/csparql_readyToGoPack_log4j.properties");

		// initializations

		//		String streamURI = "http://home.eps.hw.ac.uk/~qz1/ontologies/wirelessnetwork_networkResource.owl/stream";
		String query = null;
		RdfStream tg_1 = null;
		RdfStream tg_2 = null;
		RdfStream tg_3 = null;
		RdfStream tg_4 = null;
		RdfStream tg_5 = null;
		RdfStream tg_6 = null;
		RdfStream tg_7 = null;
		RdfStream tg_8 = null;
		RdfStream tg_9 = null;
		RdfStream tg_10 = null;
		RdfStream tg_11 = null;
		RdfStream tg_12 = null;
		RdfStream tg_13 = null;
		RdfStream tg_14 = null;
		RdfStream tg_15 = null;
//		RdfStream tg_16 = null;
//		RdfStream tg_17 = null;
//		RdfStream tg_18 = null;
//		RdfStream tg_19 = null;
//		RdfStream tg_20 = null;
		
		// Initialize C-SPARQL Engine
		CsparqlEngine engine = new CsparqlEngineImpl();
		
		engine.initialize(true);

		query = ""
				+ "REGISTER QUERY LostSilence AS "
				+ "PREFIX f: <http://larkc.eu/csparql/sparql/jena/ext#> "
				+ "PREFIX ex: <http://home.eps.hw.ac.uk/~qz1/ontologies/wirelessnetwork_networkResource.owl#> "
				+ "SELECT ?femtocell (COUNT(?UE) AS ?sample) "
				+ "FROM STREAM <http://home.eps.hw.ac.uk/~qz1/ontologies/wirelessnetwork_networkResource.owl/stream1> [RANGE 10m STEP 1s] "
				+ "FROM STREAM <http://home.eps.hw.ac.uk/~qz1/ontologies/wirelessnetwork_networkResource.owl/stream2> [RANGE 10m STEP 1s] "
				+ "FROM STREAM <http://home.eps.hw.ac.uk/~qz1/ontologies/wirelessnetwork_networkResource.owl/stream3> [RANGE 10m STEP 1s] "
				+ "FROM STREAM <http://home.eps.hw.ac.uk/~qz1/ontologies/wirelessnetwork_networkResource.owl/stream4> [RANGE 10m STEP 1s] "
				+ "FROM STREAM <http://home.eps.hw.ac.uk/~qz1/ontologies/wirelessnetwork_networkResource.owl/stream5> [RANGE 10m STEP 1s] "
				+ "FROM STREAM <http://home.eps.hw.ac.uk/~qz1/ontologies/wirelessnetwork_networkResource.owl/stream6> [RANGE 10m STEP 1s] "
				+ "FROM STREAM <http://home.eps.hw.ac.uk/~qz1/ontologies/wirelessnetwork_networkResource.owl/stream7> [RANGE 10m STEP 1s] "
				+ "FROM STREAM <http://home.eps.hw.ac.uk/~qz1/ontologies/wirelessnetwork_networkResource.owl/stream8> [RANGE 10m STEP 1s] "
				+ "FROM STREAM <http://home.eps.hw.ac.uk/~qz1/ontologies/wirelessnetwork_networkResource.owl/stream9> [RANGE 10m STEP 1s] "
				+ "FROM STREAM <http://home.eps.hw.ac.uk/~qz1/ontologies/wirelessnetwork_networkResource.owl/stream10> [RANGE 10m STEP 1s] "
				+ "FROM STREAM <http://home.eps.hw.ac.uk/~qz1/ontologies/wirelessnetwork_networkResource.owl/stream11> [RANGE 10m STEP 1s] "
				+ "FROM STREAM <http://home.eps.hw.ac.uk/~qz1/ontologies/wirelessnetwork_networkResource.owl/stream12> [RANGE 10m STEP 1s] "
				+ "FROM STREAM <http://home.eps.hw.ac.uk/~qz1/ontologies/wirelessnetwork_networkResource.owl/stream13> [RANGE 10m STEP 1s] "
				+ "FROM STREAM <http://home.eps.hw.ac.uk/~qz1/ontologies/wirelessnetwork_networkResource.owl/stream14> [RANGE 10m STEP 1s] "
				+ "FROM STREAM <http://home.eps.hw.ac.uk/~qz1/ontologies/wirelessnetwork_networkResource.owl/stream15> [RANGE 10m STEP 1s] "
//				+ "FROM STREAM <http://home.eps.hw.ac.uk/~qz1/ontologies/wirelessnetwork_networkResource.owl/stream16> [RANGE 10m STEP 1s] "
//				+ "FROM STREAM <http://home.eps.hw.ac.uk/~qz1/ontologies/wirelessnetwork_networkResource.owl/stream17> [RANGE 10m STEP 1s] "
//				+ "FROM STREAM <http://home.eps.hw.ac.uk/~qz1/ontologies/wirelessnetwork_networkResource.owl/stream18> [RANGE 10m STEP 1s] "
//				+ "FROM STREAM <http://home.eps.hw.ac.uk/~qz1/ontologies/wirelessnetwork_networkResource.owl/stream19> [RANGE 10m STEP 1s] "
//				+ "FROM STREAM <http://home.eps.hw.ac.uk/~qz1/ontologies/wirelessnetwork_networkResource.owl/stream20> [RANGE 10m STEP 1s] "				
				+ "WHERE { "
				+ "?link ex:hasDestination ?femtocell . "
				+ "?UE ex:hasQoSIssue ?status ;"
				+ " ex:hasLink ?link. "
				+ "FILTER ( ?status = ex:UnAvailable) "
				+ "} " 
				+ "GROUP BY ?femtocell"
				+ " HAVING (COUNT(?UE) >= 2) ";

		tg_1 = new UEStreamGenerator("http://home.eps.hw.ac.uk/~qz1/ontologies/wirelessnetwork_networkResource.owl/stream1");
		tg_2 = new UEStreamGenerator("http://home.eps.hw.ac.uk/~qz1/ontologies/wirelessnetwork_networkResource.owl/stream2");
		tg_3 = new UEStreamGenerator("http://home.eps.hw.ac.uk/~qz1/ontologies/wirelessnetwork_networkResource.owl/stream3");
		tg_4 = new UEStreamGenerator("http://home.eps.hw.ac.uk/~qz1/ontologies/wirelessnetwork_networkResource.owl/stream4");
		tg_5 = new UEStreamGenerator("http://home.eps.hw.ac.uk/~qz1/ontologies/wirelessnetwork_networkResource.owl/stream5");
		tg_6 = new UEStreamGenerator("http://home.eps.hw.ac.uk/~qz1/ontologies/wirelessnetwork_networkResource.owl/stream6");
		tg_7 = new UEStreamGenerator("http://home.eps.hw.ac.uk/~qz1/ontologies/wirelessnetwork_networkResource.owl/stream7");
		tg_8 = new UEStreamGenerator("http://home.eps.hw.ac.uk/~qz1/ontologies/wirelessnetwork_networkResource.owl/stream8");
		tg_9 = new UEStreamGenerator("http://home.eps.hw.ac.uk/~qz1/ontologies/wirelessnetwork_networkResource.owl/stream9");
		tg_10 = new UEStreamGenerator("http://home.eps.hw.ac.uk/~qz1/ontologies/wirelessnetwork_networkResource.owl/stream10");
		tg_11 = new UEStreamGenerator("http://home.eps.hw.ac.uk/~qz1/ontologies/wirelessnetwork_networkResource.owl/stream11");
		tg_12 = new UEStreamGenerator("http://home.eps.hw.ac.uk/~qz1/ontologies/wirelessnetwork_networkResource.owl/stream12");
		tg_13 = new UEStreamGenerator("http://home.eps.hw.ac.uk/~qz1/ontologies/wirelessnetwork_networkResource.owl/stream13");
		tg_14 = new UEStreamGenerator("http://home.eps.hw.ac.uk/~qz1/ontologies/wirelessnetwork_networkResource.owl/stream14");
		tg_15 = new UEStreamGenerator("http://home.eps.hw.ac.uk/~qz1/ontologies/wirelessnetwork_networkResource.owl/stream15");
//		tg_16 = new UEStreamGenerator("http://home.eps.hw.ac.uk/~qz1/ontologies/wirelessnetwork_networkResource.owl/stream16");
//		tg_17 = new UEStreamGenerator("http://home.eps.hw.ac.uk/~qz1/ontologies/wirelessnetwork_networkResource.owl/stream17");
//		tg_18 = new UEStreamGenerator("http://home.eps.hw.ac.uk/~qz1/ontologies/wirelessnetwork_networkResource.owl/stream18");
//		tg_19 = new UEStreamGenerator("http://home.eps.hw.ac.uk/~qz1/ontologies/wirelessnetwork_networkResource.owl/stream19");
//		tg_20 = new UEStreamGenerator("http://home.eps.hw.ac.uk/~qz1/ontologies/wirelessnetwork_networkResource.owl/stream20");
		// Register an RDF Stream

		engine.registerStream(tg_1);
		engine.registerStream(tg_2);
		engine.registerStream(tg_3);
		engine.registerStream(tg_4);
		engine.registerStream(tg_5);
		engine.registerStream(tg_6);
		engine.registerStream(tg_7);
		engine.registerStream(tg_8);
		engine.registerStream(tg_9);
		engine.registerStream(tg_10);
		engine.registerStream(tg_11);
		engine.registerStream(tg_12);
		engine.registerStream(tg_13);
		engine.registerStream(tg_14);
		engine.registerStream(tg_15);
//		engine.registerStream(tg_16);
//		engine.registerStream(tg_17);
//		engine.registerStream(tg_18);
//		engine.registerStream(tg_19);
//		engine.registerStream(tg_20);
		// Start Streaming (this is only needed for the example, normally streams are external
		// C-SPARQL Engine users are supposed to write their own adapters to create RDF streams

		final Thread t_1 = new Thread((Runnable) tg_1);
		t_1.start();
		
		final Thread t_2 = new Thread((Runnable) tg_2);
		t_2.start();	
		
		final Thread t_3 = new Thread((Runnable) tg_3);
		t_3.start();	
		
		final Thread t_4 = new Thread((Runnable) tg_4);
		t_4.start();	
		
		final Thread t_5 = new Thread((Runnable) tg_5);
		t_5.start();	

		final Thread t_6 = new Thread((Runnable) tg_6);
		t_6.start();
		
		final Thread t_7 = new Thread((Runnable) tg_7);
		t_7.start();
		
		final Thread t_8 = new Thread((Runnable) tg_8);
		t_8.start();
		
		final Thread t_9 = new Thread((Runnable) tg_9);
		t_9.start();
		
		final Thread t_10 = new Thread((Runnable) tg_10);
		t_10.start();
				
		final Thread t_11 = new Thread((Runnable) tg_11);
		t_11.start();
		
		final Thread t_12 = new Thread((Runnable) tg_12);
		t_12.start();	

		final Thread t_13 = new Thread((Runnable) tg_13);
		t_13.start();	

		final Thread t_14 = new Thread((Runnable) tg_14);
		t_14.start();	

		final Thread t_15 = new Thread((Runnable) tg_15);
		t_15.start();	
		/*********************	

		final Thread t_16 = new Thread((Runnable) tg_16);
		t_16.start();
		
		final Thread t_17 = new Thread((Runnable) tg_17);
		t_17.start();
		
		final Thread t_18 = new Thread((Runnable) tg_18);
		t_18.start();
		
		final Thread t_19 = new Thread((Runnable) tg_19);
		t_19.start();
		
		final Thread t_20 = new Thread((Runnable) tg_20);
		t_20.start();
*********************/
		// Register a C-SPARQL query

		CsparqlQueryResultProxy c1 = null;
		try {
			c1 = engine.registerQuery(query, false);	
		} catch (final ParseException ex) {
		}

		// Attach a Result Formatter to the query result proxy

		if (c1 != null) {
			c1.addObserver(new ConsoleFormatter());
		}

		// leave the system running for a while
		// normally the C-SPARQL Engine should be left running
		// the following code shows how to stop the C-SPARQL Engine gracefully
		try {
			Thread.sleep(200000);
		} catch (InterruptedException e) {
//			logger.error(e.getMessage(), e);
		}

		// clean up (i.e., unregister query and stream)
		engine.unregisterQuery(c1.getId());

		((UEStreamGenerator) tg_1).pleaseStop();

		engine.unregisterStream(tg_1.getIRI());

		System.exit(0);

	}

}
