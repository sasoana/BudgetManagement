package controller;

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
    public void addEntryTC1() {

    }

    @Test
    public void addEntryTC2() {

    }
}
