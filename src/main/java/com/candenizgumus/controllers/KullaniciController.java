package com.candenizgumus.controllers;

import com.candenizgumus.entities.Genre;
import com.candenizgumus.entities.Kullanici;
import com.candenizgumus.services.GenreService;
import com.candenizgumus.services.KullaniciService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.candenizgumus.constants.EndPoints.*;
@RestController
@RequestMapping(KULLANICI)
@RequiredArgsConstructor
public class KullaniciController
{
    private final KullaniciService kullaniciService;

    @PostMapping(SAVE)
    @CrossOrigin("*")
    public ResponseEntity<Kullanici> save(@RequestBody Kullanici kullanici)
    {
        return ResponseEntity.ok( kullaniciService.save(kullanici));
    }

    @GetMapping(FINDALL)
    @CrossOrigin("*")
    public ResponseEntity<List<Kullanici>> findAll()
    {
        return ResponseEntity.ok(kullaniciService.findAll());
    }
}
