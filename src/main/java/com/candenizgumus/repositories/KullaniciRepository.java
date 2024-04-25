package com.candenizgumus.repositories;

import com.candenizgumus.entities.Genre;
import com.candenizgumus.entities.Kullanici;
import org.springframework.data.jpa.repository.JpaRepository;

public interface KullaniciRepository extends JpaRepository<Kullanici,Long>
{
}
