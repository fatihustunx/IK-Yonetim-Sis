package Kodlama.io.Kodlama.io.Devs.business.conceretes;

import java.util.List;

import org.springframework.stereotype.Service;

import Kodlama.io.Kodlama.io.Devs.business.abstracts.ProgrammingLanguageCheckService;
import Kodlama.io.Kodlama.io.Devs.business.requests.CreateProgrammingLanguageRequest;
import Kodlama.io.Kodlama.io.Devs.business.requests.UpdateProgrammingLanguageRequest;
import Kodlama.io.Kodlama.io.Devs.business.responses.GetAllProgrammingLanguagesResponse;

@Service
public class ProgrammingLanguageCheckManager implements ProgrammingLanguageCheckService {

	@Override
	public boolean checkCreateProgrammingLanguage(CreateProgrammingLanguageRequest createProgrammingLanguageRequest,
			List<GetAllProgrammingLanguagesResponse> getAllProgrammingLanguagesResponses) {

		if (createProgrammingLanguageRequest == null) {
			return false;
		}

		int counter = 0;
		char[] array = createProgrammingLanguageRequest.getName().toCharArray();
		for (int i = 0; i < array.length; i++) {
			if (array[i] == ' ') {
				counter++;
			}
		}
		if (counter == array.length) {
			return false;
		}

		if (getAllProgrammingLanguagesResponses != null) {
			for (GetAllProgrammingLanguagesResponse getAllProgrammingLanguagesResponse : getAllProgrammingLanguagesResponses) {
				if (createProgrammingLanguageRequest.getName() == getAllProgrammingLanguagesResponse.getName()) {
					return false;
				}
			}
		}

		return true;
	}

	@Override
	public boolean checkUpdateProgrammingLanguage(UpdateProgrammingLanguageRequest updateProgrammingLanguageRequest,
			List<GetAllProgrammingLanguagesResponse> getAllProgrammingLanguagesResponses) {

		if (updateProgrammingLanguageRequest == null) {
			return false;
		}

		int counter = 0;
		char[] array = updateProgrammingLanguageRequest.getName().toCharArray();
		for (int i = 0; i < array.length; i++) {
			if (array[i] == ' ') {
				counter++;
			}
		}
		if (counter == array.length) {
			return false;
		}

		if (getAllProgrammingLanguagesResponses != null) {
			for (GetAllProgrammingLanguagesResponse getAllProgrammingLanguagesResponse : getAllProgrammingLanguagesResponses) {
				if (updateProgrammingLanguageRequest.getName() == getAllProgrammingLanguagesResponse.getName()) {
					return false;
				}
			}
		}

		return true;
	}

}