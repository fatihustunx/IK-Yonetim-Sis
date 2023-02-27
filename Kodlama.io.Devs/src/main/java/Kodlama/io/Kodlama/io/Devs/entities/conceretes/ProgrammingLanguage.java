package Kodlama.io.Kodlama.io.Devs.entities.conceretes;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "programingLanguages")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class ProgrammingLanguage {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "name")
	private String name;

	@OneToMany(mappedBy = "programmingLanguage")
	private List<SubTechnology> subTechnologies;
}
