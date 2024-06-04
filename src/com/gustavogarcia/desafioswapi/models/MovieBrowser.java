package com.gustavogarcia.desafioswapi.models;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

public class MovieBrowser {
    int idMovie;
    String address;
    String json;
    List<Movie> movies = new ArrayList<>();
    Gson gson = new GsonBuilder()
            .setPrettyPrinting()
            .create();

    public void searchMovie(int idMovie) throws IOException, InterruptedException {
        this.idMovie = idMovie;
        this.address = "https://swapi.py4e.com/api/films/" + this.idMovie + "/";
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(address))
                .build();
        HttpResponse<String> response = client
                .send(request, HttpResponse.BodyHandlers.ofString());

        json = response.body();
        MovieSWAPI movieSWAPI = gson.fromJson(json, MovieSWAPI.class);
        Movie movie = new Movie(movieSWAPI);
        System.out.println(movie);
        movies.add(movie);
    }

    public void saveAFile() {
        System.out.println("Lista:\n" + movies);
        try {
            FileWriter fileWriter = new FileWriter("movies.json");
            fileWriter.write(gson.toJson(movies));
            fileWriter.close();

        } catch (IOException e) {
            System.out.println("It happened just an error with: ");
            System.out.println(e.getMessage());
        }
    }
}
