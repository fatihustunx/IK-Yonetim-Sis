package Kodlama.io.Kodlama.io.Devs.business.conceretes;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Kodlama.io.Kodlama.io.Devs.business.abstracts.SubTechnologyService;
import Kodlama.io.Kodlama.io.Devs.business.requests.CreateSubTechnologyRequest;
import Kodlama.io.Kodlama.io.Devs.business.responses.GetAllProgrammingLanguagesResponse;
import Kodlama.io.Kodlama.io.Devs.business.responses.GetSubTechnologyResponse;
import Kodlama.io.Kodlama.io.Devs.dataAccess.abstracts.SubTechnologyRepository;
import Kodlama.io.Kodlama.io.Devs.entities.conceretes.SubTechnology;

@Service
public class SubTechnologyManager implements SubTechnologyService{
	
	private SubTechnologyRepository subTechnologyRepository;

	@Autowired
	public SubTechnologyManager(SubTechnologyRepository subTechnologyRepository) {
		super();
		this.subTechnologyRepository = subTechnologyRepository;
	}

	@Override
	public void add(CreateSubTechnologyRequest createSubTechnologyRequest) {

		SubTechnology subTechnology= new SubTechnology();
		subTechnology.setName(createSubTechnologyRequest.getName());
		subTechnology.setProgrammingLanguage(null);
		
		subTechnologyRepository.save(subTechnology);
	}

	@Override
	public void delete(GetSubTechnologyResponse getSubTechnologyResponse) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<GetSubTechnologyResponse> getAll() {

		List<SubTechnology> subTechnologies=subTechnologyRepository.findAll();
		List<GetSubTechnologyResponse> getSubTechnologyResponses=new ArrayList<GetSubTechnologyResponse>();
		
		for (SubTechnology subTechnology : subTechnologies) {
			GetSubTechnologyResponse responseItem=new GetSubTechnologyResponse();
			responseItem.setId(subTechnology.getId());
			responseItem.setName(subTechnology.getName());
			
			GetAllProgrammingLanguagesResponse getAllProgrammingLanguagesResponse=new GetAllProgrammingLanguagesResponse();
			getAllProgrammingLanguagesResponse.setId(subTechnology.getProgrammingLanguage().getId());
			getAllProgrammingLanguagesResponse.setName(subTechnology.getProgrammingLanguage().getName());
			
			responseItem.setGetAllProgrammingLanguagesResponse(getAllProgrammingLanguagesResponse);
			getSubTechnologyResponses.add(responseItem);
		}
		
		return getSubTechnologyResponses;
	}

	@Override
	public GetSubTechnologyResponse getWithId(int id) {

		Optional<SubTechnology> subTechnologyOptional= subTechnologyRepository.findById(id);
		
		if(subTechnologyOptional.isPresent()) {
			GetSubTechnologyResponse getSubTechnologyResponse=new GetSubTechnologyResponse();
			getSubTechnologyResponse.setId(subTechnologyOptional.get().getId());
			getSubTechnologyResponse.setName(subTechnologyOptional.get().getName());
			
			GetAllProgrammingLanguagesResponse getAllProgrammingLanguagesResponse=new GetAllProgrammingLanguagesResponse();
			getAllProgrammingLanguagesResponse.setId(subTechnologyOptional.get().getId());
			getAllProgrammingLanguagesResponse.setName(subTechnologyOptional.get().getName());
			
			getSubTechnologyResponse.setGetAllProgrammingLanguagesResponse(getAllProgrammingLanguagesResponse);
			
			return getSubTechnologyResponse;
			
		}else {
			return null;
		}
	}

}
