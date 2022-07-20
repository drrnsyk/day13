package sg.edu.nuss.iss.d13workshop;

import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import sg.edu.nuss.iss.d13workshop.services.DatabaseService;

@SpringBootApplication
public class D13workshopApplication implements ApplicationRunner {

	@Autowired // helps to automatically instantiate classes
	DatabaseService db5vc;

	public static void main(String[] args) {
		SpringApplication.run(D13workshopApplication.class, args);
		// method 1 is to follow day11 to process arguments here

	}

	// method 2 is to use application runner to handle arguments
	@Override
	public void run(ApplicationArguments args) {

		if (args.containsOption("dataDir")) {
			final String dataDir = args.getOptionValues("dataDir").get(0);
			db5vc.setDataDir((new File(dataDir)));

			if (!db5vc.isDataDirValid()) {
				System.err.printf("%s does not exist, is not a directory or not writable.", dataDir);
				//System.exit(-1);
			}

			System.out.printf("Using %s as data directory\n", dataDir);
		}
		else
		{
			db5vc.setDataDir((new File("./data")));
		}

	}

}
