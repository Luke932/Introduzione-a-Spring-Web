package luke932.Spring_Web.entities;

import lombok.Data;

@Data
public class Postazione {

	private Long id;

	private String codice;

	private String descrizione;

	private TipoPostazione tipo;

	private int numeroMassimoOccupanti;

	private String città;

}
