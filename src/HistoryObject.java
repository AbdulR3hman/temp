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

	
	public HistoryObject(int id){
		//intiate the ID
		this.ID = id;
		MAXTIMESTAMP = 1000;	//as assumed by the spec that won't have more than 1000 timestamps
		setHistory(new ArrayList<String>());	//index is the timestamp and the element is the data change (observation)
	}

	//Retrieve the history list ID
	public int getID(){
		return this.ID;
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
	
	
}
