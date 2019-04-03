package hello;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CountryRepository extends PagingAndSortingRepository<Country, Long> {

}
