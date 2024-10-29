package com.example.urlshortener.controller;

import com.example.urlshortener.model.Url;
import com.example.urlshortener.service.UrlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class UrlController {

    @Autowired
    private UrlService urlService;

    @GetMapping("/")
    public String home() {
        return "index";
    }

    @PostMapping("/shorten-url")
    @ResponseBody
    public String shortenUrl(@RequestBody Map<String, String> request) {
        String originalUrl = request.get("originalUrl");
        return urlService.shortenUrl(originalUrl);
    }

    @GetMapping("/{shortUrl}")
    public ResponseEntity<?> redirect(@PathVariable String shortUrl) {
        Optional<Url> url = urlService.getOriginalUrl(shortUrl);
        return url.map(u -> ResponseEntity.status(HttpStatus.FOUND)
                .location(URI.create(u.getOriginalUrl()))
                .build())
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }
}
