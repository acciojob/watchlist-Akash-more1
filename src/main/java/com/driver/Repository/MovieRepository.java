package com.driver.Repository;

import com.driver.Model.Director;
import com.driver.Model.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Repository
public class MovieRepository {
  //  @Autowired


    HashMap<String,Movie> moviedb;
    HashMap<String, Director> directordb;

    HashMap<String, List<String>> dimodb;



    public MovieRepository(HashMap<String, Movie> moviedb, HashMap<String, Director> directordb, HashMap<String, List<String>> dimodb) {
        this.moviedb = moviedb;
        this.directordb = directordb;
        this.dimodb = dimodb;
    }
    public void addMovie(Movie movie){
        moviedb.put(movie.getName(),movie);
    }

    public  void addDirector(Director director){
        directordb.put(director.getName(),director);
        dimodb.put(director.getName(),new ArrayList<String>());
    }

    public void pair(String director,String movie ){
//        if(dimodb.containsKey(director.getName())==false){
//            dimodb.put(director.getName(),new ArrayList<Movie>());
//        }
        if(directordb.containsKey(director)==true && moviedb.containsKey(movie)==true){
            dimodb.get(director).add(movie);

        }

    }

    public Movie getMovie(String name){
        return moviedb.get(name);
    }

    public Director getDirector(String name){
        return directordb.get(name);
    }

    public List<String> getdimovies(String diName){
//        List<String> res=new ArrayList<>();
//        List<Movie> temp=dimodb.get(diName);
//        for(Movie ele:temp ){
//            res.add(ele.getName());
//        }
//        return res;
        return dimodb.get(diName);
    }
    public List<String> getAllmovies(){
        List<String> res=new ArrayList<>();

        for(String ele:moviedb.keySet() ){
            res.add(ele);
        }
        return res;
    }

    public void deleteDi(String diname){
        if(directordb.containsKey(diname)){
            directordb.remove(diname);
        }
        List<String> temp=dimodb.get(diname);

        for(String ele: temp){
            if(moviedb.containsKey(ele)){
                moviedb.remove(ele);
            }
        }

        if(dimodb.containsKey(diname)){
            dimodb.remove(diname);
        }
    }

    public  void deleteAllDi(){
        for(String ele: directordb.keySet()){
            deleteDi(ele);
        }
    }

    public HashMap<String, List<String>> showsize(){
        return dimodb;
    }
}
