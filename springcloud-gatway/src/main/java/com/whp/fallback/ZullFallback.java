package com.whp.fallback;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.springframework.cloud.netflix.zuul.filters.route.ZuulFallbackProvider;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;

@Component
public class ZullFallback implements ZuulFallbackProvider {

	@Override
	public ClientHttpResponse fallbackResponse() {
		return new ClientHttpResponse() {

			@Override
			public HttpHeaders getHeaders() {
				HttpHeaders headers = new HttpHeaders();
				headers.set("Content-Type", "text/html;charset=utf-8");
				return headers;
			}

			@Override
			public InputStream getBody() throws IOException {
				return new ByteArrayInputStream(
						"{\"uid\": 77777,\"username\": \"[error] zuul fallback\",\"address\": \"zull provider..\"}"
								.getBytes());
			}

			@Override
			public String getStatusText() throws IOException {
				return HttpStatus.BAD_GATEWAY.getReasonPhrase();
			}

			@Override
			public HttpStatus getStatusCode() throws IOException {
				return HttpStatus.BAD_GATEWAY;
			}

			@Override
			public int getRawStatusCode() throws IOException {
				return HttpStatus.BAD_GATEWAY.value();
			}

			@Override
			public void close() {

			}
		};
	}

	@Override
	public String getRoute() {
		return "user-provider";
	}

}
