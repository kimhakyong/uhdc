package com.example.uhdc.error;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/error")
public class ErrorController {
    @GetMapping("/{statusCode}")
    public ResponseEntity<ResponseData> status404(@PathVariable int statusCode) {
//        HttpHeaders headers= new HttpHeaders();
//        headers.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));

        StatusEnum statusEnum = StatusEnum.resolve(statusCode);
        return new ResponseEntity<>(statusEnum.getResponseData(), statusEnum.getHttpStatus());
    }
}
