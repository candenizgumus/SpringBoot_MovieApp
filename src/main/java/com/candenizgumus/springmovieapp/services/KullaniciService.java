package com.candenizgumus.springmovieapp.services;

import com.candenizgumus.springmovieapp.dto.request.KullaniciSaveDto;
import com.candenizgumus.springmovieapp.entities.Kullanici;
import com.candenizgumus.springmovieapp.mappers.KullaniciMapper;
import com.candenizgumus.springmovieapp.repositories.KullaniciRepository;
import com.candenizgumus.springmovieapp.utility.ServiceManager;
import org.springframework.stereotype.Service;

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
}
