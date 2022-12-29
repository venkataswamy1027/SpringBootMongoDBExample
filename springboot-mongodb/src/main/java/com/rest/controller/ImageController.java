package com.rest.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.rest.collection.Image;
import com.rest.service.ImageService;

import java.io.IOException;

@RestController
@RequestMapping("/image")
public class ImageController {

	@Autowired
    private ImageService imageService;

    @PostMapping
    public Image addImage(@RequestParam("image") MultipartFile image) throws IOException {
        return imageService.addImage(image.getOriginalFilename(),image);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Resource> downloadImage(@PathVariable String id) {
        Image image = imageService.getImageById(id);
        Resource resource
                = new ByteArrayResource(image.getImage().getData());

        return  ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + image.getTitle() + "\"")
                .contentType(MediaType.APPLICATION_OCTET_STREAM)
                .body(resource);
    }
}
