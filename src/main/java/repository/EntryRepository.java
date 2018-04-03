package repository;

import model.Entry;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by oana on 3/19/2018.
 */
public class EntryRepository {
    private List<Entry> entries = new ArrayList<Entry>();

    private final String filenameBudget;

    public EntryRepository(String filename) {
        this.filenameBudget = filename;
        try{
            FileReader fileReaderEntry = null;
            BufferedReader bufferedReaderEntry = null;
            String currentLineEntry = null;

            fileReaderEntry = new FileReader(filenameBudget);
            bufferedReaderEntry = new BufferedReader(fileReaderEntry);

            while ((currentLineEntry = bufferedReaderEntry.readLine()) != null) {
                String line[] = currentLineEntry.split(";");
                int valueEntry = Integer.parseInt(line[1]);
                int idEntryMember = Integer.parseInt(line[2]);
                Entry e = new Entry(line[0],valueEntry,idEntryMember);
                this.entries.add(e);
            }
        }catch(Exception ex){
            System.err.println("Error when loading from file.");
        }
    }

    public void writeToFile() {
        try{
            FileWriter fileWriter = null;
            BufferedWriter bufferedWriter = null;

            fileWriter = new FileWriter(filenameBudget);
            bufferedWriter = new BufferedWriter(fileWriter);
            for (Entry entry : entries) {
                bufferedWriter.write(entry.getType() + ";" + entry.getValue() + ";" + entry.getIdMember() + "\n");
            }
            bufferedWriter.close();
        }catch(Exception ex){
            System.err.println("Error when writing to file.");
        }
    }

    public void addEntry(Entry e){
        entries.add(e);
        try{
            FileWriter fileWriter = null;
            BufferedWriter bufferedWriter = null;

            fileWriter = new FileWriter(filenameBudget, true);
            bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(e.getType() + ";" + e.getValue() + ";" + e.getIdMember() + "\n");
            bufferedWriter.close();
        }catch(Exception ex){
            System.err.println("Error when writing to file.");
        }
    }

    public List<Entry> getAllEntries(){
        return entries;
    }

    public List<Entry> getAllEntriesForMember(Integer id){
        return entries.stream().filter(e -> (e.getIdMember() == id)).collect(Collectors.toList());
    }
}
