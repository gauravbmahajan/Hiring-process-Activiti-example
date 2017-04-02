package com.example.activitiDemo.repositoy;

import com.example.activitiDemo.model.Applicant;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Locale;

/**
 * Created by Gaurav Mahajan on 25-03-2017.
 */
public interface ApplicantRepository extends JpaRepository<Applicant,Long> {
}
