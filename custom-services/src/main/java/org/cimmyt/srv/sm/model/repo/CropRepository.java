package org.cimmyt.srv.sm.model.repo;

import org.cimmyt.srv.sm.model.Crop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CropRepository extends JpaRepository<Crop,Integer> {

}
