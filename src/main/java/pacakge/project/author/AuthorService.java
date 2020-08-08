package pacakge.project.author;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

// Service annotation define a class as businees 
@Service
public class AuthorService {

	@Autowired
	private AuthorRepository authorRepository;

	@Autowired
	private EntityManager entityManager;

	public List<Author> getAllAuthors() {
		List<Author> topics = new ArrayList<>();
		authorRepository.findAll().forEach(topics::add);
		return topics;
	}
	public List<Author> searchAuthor() {
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Author> criteriaQuery = criteriaBuilder.createQuery(Author.class);
		Root<Author> root = criteriaQuery.from(Author.class);
		
		List<Predicate> searchCriterias= new ArrayList<>();
		searchCriterias.add(criteriaBuilder.like(root.get("firstName"), "%kap%"));
		
		criteriaQuery.select(root).where(criteriaBuilder.and(searchCriterias.toArray(new Predicate[searchCriterias.size()])));
	
		return entityManager.createQuery(criteriaQuery).getResultList();
		
		
//		LocalDate today = new LocalDate();
//		CriteriaBuilder builder = em.getCriteriaBuilder();
//		CriteriaQuery<Customer> query = builder.createQuery(Customer.class);
//		Root<Customer> root = query.from(Customer.class);
//		Predicate hasBirthday = builder.equal(root.get(Customer_.birthday), today);
//		Predicate isLongTermCustomer = builder.lessThan(root.get(Customer_.createdAt), today.minusYears(2); 
//		query.where(builder.and(hasBirthday, isLongTermCustomer));
//		em.createQuery(query.select(root)).getResultList();
		
	}
}
