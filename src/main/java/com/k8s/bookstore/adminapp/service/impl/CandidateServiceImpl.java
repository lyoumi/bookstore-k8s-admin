package com.k8s.bookstore.adminapp.service.impl;

import com.k8s.bookstore.adminapp.data.Candidate;
import com.k8s.bookstore.adminapp.data.Skill;
import com.k8s.bookstore.adminapp.repository.CandidateRepository;
import com.k8s.bookstore.adminapp.service.CandidateService;
import com.k8s.bookstore.adminapp.service.CountryUtil;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
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
        final List<Skill> skills = candidate.getSkills();
        candidate.setSkills(new ArrayList<>());
        for (Skill skill : skills) {
            candidate.addSkill(skill);
        }

        Optional.ofNullable(candidate.getAddress())
            .ifPresent(address ->
                address.setCountry(CountryUtil.getCountryByCode(address.getCountry()))
            );

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
