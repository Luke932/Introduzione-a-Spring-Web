package luke932.Spring_Web.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.stereotype.Service;

import luke932.Spring_Web.entities.Postazione;
import luke932.Spring_Web.entities.TipoPostazione;

@Service
public class PostazioneService {

	private List<Postazione> postazioni = new ArrayList<>();

	public Postazione save(Postazione pst) {
		Random rndm = new Random();
		pst.setId(rndm.nextLong());
		this.postazioni.add(pst);
		return pst;
	}

	public List<Postazione> getPositions() {
		return this.postazioni;
	}

	public List<Postazione> findByTipoandCittà(TipoPostazione tipo, String città) {
		List<Postazione> result = new ArrayList<>();
		for (Postazione postazione : postazioni) {
			if (postazione.getTipo() == tipo && postazione.getCittà().equalsIgnoreCase(città)) {
				result.add(postazione);
			}
		}
		return result;
	}

}
