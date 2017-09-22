package model;

import annotation.CSVProperty;

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

}
