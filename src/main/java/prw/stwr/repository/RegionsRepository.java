package prw.stwr.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import prw.stwr.model.Regions;

@Repository
public interface RegionsRepository extends JpaRepository<Regions, Integer>{

}
