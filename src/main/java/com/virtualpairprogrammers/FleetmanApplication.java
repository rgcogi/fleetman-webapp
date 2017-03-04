package com.virtualpairprogrammers;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.commons.util.InetUtils;
import org.springframework.cloud.netflix.eureka.EurekaInstanceConfigBean;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import com.netflix.appinfo.AmazonInfo;

@SpringBootApplication
@EnableCircuitBreaker
@EnableDiscoveryClient
@EnableFeignClients
public class FleetmanApplication {

	public static void main(String[] args) {
		SpringApplication.run(FleetmanApplication.class, args);
	}
	

	// In main class

	@Bean
	public EurekaInstanceConfigBean eurekaInstanceConfigBean(InetUtils utils) 
	{
	   EurekaInstanceConfigBean instance = new EurekaInstanceConfigBean(utils);
	   AmazonInfo info = AmazonInfo.Builder.newBuilder().autoBuild("eureka");
	   instance.setHostname(info.get(AmazonInfo.MetaDataKey.publicHostname));
	   instance.setIpAddress(info.get(AmazonInfo.MetaDataKey.publicIpv4));
	   instance.setDataCenterInfo(info);
	   instance.setNonSecurePort(8080);
	   return instance;
	}
	
}
