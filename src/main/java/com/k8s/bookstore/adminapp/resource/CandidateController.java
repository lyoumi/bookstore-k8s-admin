package com.k8s.bookstore.adminapp.resource;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.NO_CONTENT;
import static org.springframework.http.HttpStatus.OK;

import com.k8s.bookstore.adminapp.data.Candidate;
import com.k8s.bookstore.adminapp.service.CandidateService;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("candidate")
@AllArgsConstructor
public class CandidateController {

    private final CandidateService candidateService;

    @GetMapping
    @ResponseStatus(OK)
    public List<Candidate> getAllCandidates() {
        return candidateService.getAllCandidates();
    }

    @PostMapping
    @ResponseStatus(CREATED)
    public Candidate createCandidate(@RequestBody Candidate candidate) {
        return candidateService.createCandidate(candidate);
    }

    @GetMapping(path = "{id}")
    @ResponseStatus(OK)
    public Candidate getCandidate(@PathVariable("id") String id) {
        return candidateService.getCandidateById(id);
    }

    @DeleteMapping(path = "{id}")
    @ResponseStatus(NO_CONTENT)
    public void deleteCandidateById(@PathVariable("id") String id) {
        candidateService.deleteCandidate(id);
    }
}
