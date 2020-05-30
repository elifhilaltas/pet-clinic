package com.javaegitimleri.petclinic.web;

import static org.mockito.Mockito.never;

import java.net.URI;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.support.BasicAuthorizationInterceptor;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import com.javaegitimleri.petclinic.model.Owner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.DEFINED_PORT)
@ActiveProfiles("dev")
public class PetClinicRestControllerTests {
	@Autowired
	private TestRestTemplate restTemplate;
	
	@Before
	public void setUp() {
		
		restTemplate = restTemplate.withBasicAuth("user2", "secret");
		
		
		
//		restTemplate = new RestTemplate();
//		BasicAuthorizationInterceptor basicAuthorizationInterceptor = new BasicAuthorizationInterceptor("user2","secret");
//		restTemplate.setInterceptors(Arrays.asList(basicAuthorizationInterceptor));
	}
	
	
	@Test
	public void testDeleteOwner() {
		
		//restTemplate.delete("http://localhost:8080/rest/owner/1");
		ResponseEntity<Void> responseEntity = restTemplate.exchange("http://localhost:8080/rest/owner/1", HttpMethod.DELETE,null,Void.class);
		try
		{
			restTemplate.getForEntity("http://localhost:8080/rest/owner/1", Owner.class);
			org.junit.Assert.fail("should have not returned  owner");
		}
		catch (HttpClientErrorException ex) {
			MatcherAssert.assertThat(ex.getStatusCode().value(), Matchers.equalTo(404));
			
		}
	}
	
	@Test
	public void testUpdateOwner() {
		 Owner owner = restTemplate.getForObject("http://localhost:8080/rest/owner/2", Owner.class);
		
		MatcherAssert.assertThat(owner.getFirstName(),Matchers.equalTo("Ahmet"));
		
		owner.setFirstName("Ahmet Fırat");
		restTemplate.put("http://localhost:8080/rest/owner/2", owner);
		
		owner = restTemplate.getForObject("http://localhost:8080/rest/owner/2", Owner.class);
		MatcherAssert.assertThat(owner.getFirstName(),Matchers.equalTo("Ahmet Fırat"));
		
		
		owner = restTemplate.getForObject("http://localhost:8080/rest/owner/2", Owner.class);
		
		MatcherAssert.assertThat(owner.getLastName(),Matchers.equalTo("Solak"));
		
		owner.setLastName("Gürbüz");
		restTemplate.put("http://localhost:8080/rest/owner/2", owner);
		
		owner = restTemplate.getForObject("http://localhost:8080/rest/owner/2", Owner.class);
		MatcherAssert.assertThat(owner.getLastName(),Matchers.equalTo("Gürbüz"));
		
		
	}
	
	
	
	@Test
	public void testCreateOwner() {
		
		Owner owner = new Owner();
		owner.setFirstName("Münevver");
		owner.setLastName("Solak");
			
		URI location = restTemplate.postForLocation("http://localhost:8080/rest/owner", owner);
		
		Owner owner2=restTemplate.getForObject(location, Owner.class);
		
		MatcherAssert.assertThat(owner2.getFirstName(), Matchers.equalTo(owner.getFirstName()));
		MatcherAssert.assertThat(owner2.getLastName(), Matchers.equalTo(owner.getLastName()));
		}
	
	
	@Test
	public void testGetOwnerById() {
		ResponseEntity<Owner> response = restTemplate.getForEntity("http://localhost:8080/rest/owner/1", Owner.class);
		
		MatcherAssert.assertThat(response.getStatusCodeValue(), Matchers.equalTo(200));
		MatcherAssert.assertThat(response.getBody().getFirstName(), Matchers.equalTo("Ahmet"));
	}
	
	@Test
	public void testGetOwnerByLastName() {
		ResponseEntity<List> response = restTemplate.getForEntity("http://localhost:8080/rest/owner?ln=Tas", List.class);
		
		MatcherAssert.assertThat(response.getStatusCodeValue(), Matchers.equalTo(200));
		
		List<Map<String,String>> body= response.getBody();
		
		List<String> firstNames= body.stream().map(e->e.get("firstName")).collect(Collectors.toList());
			
		MatcherAssert.assertThat(firstNames, Matchers.containsInAnyOrder("Elif","Gulbahar","Meryem"));
			
	}
	
	@Test
	public void TestGetOwners() {
		ResponseEntity<List> response = restTemplate.getForEntity("http://localhost:8080/rest/owners", List.class);
		
		MatcherAssert.assertThat(response.getStatusCodeValue(), Matchers.equalTo(200));
		
		List<Map<String,String>> body= response.getBody();
		
		List<String> firstNames= body.stream().map(e->e.get("firstName")).collect(Collectors.toList());
		
		MatcherAssert.assertThat(firstNames, Matchers.containsInAnyOrder("Elif","Gulbahar","Meryem","Ahmet"));
	
	}
	
	@Test
	public void testServiceLevelValidation() {
		
		Owner owner = new Owner();
	//	owner.setFirstName("EH");
	//	owner.setLastName("TG");
		
		ResponseEntity<URI> responseEntity = restTemplate.postForEntity("http://localhost:8080/rest/owner", owner, URI.class);
		
		MatcherAssert.assertThat(responseEntity.getStatusCode(), Matchers.equalTo(HttpStatus.PRECONDITION_FAILED));
	}
	
	
}
