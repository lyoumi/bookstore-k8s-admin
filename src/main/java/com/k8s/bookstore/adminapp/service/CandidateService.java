package com.k8s.bookstore.adminapp.service;

import com.k8s.bookstore.adminapp.data.Candidate;
import java.util.List;

public interface CandidateService {

    List<Candidate> getAllCandidates();

    Candidate createCandidate(Candidate candidate);

    Candidate getCandidateById(String id);

    void deleteCandidate(String id);
}
