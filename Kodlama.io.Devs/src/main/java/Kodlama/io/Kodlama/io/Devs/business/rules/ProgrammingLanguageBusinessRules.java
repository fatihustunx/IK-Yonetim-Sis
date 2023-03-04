package Kodlama.io.Kodlama.io.Devs.business.rules;

import org.springframework.stereotype.Service;

import Kodlama.io.Kodlama.io.Devs.dataAccess.abstracts.ProgrammingLanguageRepository;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class ProgrammingLanguageBusinessRules {

	private ProgrammingLanguageRepository programmingLanguageRepository;

	public void checkIfProgrammingLanguageNameExists(String name) {
		if (this.programmingLanguageRepository.existsByName(name)) {
			throw new RuntimeException("Programming language name already exists !");
		}
	}
}
