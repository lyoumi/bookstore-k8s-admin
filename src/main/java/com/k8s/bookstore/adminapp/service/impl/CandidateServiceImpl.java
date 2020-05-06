package com.k8s.bookstore.adminapp.service.impl;

import com.k8s.bookstore.adminapp.data.Candidate;
import com.k8s.bookstore.adminapp.repository.CandidateRepository;
import com.k8s.bookstore.adminapp.service.CandidateService;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CandidateServiceImpl implements CandidateService {

    private final CandidateRepository candidateRepository;

    @Override
    public List<Candidate> getAllCandidates() {
        return candidateRepository.findAll();
    }

    @Override
    public Candidate createCandidate(Candidate candidate) {
        return candidateRepository.saveAndFlush(candidate);
    }

    @Override
    public Candidate getCandidateById(String id) {
        return candidateRepository.getOne(id);
    }

    @Override
    public void deleteCandidate(String id) {
        candidateRepository.deleteById(id);
    }
}
