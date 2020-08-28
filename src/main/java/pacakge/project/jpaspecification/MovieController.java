package pacakge.project.jpaspecification;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import pacakge.project.util.AppConstant.SearchOperation;

@RestController
@RequestMapping(value="/movie" )
public class MovieController {
	@Autowired MovieRepository movieRepository;
	
	
	@RequestMapping(method = RequestMethod.GET)
	public List<Movie> findAllMovies() {
		List<Movie> movies = new ArrayList<>();
		movieRepository.findAll().forEach(movies::add);
		return movies;
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/save")
	public void addCourse(@RequestBody Movie movie) {
		movieRepository.save(movie);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/saveDummy")
	public void addDummyMovies() {
		movieRepository.saveAll(Arrays.asList(
                new Movie("Troy", "Drama", 7.2, 196, 2004),
                new Movie("The Godfather", "Crime", 9.2, 178, 1972),
                new Movie("Invictus", "Sport", 7.3, 135, 2009),
                new Movie("Black Panther", "Action", 7.3, 135, 2018),
                new Movie("Joker", "Drama", 8.9, 122, 2018),
                new Movie("Iron Man", "Action", 8.9, 126, 2008)
        ));
	}
	
	// search movies by `title` and `rating` > 7
	@RequestMapping(method = RequestMethod.GET, value = "/search")
	public List<Movie> searchMovie() {
		  MovieSpecification msTitleRating = new MovieSpecification();
		    msTitleRating.add(new SearchCriteria("title", "black", SearchOperation.MATCH));
		    msTitleRating.add(new SearchCriteria("rating", 7, SearchOperation.GREATER_THAN));
		    List<Movie> msTitleRatingList = movieRepository.findAll(msTitleRating);
		   return msTitleRatingList;
	}
	
	// search movies by `title` <> 'Joker' and paginate results
	@RequestMapping(method = RequestMethod.GET, value = "/searchpage")
	public Page<Movie> pageableSearch() {
        MovieSpecification msTitle = new MovieSpecification();
        msTitle.add(new SearchCriteria("title", "Joker", SearchOperation.NOT_EQUAL));
        Pageable pageable = PageRequest.of(0, 3, Sort.by("releaseYear").descending());
        Page<Movie> msTitleList = movieRepository.findAll(msTitle, pageable);

        return msTitleList;
	
	}
	 
	
	public void operation() {

        // search movies by `genre`
        MovieSpecification msGenre = new MovieSpecification();
        msGenre.add(new SearchCriteria("genre", "Action", SearchOperation.EQUAL));
        List<Movie> msGenreList = movieRepository.findAll(msGenre);
        msGenreList.forEach(System.out::println);

       

        // search movies by release year < 2010 and rating > 8
        MovieSpecification msYearRating = new MovieSpecification();
        msYearRating.add(new SearchCriteria("releaseYear", 2010, SearchOperation.LESS_THAN));
        msYearRating.add(new SearchCriteria("rating", 8, SearchOperation.GREATER_THAN));
        List<Movie> msYearRatingList = movieRepository.findAll(msYearRating);
        msYearRatingList.forEach(System.out::println);

        // search movies by watch time >= 150 and sort by `title`
        MovieSpecification msWatchTime = new MovieSpecification();
        msWatchTime.add(new SearchCriteria("watchTime", 150, SearchOperation.GREATER_THAN_EQUAL));
        List<Movie> msWatchTimeList = movieRepository.findAll(msWatchTime, Sort.by("title"));
        msWatchTimeList.forEach(System.out::println);

        // search movies by `title` <> 'white' and paginate results
        MovieSpecification msTitle = new MovieSpecification();
        msTitle.add(new SearchCriteria("title", "white", SearchOperation.NOT_EQUAL));

        Pageable pageable = PageRequest.of(0, 3, Sort.by("releaseYear").descending());
        Page<Movie> msTitleList = movieRepository.findAll(msTitle, pageable);

        msTitleList.forEach(System.out::println);
	}
}
