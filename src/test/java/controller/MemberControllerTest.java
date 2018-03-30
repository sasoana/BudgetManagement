package controller;

import exceptions.InvalidNameException;
import model.Member;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import repository.MemberRepository;

import java.util.ArrayList;

/**
 * Created by oana on 3/31/2018.
 */
public class MemberControllerTest {

    private MemberController memberController;

    @Before
    public void setRepo() {
        MemberRepository memberRepository = new MemberRepository("src/test/java/initMembers.txt");
        this.memberController = new MemberController(memberRepository);
    }

    @Test
    public void testAddMemberValidName() throws Exception {
        memberController.setMembers(new ArrayList<Member>());
        String name = "Diana";
        Assert.assertTrue(memberController.addMember(name));
        Assert.assertEquals(1, memberController.getMembers().size());
    }

    @Test
    public void testAddMemberNotLetterName() throws Exception {
        memberController.setMembers(new ArrayList<Member>());
        String name = "Diana1";
        try {
            memberController.addMember(name);
        } catch (InvalidNameException e) {
            Assert.assertEquals("Name contains other characters.", e.getMsg());
        }
        Assert.assertEquals(0, memberController.getMembers().size());
    }
}
