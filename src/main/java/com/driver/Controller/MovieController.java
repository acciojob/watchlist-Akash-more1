package com.driver.Controller;

import com.driver.Model.Director;
import com.driver.Model.Movie;
import com.driver.Service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
public class MovieController {

    //@Autowired
    MovieService movieService=new MovieService();

    @PostMapping("/movies/add-movie")
    public ResponseEntity<String> addMovie(@RequestBody Movie movie){
        movieService.addMovie(movie);
       // String str="Successfully added";
        return new ResponseEntity<>("Movie added Successfully", HttpStatus.OK);
    }

    @PostMapping("/movies/add-director")
    public ResponseEntity<String> addDirector(@RequestBody Director director){
        movieService.addDi(director);
        return new ResponseEntity<>("Director added Successfully", HttpStatus.OK);
    }
    @RequestMapping("/movies/add-movie-director-pair")
@PutMapping
    public  ResponseEntity<String> addMovieDirectorPair(@RequestParam String movie, @RequestParam String director){
        movieService.pair(director,movie);
        return new ResponseEntity<>("Movie-Director added Successfully", HttpStatus.OK);
    }
@GetMapping("/movies/get-movie-by-name/{name}")
    public ResponseEntity<Movie> getMovieByName(@PathVariable String name){
      Movie temp=  movieService.getMovie(name);

      return new ResponseEntity<>(temp, HttpStatus.OK);
    }
    @GetMapping("/movies/get-director-by-name/{name}")
    public ResponseEntity<Director>  getDirectorByName(@PathVariable String name){
        Director temp=movieService.getDirector(name);
        return new ResponseEntity<>(temp, HttpStatus.OK);
    }
@GetMapping("/movies/get-movies-by-director-name/{director}")
    public ResponseEntity<List<String>> getMoviesByDirectorName(@PathVariable String director){
        List<String> temp=movieService.getDiMo(director);
         System.out.print(temp.size());
        return new ResponseEntity<>(temp, HttpStatus.OK);
    }
@GetMapping("/movies/get-all-movies")
    public ResponseEntity<List<String>> findAllMovies(){
        List<String> temp=movieService.getAllMo();
    System.out.print(temp.size());
        return new ResponseEntity<>(temp, HttpStatus.OK);
    }
    @DeleteMapping("/movies/delete-director-by-name")
    public  ResponseEntity<String> deleteDirectorByName(@RequestParam String director){
        movieService.deleteDi(director);
        return  new ResponseEntity<>("Successfully deleted director movies", HttpStatus.OK);
    }
@DeleteMapping("/movies/delete-all-directors")
    public  ResponseEntity<String> deleteAllDirectors(){
        movieService.deleteAllDi();
        return  new ResponseEntity<>("Successfully deleted ALL director movies", HttpStatus.OK);
    }
    @GetMapping("api/showsize/modidb")
    public ResponseEntity<HashMap<String, List<String>>> showsize(){
        HashMap<String, List<String>> tempo=  movieService.showsize();
        return new ResponseEntity<>(tempo,HttpStatus.OK );
    }
}
