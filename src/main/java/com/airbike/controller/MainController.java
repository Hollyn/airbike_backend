package com.airbike.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.core.io.ClassPathResource;
import org.springframework.http.MediaType;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api")
public class MainController {

	@GetMapping(value = "/image/{imgName}")

	public void getImage(HttpServletResponse response, @PathVariable(value = "imgName") String imgName)
			throws IOException {

		ClassPathResource imgFile = new ClassPathResource("image/" + imgName);

		response.setContentType(MediaType.IMAGE_PNG_VALUE);
		StreamUtils.copy(imgFile.getInputStream(), response.getOutputStream());
	}

}
