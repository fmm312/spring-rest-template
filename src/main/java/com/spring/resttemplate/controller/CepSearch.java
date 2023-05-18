package com.spring.resttemplate.controller;


import com.spring.resttemplate.dto.CepSearchDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("search-cep")
public class CepSearch {

	@GetMapping("{cep}")
	public CepSearchDto findAddressByCep(@PathVariable("cep") String cep) {
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<CepSearchDto> response =
				restTemplate.getForEntity(
						String.format("https://viacep.com.br/ws/%s/json", cep),
						CepSearchDto.class);
		return response.getBody();
	}

}

