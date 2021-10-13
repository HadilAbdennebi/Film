package com.hadil.films;

import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;

import com.hadil.films.entities.Film;
import com.hadil.films.entities.Genre;
import com.hadil.films.repos.FilmRepository;
//import com.hadil.films.service.FilmService;

@SpringBootTest
class FilmsApplicationTests {

	@Autowired
	private FilmRepository filmRepository;

	//@Autowired
	//private FilmService filmService;

	@Test
	public void testCreateFilm() {
		Film film = new Film("Iron man", 20000.0, new Date());

		filmRepository.save(film);
	}
//
	@Test
	public void testFindFilm() {
		Film f = filmRepository.findById(1L).get();
		System.out.println(f);
	}

	@Test
	public void testUpdateFilm() {
		Film f = filmRepository.findById(1L).get();
		f.setPrixTicket(10000.0);
		filmRepository.save(f);
	}

	@Test
	public void testDeleteFilm() {
		filmRepository.deleteById(1L);
		;
	}

	@Test
	public void testListerTousFilms() {
		List<Film> films = filmRepository.findAll();
		for (Film f : films) {
			System.out.println(f);
		}
	}
	/*
	 * @Test public void testFindByNomFilmContains() { Page<Film> films =
	 * filmService.getAllFilmsParPage(0, 2); System.out.println(films.getSize());
	 * System.out.println(films.getTotalElements());
	 * System.out.println(films.getTotalPages()); films.getContent().forEach(p -> {
	 * System.out.println(p.toString()); }); /* ou bien for (Produit p : prods) {
	 * System.out.println(p); }
	 * 
	 * }
	 */

	@Test
	public void testFindByNomFilm() {
		List<Film> films = filmRepository.findByNomFilm("Titanic");
		for (Film p : films) {
			System.out.println(p);
		}
	}

	@Test
	public void testFindByNomFilmContains() {
		List<Film> films = filmRepository.findByNomFilmContains("Iron");
		for (Film p : films) {
			System.out.println(p);
		}
	}
	/*
	@Test
	public void testfindByGenre()
	{
		Genre gen = new Genre();
		//gen.setIdGen(1L);
		List<Film> films = filmRepository.findByGenre(gen);
		for (Film f : films)
			{
				System.out.println(f);
			}

	}*/
	/*
	@Test
	public void testfindByNomPrix() {
		List<Film> prods = filmRepository.findByNomPrix("Frozen", 1000.0);
		for (Film p : prods) {
			System.out.println(p);
		}
	}
	
	@Test
	public void testfindByOrderByNomFilmAsc()
	{
	List<Film> films = filmRepository.findByOrderByNomFilmAsc();
	for (Film p : films)
	{
	System.out.println(p);
	}
	}
	/*
	@Test
	public void testTrierFilmsNomsPrix()
	{
	List<Film> films = filmRepository.trierFilmsNomsPrix();
	for (Film p : films)
	{
	System.out.println(p);
	}
	}

	@Test
	public void findByCategorieIdCat()
		{
			List<Film> films = filmRepository.findByGenreId(1L);
		for (Film p : films)
			{
			System.out.println(p);
			}

	}

*/

	
}
