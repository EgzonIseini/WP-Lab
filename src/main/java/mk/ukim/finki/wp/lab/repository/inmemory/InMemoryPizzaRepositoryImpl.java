package mk.ukim.finki.wp.lab.repository.inmemory;

import mk.ukim.finki.wp.lab.repository.PizzaRepository;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

@Profile("in-memory-rep")
@Repository
public abstract class InMemoryPizzaRepositoryImpl implements PizzaRepository {
}
