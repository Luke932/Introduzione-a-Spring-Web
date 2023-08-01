package luke932.Spring_Web.controllers;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import luke932.Spring_Web.entities.Prenotazione;
import luke932.Spring_Web.service.PrenotazioneService;

@RestController
@RequestMapping("/bookings")
public class PrenotazioneController {

	@Autowired
	PrenotazioneService bookS;

	// #POST salvataggio postazioni
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Prenotazione saveBook(@RequestBody Prenotazione body) {
		Prenotazione createUser = bookS.save(body);
		return createUser;
	}

	// #GET ritorna lista postazioni
	@GetMapping
	public List<Prenotazione> getUsers() {
		return bookS.getBookings();
	}

	@PostMapping("/makeReservation")
	public ResponseEntity<String> makeReservation(@RequestParam LocalDate date, @RequestParam String workstationId) {
		boolean success = bookS.makeReservation(date, workstationId);
		if (success) {
			return ResponseEntity.ok("Prenotazione effettuata con successo");
		} else {
			return ResponseEntity.badRequest().body("Errore durante la prenotazione");
		}
	}

}
