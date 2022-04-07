package com.fundamentos.springboot.fundamentos;

import com.fundamentos.springboot.fundamentos.bean.MyBean;
import com.fundamentos.springboot.fundamentos.bean.MyBeanWithDependency;
import com.fundamentos.springboot.fundamentos.bean.MyBeanWithProperties;
import com.fundamentos.springboot.fundamentos.component.ComponentDependency;
import com.fundamentos.springboot.fundamentos.entity.User;
import com.fundamentos.springboot.fundamentos.pojo.UserPojo;
import com.fundamentos.springboot.fundamentos.repository.UserRepository;
import org.apache.commons.logging.Log;

import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Sort;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class FundamentosApplication implements CommandLineRunner {

	private final Log LOGGER = LogFactory.getLog(FundamentosApplication.class);

	private ComponentDependency componentDependency;
	private MyBean myBean;
	private MyBeanWithDependency myBeanWithDependency;
	private MyBeanWithProperties myBeanWithProperties;
	private UserPojo userPojo;
	private UserRepository userRepository;

	public FundamentosApplication(@Qualifier("componentTwoImplement") ComponentDependency componentDependency, MyBean myBean, MyBeanWithDependency myBeanWithDependency, MyBeanWithProperties myBeanWithProperties, UserPojo userPojo, UserRepository userRepository) {
		this.componentDependency = componentDependency;
		this.myBean = myBean;
		this.myBeanWithDependency = myBeanWithDependency;
		this.myBeanWithProperties = myBeanWithProperties;
		this.userPojo = userPojo;
		this.userRepository = userRepository;
	}


	private void getInformationJpqlFromUser(){

		LOGGER.info("buscar por email del usuario" +
				userRepository.findByUserEmail("john@domain.com")
			);

		userRepository.findAndSort("John", Sort.by("id").descending())
				.stream()
				.forEach(user -> LOGGER.info("User : " + user));

		userRepository.findByName("John").forEach(user -> LOGGER.info("User query method " + user));

		LOGGER.info( "Usuario email name query method " + userRepository.findByEmailAndName("john2@domain.com","John3")
				);


		userRepository.findByNameLike("%Joh%").stream().forEach(user -> LOGGER.info("Like " + user));

	}


	private void saveUsersInDataBase(){
		User user1 = new User("John", "john@domain.com", LocalDate.of(2021,03,1));
		User user2 = new User("John", "john1@domain.com", LocalDate.of(2021,04,2));
		User user3 = new User("John3", "john2@domain.com", LocalDate.of(2021,05,3));
		User user4 = new User("John4", "john3@domain.com", LocalDate.of(2021,06,4));
		User user5 = new User("John5", "john4@domain.com", LocalDate.of(2021,07,5));
		User user6 = new User("John6", "john5@domain.com", LocalDate.of(2021,8,6));
		User user7 = new User("John7", "john6@domain.com", LocalDate.of(2021,9,7));
		User user8 = new User("John8", "john7@domain.com", LocalDate.of(2021,10,8));
		User user9 = new User("John9", "john8@domain.com", LocalDate.of(2021,11,9));
		User user10 = new User("John10", "john9@domain.com", LocalDate.of(2021,3,10));
		User user11= new User("John11", "john10@domain.com", LocalDate.of(2021,12,11));
		User user12 = new User("John12", "john11@domain.com", LocalDate.of(2021,3,12));

		List<User> list = Arrays.asList(user1, user2, user3,user4, user5, user6, user6, user7,user8, user9, user10, user11,user12);

		userRepository.saveAll(list);


	}


	public static void main(String[] args) {
		SpringApplication.run(FundamentosApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
			previousCourses();
			saveUsersInDataBase();
			getInformationJpqlFromUser();
	}

	private void previousCourses(){
		componentDependency.saludar();
		myBean.print();
		myBeanWithDependency.printWithDependency();
		System.out.println(myBeanWithProperties.function()	);
		System.out.println(userPojo.getEmail() + " " + userPojo.getPsw() + " " + userPojo.getAge());
		LOGGER.error("Esto es un error.");

	}
}
