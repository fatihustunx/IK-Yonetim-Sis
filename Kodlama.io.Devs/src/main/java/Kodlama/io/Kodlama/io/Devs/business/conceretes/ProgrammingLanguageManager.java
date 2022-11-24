package Kodlama.io.Kodlama.io.Devs.business.conceretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Kodlama.io.Kodlama.io.Devs.business.abstracts.ProgrammingLanguageCheckService;
import Kodlama.io.Kodlama.io.Devs.business.abstracts.ProgrammingLanguageService;
import Kodlama.io.Kodlama.io.Devs.dataAccess.abstracts.ProgrammingLanguageRepository;
import Kodlama.io.Kodlama.io.Devs.entities.ProgrammingLanguage;

@Service
public class ProgrammingLanguageManager implements ProgrammingLanguageService {

	private ProgrammingLanguageRepository programmingLanguageRepository;
	private ProgrammingLanguageCheckService programmingLanguageCheckService;

	@Autowired
	public ProgrammingLanguageManager(ProgrammingLanguageRepository programmingLanguageRepository,
			ProgrammingLanguageCheckService programmingLanguageCheckService) {
		this.programmingLanguageRepository = programmingLanguageRepository;
		this.programmingLanguageCheckService = programmingLanguageCheckService;
	}

	@Override
	public void add(ProgrammingLanguage programmingLanguage) throws Exception {

		if (programmingLanguageCheckService.checkProgrammingLanguage(programmingLanguage, getAll())) {
			programmingLanguageRepository.add(programmingLanguage);
		} else {
			throw new Exception("Check the programming language you are trying to add !");
		}
	}

	@Override
	public void update(ProgrammingLanguage oldPLanguage, ProgrammingLanguage newPLanguage) throws Exception {

		if (getAll() == null) {
			throw new Exception("Programming languages list is null !");
		}

		boolean counter = false;
		for (ProgrammingLanguage programmingLanguage : getAll()) {
			if (programmingLanguage == oldPLanguage) {
				counter = true;
			}
		}
		if (counter) {
			List<ProgrammingLanguage> temp = getAll();
			temp.remove(oldPLanguage);

			if (programmingLanguageCheckService.checkProgrammingLanguage(newPLanguage, temp)) {
				programmingLanguageRepository.update(oldPLanguage, newPLanguage);
			} else {
				throw new Exception("Check the new programming language you are trying to update !");
			}
		} else {
			throw new Exception("Check the old programming language you are trying to update !");
		}

	}

	@Override
	public void delete(ProgrammingLanguage programmingLanguage) throws Exception {

		try {
			for (ProgrammingLanguage programmingLanguage2 : getAll()) {
				if (programmingLanguage == programmingLanguage2) {
					programmingLanguageRepository.delete(programmingLanguage);
					break;
				}
			}
		} catch (Exception e) {
			System.out.println("Check the programming language you are trying to delete !");
		}
	}

	@Override
	public List<ProgrammingLanguage> getAll() {

		return programmingLanguageRepository.getAll();
	}

	@Override
	public ProgrammingLanguage getWithId(int id) throws Exception {

		if (programmingLanguageRepository.getWithId(id) != null) {
			return programmingLanguageRepository.getWithId(id);
		} else {
			throw new Exception("Check the programming language's id you are trying to get !");
		}
	}

}
