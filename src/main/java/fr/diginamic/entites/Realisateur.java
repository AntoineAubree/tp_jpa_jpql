package fr.diginamic.entites;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

@Entity
@Table(name="REALISATEUR")
public class Realisateur {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Long id;
	
	@Column(name="id_imdb")
	private String idImdb;
	private String identite;
	private String href;
	private LocalDate anniversaire;
	
	public Realisateur() {
		
	}
	
	public Realisateur(String idImdb, String identite, String href) {
		super();
		this.idImdb = idImdb;
		this.identite = identite;
		this.href = href;
	}
	
	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(idImdb).toHashCode();
	}
	
	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Realisateur)) {
			return false;
		}
		Realisateur autre = (Realisateur)obj;
		return new EqualsBuilder().append(idImdb, autre.getIdImdb()).isEquals();
	}
	
	/** Getter
	 * @return the id
	 */
	public Long getId() {
		return id;
	}
	/** Setter
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}
	/** Getter
	 * @return the idImdb
	 */
	public String getIdImdb() {
		return idImdb;
	}
	/** Setter
	 * @param idImdb the idImdb to set
	 */
	public void setIdImdb(String idImdb) {
		this.idImdb = idImdb;
	}
	/** Getter
	 * @return the identite
	 */
	public String getIdentite() {
		return identite;
	}
	/** Setter
	 * @param identite the identite to set
	 */
	public void setIdentite(String identite) {
		this.identite = identite;
	}
	/** Getter
	 * @return the href
	 */
	public String getHref() {
		return href;
	}
	/** Setter
	 * @param href the href to set
	 */
	public void setHref(String href) {
		this.href = href;
	}
	/** Getter
	 * @return the anniversaire
	 */
	public LocalDate getAnniversaire() {
		return anniversaire;
	}
	/** Setter
	 * @param anniversaire the anniversaire to set
	 */
	public void setAnniversaire(LocalDate anniversaire) {
		this.anniversaire = anniversaire;
	}
}