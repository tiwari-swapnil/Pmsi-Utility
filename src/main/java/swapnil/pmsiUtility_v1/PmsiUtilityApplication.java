package swapnil.pmsiUtility_v1;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import swapnil.pmsiUtility_v1.enums.GuestLanguages;
import swapnil.pmsiUtility_v1.enums.PmsOperations;
import swapnil.pmsiUtility_v1.socket.PmsSocket;

@Slf4j
@SpringBootApplication
public class PmsiUtilityApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(PmsiUtilityApplication.class, args);
		PmsSocket pmsSocket = context.getBean(PmsSocket.class);
		log.info("PMSSocket :: Application context initialized successfully");
	}

}
