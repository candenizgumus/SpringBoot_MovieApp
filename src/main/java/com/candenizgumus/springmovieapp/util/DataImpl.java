package com.candenizgumus.springmovieapp.util;

import com.candenizgumus.springmovieapp.entities.Kullanici;
import com.candenizgumus.springmovieapp.entities.Movie;
import com.candenizgumus.springmovieapp.entities.MovieComment;
import com.candenizgumus.springmovieapp.services.GenreService;
import com.candenizgumus.springmovieapp.services.KullaniciService;
import com.candenizgumus.springmovieapp.services.MovieService;
import com.candenizgumus.springmovieapp.util.data.Root;
import com.google.gson.Gson;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

@Component
public class DataImpl implements ApplicationRunner
{
    private final GenreService genreService;
    private final MovieService movieService;
    private final KullaniciService kullaniciService;

    public DataImpl(GenreService genreService, MovieService movieService, KullaniciService kullaniciService)
    {
        this.genreService = genreService;
        this.movieService = movieService;
        this.kullaniciService = kullaniciService;
    }

    public Root[] saveMoviesFromTvMaze()
    {
        {
            try
            {
                URL url = new URL("https://api.tvmaze.com/shows");
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();

                InputStream inputStream = connection.getInputStream();
                BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
                String jsonIcerik = "";
                jsonIcerik = reader.readLine();

                 Root[] movieArray = new Gson().fromJson(jsonIcerik, Root[].class );


                return movieArray;

            } catch (MalformedURLException e)
            {
                throw new RuntimeException(e);
            } catch (IOException e)
            {
                throw new RuntimeException(e);
            }
        }


    }

    public void saveUsers(){
        Kullanici kullanici1 = Kullanici.builder()
                .name("Berkay")
                .surname("Güzel")
                .email("guzel@gmail.com")
                .phone("554124123")
                .password("1234")
                .favgenre(genreService.saveGenreString(List.of("Drama","Horror","AŞKKKKK")))
                .favmovie(movieService.findAllById(List.of(1L,15L,20L)))
                .build();

        kullanici1.setComment(List.of(

                MovieComment.builder().content("Çok iyi").movie(movieService.findById(1L).get()).kullanici(kullanici1).build(),
                MovieComment.builder().content("Fena iyi iyi").movie(movieService.findById(15L).get()).kullanici(kullanici1).build(),
                MovieComment.builder().content("Degşet iyi").movie(movieService.findById(25L).get()).kullanici(kullanici1).build()

        ));

        kullaniciService.save(kullanici1);


        Kullanici kullanici2 = Kullanici.builder()
                .name("Aslı")
                .surname("Mert")
                .email("asli@gmail.com")
                .phone("554124123")
                .password("1234")
                .favgenre(genreService.saveGenreString(List.of("Action","Adventure")))
                .favmovie(movieService.findAllById(List.of(2L,16L,21L)))
                .build();

        kullanici2.setComment(List.of(

                MovieComment.builder().content("Çok iyi").movie(movieService.findById(2L).get()).kullanici(kullanici2).build(),
                MovieComment.builder().content("Fena iyi iyi").movie(movieService.findById(16L).get()).kullanici(kullanici2).build(),
                MovieComment.builder().content("Degşet iyi").movie(movieService.findById(21L).get()).kullanici(kullanici2).build()

        ));

        kullaniciService.save(kullanici2);

        Kullanici kullanici3 = Kullanici.builder()
                .name("Kenan")
                .surname("Öktener")
                .email("kenan@gmail.com")
                .phone("554124123")
                .password("1234")
                .favgenre(genreService.saveGenreString(List.of("Mystery","Legal")))
                .favmovie(movieService.findAllById(List.of(3L,17L,22L)))
                .build();

        kullanici3.setComment(List.of(

                MovieComment.builder().content("Çok iyi").movie(movieService.findById(3L).get()).kullanici(kullanici3).build(),
                MovieComment.builder().content("Fena iyi iyi").movie(movieService.findById(17L).get()).kullanici(kullanici3).build(),
                MovieComment.builder().content("Manyak film dehşet iyi").movie(movieService.findById(22L).get()).kullanici(kullanici3).build()

        ));

        kullaniciService.save(kullanici3);




        Kullanici kullanici4 = Kullanici.builder()
                .name("Salih")
                .surname("Er")
                .email("salih@gmail.com")
                .phone("1235123")
                .password("12354")
                .favgenre(genreService.saveGenreString(List.of("Science-Fiction","War")))
                .favmovie(movieService.findAllById(List.of(5L)))
                .build();

        kullanici4.setComment(List.of(

                MovieComment.builder().content("Çok iyi").movie(movieService.findById(5L).get()).kullanici(kullanici4).build(),
                MovieComment.builder().content("Fena iyi iyi").movie(movieService.findById(22L).get()).kullanici(kullanici4).build(),
                MovieComment.builder().content("Manyak film dehşet iyi").movie(movieService.findById(17L).get()).kullanici(kullanici4).build()

        ));

        kullaniciService.save(kullanici4);



    }

    public void addMoviesToDatabaseFromAPI(Root[] movies){ //TODO tür varsa yeni tür yaratmasın bunu nasıl engelelyecez


        for (Root movie : movies)
        {

            movieService.save(
                    Movie.builder()

                            .language(movie.language)
                            .image(movie.image.medium)
                            .name(movie.name)
                            .country(movie.network != null ? movie.network.country.name : "Bilinmiyor")
                            .rating(movie.rating.average)
                            .summary(movie.summary)
                            .premiered(LocalDate.parse(movie.premiered)) //burada hata olabilir
                            .url(movie.url)
                            .genre(genreService.saveGenreString(movie.genres))
                            .build()
            );


        }
    }

    @Override
    public void run(ApplicationArguments args) throws Exception
    {

      /*  addMoviesToDatabaseFromAPI(saveMoviesFromTvMaze());
        saveUsers();*/
    }
}