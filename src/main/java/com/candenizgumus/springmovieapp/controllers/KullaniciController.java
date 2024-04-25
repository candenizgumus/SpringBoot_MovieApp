package com.candenizgumus.springmovieapp.controllers;

import com.candenizgumus.springmovieapp.dto.request.KullaniciSaveDto;
import com.candenizgumus.springmovieapp.entities.Kullanici;
import com.candenizgumus.springmovieapp.services.KullaniciService;
import com.candenizgumus.springmovieapp.constants.EndPoints;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(EndPoints.KULLANICI)
@RequiredArgsConstructor
public class KullaniciController
{
    private final KullaniciService kullaniciService;

    @PostMapping(EndPoints.SAVEDTO)
    @CrossOrigin("*")
    public ResponseEntity<Kullanici> saveDto(@RequestBody KullaniciSaveDto dto)
    {
        return ResponseEntity.ok( kullaniciService.saveDto(dto));
    }
    @PostMapping(EndPoints.SAVE)
    @CrossOrigin("*")
    public ResponseEntity<Kullanici> save(@RequestBody Kullanici kullanici)
    {
        return ResponseEntity.ok( kullaniciService.save(kullanici));
    }
    @GetMapping(EndPoints.FINDALL)
    @CrossOrigin("*")
    public ResponseEntity<List<Kullanici>> findAll()
    {
        return ResponseEntity.ok(kullaniciService.findAll());
    }
}
