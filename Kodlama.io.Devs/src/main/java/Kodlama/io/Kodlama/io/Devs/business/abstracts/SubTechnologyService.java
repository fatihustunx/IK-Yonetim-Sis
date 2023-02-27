package Kodlama.io.Kodlama.io.Devs.business.abstracts;

import java.util.List;

import org.springframework.http.ResponseEntity;

import Kodlama.io.Kodlama.io.Devs.business.requests.CreateSubTechnologyRequest;
import Kodlama.io.Kodlama.io.Devs.business.requests.UpdateSubTechnologyRequest;
import Kodlama.io.Kodlama.io.Devs.business.responses.GetSubTechnologyResponse;

public interface SubTechnologyService {

	void add(CreateSubTechnologyRequest createSubTechnologyRequest) throws Exception;

	void update(UpdateSubTechnologyRequest updateSubTechnologyRequest) throws Exception;

	void delete(int id) throws Exception;

	ResponseEntity<GetSubTechnologyResponse> getWithId(int id);

	ResponseEntity<List<GetSubTechnologyResponse>> getAll();
}
