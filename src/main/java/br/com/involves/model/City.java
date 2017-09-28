package br.com.involves.model;

import br.com.involves.annotation.CSVProperty;

public class City {

	@CSVProperty(column = "ibge_id")
	private Long ibgeId;

	@CSVProperty(column = "uf")
	private String uf;

	@CSVProperty(column = "name")
	private String name;
	
	@CSVProperty(column = "capital")
	private Boolean capital;
	
	@CSVProperty(column = "lon")
	private Double longitude;
	
	@CSVProperty(column = "lat")
	private Double latitude;
	
	@CSVProperty(column = "no_accents")
	private String noAccents;
	
	@CSVProperty(column = "alternative_names")	
	private String alternativeNames;
	
	@CSVProperty(column = "microregion")
	private String microregion;
	
	@CSVProperty(column = "mesoregion")
	private String mesoregion;

	public Long getIbgeId() {
		return ibgeId;
	}

	public void setIbgeId(final Long ibgeId) {
		this.ibgeId = ibgeId;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(final String uf) {
		this.uf = uf;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(final String name) {
		this.name = name;
	}

	public Boolean getCapital() {
		return capital;
	}

	public void setCapital(final Boolean capital) {
		this.capital = capital;
	}

	public Double getLongitude() {
		return longitude;
	}

	public void setLongitude(final Double longitude) {
		this.longitude = longitude;
	}

	public Double getLatitude() {
		return latitude;
	}

	public void setLatitude(final Double latitude) {
		this.latitude = latitude;
	}

	public String getNoAccents() {
		return noAccents;
	}

	public void setNoAccents(final String noAccents) {
		this.noAccents = noAccents;
	}

	public String getAlternativeNames() {
		return alternativeNames;
	}

	public void setAlternativeNames(String alternativeNames) {
		this.alternativeNames = alternativeNames;
	}

	public String getMicroregion() {
		return microregion;
	}

	public void setMicroregion(final String microregion) {
		this.microregion = microregion;
	}

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
		result = prime * result + ((alternativeNames == null) ? 0 : alternativeNames.hashCode());
		result = prime * result + ((capital == null) ? 0 : capital.hashCode());
		result = prime * result + ((ibgeId == null) ? 0 : ibgeId.hashCode());
		result = prime * result + ((latitude == null) ? 0 : latitude.hashCode());
		result = prime * result + ((longitude == null) ? 0 : longitude.hashCode());
		result = prime * result + ((mesoregion == null) ? 0 : mesoregion.hashCode());
		result = prime * result + ((microregion == null) ? 0 : microregion.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((noAccents == null) ? 0 : noAccents.hashCode());
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
		if (alternativeNames == null) {
			if (other.alternativeNames != null)
				return false;
		} else if (!alternativeNames.equals(other.alternativeNames))
			return false;
		if (capital == null) {
			if (other.capital != null)
				return false;
		} else if (!capital.equals(other.capital))
			return false;
		if (ibgeId == null) {
			if (other.ibgeId != null)
				return false;
		} else if (!ibgeId.equals(other.ibgeId))
			return false;
		if (latitude == null) {
			if (other.latitude != null)
				return false;
		} else if (!latitude.equals(other.latitude))
			return false;
		if (longitude == null) {
			if (other.longitude != null)
				return false;
		} else if (!longitude.equals(other.longitude))
			return false;
		if (mesoregion == null) {
			if (other.mesoregion != null)
				return false;
		} else if (!mesoregion.equals(other.mesoregion))
			return false;
		if (microregion == null) {
			if (other.microregion != null)
				return false;
		} else if (!microregion.equals(other.microregion))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (noAccents == null) {
			if (other.noAccents != null)
				return false;
		} else if (!noAccents.equals(other.noAccents))
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
