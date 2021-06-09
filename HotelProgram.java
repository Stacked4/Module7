// This is a hotel program - I figured since I have to go down to CA for a funeral
// in September, this might present a great concept for a program.
// Ashby Andrus
// CIS 143
// also note: I also attempted to do some I/O here as well.

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class HotelProgram {
	
	private static boolean MainMenu = true;
	private static boolean SubMenu = true;
	

public static void main(String[] args) throws IOException {
	try (Scanner input = new Scanner(System.in)) {
		Room[] myHotel = new Room[10];
		myHotel[0] = new Room();
		myHotel[1] = new Room();
		myHotel[2] = new Room();
		myHotel[3] = new Room();
		myHotel[4] = new Room();
		myHotel[5] = new Room();
		myHotel[6] = new Room();
		myHotel[7] = new Room();
		myHotel[8] = new Room();
		myHotel[9] = new Room();
		int roomNum = 0;
		initialise (myHotel);
		while (MainMenu) {
			while (SubMenu) {
				System.out.println("-----------------------------------------");
				System.out.println("Hello this is my Hotel Program.");
				System.out.println("-----------------------------------------");
				System.out.println("Please select one of the following:");
				System.out.println("A. Book a new room.");
				System.out.println("-----------------------------------------");
				System.out.println("E. Display empty rooms.");
				System.out.println("-----------------------------------------");
				System.out.println("V. View all rooms");
				System.out.println("-----------------------------------------");
				System.out.println("D. Delete customer");
				System.out.println("========================================");
				System.out.println("Find room from customer name:");
				System.out.println("========================================");
				System.out.println("S. Store data in file.");
				System.out.println("========================================");
				System.out.println("L. load program data from file");
				System.out.println("****************************************");
				System.out.println("O. view rooms ordered alphetically:");
				System.out.println("----------------------------------------");
				System.out.println("--------------------");
				System.out.println("--------------------");
				
				String Selection = input.next();
				Selection = Selection.toUpperCase();
				switch (Selection) {
				case "A":
					BookARoom(myHotel, roomNum);
					break;
				case "E":
					CheckIfEmpty(myHotel);
					break;
				case "V":
					ViewAllRooms(myHotel);
					break;
				case "D":
					DeleteCustomerFromRoom(myHotel, roomNum);
					break;
				case "F":
					FindRoomFromCustomerName(myHotel);
					break;
				case "S":
					StoreProgramDataInToFile(myHotel);
					break;
				case "L":
					LoadProgramDataFromFile(myHotel);
					break;
				case "O":
					ViewRoomsOrderedAlphabeticallyByName(myHotel);
					break;
				default:
					System.out.println("Invalid selection try again");
					break;
				}
			System.out.println("---------------------");
			System.out.println("-----------------------");
			System.out.println("Would you like to make another choice: (1 yes 2 no");
			System.out.println("---------------------------");
			System.out.println("---------------------------");
			if (input.nextInt() == 1) {
				SubMenu = true;
			} else {
				SubMenu = false;
			}
			}
		SubMenu = true;
		System.out.println("-------------------------------");
		System.out.println("would you like to continue 1  yes 2 no");
		System.out.println("------------------------------");
		if (input.nextInt() == 1 ) {
			MainMenu = true;
		} else {
			System.out.println("");
			System.exit(0);
		}
		}
	}
}

private static void initialise(Room[] myHotel) {
	for(int x=0; x < myHotel.length; x++) {
		myHotel[x].setName("nobody");
	}
}
private static void CheckIfEmpty(Room[] myHotel) {
	for (int x = 0;x < myHotel.length; x++) {
		if (myHotel[x].getName().equals("nobody")) {
			System.out.println("room " + (x + 1) + " is empty");
		}
	}
}
private static void BookARoom(Room[] myHotel, int roomNum) {
	String roomName;
	Scanner input = new Scanner(System.in);
	System.out.println("Enter room number (1-10");
	roomNum = input.nextInt() -1;
	System.out.println("Enter name for room " + (roomNum + 1) + " :");
	roomName = input.next();
	myHotel[roomNum].setName(roomName);
}


private static void ViewAllRooms(Room[] myHotel) {
	for (int x = 0;x < myHotel.length; x++) {
		System.out.println("room " + (x + 1) + " occupied by " + myHotel[x].getName());
	}
}
private static void DeleteCustomerFromRoom(Room[] myHotel, int roomNum) {
	Scanner input = new Scanner(System.in);
			System.out.println("Enter room number to delete 1-10");
	roomNum = input.nextInt() - 1;
	myHotel[roomNum].setName("nobody");
	System.out.println("Entry is deleted ");
}
private static void FindRoomFromCustomerName(Room[] myHotel) {
	Scanner input = new Scanner(System.in);
	String roomName;
	System.out.println("Enter name to search: ");
	roomName = input.next();
	int x;
	boolean Checker = false;
	for (x = 0;x < myHotel.length; x++) {
		if (roomName.equals(myHotel[x].getName())) {
			System.out.println("The Account that has that Name is " + x);
			Checker = true;
		}
	}
	if (Checker == false) {
		System.out.println("There are no rooms with that name.");
	}
}
private static void StoreProgramDataInToFile(Room[] myHotel) throws IOException {
	try (PrintWriter out = new PrintWriter(new FileWriter
			("/users/afand/desktop/outputfile.txt"))) {
		int x;
		for (x = 0;x <myHotel.length; x++ ) {
			out.println("Name and Room number are: " + myHotel[x].getName() + "at:" + x);
		}
	}
	System.out.println("All room names are saved.");
}
private static void LoadProgramDataFromFile(Room[] myHotel) throws IOException {
	FileInputStream fs = new FileInputStream("/users/afand/desktop/inputfile.txt");
	BufferedReader br = new BufferedReader(new InputStreamReader(fs));
	for(int i = 0;i <myHotel.length; i++) {
		myHotel[i].setName(br.readLine());
	}
}
private static void ViewRoomsOrderedAlphabeticallyByName(Room[] myHotel) {
	String[] myStrArray = new String[myHotel.length];
	for (int i=0; i < myHotel.length; i++) {
		myStrArray[i] = myHotel[1].getName();
	}
	
	Arrays.sort(myStrArray);
	for (int a=0;a < myStrArray.length; a++) {
		System.out.println(myStrArray[a]);
	}
}
public static class Room {
	private String mainName;
	int guestsInRoom;
	
	public Room() {
		mainName = "k";
	}
	
	public void setName(String aName) {
		mainName = aName;
	}
	
	public String getName() {
		return mainName;
	}
}

	}

			
			