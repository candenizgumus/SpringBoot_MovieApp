package com.candenizgumus.services;

import com.candenizgumus.entities.Genre;
import com.candenizgumus.entities.Kullanici;
import com.candenizgumus.repositories.GenreRepository;
import com.candenizgumus.repositories.KullaniciRepository;
import com.candenizgumus.utility.ServiceManager;
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
}
