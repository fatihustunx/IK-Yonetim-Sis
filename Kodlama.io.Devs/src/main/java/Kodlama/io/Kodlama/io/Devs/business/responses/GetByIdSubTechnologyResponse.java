package Kodlama.io.Kodlama.io.Devs.business.responses;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetByIdSubTechnologyResponse {

	private int id;
	private String name;

	private String programmingLanguageName;
}
