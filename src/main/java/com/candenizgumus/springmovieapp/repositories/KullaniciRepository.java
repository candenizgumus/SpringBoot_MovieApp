package com.candenizgumus.springmovieapp.repositories;

import com.candenizgumus.springmovieapp.entities.Kullanici;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KullaniciRepository extends JpaRepository<Kullanici,Long>
{
}
