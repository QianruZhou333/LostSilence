package tutorial;

import java.util.TimerTask;

import com.hp.hpl.jena.query.QuerySolution;
import com.hp.hpl.jena.query.ResultSet;

import java.util.ArrayList;
import java.util.Timer;

public class Start {
	
	// ArrayList to store temp UEs that lost signal and at the same location
	static ArrayList<QuerySolution> LostArrayList = new ArrayList<QuerySolution>();
	
	// the number of UEs that lost signal at the same location
	static ArrayList<Integer> Counter = new ArrayList<Integer>();
	
	static class MyTask extends TimerTask {

		@Override
		public void run() {
			// TODO Auto-generated method stub
			System.out.println("Start!!");
			
			FindLostSilence.findLostSilence(LostArrayList, Counter);
			
		}
		
	}
	
	static class Shutdown extends TimerTask {
		Timer timer = null;
		
		public Shutdown() {
		}
		
		public Shutdown(Timer mytimer) {
			timer = mytimer;
		}
		
		public void run() {
			System.out.println("End!!");
			timer.cancel();
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		new SparqlTest().runQuery();
		Timer timer = new Timer();
		timer.schedule(new MyTask(), 0);
		timer.schedule(new Shutdown(timer), 50000);
	}

}
