package Generator;
// default package
// Generated 11-jun-2015 16:11:55 by Hibernate Tools 3.4.0.CR1

import java.util.HashSet;
import java.util.Set;

/**
 * Locations generated by hbm2java
 */
public class Locations implements java.io.Serializable {

	private short locationId;
	private Countries countries;
	private String streetAddress;
	private String postalCode;
	private String city;
	private String stateProvince;
	private Set departmentses = new HashSet(0);

	public Locations() {
	}

	public Locations(short locationId, String city) {
		this.locationId = locationId;
		this.city = city;
	}

	public Locations(short locationId, Countries countries,
			String streetAddress, String postalCode, String city,
			String stateProvince, Set departmentses) {
		this.locationId = locationId;
		this.countries = countries;
		this.streetAddress = streetAddress;
		this.postalCode = postalCode;
		this.city = city;
		this.stateProvince = stateProvince;
		this.departmentses = departmentses;
	}

	public short getLocationId() {
		return this.locationId;
	}

	public void setLocationId(short locationId) {
		this.locationId = locationId;
	}

	public Countries getCountries() {
		return this.countries;
	}

	public void setCountries(Countries countries) {
		this.countries = countries;
	}

	public String getStreetAddress() {
		return this.streetAddress;
	}

	public void setStreetAddress(String streetAddress) {
		this.streetAddress = streetAddress;
	}

	public String getPostalCode() {
		return this.postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getStateProvince() {
		return this.stateProvince;
	}

	public void setStateProvince(String stateProvince) {
		this.stateProvince = stateProvince;
	}

	public Set getDepartmentses() {
		return this.departmentses;
	}

	public void setDepartmentses(Set departmentses) {
		this.departmentses = departmentses;
	}

}
