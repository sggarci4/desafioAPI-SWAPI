package com.gustavogarcia.desafioswapi.models;

public class Movie {
    private String title;
    private int numberOfEpisode;
    private String director;
    private String producer;
    private String releaseDate;

    public Movie(MovieSWAPI movieSWAPI) {
        this.title = movieSWAPI.title();
        this.numberOfEpisode = movieSWAPI.episode_id();
        this.director = movieSWAPI.director();
        this.producer = movieSWAPI.producer();
        this.releaseDate = movieSWAPI.release_date();
    }

    public String getTitle() {
        return title;
    }

    public int getNumberOfEpisode() {
        return numberOfEpisode;
    }

    public String getDirector() {
        return director;
    }

    public String getProducer() {
        return producer;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    @Override
    public String toString() {
        return """
                ****************************
                Title : %s
                Number of the episode: %d
                Director: %s
                Producer: %s
                Release Date: %s
                ****************************
                """.formatted(title,numberOfEpisode,director,producer,releaseDate);
    }
}
