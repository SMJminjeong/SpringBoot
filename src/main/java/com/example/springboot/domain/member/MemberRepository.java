package com.example.springboot.domain.member;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Member 저장소
 */
public class MemberRepository {

    private Map<Long, Member> store = new HashMap<>();
    private long sequence = 0L;

    //싱글통
    private static final MemberRepository instance = new MemberRepository();

    public static MemberRepository getInstance() {
        return instance;
    }
    public MemberRepository() {
    }

    public Member save(Member member){
        member.setId(++sequence);
        store.put(member.getId(),  member);
        return member;
    }

    public Member findById(Long id){
        return store.get(id);
    }

    public List<Member> findAll(){
        return new ArrayList<>(store.values()); //store 를 보호하기 위해
    }

    public void clearStore(){
        store.clear();
    }
}
