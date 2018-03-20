package repository;

import java.io.BufferedReader;

import model.*;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import exceptions.InvalidBudgetException;
import exceptions.InvalidNameException;
import exceptions.InvalidTypeException;

public class MemberRepository {
	private List<Member> members = new ArrayList<Member>();

	private static Integer nextId;
	private final static String filenameMember = "membersF.txt";

	@SuppressWarnings("resource")
	public MemberRepository() {
		nextId = 0;
		try{
			FileReader fileReader = null;
			BufferedReader bufferedReader = null;
			String currentLine = null;

			fileReader = new FileReader(filenameMember);
			bufferedReader = new BufferedReader(fileReader);

			while ((currentLine = bufferedReader.readLine()) != null) {
				String line[] = currentLine.split(";");
				Member m = new Member(line[0], Integer.parseInt(line[1]));
				nextId = Integer.parseInt(line[1]);
				this.members.add(m);
			}
			nextId++;
		}catch(Exception ex){
			System.err.println("Error when loading from file.");
		}
	}

	 public void addMember(Member m){
		m.setId(nextId);
		nextId++;
		members.add(m);
	 	try{
	 		FileWriter fileWriter = null;
	 		BufferedWriter bufferedWriter = null;

	 		fileWriter = new FileWriter(filenameMember);
	 		bufferedWriter = new BufferedWriter(fileWriter);
	 		for (Member member :  members) {
				bufferedWriter.write(member.getName() + ";" + member.getId() + "\n");
			}
			bufferedWriter.close();
	 	}catch(Exception ex){
	 		System.err.println("Error when writing to file.");
	 	}
	 }

	 public Integer getIdForMember(String name) {
	 	for (Member member : members) {
	 		if (member.getName().equals(name))
	 			return member.getId();
		}

		return -1;
	 }

}
