package Kodlama.io.Kodlama.io.Devs.dataAccess.abstracts;

import java.util.List;

import Kodlama.io.Kodlama.io.Devs.entities.ProgrammingLanguage;

public interface ProgrammingLanguageRepository {

	void add(ProgrammingLanguage programmingLanguage);

	void update(ProgrammingLanguage oldPLanguage, ProgrammingLanguage newPLanguage);

	void delete(ProgrammingLanguage programmingLanguage);

	List<ProgrammingLanguage> getAll();

	ProgrammingLanguage getWithId(int id);

}
