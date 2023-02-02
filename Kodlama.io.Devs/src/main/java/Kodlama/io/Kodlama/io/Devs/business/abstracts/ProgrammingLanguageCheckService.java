package Kodlama.io.Kodlama.io.Devs.business.abstracts;

import java.util.List;

import Kodlama.io.Kodlama.io.Devs.business.requests.CreateProgrammingLanguageRequest;
import Kodlama.io.Kodlama.io.Devs.business.responses.GetAllProgrammingLanguagesResponse;

public interface ProgrammingLanguageCheckService {

	boolean checkProgrammingLanguage(CreateProgrammingLanguageRequest createProgrammingLanguageRequest,
			List<GetAllProgrammingLanguagesResponse> getAllProgrammingLanguagesResponses);
}
