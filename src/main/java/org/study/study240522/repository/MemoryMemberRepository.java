package org.study.study240522.repository;

import org.study.study240522.domain.Member;

import java.util.*;

public class MemoryMemberRepository implements MemberRepository {

    private static Map<Long, Member> store = new HashMap<>();
    private static long sequence = 0L;
    @Override
    public Member save(Member member) {
        //생성할때 순차적으로 부여하기 위해
        member.setId(++sequence);
        store.put(member.getId(), member);
        return member;
    }

    @Override
    public Optional<Member> findById(Long id) {

        return Optional.ofNullable(store.get(id));
    }

    @Override
    public Optional<Member> findByName(String name) {
        return store.values().stream()
                .filter(member -> member.getName().equals(name)).findAny(); //findAny를 통해 찾는값이 하나라도 있으면 반환
    }

    @Override
    public List<Member> findAll() {
        return new ArrayList<>(store.values()); //<-Map의 values()는 모든 요소의 '값'만 묶어 반환함
    }

    public void clearStore()
    {
        store.clear();
    }
}
