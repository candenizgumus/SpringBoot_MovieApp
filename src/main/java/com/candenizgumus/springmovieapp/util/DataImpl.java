package com.candenizgumus.springmovieapp.util;

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
import java.util.Arrays;

@Component
public class DataImpl implements ApplicationRunner
{

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


    @Override
    public void run(ApplicationArguments args) throws Exception
    {
        saveMoviesFromTvMaze();
    }
}