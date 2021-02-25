package fr.diginamic.entites;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

@Entity
@Table(name="FILM")
public class Film {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Long id;
	
	@Column(name="id_imdb")
	private String idImdb;
	
	@Column(name="imdb_href")
	private String imdbHref;
	private String nom;
	private Integer annee;
	private char traite;
	
	@OneToMany(mappedBy="film")
	private Set<Role> roles = new HashSet<>();
	
	@ManyToMany
	@JoinTable(name="FILM_REAlISATEUR", joinColumns = { @JoinColumn(name = "id_film") }, 
    inverseJoinColumns = { @JoinColumn(name = "id_realisateur") } )
	private Set<Realisateur> realisateurs = new HashSet<>();
	
	@ManyToMany
	@JoinTable(name="FILM_GENRE", joinColumns = { @JoinColumn(name = "id_film") }, 
	        inverseJoinColumns = { @JoinColumn(name = "id_genre") } )
	private Set<Genre> genres = new HashSet<>();
	
	@ManyToMany
	@JoinTable(name="FILM_PAYS", joinColumns = { @JoinColumn(name = "id_film") }, 
	        inverseJoinColumns = { @JoinColumn(name = "id_pays") } )
	private Set<Pays> pays = new HashSet<>();
	
	public Film() {
		
	}
	
	public Film(String imdbHref, String nom) {
		super();
		this.imdbHref = imdbHref;
		this.nom = nom;
	}
	
	public Film(String nom, Integer annee) {
		super();
		this.nom = nom;
		this.annee = annee;
	}
	
	public boolean acteurExists(Acteur acteur) {
		return roles.stream().anyMatch(r -> r.getActeur().equals(acteur));
	}
	
	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(idImdb).toHashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Film)) {
			return false;
		}
		Film other = (Film) obj;
		return new EqualsBuilder().append(idImdb, other.getIdImdb()).isEquals();
	}

	/** Getter
	 * @return the nom
	 */
	public String getNom() {
		return nom;
	}
	/** Setter
	 * @param nom the nom to set
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}
	/** Getter
	 * @return the annee
	 */
	public Integer getAnnee() {
		return annee;
	}
	/** Setter
	 * @param annee the annee to set
	 */
	public void setAnnee(Integer annee) {
		this.annee = annee;
	}

	/** Getter
	 * @return the imdbHref
	 */
	public String getImdbHref() {
		return imdbHref;
	}

	/** Setter
	 * @param imdbHref the imdbHref to set
	 */
	public void setImdbHref(String imdbHref) {
		this.imdbHref = imdbHref;
	}

	@Override
	public String toString() {
		return "id=" + idImdb + ", nom=" + nom + ", annee=" + annee;
	}

	public void addRole(Role role) {
		System.out.println("Ajout role : "+role+" pour le film : "+this);
		roles.add(role);
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

	/** Setter
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/** Getter
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/** Getter
	 * @return the roles
	 */
	public Set<Role> getRoles() {
		return roles;
	}

	/** Setter
	 * @param roles the roles to set
	 */
	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	/** Getter
	 * @return the traite
	 */
	public char getTraite() {
		return traite;
	}

	/** Setter
	 * @param traite the traite to set
	 */
	public void setTraite(char traite) {
		this.traite = traite;
	}

	/** Getter
	 * @return the genres
	 */
	public Set<Genre> getGenres() {
		return genres;
	}

	/** Setter
	 * @param genres the genres to set
	 */
	public void setGenres(Set<Genre> genres) {
		this.genres = genres;
	}

	/** Getter
	 * @return the realisateurs
	 */
	public Set<Realisateur> getRealisateurs() {
		return realisateurs;
	}

	/** Setter
	 * @param realisateurs the realisateurs to set
	 */
	public void setRealisateurs(Set<Realisateur> realisateurs) {
		this.realisateurs = realisateurs;
	}

	/** Getter
	 * @return the pays
	 */
	public Set<Pays> getPays() {
		return pays;
	}

	/** Setter
	 * @param pays the pays to set
	 */
	public void setPays(Set<Pays> pays) {
		this.pays = pays;
	}

	
}