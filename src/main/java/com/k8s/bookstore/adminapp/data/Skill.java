package com.k8s.bookstore.adminapp.data;

import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import lombok.Data;

@Data
@Entity
public class Skill {

    @Id
    @GeneratedValue
    private UUID id;
    @Column(name = "name")
    private String name;
    @Column(name = "level")
    private String level;
    @ManyToOne
    @JoinColumn(name = "candidate_id", referencedColumnName = "id")
    private Candidate candidate;
}
