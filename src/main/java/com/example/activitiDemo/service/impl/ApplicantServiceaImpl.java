package com.example.activitiDemo.service.impl;

import com.example.activitiDemo.model.Applicant;
import com.example.activitiDemo.repositoy.ApplicantRepository;
import com.example.activitiDemo.service.ApplicantService;
import org.activiti.engine.ProcessEngineConfiguration;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.impl.cmd.SetProcessDefinitionVersionCmd;
import org.activiti.engine.impl.interceptor.CommandExecutor;
import org.activiti.engine.task.Task;
import org.activiti.spring.SpringProcessEngineConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * Created by Gaurav Mahajan on 25-03-2017.
 */
@Component
public class ApplicantServiceaImpl implements ApplicantService {

    @Autowired
    private ApplicantRepository applicantRepository;

    @Autowired
    private RuntimeService runtimeService;

    @Autowired
    private RepositoryService repositoryService;

    @Autowired
    TaskService taskService;

    @Autowired
    ProcessEngineConfiguration processEngineConfiguration;

    @Override
    public Applicant save(Applicant applicant) {
        Applicant applicant1 = applicantRepository.save(applicant);
        Map<String,Object> variables = new HashMap<>();
        variables.put("applicant",applicant1);
        variables.put("id", applicant1.getId());
        variables.put("name",applicant1.getName());
        runtimeService.startProcessInstanceByKey("hireProcess",variables);
        return applicant1;
    }

    @Override
    public Applicant getById(long id) {
        return applicantRepository.findOne(id);
    }

    @Override
    public List<Applicant> getAll() {
        return applicantRepository.findAll();
    }

    @Override
    public void completeTask(long applicantId, boolean flag) {
        Map<String,Object> parameters = new HashMap<>();
        parameters.put("telephoneInterviewOutcome",flag);
        int processDefVersion = repositoryService.createProcessDefinitionQuery().latestVersion().processDefinitionKey("hireProcess").singleResult().getVersion();
        Task task = taskService.createTaskQuery()
                .processVariableValueEquals("id", applicantId).singleResult();
        int processInstanceVersion = runtimeService.createProcessInstanceQuery().processInstanceId(task.getProcessInstanceId()).singleResult().getProcessDefinitionVersion();
        if(processInstanceVersion!=processDefVersion) {
            CommandExecutor commandExecutor = ((SpringProcessEngineConfiguration) processEngineConfiguration)
                    .getCommandExecutor();
            commandExecutor.execute(new SetProcessDefinitionVersionCmd(task.getProcessInstanceId(), processDefVersion));
        }
        taskService.claim(task.getId(),"");
        taskService.complete(task.getId(),parameters);
    }
}
