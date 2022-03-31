package com.hansgrohe.springintegrationdemo.beans;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.apache.commons.lang3.StringUtils;

import java.util.Map;

public class LeadFormRequestWsData {

	@JsonProperty("FormId")
	private String formId;

	@JsonProperty("SourceId")
	private String sourceId;

	@JsonProperty("ContactOrigin")
	private String contactOrigin;

	@JsonProperty("GenderCode")
	private String gender;

	@JsonProperty("ContactID")
	private String contactID;

	@JsonProperty("FirstName")
	private String firstName;

	@JsonProperty("LastName")
	private String lastName;

	@JsonProperty("EmailAddress")
	private String email;

	@JsonProperty("StreetName")
	private String street;

	@JsonProperty("CityName")
	private String city;

	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	@JsonProperty("YY1_ACC_TYPE_ENH")
	private String c4cAccountType;

	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	@JsonProperty("YY1_ACTIVATION_URL_ENH")
	private String activationUrl;

	private boolean isContactPerson;

	private boolean isConsumer;

	@JsonProperty("Country")
	private String country;

	@JsonProperty("Language")
	private String language;

	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	@JsonProperty("CorporateAccountName")
	private String accountName;

	@JsonProperty("ContactPostalCode")
	private String contactPostalCode;

	@JsonProperty("PhoneNumber")
	private String phoneNumber;

	@JsonProperty("Interactions")
	private Map<String, Object> interactions;

	public Map<String, Object> getInteractions() {
		return interactions;
	}

	public void setInteractions(final Map<String, Object> interactions) {
		this.interactions = interactions;
	}

	public String getFormId() {
		return formId;
	}

	public void setFormId(String formId) {
		this.formId = formId;
	}

	public String getSourceId() {
		return sourceId;
	}

	public void setSourceId(String sourceId) {
		this.sourceId = sourceId;
	}

	public String getContactOrigin() {
		return contactOrigin;
	}

	public void setContactOrigin(String contactOrigin) {
		this.contactOrigin = contactOrigin;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getFirstName() {
		if (firstName != null && firstName.length() > 40) {
			return firstName.substring(0, 40);
		}
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		if (lastName != null && lastName.length() > 40) {
			return lastName.substring(0, 40);
		}
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		if (email != null && email.length() > 241) {
			return email.substring(0, 241);
		}
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getC4cAccountType() {
		return c4cAccountType;
	}

	public void setC4cAccountType(final String c4cAccountType) {
		this.c4cAccountType = c4cAccountType;
	}

	@JsonProperty("IsContactPerson")
	public boolean isContactPerson() {
		return isContactPerson;
	}

	public void setContactPerson(final boolean contactPerson) {
		isContactPerson = contactPerson;
	}

	@JsonProperty("IsConsumer")
	public boolean isConsumer() {
		return isConsumer;
	}

	public void setConsumer(final boolean consumer) {
		isConsumer = consumer;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getAccountName() {
		if (accountName != null && accountName.length() > 40) {
			return accountName.substring(0, 40);
		}
		return accountName;
	}

	public void setAccountName(final String accountName) {
		this.accountName = accountName;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getContactPostalCode() {
		return contactPostalCode;
	}

	public void setContactPostalCode(final String contactPostalCode) {
		if (StringUtils.isNotEmpty(contactPostalCode) && StringUtils.length(contactPostalCode) > 10) {
			this.contactPostalCode = contactPostalCode.substring(0, 10);
		} else {
			this.contactPostalCode = contactPostalCode;
		}
	}

	public String getActivationUrl() {
		return activationUrl;
	}

	public void setActivationUrl(final String activationUrl) {
		this.activationUrl = activationUrl;
	}

	public String getContactID() {
		return contactID;
	}

	public void setContactID(final String contactID) {
		this.contactID = contactID;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(final String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(final String city) {
		this.city = city;
	}

}
