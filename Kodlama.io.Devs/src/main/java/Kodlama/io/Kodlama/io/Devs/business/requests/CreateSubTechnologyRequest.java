package Kodlama.io.Kodlama.io.Devs.business.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateSubTechnologyRequest {

	private String name;
	private CreateProgrammingLanguageRequest createProgrammingLanguageRequest;
}
