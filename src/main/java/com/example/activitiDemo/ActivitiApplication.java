package com.example.activitiDemo;

import org.activiti.engine.IdentityService;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.identity.Group;
import org.activiti.engine.identity.User;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
@EnableSwagger2
public class ActivitiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ActivitiApplication.class, args);
	}

//	@Bean
//	CommandLineRunner init(final RepositoryService repositoryService, final RuntimeService runtimeService, final TaskService taskService){
//		return new CommandLineRunner() {
//			@Override
//			public void run(String... strings) throws Exception {
//				Map<String,Object> variables = new HashMap<>();
//				variables.put("applicantName","Bhau Kadam");
//				variables.put("email","gauravbmahajan@gmail.com");
//				variables.put("phoneNumber","9604192819");
//				runtimeService.startProcessInstanceByKey("hireProcess",variables);
//			}
//		};
//	}

//	@Bean
//	InitializingBean UsersAndGroupsInitializer(final IdentityService identityService){
//		return new InitializingBean() {
//			@Override
//			public void afterPropertiesSet() throws Exception {
//				Group group = identityService.newGroup("user");
//				group.setName("Users");
//				group.setType("security-role");
//				identityService.saveGroup(group);
//
//				User admin = identityService.newUser("admin");
//				admin.setPassword("password");
//				identityService.saveUser(admin);
//			}
//		};
//	}
}


