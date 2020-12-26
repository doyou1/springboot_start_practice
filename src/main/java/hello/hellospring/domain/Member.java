package hello.hellospring.domain;

import javax.persistence.*;

// JPA가 관리하는 Entity를 의미하는 어노테이션
@Entity
public class Member {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

//  Column명이 다를시 @Column을 통해 맵핑
//    @Column(name="username")
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
