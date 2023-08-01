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

import luke932.Spring_Web.entities.Utente;
import luke932.Spring_Web.service.UtenteService;

@RestController
@RequestMapping("/users")
public class UtenteController {

	@Autowired
	UtenteService userP;

	// #POST salvataggio postazioni
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Utente saveUser(@RequestBody Utente body) {
		Utente createUser = userP.save(body);
		return createUser;
	}

	// #GET ritorna lista postazioni
	@GetMapping
	public List<Utente> getUsers() {
		return userP.getUsers();
	}

}
