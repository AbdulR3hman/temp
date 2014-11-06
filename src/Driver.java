import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * @author AbdulRehamn AL-Faraj
 * @version 6TH/NOV/2014
 * 
 */

public class Driver {

	public static void main(String[] args) {

		HistoryContainer log = new HistoryContainer();
		String command = "NoCommand", data = "";
		int id = -1, timestamp = -1;
		Pattern whiteSpaces = Pattern. compile("\\d");
		Scanner scanIn = new Scanner(System.in);

		System.out
				.println("Welcome to Diawa read-biased in-memory temporal data store\n "
						+ "Please start by typing your command followed by any necessary input fields.: ");

		// From the specifications, the style of which any command would be cast
		// as follow:
		// Command Name <ID> [TimeStamp] [Data]
		if (scanIn.hasNext(whiteSpaces)) {
			command = scanIn.next().toUpperCase();	//Command Name

			if (scanIn.hasNext(whiteSpaces)) {
				id = scanIn.nextInt();				// <ID>

				if (scanIn.hasNext(whiteSpaces)) {
					timestamp = scanIn.nextInt();	//[timeStamp]

					if (scanIn.hasNext(whiteSpaces)) {
						data = scanIn.next();		//[data]
					}
				}
			}
		}
		
		
		scanIn.close();
		switch (command) {
		case "GET":
			System.out.print("a get test");
			break;

		default:
			System.out
					.print("The command you requested is not valid, please try again");

		}

		System.out.println(command);
		System.out.println(id);
		System.out.println(timestamp);
		System.out.println(data);

	}

}
