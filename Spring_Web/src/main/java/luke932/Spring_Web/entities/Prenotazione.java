package luke932.Spring_Web.entities;

import java.time.LocalDate;

import lombok.Data;

@Data
public class Prenotazione {

	private Long id;

	private LocalDate dataPrenotazione;

}
