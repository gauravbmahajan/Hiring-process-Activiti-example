package com.example.activitiDemo.controller;

import com.example.activitiDemo.model.Applicant;
import com.example.activitiDemo.service.ApplicantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Gaurav Mahajan on 25-03-2017.
 */

@RestController
@RequestMapping(value = "/api")
public class ApplicantController {

    @Autowired
    private ApplicantService applicantService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List<Applicant> getAllApplicant(){
        return applicantService.getAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Applicant getApplicantById(@PathVariable long id){
        return applicantService.getById(id);
    }

    @RequestMapping(value = "/", method = RequestMethod.POST )
    public Applicant saveApplicant(@RequestBody Applicant applicant){
        return applicantService.save(applicant);
    }

    @RequestMapping(value = "/claimTask/{id}", method = RequestMethod.GET)
    public void telephoneInterviewOutcome(@PathVariable long id){
        boolean flag = true;
        applicantService.completeTask(id,flag);
    }

}
