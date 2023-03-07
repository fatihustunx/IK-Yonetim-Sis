package Kodlama.io.Kodlama.io.Devs.business.rules;

import org.springframework.stereotype.Service;

import Kodlama.io.Kodlama.io.Devs.core.utilities.exceptions.BusinessException;
import Kodlama.io.Kodlama.io.Devs.dataAccess.abstracts.ProgrammingLanguageRepository;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class ProgrammingLanguageBusinessRules {

	private ProgrammingLanguageRepository programmingLanguageRepository;

	public void checkIfProgrammingLanguagesListExists() {
		if (this.programmingLanguageRepository.findAll().isEmpty()) {
			throw new BusinessException("Programming languages list is null !");
		}
	}

	public void checkIfProgrammingLanguageIdExistsNot(int id) {
		if (!this.programmingLanguageRepository.existsById(id)) {
			throw new BusinessException("Programming language id is not valid !");
		}
	}

	public void checkIfProgrammingLanguageNameExists(String name) {
		if (this.programmingLanguageRepository.existsByName(name)) {
			throw new BusinessException("Programming language name already exists !");
		}
	}
}
