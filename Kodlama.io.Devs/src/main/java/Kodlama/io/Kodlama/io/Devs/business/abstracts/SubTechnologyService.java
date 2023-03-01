package Kodlama.io.Kodlama.io.Devs.business.abstracts;

import java.util.List;

import org.springframework.http.ResponseEntity;

import Kodlama.io.Kodlama.io.Devs.business.requests.CreateSubTechnologyRequest;
import Kodlama.io.Kodlama.io.Devs.business.requests.UpdateSubTechnologyRequest;
import Kodlama.io.Kodlama.io.Devs.business.responses.GetSubTechnologyResponse;

public interface SubTechnologyService {

	ResponseEntity<List<GetSubTechnologyResponse>> getAll();

	ResponseEntity<GetSubTechnologyResponse> getWithId(int id);
	
	void add(CreateSubTechnologyRequest createSubTechnologyRequest) throws Exception;

	void update(UpdateSubTechnologyRequest updateSubTechnologyRequest) throws Exception;

	void delete(int id) throws Exception;
}
