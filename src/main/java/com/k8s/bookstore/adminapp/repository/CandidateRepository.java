package com.k8s.bookstore.adminapp.repository;

import com.k8s.bookstore.adminapp.data.Candidate;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CandidateRepository extends JpaRepository<Candidate, String> {

}
