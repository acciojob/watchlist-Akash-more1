package com.driver.Service;

import com.driver.Model.Director;
import com.driver.Model.Movie;
import com.driver.Repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class MovieService {
//@Autowired
MovieRepository movieRepository;
    public MovieService() {
        movieRepository =new MovieRepository();
    }


public void addMovie(Movie movie){
    movieRepository.addMovie(movie);
}
public  void addDi(Director director){
    movieRepository.addDirector(director);
}

public  void pair (String director, String movie){
    movieRepository.pair(director,movie);
}
public Movie getMovie(String movie){
    return movieRepository.getMovie(movie);
}

public Director getDirector(String director){
    return movieRepository.getDirector(director);
}

public List<String> getDiMo(String director){
    return movieRepository.getdimovies(director);
}
public  List<String> getAllMo(){
    return movieRepository.getAllmovies();
}
public void deleteDi(String director){
    movieRepository.deleteDi(director);
}
public void deleteAllDi(){
    movieRepository.deleteAllDi();
}

    public HashMap<String, List<String>> showsize(){
        return movieRepository.showsize();
    }
}
