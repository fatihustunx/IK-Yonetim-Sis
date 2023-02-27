package Kodlama.io.Kodlama.io.Devs.entities.conceretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "subTechnologies")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class SubTechnology {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "name")
	private String name;

	@ManyToOne
	private ProgrammingLanguage programmingLanguage;
}
