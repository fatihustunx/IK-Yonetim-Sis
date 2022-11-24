package Kodlama.io.Kodlama.io.Devs.business.conceretes;

import java.util.List;

import org.springframework.stereotype.Service;

import Kodlama.io.Kodlama.io.Devs.business.abstracts.ProgrammingLanguageCheckService;
import Kodlama.io.Kodlama.io.Devs.entities.ProgrammingLanguage;

@Service
public class ProgrammingLanguageCheckManager implements ProgrammingLanguageCheckService {

	@Override
	public boolean checkProgrammingLanguage(ProgrammingLanguage programmingLanguage,
			List<ProgrammingLanguage> programmingLanguages) {

		if (programmingLanguage == null) {
			return false;
		}

		int counter = 0;
		char[] array = programmingLanguage.getName().toCharArray();
		for (int i = 0; i < array.length; i++) {
			if (array[i] == ' ') {
				counter++;
			}
		}
		if (counter == array.length) {
			return false;
		}

		for (ProgrammingLanguage programmingLanguage2 : programmingLanguages) {
			if (programmingLanguage.getId() == programmingLanguage2.getId()
					|| programmingLanguage.getName() == programmingLanguage2.getName()) {
				return false;
			}
		}

		return true;
	}

}
