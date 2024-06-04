package com.gustavogarcia.desafioswapi.models;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {
    public void showMenu() {

        Scanner scanner = new Scanner(System.in);
        MovieBrowser movieBrowser = new MovieBrowser();
        try {
            while (true) {
                System.out.println("Put the number of the Star Wars movie that you want to see: ");
                var idMovie = scanner.nextInt();

                if (idMovie > 6) {
                    System.out.println("Movie not found");
                    break;
                } else if (idMovie == 0) {
                    System.out.println("Thanks for use this app");
                    movieBrowser.saveAFile();
                    break;
                }
                movieBrowser.searchMovie(idMovie);

            }
        } catch (InputMismatchException e) {
            System.out.println("It was just happened an error with the entered value: ");
        } catch (Exception e) {
            System.out.println("Unexpected Error");
            System.out.println(e.getMessage());
        }
    }
}
