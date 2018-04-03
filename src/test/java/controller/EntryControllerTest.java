package controller;

import exceptions.InvalidBudgetException;
import exceptions.InvalidNameException;
import exceptions.InvalidTypeException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import repository.EntryRepository;
import repository.MemberRepository;

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
            Assert.assertEquals("Value must be integer and positive.", e.getMsg());
        }
        Assert.assertEquals(1, entryController.getEntries().size());
    }
}
