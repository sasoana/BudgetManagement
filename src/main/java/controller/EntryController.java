package controller;

import exceptions.InvalidBudgetException;
import exceptions.InvalidNameException;
import exceptions.InvalidTypeException;
import model.Entry;
import model.Member;
import repository.EntryRepository;
import repository.MemberRepository;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by oana on 3/19/2018.
 */
public class EntryController {

    private EntryRepository entryRepository;
    private MemberRepository memberRepository;

    public EntryController(EntryRepository entryRepository, MemberRepository memberRepository){
        this.entryRepository = entryRepository;
        this.memberRepository = memberRepository;
    }

    public void addEntry(String type, String value, String name) throws InvalidBudgetException, InvalidNameException, InvalidTypeException {

        if (validateEntry(type, value, name)) {
            entryRepository.addEntry(new Entry(type, Integer.parseInt(value), memberRepository.getIdForMember(name)));
        }
    }

    private boolean validateEntry(String type, String value, String name) throws InvalidTypeException, InvalidBudgetException, InvalidNameException {
        if (!type.equals("income") && !type.equals("cost")) {
            throw new InvalidTypeException("Not a valid entry type.");
        }
        if (memberRepository.getIdForMember(name) == -1) {
            throw new InvalidNameException("Member does not exist.");
        }
        try {
            Integer valueInt = Integer.parseInt(value);
            if (valueInt < 0 ) throw new InvalidBudgetException("Value must be integer and positive.");
        } catch (Exception e) {
            throw new InvalidBudgetException("Value must be integer and positive.");
        }
        return true;
    }

    public List<Entry> allEntriesForMember(Integer id) {
        List<Entry> allEntries = new ArrayList<>();
        allEntries = this.entryRepository.getAllEntriesForMember(id);
        return allEntries;
    }
}
