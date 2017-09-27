package model;

import annotation.CSVProperty;

public class City {

	private Long ibgeId;
	private String uf;
	private String name;
	private Boolean capital;
	private Double longitude;
	private Double latitude;
	private String noAccents;
	private String alternativeNames;
	private String microregion;
	private String mesoregion;

	@CSVProperty(column = "ibge_id")
	public Long getIbgeId() {
		return ibgeId;
	}

	@CSVProperty(column = "ibge_id")
	public void setIbgeId(final Long ibgeId) {
		this.ibgeId = ibgeId;
	}

	@CSVProperty(column = "uf")
	public String getUf() {
		return uf;
	}

	@CSVProperty(column = "uf")
	public void setUf(final String uf) {
		this.uf = uf;
	}

	@CSVProperty(column = "name")
	public String getName() {
		return name;
	}
	
	@CSVProperty(column = "name")
	public void setName(final String name) {
		this.name = name;
	}

	@CSVProperty(column = "capital")
	public Boolean getCapital() {
		return capital;
	}

	@CSVProperty(column = "capital")
	public void setCapital(final Boolean capital) {
		this.capital = capital;
	}

	@CSVProperty(column = "lon")
	public Double getLongitude() {
		return longitude;
	}

	@CSVProperty(column = "lon")
	public void setLongitude(final Double longitude) {
		this.longitude = longitude;
	}

	@CSVProperty(column = "lat")
	public Double getLatitude() {
		return latitude;
	}

	@CSVProperty(column = "lat")
	public void setLatitude(final Double latitude) {
		this.latitude = latitude;
	}

	@CSVProperty(column = "no_accents")
	public String getNoAccents() {
		return noAccents;
	}

	@CSVProperty(column = "no_accents")
	public void setNoAccents(final String noAccents) {
		this.noAccents = noAccents;
	}

	@CSVProperty(column = "alternative_names")
	public String getAlternativeNames() {
		return alternativeNames;
	}

	@CSVProperty(column = "alternative_names")
	public void setAlternativeNames(String alternativeNames) {
		this.alternativeNames = alternativeNames;
	}

	@CSVProperty(column = "microregion")
	public String getMicroregion() {
		return microregion;
	}

	@CSVProperty(column = "microregion")
	public void setMicroregion(final String microregion) {
		this.microregion = microregion;
	}

	@CSVProperty(column = "mesoregion")
	public String getMesoregion() {
		return mesoregion;
	}

	@CSVProperty(column = "mesoregion")
	public void setMesoregion(final String mesoregion) {
		this.mesoregion = mesoregion;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ibgeId == null) ? 0 : ibgeId.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((uf == null) ? 0 : uf.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		City other = (City) obj;
		if (ibgeId == null) {
			if (other.ibgeId != null)
				return false;
		} else if (!ibgeId.equals(other.ibgeId))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (uf == null) {
			if (other.uf != null)
				return false;
		} else if (!uf.equals(other.uf))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return this.ibgeId + "|" + this.uf + "|" + this.name + "|" + (this.capital ? "true" : "") + "|" + this.longitude + "|"
				+ this.latitude + "|" + this.noAccents + "|" + this.alternativeNames + "|" 
				+ this.microregion + "|" + this.mesoregion;
	}
	
}
