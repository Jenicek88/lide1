package cz.honza.test.demo.lide;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table; 

@Entity // Tohlw jE OYNACENI YE SE JEDNA O DATABAYOVZ OBJEKT
@Table(name="lide")
public class Clovek {
	
	@Id
	private int id;
	@Column(name="jmeno") //neni povinnost pokud se shoduje s databazi
	private String jmeno;
	private String prijmeni;
	private Integer vek;
	private String pohlavi;
	private String heslo;
	private String nick;
	
	
	public String getHeslo() {
		return heslo;
	}
	public void setHeslo(String heslo) {
		this.heslo = heslo;
	}
	public String getNick() {
		return nick;
	}
	public void setNick(String nick) {
		this.nick = nick;
	}
	public String getPohlavi() {
		return pohlavi;
	}
	public void setPohlavi(String pohlavi) {
		this.pohlavi = pohlavi;
	}
	public Integer getVek() {
		return vek;
	}
	public void setVek(Integer vek) {
		this.vek = vek;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getJmeno() {
		return jmeno;
	}
	public void setJmeno(String jmeno) {
		this.jmeno = jmeno;
	}
	public String getPrijmeni() {
		return prijmeni;
	}
	public void setPrijmeni(String prijmeni) {
		this.prijmeni = prijmeni;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;     // unikatni id vytvori 
		result = prime * result + id;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)  						//slouzi k porovnani instanci
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Clovek other = (Clovek) obj;
		if (id != other.id)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Clovek [id=" + id + ", jmeno=" + jmeno + ", prijmeni=" + prijmeni + "]";
	}
	
	
}
