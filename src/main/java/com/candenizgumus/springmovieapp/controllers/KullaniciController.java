package com.candenizgumus.springmovieapp.controllers;

import com.candenizgumus.springmovieapp.dto.request.KullaniciLoginDto;
import com.candenizgumus.springmovieapp.dto.request.KullaniciRegisterDto;
import com.candenizgumus.springmovieapp.dto.request.KullaniciSaveDto;
import com.candenizgumus.springmovieapp.dto.response.KullaniciRegisterResponseDto;
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


    @GetMapping("/findallbyname")
    public ResponseEntity<List<Kullanici>> findAllByOrderByName(){
        return ResponseEntity.ok(kullaniciService.findAllByOrderByName());
    }

    @GetMapping("/findemailbycontaining")
    public ResponseEntity<List<Kullanici>> findAllByEmailContaining(String metin){
        return ResponseEntity.ok(kullaniciService.findAllByEmailContaining(metin));
    }

    @GetMapping("/findemailendswith")
    public ResponseEntity<List<Kullanici>> findAllByEmailEndingWith(String metin){
        return ResponseEntity.ok(kullaniciService.findAllByEmailEndingWith(metin));
    }

    @GetMapping("/isemailandpasswordcorrectofkullanici")
    public ResponseEntity<Boolean> findAllByEmailEndingWith(String email,String password){
        return ResponseEntity.ok(kullaniciService.findByEmailAndPasswordIsTrue(email,password));
    }

    @GetMapping("/findkullanicibylengthofpassword")
    public ResponseEntity<List<Kullanici>> findKullaniciByLengthOfPassword(int uzunluk){
        return ResponseEntity.ok(kullaniciService.findKullaniciByLengthOfPassword(uzunluk));
    }

    @PostMapping("/register")
    public ResponseEntity<KullaniciRegisterResponseDto> register(KullaniciRegisterDto dto){
       return ResponseEntity.ok(kullaniciService.register(dto));
    }

    @PostMapping("/login")
    public ResponseEntity<Long> login(KullaniciLoginDto dto){
        return ResponseEntity.ok(kullaniciService.login(dto));
    }
}
