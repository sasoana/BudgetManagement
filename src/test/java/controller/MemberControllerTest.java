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

    @Test
    public void testAddMemberTC3() throws Exception {
        memberController.setMembers(new ArrayList<Member>());
        String name = "DianaDianaDianaDianaD";
        try {
            memberController.addMember(name);
        } catch (InvalidNameException e) {
            Assert.assertEquals("Name should have maximum 20 letters.", e.getMsg());
        }
        Assert.assertEquals(0, memberController.getMembers().size());
    }

    @Test
    public void testAddMemberTC4() throws Exception {
        memberController.setMembers(new ArrayList<Member>());
        String name = "Di";
        try {
            memberController.addMember(name);
        } catch (InvalidNameException e) {
            Assert.assertEquals("Name should have minimum 3 letters.", e.getMsg());
        }
        Assert.assertEquals(0, memberController.getMembers().size());
    }

    @Test
    public void testAddMemberTC5() throws Exception {
        //memberController.setMembers(new ArrayList<Member>());
        String name = "Diana";
        try {
            memberController.addMember(name);
        } catch (InvalidNameException e) {
            Assert.assertEquals("Name already exists. Give a unique name.", e.getMsg());
        }
        Assert.assertEquals(1, memberController.getMembers().size());
    }

    @Test
    public void testAddTC6() throws Exception {
        //memberController.setMembers(new ArrayList<Member>());
        String name = "Maria";
        Assert.assertTrue(memberController.addMember(name));
        Assert.assertEquals(2, memberController.getMembers().size());
    }

    @Test
    public void testAddMemberTC7() throws Exception {
        memberController.setMembers(new ArrayList<Member>());
        String name = "1234";
        try {
            memberController.addMember(name);
        } catch (InvalidNameException e) {
            Assert.assertEquals("Name contains other characters.", e.getMsg());
        }
        Assert.assertEquals(0, memberController.getMembers().size());
    }

    @Test
    public void testAddTC8() throws Exception {
        memberController.setMembers(new ArrayList<Member>());
        String name = "Dia";
        Assert.assertTrue(memberController.addMember(name));
        Assert.assertEquals(1, memberController.getMembers().size());
    }

    @Test
    public void testAddTC9() throws Exception {
        memberController.setMembers(new ArrayList<Member>());
        String name = "Dian";
        Assert.assertTrue(memberController.addMember(name));
        Assert.assertEquals(1, memberController.getMembers().size());
    }

    @Test
    public void testAddTC10() throws Exception {
        memberController.setMembers(new ArrayList<Member>());
        String name = "DianaDianaDianaDiana";
        Assert.assertTrue(memberController.addMember(name));
        Assert.assertEquals(1, memberController.getMembers().size());
    }

    @Test
    public void testAddTC11() throws Exception {
        memberController.setMembers(new ArrayList<Member>());
        String name = "DianaDianaDianaDian";
        Assert.assertTrue(memberController.addMember(name));
        Assert.assertEquals(1, memberController.getMembers().size());
    }
}
