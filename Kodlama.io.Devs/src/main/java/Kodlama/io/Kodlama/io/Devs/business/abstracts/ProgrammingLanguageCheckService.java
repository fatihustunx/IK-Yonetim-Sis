package Kodlama.io.Kodlama.io.Devs.business.abstracts;

import java.util.List;

import Kodlama.io.Kodlama.io.Devs.business.requests.CreateProgrammingLanguageRequest;
import Kodlama.io.Kodlama.io.Devs.business.requests.UpdateProgrammingLanguageRequest;
import Kodlama.io.Kodlama.io.Devs.business.responses.GetAllProgrammingLanguagesResponse;

public interface ProgrammingLanguageCheckService {

	boolean checkCreateProgrammingLanguage(CreateProgrammingLanguageRequest createProgrammingLanguageRequest,
			List<GetAllProgrammingLanguagesResponse> getAllProgrammingLanguagesResponses);

	boolean checkUpdateProgrammingLanguage(UpdateProgrammingLanguageRequest updateProgrammingLanguageRequest,
			List<GetAllProgrammingLanguagesResponse> getAllProgrammingLanguagesResponses);
}
