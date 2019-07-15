package com.desafio.tecnico.http.builder;

import java.util.Arrays;

import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;

/**
 * Constrói a classe HttpHeader com o padrão para retorno em JSON e browsers. <br>
 * Estes valores podem ser alterados dinamicamente conforme a necessidade.
 * @author alanh
 *
 */
public class HttpHeadersBuilder {

	private String webBrowser = "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/54.0.2840.99 Safari/537.36"; 
	private MediaType mediaType = MediaType.APPLICATION_JSON;
	private String headerName = "user-agent";
	
	public HttpHeadersBuilder webBrowser(String webBrowser) {
		this.webBrowser = webBrowser;
		return this;
	}
	
	public HttpHeadersBuilder mediaType(MediaType mediaType) {
		this.mediaType = mediaType;
		return this;
	}
	
	public HttpHeadersBuilder headerName(String headerName) {
		this.headerName = headerName;
		return this;
	}
	
	public HttpHeaders build() {
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.setAccept(Arrays.asList(mediaType));
		httpHeaders.add(headerName, webBrowser);
		return httpHeaders;
	}
	
}
