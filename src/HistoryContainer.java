import java.util.ArrayList;

/**
 * 
 */

/**
 * @author AbdulRehman AL-FARAJ
 * @version 6TH/NOV/2014
 * 
 * @Purpose: a container to manage all of histories objects....
 *
 */
public class HistoryContainer {
	
	
	private ArrayList<HistoryObject> identifiersBank; 
	private final long  MAXTIMESTAMP;
	private final long  MAXIDENTIFIERS;

	public HistoryContainer(){
		identifiersBank = new ArrayList<HistoryObject>();
		MAXTIMESTAMP = 1000; 
		MAXIDENTIFIERS = 10000;
	}
	
	public String create(int id, int timestamp, String data)
	{
//		try{
//			history.
//		}
	return data;
		
	}

	private String CreateHistoryObj(int id, int timestamp)
	{
		if(id > MAXIDENTIFIERS || identifiersBank.get(id).getObservation(timestamp) == null ){
			return "ERR: current ID belongs to a history object already or it is over the max, please use other ID";
		}else{
			return "OK:" ;
		}	
	}
	
	private void update(int id, int timestamp, String data)
	{
		//history.get(id).
	}
	
}
