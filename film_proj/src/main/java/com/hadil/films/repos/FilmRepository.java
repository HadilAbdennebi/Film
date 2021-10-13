package com.hadil.films.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.hadil.films.entities.Film;
import com.hadil.films.entities.Genre;

public interface FilmRepository extends JpaRepository<Film, Long> {
		List<Film> findByNomFilm(String nom);
		 List<Film> findByNomFilmContains(String nom);
		 
		//@Query("select p from Film p where p.nomFilm like %?1 and p.prixTicket > ?2")
		 //List<Film> findByNomPrix (String nom, Double prix);*/

		/* @Query("select p from Film p where p.nomFilm like %:nom and p.prixTicket > :prix")
		// List<Film> findByNomPrix (@Param("nom") String nom,@Param("prix") Double prix);

		 @Query("select p from Film p where p.genre = ?1")
		 List<Film> findByGenre (Genre genre);
		 List<Film> findByGenreIdGen(Long id);*/
		 
		 
		 @Query("select p from Film p order by p.nomFilm ASC, p.prixTicket DESC")
		 List<Film> trierFilmsNomsPrix ();
		List<Film> findByGenreId(long l);
		 
	//	 default List<Film> findByOrderByNomFilmAsc() {
			
		/*	 @Query("select p from Film p order by p.nomFilm ASC, p.prixFilm DESC")
			 List<Film> trierFilmsNomsPrix1 ();
			List<Film> findByOrderByNomFilmAsc();
			List<Film> findByGenre(Genre gen);*/

}
		 
