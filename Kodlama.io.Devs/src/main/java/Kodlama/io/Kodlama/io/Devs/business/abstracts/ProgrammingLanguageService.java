package Kodlama.io.Kodlama.io.Devs.business.abstracts;

import java.util.List;

import Kodlama.io.Kodlama.io.Devs.entities.ProgrammingLanguage;

public interface ProgrammingLanguageService {

	void add(ProgrammingLanguage programmingLanguage) throws Exception;

	void update(ProgrammingLanguage oldPLanguage, ProgrammingLanguage newPLanguage) throws Exception;

	void delete(ProgrammingLanguage programmingLanguage) throws Exception;

	List<ProgrammingLanguage> getAll();

	ProgrammingLanguage getWithId(int id) throws Exception;
}
