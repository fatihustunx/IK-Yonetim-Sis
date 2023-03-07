package Kodlama.io.Kodlama.io.Devs.business.rules;

import org.springframework.stereotype.Service;

import Kodlama.io.Kodlama.io.Devs.core.utilities.exceptions.BusinessException;
import Kodlama.io.Kodlama.io.Devs.dataAccess.abstracts.ProgrammingLanguageRepository;
import Kodlama.io.Kodlama.io.Devs.dataAccess.abstracts.SubTechnologyRepository;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class SubTechnologyBusinessRules {

	private SubTechnologyRepository subTechnologyRepository;
	private ProgrammingLanguageRepository programmingLanguageRepository;

	public void checkIfSubTechnologiesListExists() {
		if (this.subTechnologyRepository.findAll().isEmpty()) {
			throw new BusinessException("Sub Technologies list is null !");
		}
	}

	public void checkIfSubTechnologyIdExistsNot(int id) {
		if (!this.subTechnologyRepository.existsById(id)) {
			throw new BusinessException("Sub Technology id is not valid !");
		}
	}

	/*
	 * public void checkIfExistsProgrammingLanguageIdNot(int id) { if
	 * (!this.subTechnologyRepository.existsByProgrammingLanguageId(id)) { throw new
	 * BusinessException("Sub Technology's programming language id is not valid !");
	 * } }
	 */

	public void checkIfExistsSubTechnologysProgrammingLanguageIdNot(int programmingLanguageId) {
		if (!this.programmingLanguageRepository.existsById(programmingLanguageId)) {
			throw new BusinessException("Sub Technology's programming language id is not valid !");
		}
	}

	public void checkIfSubTechnologyNameExistsInProgrammingLanguageId(int id, String name) {
		if (this.subTechnologyRepository.existsByProgrammingLanguageIdAndName(id, name)) {
			throw new BusinessException("Sub Technology name is already exists !");
		}
	}
}
