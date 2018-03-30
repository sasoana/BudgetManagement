package controller;

import model.Entry;
import repository.EntryRepository;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by oana on 3/19/2018.
 */
public class EntryController {

    private EntryRepository entryRepository;

    public EntryController(EntryRepository entryRepository){
        this.entryRepository = entryRepository;
    }

    public void addEntry(Entry oneEntry) {
        entryRepository.addEntry(oneEntry);
    }

    public List<Entry> allEntriesForMember(Integer id) {
        List<Entry> allEntries = new ArrayList<>();
        allEntries = this.entryRepository.getAllEntriesForMember(id);
        return allEntries;
    }
}
