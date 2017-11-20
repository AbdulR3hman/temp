import java.util.Scanner;

/**
 * @author AbdulRehamn AL-Faraj
 * @version 6TH/NOV/2014
 * 
 */

public class Driver {

	public static void main(String[] args) {

		HistoryContainer log = new HistoryContainer();
		String command = "NoCommand";
		String[] commands = null;

		Scanner scanIn = new Scanner(System.in);

		System.out
				.println("Welcome to Diawa read-biased in-memory temporal data store\n "
						+ "Please start by typing your command followed by any necessary input fields.: ");

		boolean end = false;
		while (!end) {

			// From the specifications, the style of which any command would be
			// cast
			// as follow:
			// Command Name <ID> [TimeStamp] [Data]
			if (scanIn.hasNext()) {
				command = scanIn.nextLine(); // Command Name
				commands = command.split("\\s+"); // splits all the commands if
													// there is more than one

				switch (commands[0].toUpperCase()) {
				case "GET":
					System.out.println("GETTING:\n");
					System.out.println(log.getObservations(
							Integer.parseInt(commands[1]),
							Integer.parseInt(commands[2]))
							+ "\r");
					break;

				case "CREATE":
					System.out.println("CREATING:\n");
					System.out.println(log.createIdentifier(
							Integer.parseInt(commands[1]),
							Integer.parseInt(commands[2]), commands[3])
							+ "\r");
					break;

				case "UPDATE":
					System.out.println("UPDATING:\n");
					System.out.println(log.update(
							Integer.parseInt(commands[1]),
							Integer.parseInt(commands[2]), commands[3])
							+ "\r");
					break;

				case "LATEST":
					System.out.println("UPDATING:\n");
					System.out.println(log.latestObs(Integer
							.parseInt(commands[1])) + "\r");
					break;

				case "DELETE":
					System.out.println("DELETING:\n");
					System.out.println(log.deleteObservations(Integer
							.parseInt(commands[1]), (commands.length < 2 ? -1
							: Integer.parseInt(commands[1]))));
					break;

				case "QUIT":
					end = true;
					break;

				default:
					System.out
							.println("The command you requested is not valid, please try again");
					break;
				}
			}
		}

		scanIn.close();
	}
}
