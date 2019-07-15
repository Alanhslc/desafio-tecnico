package com.desafio.tecnico.http.builder;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
public class HttpHeadersBuilderTest {

	@Test
	public void deveConstruirHttpHeaderPorXML() {
		HttpHeaders httpHeaders = new HttpHeadersBuilder()
				.mediaType(MediaType.APPLICATION_XML)
				.build();
		assertEquals(MediaType.APPLICATION_XML, httpHeaders.getAccept().get(0));
	}
	
}
