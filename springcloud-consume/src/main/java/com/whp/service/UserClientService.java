package com.whp.service;

import java.util.List;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.whp.config.FeignClientConfig;
import com.whp.fallback.UserFallbcakFactory;
import com.whp.vo.User;

@FeignClient(value="springcloud-gatway",configuration=FeignClientConfig.class,fallbackFactory=UserFallbcakFactory.class)
@RequestMapping("/user-proxy/user")
public interface UserClientService {

	@RequestMapping(method=RequestMethod.GET,value="/get/{uid}")
	User get(@PathVariable("uid") long uid);
	
	@RequestMapping(method=RequestMethod.GET,value="/list")
	List<User> list();

	
}
