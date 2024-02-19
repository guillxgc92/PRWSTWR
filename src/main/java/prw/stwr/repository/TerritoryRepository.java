package prw.stwr.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import prw.stwr.model.Territory;

@Repository
public interface TerritoryRepository extends JpaRepository<Territory, Integer>{

}
