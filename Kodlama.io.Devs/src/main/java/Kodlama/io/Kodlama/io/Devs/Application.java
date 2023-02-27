package Kodlama.io.Kodlama.io.Devs;

import org.modelmapper.ModelMapper;

//import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

/*
import Kodlama.io.Kodlama.io.Devs.business.abstracts.ProgrammingLanguageService;
import Kodlama.io.Kodlama.io.Devs.business.conceretes.ProgrammingLanguageCheckManager;
import Kodlama.io.Kodlama.io.Devs.business.conceretes.ProgrammingLanguageManager;
import Kodlama.io.Kodlama.io.Devs.dataAccess.conceretes.InMemoryProgrammingLanguageRepository;
import Kodlama.io.Kodlama.io.Devs.entities.ProgrammingLanguage;
*/
@SpringBootApplication
public class Application {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(Application.class, args);

		/*
		 * ProgrammingLanguageService programmingLanguageService = new
		 * ProgrammingLanguageManager( new InMemoryProgrammingLanguageRepository(), new
		 * ProgrammingLanguageCheckManager());
		 * 
		 * ProgrammingLanguage pL = new ProgrammingLanguage(0, "C"); //
		 * ProgrammingLanguage pL2= new ProgrammingLanguage(1, "C#"); //
		 * ProgrammingLanguage pL3= new ProgrammingLanguage(2, "C++"); //
		 * ProgrammingLanguage pL4= new ProgrammingLanguage(3,"Java");
		 * 
		 * programmingLanguageService.add(pL); // programmingLanguageService.add(pL2);
		 * // programmingLanguageService.add(pL3); //
		 * programmingLanguageService.add(pL4);
		 * 
		 * List<ProgrammingLanguage> temp = programmingLanguageService.getAll(); for
		 * (ProgrammingLanguage pl : temp) { System.out.println(pl.getName()); }
		 * 
		 * programmingLanguageService.update(pL, new ProgrammingLanguage(0, "Ruby"));
		 * System.out.println("-------------------------------------------");
		 * 
		 * temp = programmingLanguageService.getAll(); for (ProgrammingLanguage pl :
		 * temp) { System.out.println(pl.getName()); }
		 * 
		 * programmingLanguageService.delete(programmingLanguageService.getWithId(0));
		 * System.out.println("----------------------------------------------- ");
		 * 
		 * temp = programmingLanguageService.getAll(); for (ProgrammingLanguage pl :
		 * temp) { System.out.println(pl.getName()); }
		 */
	}

	@Bean
	public ModelMapper getModelMapper() {

		return new ModelMapper();
	}

}
