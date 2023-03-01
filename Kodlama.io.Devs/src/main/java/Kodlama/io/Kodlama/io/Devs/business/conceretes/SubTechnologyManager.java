package Kodlama.io.Kodlama.io.Devs.business.conceretes;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import Kodlama.io.Kodlama.io.Devs.business.abstracts.ProgrammingLanguageService;
import Kodlama.io.Kodlama.io.Devs.business.abstracts.SubTechnologyService;
import Kodlama.io.Kodlama.io.Devs.business.requests.CreateSubTechnologyRequest;
import Kodlama.io.Kodlama.io.Devs.business.requests.UpdateSubTechnologyRequest;
import Kodlama.io.Kodlama.io.Devs.business.responses.GetAllProgrammingLanguagesResponse;
import Kodlama.io.Kodlama.io.Devs.business.responses.GetSubTechnologyResponse;
import Kodlama.io.Kodlama.io.Devs.dataAccess.abstracts.SubTechnologyRepository;
import Kodlama.io.Kodlama.io.Devs.entities.conceretes.ProgrammingLanguage;
import Kodlama.io.Kodlama.io.Devs.entities.conceretes.SubTechnology;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class SubTechnologyManager implements SubTechnologyService {

	private ProgrammingLanguageService programmingLanguageService;
	private SubTechnologyRepository subTechnologyRepository;
	private ModelMapper modelMapper;

	@Override
	public void add(CreateSubTechnologyRequest createSubTechnologyRequest) throws Exception {

		SubTechnology subTechnology;
		subTechnology = modelMapper.map(createSubTechnologyRequest, SubTechnology.class);

		// createRequest.getProgrammingLanguageId == subTechnology.getId; !!!!

		// responseEntity only controller !!

		// Validation & Exception !!!

		// modelMapper !

		subTechnology.setProgrammingLanguage(modelMapper.map(
				programmingLanguageService.getById(createSubTechnologyRequest.getProgrammingLanguageId()),
				ProgrammingLanguage.class));

		/*
		 * subTechnology.setProgrammingLanguage(modelMapper
		 * .map(createSubTechnologyRequest.getCreateProgrammingLanguageRequest(),
		 * ProgrammingLanguage.class ));
		 */

		subTechnologyRepository.save(subTechnology);
	}

	@Override
	public void update(UpdateSubTechnologyRequest updateSubTechnologyRequest) throws Exception {

		SubTechnology subTechnology;
		subTechnology = modelMapper.map(updateSubTechnologyRequest, SubTechnology.class);

		subTechnology.setProgrammingLanguage(modelMapper.map(
				programmingLanguageService.getById(updateSubTechnologyRequest.getProgrammingLanguageId()),
				ProgrammingLanguage.class));

		subTechnologyRepository.save(subTechnology);
	}

	@Override
	public void delete(int id) throws Exception {

		Optional<SubTechnology> optionalSubTechnology = subTechnologyRepository.findById(id);

		if (optionalSubTechnology.isPresent()) {
			subTechnologyRepository.deleteById(id);
		} else {
			throw new Exception("404 not found !");
		}
	}

	@Override
	public ResponseEntity<GetSubTechnologyResponse> getWithId(int id) {

		Optional<SubTechnology> subTechnologyOptional = subTechnologyRepository.findById(id);

		if (subTechnologyOptional.isPresent()) {

			GetSubTechnologyResponse getSubTechnologyResponse = modelMapper.map(subTechnologyOptional.get(),
					GetSubTechnologyResponse.class);

			getSubTechnologyResponse.setGetAllProgrammingLanguagesResponse(modelMapper.map(
					subTechnologyOptional.get().getProgrammingLanguage(), GetAllProgrammingLanguagesResponse.class));

			return ResponseEntity.ok(getSubTechnologyResponse);
			/*
			 * GetSubTechnologyResponse getSubTechnologyResponse=new
			 * GetSubTechnologyResponse();
			 * getSubTechnologyResponse.setId(subTechnologyOptional.get().getId());
			 * getSubTechnologyResponse.setName(subTechnologyOptional.get().getName());
			 * 
			 * GetAllProgrammingLanguagesResponse getAllProgrammingLanguagesResponse=new
			 * GetAllProgrammingLanguagesResponse();
			 * getAllProgrammingLanguagesResponse.setId(subTechnologyOptional.get().getId())
			 * ; getAllProgrammingLanguagesResponse.setName(subTechnologyOptional.get().
			 * getName());
			 * 
			 * getSubTechnologyResponse.setGetAllProgrammingLanguagesResponse(
			 * getAllProgrammingLanguagesResponse);
			 * 
			 * return getSubTechnologyResponse;
			 */
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@Override
	public ResponseEntity<List<GetSubTechnologyResponse>> getAll() {

		List<SubTechnology> subTechnologies = subTechnologyRepository.findAll();

		if (subTechnologies.isEmpty()) {
			return ResponseEntity.notFound().build();
		}

		List<GetSubTechnologyResponse> getSubTechnologyResponses = new ArrayList<>();

		for (SubTechnology subTechnology : subTechnologies) {
			GetSubTechnologyResponse getSubTechnologyResponse = modelMapper.map(subTechnology,
					GetSubTechnologyResponse.class);
			getSubTechnologyResponse.setGetAllProgrammingLanguagesResponse(
					modelMapper.map(subTechnology.getProgrammingLanguage(), GetAllProgrammingLanguagesResponse.class));
			getSubTechnologyResponses.add(getSubTechnologyResponse);
		}

		return ResponseEntity.ok(getSubTechnologyResponses);
		/*
		 * List<SubTechnology> subTechnologies=subTechnologyRepository.findAll();
		 * List<GetSubTechnologyResponse> getSubTechnologyResponses=new
		 * ArrayList<GetSubTechnologyResponse>();
		 * 
		 * for (SubTechnology subTechnology : subTechnologies) {
		 * GetSubTechnologyResponse responseItem=new GetSubTechnologyResponse();
		 * responseItem.setId(subTechnology.getId());
		 * responseItem.setName(subTechnology.getName());
		 * 
		 * GetAllProgrammingLanguagesResponse getAllProgrammingLanguagesResponse=new
		 * GetAllProgrammingLanguagesResponse();
		 * getAllProgrammingLanguagesResponse.setId(subTechnology.getProgrammingLanguage
		 * ().getId()); getAllProgrammingLanguagesResponse.setName(subTechnology.
		 * getProgrammingLanguage().getName());
		 * 
		 * responseItem.setGetAllProgrammingLanguagesResponse(
		 * getAllProgrammingLanguagesResponse);
		 * getSubTechnologyResponses.add(responseItem); }
		 * 
		 * return getSubTechnologyResponses;
		 */
		/*
		 * return subTechnologyRepository.findAll().stream().map(source ->
		 * modelMapper.map(source, GetSubTechnologyResponse.class))
		 * .collect(Collectors.toList());
		 */
	}

}
