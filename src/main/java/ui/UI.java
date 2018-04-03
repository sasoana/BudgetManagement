package ui;

import java.util.List;
import java.util.Scanner;

import controller.EntryController;
import exceptions.InvalidBudgetException;
import exceptions.InvalidNameException;
import exceptions.InvalidTypeException;
import model.*;
import controller.MemberController;;

public class UI {
	private MemberController memberController;
	private EntryController entryController;

	Scanner in;
	
	public UI(MemberController memberController, EntryController entryController) {
		this.memberController = memberController;
		this.entryController = entryController;
		this.in = new Scanner(System.in);
	}
	
	public MemberController getMemberController() {
		return this.memberController;
	}

	public EntryController getEntryController() {
		return this.entryController;
	}
	
	public Scanner getIn() {
		return this.in;
	}
	
	public void setMemberController(MemberController newCtrl) {
		this.memberController = newCtrl;
	}

	public void setEntryController(EntryController newCtrl) {
		this.entryController = newCtrl;
	}
	
	public void setIn(Scanner newIn) {
		this.in=newIn;
	}
	
	public void printMenu()
	{
		String menu;
		menu="Budget Admin Menu: \n";
		menu +="\t 1 - to add a new member; \n";
		menu +="\t 2 - to add a new income/cost; \n";
		menu +="\t 3 - to list the current budget list for a member; \n";
		menu +="\t 0 - exit \n";
		
		System.out.println(menu);
	}
	
	public void Run()
	{
		printMenu();

		String cmd = in.nextLine();
		
		while(!cmd.equals("0")) {
			if(cmd.equals("1")) {
				System.out.println("Enter name:");
				String name = in.nextLine();
				try {
					memberController.addMember(name);
					System.out.println("Member added successfully.");
				} catch (InvalidNameException e) {
					System.out.println(e.getMsg());
				}
			} else
			if(cmd.equals("2")) {

				System.out.println("Enter type:");
				String type = in.nextLine();
				System.out.println("Enter the value:");
				String value = in.nextLine();
				System.out.println("Enter the name of the member:");
				String name = in.nextLine();

				try {
					entryController.addEntry(type, value, name);
					System.out.println("Entry added successfully.");
				} catch (InvalidNameException e) {
					System.out.println(e.getMsg());
				} catch (InvalidBudgetException e) {
					System.out.println(e.getMsg());
				} catch (InvalidTypeException e) {
					System.out.println(e.getMsg());
				}
			} else
			if(cmd.equals("3"))
			{
				System.out.println("Enter the name of the member:");
				String name = in.nextLine();
				/*try {
					if (validateName(name)) {
						Integer id = memberController.getIdForMember(name);
						if (id == -1) {
							System.out.println("Member does not exist.");
							continue;
						} else {
							List<Entry> allEntriesForMember = entryController.allEntriesForMember(id);
							if (allEntriesForMember.size() == 0) {
								System.out.println("No entries for this member.");
							}
							for (int j = 0; j < allEntriesForMember.size(); j++)
								System.out.println(allEntriesForMember.get(j).toString());
						}
					}
				} catch (InvalidNameException nameException) {
					System.out.println("Invalid name. Must contain at least one letter!");
					continue;
				}*/
			} else {
				System.out.println("Invalid command!");
			}

			printMenu();
			cmd = in.nextLine();
		}
		memberController.writeToFile();
	}
}

