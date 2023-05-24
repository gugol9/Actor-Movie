package com.example.movie.Repository;

import com.example.movie.DTO.FilmRatingDTO;
import com.example.movie.Model.Film;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface FilmRepository extends JpaRepository<Film,Long> {

    //top 10 movie potrzbean bedzie lista Rating i uzykac dostep do socreq

    //HTPPODPOWIADA UZYCIE DAO

    @Query( "SELECT new com.example.movie.DTO.FilmRatingDTO(f.title, SUM(r.score)) FROM Film f JOIN f.ratingList r GROUP BY f.title  ORDER BY SUM(r.score) DESC")
    List<FilmRatingDTO> top10FilmScore();


}
