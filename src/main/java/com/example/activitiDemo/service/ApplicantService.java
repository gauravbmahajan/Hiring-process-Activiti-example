package com.example.activitiDemo.service;

import com.example.activitiDemo.model.Applicant;

import java.util.List;

/**
 * Created by Gaurav Mahajan on 25-03-2017.
 */
public interface ApplicantService {
    Applicant save(Applicant applicant);
    Applicant getById(long id);
    List<Applicant> getAll();
    void completeTask(long ApplicantId,boolean flag);

}
