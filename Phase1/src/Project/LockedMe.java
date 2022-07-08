package Project;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Scanner;

public class LockedMe extends CustomException {

	public LockedMe() {
		// TODO Auto-generated constructor stub
	}
	public LockedMe(String s) {
		super(s);
		// TODO Auto-generated constructor stub
	}

	String rootDirectory;

	private String getRootDirectory() {
		// rootDirectory = Path.of("").toAbsolutePath().toString();
		rootDirectory = "C:\\Users\\Mohini Patel\\Desktop\\Mohini\\PG Program\\Programs\\Testing";
        return rootDirectory;
	}

	private void getSortingList(String directory) {
		// Find out directory is empty or contains file
		File dir = new File(directory);
		String[] filesList = dir.list();

		if (filesList.length > 0) {

			System.out.println("Files are in ascending order :");
//			
//			Used QuickSort techniques to get sorting list
//			QuickSort quickSort = new QuickSort();
//			quickSort.sort(filesList);
			
			String sortedList[] = dir.list();

			// Printing sorted file list in ascending order
			for (int i = 0; i < sortedList.length; i++) {
				System.out.println(sortedList[i]);
			}
		} else {
			System.out.println("Directory is empty");
		}

	}
	
	private void addFile()  {
		
		Scanner input = new Scanner(System.in);
        System.out.print("Enter the desired name of your file: ");
        String fileName = input.next();
        fileName = getRootDirectory() + "\\" + fileName + ".txt";
      
        //System.out.println(fileName);
		File file = new File(fileName);
		
		try {
			if (file.createNewFile()) {
				System.out.println("File created successfully!");
			}
			else
			{
				System.out.println("File is already exist");
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
 
	private void deleteFile() throws CustomException {
		
		Scanner input = new Scanner(System.in);
        System.out.print("Enter the desired name of your file: ");
        String fileName = input.nextLine();
        String filePath = getRootDirectory() + "\\" + fileName + ".txt";
		File file = new File(filePath);
		
		//checking case sensitivity
		if (fileExists(fileName + ".txt"))
		{
			if(file.delete())
			{
				System.out.println("File deleted");
			}
			else
			{
				System.out.println("File deletion failed");
			}
		} else {
			throw new CustomException("File Not Found");
		}
		
			
			
	}
	
	private void searchFile() throws CustomException
	{
		Scanner input = new Scanner(System.in);
        System.out.print("Enter the desired name of your file: ");
        String fileName = input.nextLine();
        String filePath = getRootDirectory() + "\\" + fileName + ".txt";
		File file = new File(filePath);
		
		if(file.exists() && fileExists(fileName + ".txt"))
		{
			System.out.println("File is existed in this path: " + getRootDirectory());
		}else {
			throw new CustomException("File is not exist ");
		}
	}
	
	private boolean fileExists(String fileName) {
		File dir = new File(getRootDirectory());
		String[] filesList = dir.list();
		for (String file : filesList) {
			if (file.equals(fileName)) {
				return true;
			}
		}
		return false;
		
	}
	private void crudOperations() {
		
		boolean continueOperation =  true;
		do {
		System.out.println("\nCRUD Operations\n");
		System.out.println("a. Add a file in directory list ");
		System.out.println("b. Delete file ");
		System.out.println("c. Search file ");
		System.out.println("d. Go back to main options ");
		System.out.println("");
		
		Scanner scanner = new Scanner(System.in);
		
		char value = scanner.next().charAt(0);
		switch(value) {
		case 'a':
			addFile();
			break;
		case 'b':
			try {
				deleteFile();
			} catch (CustomException e) {
				// TODO Auto-generated catch block
				System.out.println(e.getMessage());
			}
			break;
		case 'c':
			try {
				searchFile();
			} catch (CustomException e) {
				// TODO Auto-generated catch block
				System.out.println(e.getMessage());
			}
			break;
		case 'd':
			continueOperation = false;
			break;
			
		}
		}while(continueOperation);
		
	}
	
	
	public static void main(String args[]) {
		LockedMe lockdMe;
		int choice;
	//	String s1 = "";
		boolean status;
		boolean operationContinue = true;
		// Displaying devs details and application name

		System.out.println("LockedMe.com");
		System.out.println("Developed By: Mohini Patel (Full Stack Developer)" + "\n\n");

		do {
		// Showing options to display user interaction
		System.out.println("\nFeatures available for this product:");
		System.out.println("1. Shows File names in ascending order");
		System.out.println("2. Perform Add, Delete, Search specified file");
		System.out.println("3. Exit");
		System.out.println("");

		// Prompt user to select one of choice
		
		System.out.println("Please select one of above options:");
		Scanner scanner = new Scanner(System.in);
		choice = validRangeSelection(scanner, 1, 3);

		// creating instance and performing operations
		lockdMe = new LockedMe();
		switch (choice) {
		case 1:
			lockdMe.getSortingList(lockdMe.getRootDirectory());
			break;
		case 2:
			lockdMe.crudOperations();
			break;
		case 3:
			operationContinue = false;
			System.exit(0);
			break;
			
		}
		/*
		 * if (choice == 1 || choice == 2) {
		 * System.out.println("Do you want to continue? Y/N"); s1 = scanner.next(); }
		 */
       }while(operationContinue);
		
		//System.out.println(s1);
	}

	private static int validRangeSelection(Scanner scanner, int lowest, int highest) {
		int value;
		value = scanner.nextInt();
		while (value < lowest || value > highest) {
			System.out.println("Please select options between " + lowest + " and " + highest);
			value = scanner.nextInt();
		}
		return value;
	}
}
