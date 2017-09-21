package model;

public class City {

	private Long ibgeId;
	private String name;
	private String uf;
	private Boolean capital;
	private Double longitude;
	private Double latitude;
	private String noAccents;
	private String alternativeNames;
	private String microregion;
	private String mesoregion;

	public Long getIbgeId() {
		return ibgeId;
	}

	public void setIbgeId(final Long ibgeId) {
		this.ibgeId = ibgeId;
	}

	public String getName() {
		return name;
	}

	public void setName(final String name) {
		this.name = name;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(final String uf) {
		this.uf = uf;
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
