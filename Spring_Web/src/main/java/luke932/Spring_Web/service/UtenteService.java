package luke932.Spring_Web.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.stereotype.Service;

import luke932.Spring_Web.entities.Utente;

@Service
public class UtenteService {

	private List<Utente> userP = new ArrayList<>();

	public Utente save(Utente user) {
		Random rndm = new Random();
		user.setId(rndm.nextLong());
		this.userP.add(user);
		return user;
	}

	public List<Utente> getUsers() {
		return this.userP;
	}

}