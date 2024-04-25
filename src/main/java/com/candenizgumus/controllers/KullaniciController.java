package com.candenizgumus.controllers;

import com.candenizgumus.services.GenreService;
import com.candenizgumus.services.KullaniciService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/kullanici")
@RequiredArgsConstructor
public class KullaniciController
{
    private final KullaniciService kullaniciService;

}
