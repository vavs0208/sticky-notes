package com.stickynotes.readservice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ReadController {
	@RequestMapping(value = "/health", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<String> health() {
			String serverStatus = "All OK";
			return new ResponseEntity<String>(serverStatus,HttpStatus.OK);
		}
}
