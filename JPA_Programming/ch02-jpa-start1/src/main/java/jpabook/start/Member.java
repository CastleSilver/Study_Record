package jpabook.start;

import javax.persistence.*;

@Entity // 이 클래스를 테이블과 매핑한다고 JPA에게 알려준다.
@Table(name = "MEMBER") // 엔티티 클래스에 매핑할 테이블 정보를 알려준다.
public class Member {

    @Id // 해당 필드를 테이블의 기본 키에 매핑한다.
    @Column(name = "ID") // 필드를 컬럼에 매핑한다.
    private String id; // 아이디
    @Column(name = "NAME")
    private String username; // 이름

    // 매핑 정보가 없는 필드
    private Integer age; //나이

    // Getter, Setter
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
