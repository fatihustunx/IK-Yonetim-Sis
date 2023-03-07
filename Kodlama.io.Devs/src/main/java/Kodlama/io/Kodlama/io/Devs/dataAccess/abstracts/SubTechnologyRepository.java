package Kodlama.io.Kodlama.io.Devs.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import Kodlama.io.Kodlama.io.Devs.entities.conceretes.SubTechnology;

public interface SubTechnologyRepository extends JpaRepository<SubTechnology, Integer> {

	// boolean existsByProgrammingLanguageId(int id);

	boolean existsByProgrammingLanguageIdAndName(int id, String name);
}
