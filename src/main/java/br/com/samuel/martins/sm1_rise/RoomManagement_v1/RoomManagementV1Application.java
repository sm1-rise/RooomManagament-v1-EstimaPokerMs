package br.com.samuel.martins.sm1_rise.RoomManagement_v1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class RoomManagementV1Application {

	public static void main(String[] args) {
		SpringApplication.run(RoomManagementV1Application.class, args);
	}

}

@RestController
class ControllerHello{

	@GetMapping("/hello")
	public String sayHello(){
		return "Hello World";
	}
}
