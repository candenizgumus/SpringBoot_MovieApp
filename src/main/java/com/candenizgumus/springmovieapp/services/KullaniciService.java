package com.candenizgumus.springmovieapp.services;

import com.candenizgumus.springmovieapp.dto.request.KullaniciLoginDto;
import com.candenizgumus.springmovieapp.dto.request.KullaniciRegisterDto;
import com.candenizgumus.springmovieapp.dto.request.KullaniciSaveDto;
import com.candenizgumus.springmovieapp.dto.response.KullaniciLoginResponseDto;
import com.candenizgumus.springmovieapp.dto.response.KullaniciRegisterResponseDto;
import com.candenizgumus.springmovieapp.entities.Kullanici;
import com.candenizgumus.springmovieapp.exceptions.ErrorType;
import com.candenizgumus.springmovieapp.exceptions.MovieAppException;
import com.candenizgumus.springmovieapp.mappers.KullaniciMapper;
import com.candenizgumus.springmovieapp.repositories.KullaniciRepository;
import com.candenizgumus.springmovieapp.utility.ServiceManager;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class KullaniciService extends ServiceManager<Kullanici,Long>
{
    private final KullaniciRepository kullaniciRepository;


    public KullaniciService(KullaniciRepository kullaniciRepository)
    {
        super(kullaniciRepository);
        this.kullaniciRepository = kullaniciRepository;
    }

    public Kullanici saveDto(KullaniciSaveDto dto)
    {
        return kullaniciRepository.save(KullaniciMapper.INSTANCE.kullaniciSaveDtoToKullanici(dto));
    }

    public List<Kullanici> findAllByOrderByName(){
        return kullaniciRepository.findAllByOrderByName();
    }

    public List<Kullanici> findAllByEmailContaining(String metin){
        return kullaniciRepository.findAllByEmailContaining(metin);
    }
    public List<Kullanici> findAllByEmailEndingWith(String metin){
        return kullaniciRepository.findAllByEmailEndingWith(metin);
    }

    public Boolean findByEmailAndPasswordIsTrue(String email,String password){

        Optional<Kullanici> kullanici = kullaniciRepository.findByEmailAndPassword(email, password);
        if (kullanici.isPresent())
        {
            return true;
        }
        return false;
    }

    public List<Kullanici> findKullaniciByLengthOfPassword(int uzunluk){
        return kullaniciRepository.findKullaniciByLengthOfPassword(uzunluk);
    }


    public KullaniciRegisterResponseDto register(  KullaniciRegisterDto dto)
    {
        if (!dto.password().equals(dto.repassword()))
        {
            throw new MovieAppException(ErrorType.PASSWORDS_ARE_NOT_SAME);

        }
        List<Kullanici> allByEmailContaining = findAllByEmailContaining(dto.email());
        if (!allByEmailContaining.isEmpty())
        {
            throw new MovieAppException(ErrorType.EMAIL_TAKEN);
        }

        Kullanici kaydedilenKullanici = kullaniciRepository.save(KullaniciMapper.INSTANCE.kullaniciRegisterDto(dto));
        return KullaniciMapper.INSTANCE.kullaniciToResponseDto(kaydedilenKullanici);
    }

    public KullaniciLoginResponseDto login(KullaniciLoginDto dto)
    {
        Optional<Kullanici> kullanici = kullaniciRepository.findByEmailAndPassword(dto.email(), dto.password());
        if (kullanici.isEmpty())
        {
            throw new MovieAppException(ErrorType.KULLANICI_NOT_FOUND);
        }

        return KullaniciMapper.INSTANCE.kullaniciToResponseid(kullanici.get());
    }
}
