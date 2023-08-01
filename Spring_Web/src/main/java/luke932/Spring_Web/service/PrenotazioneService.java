package luke932.Spring_Web.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.stereotype.Service;

import luke932.Spring_Web.entities.Prenotazione;

@Service
public class PrenotazioneService {

	private List<Prenotazione> prn = new ArrayList<>();

	public Prenotazione save(Prenotazione booking) {
		Random rndm = new Random();
		booking.setId(rndm.nextLong());
		this.prn.add(booking);
		return booking;
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
