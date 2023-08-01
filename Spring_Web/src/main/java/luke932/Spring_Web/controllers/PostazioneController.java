package luke932.Spring_Web.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import luke932.Spring_Web.entities.Postazione;
import luke932.Spring_Web.service.PostazioneService;

@RestController
@RequestMapping("/positions")
public class PostazioneController {

	@Autowired
	PostazioneService pstS;

	// #POST salvataggio postazioni
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Postazione savePst(@RequestBody Postazione body) {
		Postazione createPst = pstS.save(body);
		return createPst;
	}

	// #GET ritorna lista postazioni
	@GetMapping
	public List<Postazione> getPositions() {
		return pstS.getPositions();
	}
}
