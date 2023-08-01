package luke932.Spring_Web.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.stereotype.Service;

import luke932.Spring_Web.entities.Postazione;

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
		return pstR.findByTipoAndEdificioCittà(tipo, città);
	}
}
