package com.candenizgumus.springmovieapp.services;

import com.candenizgumus.springmovieapp.dto.request.KullaniciSaveDto;
import com.candenizgumus.springmovieapp.entities.Kullanici;
import com.candenizgumus.springmovieapp.mappers.KullaniciMapper;
import com.candenizgumus.springmovieapp.repositories.KullaniciRepository;
import com.candenizgumus.springmovieapp.utility.ServiceManager;
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

    public List<Kullanici> findAllByNameIgnoreCase(String ad){
        return kullaniciRepository.findAllByNameIgnoreCase(ad);
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


}
