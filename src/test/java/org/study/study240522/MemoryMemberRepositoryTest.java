package org.study.study240522;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.study.study240522.domain.Member;
import org.study.study240522.repository.MemoryMemberRepository;

import java.util.List;

public class MemoryMemberRepositoryTest {

    MemoryMemberRepository repository = new MemoryMemberRepository();

    @AfterEach //하나 테스트 실행할때마다 작동함
    public void afterEach()
    {
        repository.clearStore();
    }

    @Test
    public void save() {
        Member member = new Member();
        member.setName("heejune");

        repository.save(member);
        Member result = repository.findById(member.getId()).get();
        /*System.out.println(result);*/ //일일히 문자쳐볼수 없어 Assert기능 활용하기

        Assertions.assertEquals(member,result);
    }

    @Test
    public void findByName()
    {
        Member member1 = new Member();
        member1.setName("HJ1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("HJ2");
        repository.save(member2);

        Member result = repository.findByName("HJ1").get();

        Assertions.assertEquals(member1,result);
    }

    @Test
    public void findAll()
    {
        Member member1 = new Member();
        member1.setName("HJ1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("HJ2");
        repository.save(member2);

        List<Member> result = repository.findAll();

        Assertions.assertEquals(2,result.size());
    }
}
