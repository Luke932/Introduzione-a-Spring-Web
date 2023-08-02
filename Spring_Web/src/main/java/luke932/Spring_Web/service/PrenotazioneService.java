package luke932.Spring_Web.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import luke932.Spring_Web.entities.Postazione;
import luke932.Spring_Web.entities.Prenotazione;
import luke932.Spring_Web.entities.Utente;
import luke932.Spring_Web.payloads.NewPostazioneBody;

@Service
public class PrenotazioneService {

	private List<Prenotazione> prn = new ArrayList<>();

	@Autowired
	UtenteService utS;

	@Autowired
	PostazioneService pstS;

	public Prenotazione save(NewPostazioneBody body) {
		Optional<Utente> utenteOptional = utS.findById(body.getId_utente());
		Optional<Postazione> postazioneOptional = pstS.findById(body.getId_postazione());

		Utente utente = utenteOptional.orElseThrow(() -> new NoSuchElementException("Utente non trovato"));
		Postazione postazione = postazioneOptional
				.orElseThrow(() -> new NoSuchElementException("Postazione non trovata"));

		Prenotazione booking1 = new Prenotazione(Math.abs(new Random().nextInt()), body.getDate(), utente, postazione);

		this.prn.add(booking1);
		return booking1;
	}

	public List<Prenotazione> getBookings() {
		return this.prn;
	}

	public boolean makeReservation(LocalDate date, String workstationId) {
		if (date.isBefore(LocalDate.now().plusDays(2))) {
			return false;
		}
		return false;
	}
}
