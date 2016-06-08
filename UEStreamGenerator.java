/*******************************************************************************
 * @author Qianru Zhou
 * @email qz1@hw.ac.uk
 * @project Lost Silence
 * @function UEStreamGenerator
 ******************************************************************************/
package asleep.streamer;

import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import eu.larkc.csparql.cep.api.RdfQuadruple;
import eu.larkc.csparql.cep.api.RdfStream;

public class UEStreamGenerator extends RdfStream implements Runnable {

	/** The logger. */
	protected final Logger logger = LoggerFactory
			.getLogger(UEStreamGenerator.class);	

	private int c = 1;
	private boolean keepRunning = false;
	
	public UEStreamGenerator(final String iri) {
		super(iri);
	}

	public void pleaseStop() {
		keepRunning = false; 
	}

	@Override
	public void run() {
		keepRunning = true;
		
		Random random = new Random();
		int FemtoCellID;
		
		while (keepRunning) {
			FemtoCellID = random.nextInt(60);
	
//			System.out.println("it's running. " + this.c);
			
			final RdfQuadruple q = new RdfQuadruple(getIRI()+"/Phone" + this.c,
					"http://home.eps.hw.ac.uk/~qz1/ontologies/wirelessnetwork_networkResource.owl/hasLink", getIRI() + "/Link" + this.c, 
					System.currentTimeMillis());

			this.put(q);
//			System.out.println("q: " + q);
			
			final RdfQuadruple q1 = new RdfQuadruple(getIRI() + "/Link" + this.c,
					"http://home.eps.hw.ac.uk/~qz1/ontologies/wirelessnetwork_networkResource.owl/hasDestination", 
					"http://home.eps.hw.ac.uk/~qz1/ontologies/wirelessnetwork_networkResource.owl/FemtoCell" + FemtoCellID,
					System.currentTimeMillis());
			
			this.put(q1);
//			System.out.println("q1: " + q1);

			double UEStatus = random.nextInt(5); // UE status, 1: unAvailable; 2: detached; others: normal.

			if (UEStatus == 1) {
				final RdfQuadruple q2 = new RdfQuadruple(getIRI() + "/Phone" + this.c,
						"http://home.eps.hw.ac.uk/~qz1/ontologies/wirelessnetwork_networkResource.owl/hasQoSIssue", 
						"http://home.eps.hw.ac.uk/~qz1/ontologies/wirelessnetwork_networkResource.owl/UnAvailable",
						System.currentTimeMillis());
				
				this.put(q2);
//				System.out.println("q1: " + q1);
				System.out.println("Phone" + this.c + " is UnAvailable, FemtoCell: " + FemtoCellID);

			} else if (UEStatus == 2) {
				final RdfQuadruple q2 = new RdfQuadruple(getIRI() + "/Phone" + this.c,
						"http://home.eps.hw.ac.uk/~qz1/ontologies/wirelessnetwork_networkResource.owl/hasQoSIssue", 
						"http://home.eps.hw.ac.uk/~qz1/ontologies/wirelessnetwork_networkResource.owl/Detached", 
						System.currentTimeMillis());
				
				this.put(q2);
				
//				System.out.println("q2: " + q2);

			}

			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			this.c++;
		}
	}
}
