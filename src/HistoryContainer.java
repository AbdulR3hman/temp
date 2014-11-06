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
	private final long  MAXIDENTIFIERS;

	public HistoryContainer(){
		identifiersBankIntiate();
		MAXIDENTIFIERS = 10000;
	}
	

	//Initiate the size of the array list bank to max accordingly with the specifications
	private void identifiersBankIntiate() {
		identifiersBank = new ArrayList<HistoryObject>();
		for (int i = 0 ; i <= MAXIDENTIFIERS ; i++)
		{
			identifiersBank.add(null);
		}
	}


	/*
	 * Creates new Identifier based on the ID and it's time sta
	 */
	public String CreateIdentifier(int id, int timestamp, String data)
	{
		if(!isIDinBoundAndInitiated(id)){
			return "ERR: current ID belongs to a history object already or it is over the max, please use other ID";
		}else{		
			identifiersBank.add(id, new HistoryObject(id,timestamp, data));
			return "OK: new identifier has been created with an observation: " + data;
		}	
	}
	
	//Add a new observations to a given timestamp, if the timestamp has been used before, 
	//remove the observation and add the new one and return the old observation
	public String update(int id, int timestamp, String data)
	{
		if(isIDinBoundAndInitiated(id)){
			return identifiersBank.get(id).update(id, timestamp, data);
		}else
		{
			return "ERR: the requested identifier can not be found";
		}
	}
	
	//Deletes observations from a given identifier for a given timestamp 
	public String deleteObservations(int id, int timestamp)
	{
		if(isIDinBoundAndInitiated(id)){
		return identifiersBank.get(id).deleteObservations(id, timestamp);
		}else
		{
			return "ERR: Identifier is not iniated or our of bounds. " ;
		}
	}
	
	//Returns an observation history for a given identifier and a timestamp
	public String getObservations(int id , int timestamp)
	{
		if (isIDinBoundAndInitiated(id)){
				return identifiersBank.get(id).getObs(id, timestamp);
		}else
			return "ERR: Identifier is out of bounds";	
	}
	
	//get the latest history for the greatest timestamp for a given identifier
	public String latestObs(int id)
	{
		if(isIDinBoundAndInitiated(id))
		{
			return identifiersBank.get(id).latest(id);
		}else
			return "ERR: Identifier is out of bounds";	
	}
	
	
	//checks if the ID is in bounds of the specifications limits and is initiated
	private boolean isIDinBoundAndInitiated(int id)
	{
		if (identifiersBank.get(id).doesItExist())
		{return true;} else {return false;}
			
	}
	
}
