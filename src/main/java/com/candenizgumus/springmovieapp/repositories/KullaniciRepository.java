package com.candenizgumus.springmovieapp.repositories;

import com.candenizgumus.springmovieapp.entities.Kullanici;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface KullaniciRepository extends JpaRepository<Kullanici,Long>
{

    //Dışarıdan girilen değer hangi kullanıcıların isimlerinde mevcuttur.
    List<Kullanici> findAllByNameIgnoreCase(String ad);

    //Emaillerini içinde belirlediğimiz değer geçen kullanıcılar
    List<Kullanici> findAllByEmailContaining(String metin);

    //Emaillerde belirlenen değere göre biten
    List<Kullanici> findAllByEmailEndingWith(String metin);

    //Email ve password'e göre kullanıcı kontrolü

    Optional<Kullanici> findByEmailAndPassword(String email, String password);

    //Passwordu uzunluğu belirlediğimiz sayıdan büyük olanlar
    @Query("SELECT k FROM Kullanici  k WHERE length(k.password)  >= :uzunluk")
    List<Kullanici> findKullaniciByLengthOfPassword(int uzunluk);
}
