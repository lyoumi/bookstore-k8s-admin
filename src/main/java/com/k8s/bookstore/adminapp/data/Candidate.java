package com.k8s.bookstore.adminapp.data;

import com.fasterxml.jackson.annotation.JsonBackReference;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

@Data
@Entity
public class Candidate {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;
    @Column(name = "name")
    private String name;
    @Column(name = "email")
    private String email;
    @Column(name = "age")
    private Integer age;
    @OneToMany(mappedBy = "candidate", cascade = CascadeType.ALL)
    @LazyCollection(LazyCollectionOption.FALSE)
    @JsonBackReference
    private List<Skill> skills = new ArrayList<>();
    @OneToOne(cascade = CascadeType.ALL)
    @LazyCollection(LazyCollectionOption.FALSE)
    @JoinColumn(name = "address_id", referencedColumnName = "id")
    private Address address;

    public void addSkill(Skill skill) {
        this.skills.add(skill);
        skill.setCandidate(this);
    }
}
