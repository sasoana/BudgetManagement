package controller;

import repository.MemberRepository;

import model.Member;
import model.Entry;



import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class MemberController {
	
    private MemberRepository mr;
    
    public MemberController(MemberRepository memberRepository){
        this.mr = memberRepository;
    }
    
    public void addMember(Member member) {
        mr.addMember(member);
    }

    public Integer getIdForMember(String name) {
        return mr.getIdForMember(name);
    }
} 