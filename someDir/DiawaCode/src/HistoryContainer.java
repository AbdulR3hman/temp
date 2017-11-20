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
	private final int MAXIDENTIFIERS;
	private HistoryObject defaultHis;

	public HistoryContainer() {

		MAXIDENTIFIERS = 10000;
		identifiersBank = new ArrayList<HistoryObject>(MAXIDENTIFIERS);
		identifiersBankIntiate();
	}

	// Initiate the size of the array list bank to max accordingly with the
	// specifications
	private void identifiersBankIntiate() {

		for (int i = 0; i <= MAXIDENTIFIERS + 2; i++) {
			identifiersBank.add(i, new HistoryObject(i));
		}
	}

	/*
	 * Creates new Identifier based on the ID and it's time sta
	 */
	public String createIdentifier(int id, int timestamp, String data) {
		if (isIDinBounds(id) && identifiersBank.get(id).obsCheck(timestamp)) {
			identifiersBank.get(id).setObservation(timestamp, data);
			return "OK: new identifier has been created with an observation: "
					+ data;

		} else {
			return "ERR: current ID belongs to a history object already, please use other ID";
		}
	}

	// Add a new observations to a given timestamp, if the timestamp has been
	// used before,
	// remove the observation and add the new one and return the old observation
	public String update(int id, int timestamp, String data) {
		if (isIDInitiated(id)) {
			return identifiersBank.get(id).update(id, timestamp, data);
		} else {
			return "ERR: the requested identifier can not be found";
		}
	}

	// Deletes observations from a given identifier for a given timestamp
	public String deleteObservations(int id, int timestamp) {
		if (isIDInitiated(id)) {
			return identifiersBank.get(id).deleteObservations(id, timestamp);
		} else {
			return "ERR: Identifier does not exist. ";
		}
	}

	// Returns an observation history for a given identifier and a timestamp
	public String getObservations(int id, int timestamp) {
		if (isIDInitiated(id)) {
			return identifiersBank.get(id).getObs(timestamp);
		} else
			return "ERR: Identifier is out of bounds";
	}

	// get the latest history for the greatest timestamp for a given identifier
	public String latestObs(int id) {
		if (isIDInitiated(id)) {
			return identifiersBank.get(id).latest(id);
		} else
			return "ERR: Identifier does not exist";
	}

	// checks if the ID is in bounds of the specifications limits and is
	// initiated
	private boolean isIDInitiated(int id) {
		if (identifiersBank.get(id).doesItExist()) {
			return true;
		} else {
			return false;
		}

	}

	private boolean isIDinBounds(int id) {
		return (id >= 0 && id <= MAXIDENTIFIERS) ? true : false;

	}

}
