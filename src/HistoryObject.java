import java.util.ArrayList;

/*
 * @Author:	AbdulRehman Faraj
 * @Date:	6th/Nov/2014
 * 
 * Purpose:	History object to specify and rule the structure of each data and it's history.  
 */

public class HistoryObject {
	
	private final int ID; 	//ID to refer to the a certain history
	private final long  MAXTIMESTAMP;
	private ArrayList<String> history;	//An arraylist to hold the history, I choose an arraylist because it can expand. 
	private boolean exist;		//keep track of the latest timestamp
	private int greatestTS;
	
	public HistoryObject(int id, int timestamp, String data){
		//Initiate the ID
		this.ID = id;
		this.greatestTS = 0;
		MAXTIMESTAMP = 1000;	//as assumed by the specifications that won't have more than 1000 timestamps
		exist = true; //this indicates that this Identifier has been initiated already. 
		
		setHistory(new ArrayList<String>());	//index is the timestamp and the element is the data change (observation)
		setObservation(timestamp, data);
	}

	//Retrieve the history list ID
	public int getID(){
		return this.ID;
	}
	
	//checks if the actual identifier has been used or not before.
	public boolean doesItExist()
	{
		return exist;
	}
	
	//Return the whole list of history
	public ArrayList<String> getHistory() {
		return history;
	}


	private void setHistory(ArrayList<String> history) {
		this.history = history;
		this.initHistory();
	}
	
	private void initHistory(){
		for (int i = 0; i <= MAXTIMESTAMP; i++)
		{
			this.history.addAll(null);
		}
	}

	
	//Get an observation based on the last timestamp
	public String getObservation(int timestamp) 
	{
		return history.get(timestamp);
		
	}
	
	//Set Observations
	public String setObservation(int timestamp, String data)
	{
		history.add(timestamp, data);
		return data;
	}

	//Update timestamp
	public String update(int id2, int timestamp, String data) {

		if (timestampInBounds(timestamp)){
			String oldObservation = history.get(id2);
			history.set(id2, data);
			updateGreatestTS(timestamp);
			return "OK: previous observation was: " + oldObservation;
		}else
			return "ERR: timestamp is out of bounds";
	}

	//update the greatest timestamp for each identifier
	private void updateGreatestTS(int timestamp) {
		if (greatestTS < timestamp)
			greatestTS = timestamp;		
	}

	/*
	 * deletes an observation based on given ID and timestamp or just ID
	 */
	public String deleteObservations(int id2, int timestamp) {
		//Delete observations
		String returnObservation;
		//if timestamp is not given
		if (timestampInBounds(timestamp)){
				returnObservation = history.get(greatestTS);
				history.clear();
				return "OK: the observation with the greatest history is: " + returnObservation;
		}else	// if timestamp is given
		{
			for(int i = timestamp+1 ; i <= MAXTIMESTAMP; i++)
				history.remove(i);
			return "OK: the observation for timestamp: " + timestamp + " is: " + history.get(timestamp);
		}
	}
	
	/*
	 * returns observation if timestamp correct or an error
	 */
	public String getObs(int id, int timestamp){
		
		if(timestampInBounds(timestamp) && history.get(timestamp) == null){
			return "OK: Observation for timestamp: " + timestamp +" is: " + history.get(timestamp);
		}else
		{
			return "ERR: no observations found";
		}
	}

	//return the observation for the last timestamp
	public String latest(int id)
	{
		return this.getObs(id, greatestTS);
	}
	
	//checks if timestamp in bounds of the specifications assumptions
	private boolean timestampInBounds(int timestamp) {
		if(timestamp >= 0 && timestamp <= MAXTIMESTAMP){
			return true;
		}else
			return false;
	}
}
