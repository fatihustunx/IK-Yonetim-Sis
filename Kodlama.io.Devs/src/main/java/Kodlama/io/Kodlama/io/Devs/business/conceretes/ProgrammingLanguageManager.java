package Kodlama.io.Kodlama.io.Devs.business.conceretes;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Kodlama.io.Kodlama.io.Devs.business.abstracts.ProgrammingLanguageCheckService;
import Kodlama.io.Kodlama.io.Devs.business.abstracts.ProgrammingLanguageService;
import Kodlama.io.Kodlama.io.Devs.business.requests.CreateProgrammingLanguageRequest;
import Kodlama.io.Kodlama.io.Devs.business.responses.GetAllProgrammingLanguagesResponse;
import Kodlama.io.Kodlama.io.Devs.dataAccess.abstracts.ProgrammingLanguageRepository;
import Kodlama.io.Kodlama.io.Devs.entities.conceretes.ProgrammingLanguage;

@Service
public class ProgrammingLanguageManager implements ProgrammingLanguageService {

	private ProgrammingLanguageRepository programmingLanguageRepository;
	private ProgrammingLanguageCheckService programmingLanguageCheckService;

	@Autowired
	public ProgrammingLanguageManager(ProgrammingLanguageRepository programmingLanguageRepository,
			ProgrammingLanguageCheckService programmingLanguageCheckService) {
		this.programmingLanguageRepository = programmingLanguageRepository;
		this.programmingLanguageCheckService = programmingLanguageCheckService;
	}

	@Override
	public void add(CreateProgrammingLanguageRequest createProgrammingLanguageRequest) throws Exception {

		if (programmingLanguageCheckService.checkProgrammingLanguage(createProgrammingLanguageRequest, getAll())) {
			ProgrammingLanguage programmingLanguage=new ProgrammingLanguage();
			programmingLanguage.setName(createProgrammingLanguageRequest.getName());
			programmingLanguageRepository.save(programmingLanguage);
		} else {
			throw new Exception("Check the programming language you are trying to add !");
		}
	}

	@Override
	public void update(GetAllProgrammingLanguagesResponse getProgrammingLanguageResponse,
			CreateProgrammingLanguageRequest createProgrammingLanguageRequest) throws Exception {

		if (getAll() == null) {
			throw new Exception("Programming languages list is null !");
		}

		boolean counter = false;
		for (GetAllProgrammingLanguagesResponse getProgrammingLanguageResponse2 : getAll()) {
			if (getProgrammingLanguageResponse == getProgrammingLanguageResponse2) {
				counter = true;
			}
		}
		if (counter) {
			List<GetAllProgrammingLanguagesResponse> temp = getAll();
			temp.remove(getProgrammingLanguageResponse);

			if (programmingLanguageCheckService.checkProgrammingLanguage(createProgrammingLanguageRequest, temp)) {
				ProgrammingLanguage programmingLanguage=programmingLanguageRepository
						.getReferenceById(getProgrammingLanguageResponse.getId());
				programmingLanguage.setName(createProgrammingLanguageRequest.getName());
				programmingLanguageRepository.save(programmingLanguage);
				
			} else {
				throw new Exception("Check the new programming language you are trying to update !");
			}
		} else {
			throw new Exception("Check the old programming language you are trying to update !");
		}

	}

	@Override
	public void delete(GetAllProgrammingLanguagesResponse getProgrammingLanguageResponse) throws Exception {

		try {
			for (GetAllProgrammingLanguagesResponse getAllProgrammingLanguagesResponse2 : getAll()) {
				if (getProgrammingLanguageResponse == getAllProgrammingLanguagesResponse2) {
					ProgrammingLanguage programmingLanguage=programmingLanguageRepository
							.getReferenceById(getProgrammingLanguageResponse.getId());
					programmingLanguageRepository.delete(programmingLanguage);
				}
			}
		} catch (Exception e) {
			System.out.println("Check the programming language you are trying to delete !");
		}
	}

	@Override
	public List<GetAllProgrammingLanguagesResponse> getAll() {
		
		List<ProgrammingLanguage> programmingLanguages=programmingLanguageRepository.findAll();
		List<GetAllProgrammingLanguagesResponse> programmingLanguagesResponses=new ArrayList<GetAllProgrammingLanguagesResponse>();
		
		for (ProgrammingLanguage programmingLanguage : programmingLanguages) {
				GetAllProgrammingLanguagesResponse responseItem=new GetAllProgrammingLanguagesResponse();
				responseItem.setId(programmingLanguage.getId());
				responseItem.setName(programmingLanguage.getName());
				programmingLanguagesResponses.add(responseItem);
		}

		return programmingLanguagesResponses;
	}

	@Override
	public GetAllProgrammingLanguagesResponse getWithId(int id) throws Exception {
		
		Optional<ProgrammingLanguage> programmingLanguageOptional=programmingLanguageRepository.findById(id);
		
		if (programmingLanguageOptional.isPresent()) {
			GetAllProgrammingLanguagesResponse getProgrammingLanguageResponse=new GetAllProgrammingLanguagesResponse();
			
			getProgrammingLanguageResponse.setId(programmingLanguageOptional.get().getId());
			getProgrammingLanguageResponse.setName(programmingLanguageOptional.get().getName());
			
			return getProgrammingLanguageResponse;
		} else {
			throw new Exception("Check the programming language's id you are trying to get !");
		}
	}

}
