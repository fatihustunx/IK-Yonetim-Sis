package Kodlama.io.Kodlama.io.Devs.business.abstracts;

import java.util.List;

import Kodlama.io.Kodlama.io.Devs.entities.ProgrammingLanguage;

public interface ProgrammingLanguageCheckService {

	boolean checkProgrammingLanguage(ProgrammingLanguage programmingLanguage,
			List<ProgrammingLanguage> programmingLanguages);
}
