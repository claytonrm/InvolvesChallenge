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

	public void setIbgeId(final Long ibgeId) {
		this.ibgeId = ibgeId;
	}

	@CSVProperty(column = "uf")
	public String getUf() {
		return uf;
	}

	public void setUf(final String uf) {
		this.uf = uf;
	}

	@CSVProperty(column = "name")
	public String getName() {
		return name;
	}
	
	public void setName(final String name) {
		this.name = name;
	}

	@CSVProperty(column = "capital")
	public Boolean getCapital() {
		return capital;
	}

	public void setCapital(final Boolean capital) {
		this.capital = capital;
	}

	@CSVProperty(column = "lon")
	public Double getLongitude() {
		return longitude;
	}

	public void setLongitude(final Double longitude) {
		this.longitude = longitude;
	}

	@CSVProperty(column = "lat")
	public Double getLatitude() {
		return latitude;
	}

	public void setLatitude(final Double latitude) {
		this.latitude = latitude;
	}

	@CSVProperty(column = "no_accents")
	public String getNoAccents() {
		return noAccents;
	}

	public void setNoAccents(final String noAccents) {
		this.noAccents = noAccents;
	}

	@CSVProperty(column = "alternative_names")
	public String getAlternativeNames() {
		return alternativeNames;
	}

	public void setAlternativeNames(String alternativeNames) {
		this.alternativeNames = alternativeNames;
	}

	@CSVProperty(column = "microregion")
	public String getMicroregion() {
		return microregion;
	}

	public void setMicroregion(final String microregion) {
		this.microregion = microregion;
	}

	@CSVProperty(column = "mesoregion")
	public String getMesoregion() {
		return mesoregion;
	}

	public void setMesoregion(final String mesoregion) {
		this.mesoregion = mesoregion;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ibgeId == null) ? 0 : ibgeId.hashCode());
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
		return true;
	}
}
