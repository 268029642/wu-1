package com.whp.config;

import java.nio.charset.Charset;
import java.util.Base64;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

public class ZuulSecurityFilter extends ZuulFilter{

	@Override
	public Object run() {
		RequestContext currentContext = RequestContext.getCurrentContext();
		String auth = "wu:123";
		byte[] encode = Base64.getEncoder().encode(auth.getBytes(Charset.forName("UTF-8")));
		String header = "Basic " + new String(encode);
		currentContext.addZuulRequestHeader("Authorization", header);
		return null;
	}

	@Override
	public boolean shouldFilter() {
		return true;
	}

	@Override
	public int filterOrder() {
		return 0;
	}

	@Override
	public String filterType() {
		return "pre";
	}

}
