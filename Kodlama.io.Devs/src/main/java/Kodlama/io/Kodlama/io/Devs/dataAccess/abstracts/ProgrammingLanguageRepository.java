package Kodlama.io.Kodlama.io.Devs.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import Kodlama.io.Kodlama.io.Devs.entities.conceretes.ProgrammingLanguage;

public interface ProgrammingLanguageRepository extends JpaRepository<ProgrammingLanguage, Integer> {
/**
	void add(ProgrammingLanguage programmingLanguage);

	void update(ProgrammingLanguage oldPLanguage, ProgrammingLanguage newPLanguage);

	void delete(ProgrammingLanguage programmingLanguage);

	List<ProgrammingLanguage> getAll();

	ProgrammingLanguage getWithId(int id);
**/
}
