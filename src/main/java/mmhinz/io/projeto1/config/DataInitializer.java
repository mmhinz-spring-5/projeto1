package mmhinz.io.projeto1.config;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import mmhinz.io.projeto1.entity.User;
import mmhinz.io.projeto1.repository.UserRepository;

@Component
public class DataInitializer implements ApplicationListener<ContextRefreshedEvent> {
	
	@Autowired 
	UserRepository userRepository;

	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		// TODO Auto-generated method stub
		System.out.println("Entrou aqui");
		
		List <User> users = userRepository.findAll();
		
		if (users.isEmpty()) {
			createUser("Mauro", "mmhinz@gmail.com");
			createUser("Joao", "joao@gmail.com");
			createUser("Carlos", "carlos@gmail.com");
		}
		
		User user = userRepository.findByName("Carlos");
		System.out.println(user.getName());
		
		User user_2 = userRepository.findByEmailQualquerCoisa("joao@gmail.com");
		System.out.println(user_2.getEmail());
		
	}
	
	public void createUser (String nome, String email) {
		User user = new User(nome, email);
		userRepository.save(user);
	}

}
