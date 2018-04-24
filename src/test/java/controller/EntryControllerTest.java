package controller;

import exceptions.InvalidBudgetException;
import exceptions.InvalidNameException;
import exceptions.InvalidTypeException;
import model.Entry;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import repository.EntryRepository;
import repository.MemberRepository;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by oana on 4/3/2018.
 */
public class EntryControllerTest {

    private EntryController entryController;

    @Before
    public void setRepo() {
        MemberRepository memberRepository = new MemberRepository("src/test/java/initMembers.txt");
        EntryRepository entryRepository = new EntryRepository("src/test/java/initEntries.txt");
        this.entryController = new EntryController(entryRepository, memberRepository);
    }

    @Test
    public void addEntryTC1() throws Exception {
        String type = "a", value = "1", name = "Diana";
        try {
            entryController.addEntry(type, value, name);
        } catch (InvalidTypeException e) {
            Assert.assertEquals("Not a valid entry type.", e.getMsg());
        }
        Assert.assertEquals(1, entryController.getEntries().size());

    }

    @Test
    public void addEntryTC2() throws Exception{
        String type = "income", value = "u", name = "Diana";
        try {
            entryController.addEntry(type, value, name);
        } catch (InvalidBudgetException e) {
            Assert.assertEquals("Value must be integer.", e.getMsg());
        }
        Assert.assertEquals(1, entryController.getEntries().size());
    }

    @Test
    public void addEntryTC3() throws Exception{
        String type = "cost", value = "-1", name = "Diana";
        try {
            entryController.addEntry(type, value, name);
        } catch (InvalidBudgetException e) {
            Assert.assertEquals("Value must be positive.", e.getMsg());
        }
        Assert.assertEquals(1, entryController.getEntries().size());
    }

    @Test
    public void addEntryTC4() throws Exception{
        String type = "cost", value = "1", name = "Oana";
        try {
            entryController.addEntry(type, value, name);
        } catch (InvalidNameException e) {
            Assert.assertEquals("Member does not exist.", e.getMsg());
        }
        Assert.assertEquals(1, entryController.getEntries().size());
    }

    @Test
    public void addEntryTC5() throws Exception{
        String type = "income", value = "1", name = "Diana";
        entryController.addEntry(type, value, name);
        Assert.assertEquals(2, entryController.getEntries().size());
    }

    @Test
    public void addEntryTC6() throws Exception{
        String type = "income", value = "1", name = "Diana";
        MemberRepository memberRepository = new MemberRepository("src/test/java/noMembers.txt");
        EntryRepository entryRepository = new EntryRepository("src/test/java/initEntries.txt");
        this.entryController = new EntryController(entryRepository, memberRepository);
        try {
            entryController.addEntry(type, value, name);
        } catch (InvalidNameException e) {
            Assert.assertEquals("Members list is empty.", e.getMsg());
        }
        Assert.assertEquals(1, entryController.getEntries().size());
    }

    @Test
    public void addEntryTC7() throws Exception{
        String type = "income", value = "1", name = "Diana";
        MemberRepository memberRepository = new MemberRepository("src/test/java/2Members.txt");
        EntryRepository entryRepository = new EntryRepository("src/test/java/initEntries.txt");
        this.entryController = new EntryController(entryRepository, memberRepository);
        entryController.addEntry(type, value, name);
        Assert.assertEquals(2, entryController.getEntries().size());
    }

    @After
    public void resetEntryFile() {
        entryController.setEntries(new ArrayList<Entry>(Arrays.asList(new Entry("income", 1, 1))));
    }

}
