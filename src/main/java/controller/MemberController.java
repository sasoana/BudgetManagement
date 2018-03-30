package controller;

import exceptions.InvalidNameException;
import repository.MemberRepository;

import model.Member;

import java.util.List;

public class MemberController {
	
    private MemberRepository mr;
    
    public MemberController(MemberRepository memberRepository){
        this.mr = memberRepository;
    }

    private boolean validateName(String name) throws InvalidNameException {
        if (!name.chars().allMatch(Character::isLetter)) {
            throw new InvalidNameException("Name contains other characters.");
        }
        if (getIdForMember(name) != -1) {
            throw new InvalidNameException("Name already exists. Give a unique name.");
        }
        if (name.length() > 20) {
            throw new InvalidNameException("Name should have maximum 20 letters.");
        }
        return true;
    }

    public boolean addMember(String member) throws InvalidNameException {

        if (validateName(member)) {
            mr.addMember(new Member(member));
            mr.writeToFile();
            return true;
        }
        return false;
    }

    public Integer getIdForMember(String name) {
        return mr.getIdForMember(name);
    }

    public List<Member> getMembers() {
        return mr.getMembers();
    }
}