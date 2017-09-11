package cz.honza.test.demo.lide;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ClovekRepository extends CrudRepository<Clovek,Integer> {

	@Query(" FROM Clovek c Order by c.jmeno")
	List<Clovek> najdiVsechnyLidi();
	
	@Query(" FROM Clovek c where c.id=:idsss")
	Clovek najdiClovek(@Param("idsss") Integer id);
	
	@Query("FROM Clovek c where c.jmeno=:jmeno AND c.prijmeni=:prijmeni")
	List<Clovek> najdiPodleJmenaAPrijmeni(@Param("jmeno") String jmeno,@Param("prijmeni") String prijmeni);
	
	@Query("FROM Clovek c where c.vek>:vek")
	List<Clovek> najdiPodleVeku(@Param("vek") Integer vek);
	
	@Query("FROM Clovek c where c.vek>:vek AND c.pohlavi=:pohlavi")
	List<Clovek> najdiPodleVekuAPohlavi(@Param("vek") Integer vek, @Param("pohlavi") String pohlavi);

	@Query("FROM Clovek c where c.heslo=:heslo AND c.nick=:nick")
	List<Clovek> najdiPodleHesla(String heslo, String nick);
	
	@Query("FROM Clovek c where c.nick=:nick")
	List<Clovek> najdiPodleNick(@Param("nick") String nick);
}
