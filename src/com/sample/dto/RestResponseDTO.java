package com.sample.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class RestResponseDTO {

	@JsonProperty("RestResponse")
	private RestResponse restResponse;

	public RestResponseDTO() {
		super();
	}

	public RestResponse getRestResponse() {
		return restResponse;
	}

	public void setRestResponse(RestResponse restResponse) {
		this.restResponse = restResponse;
	}

	@Override
	public String toString() {
		return "RestResponseDTO [RestResponse=" + restResponse + "]";
	}

}
