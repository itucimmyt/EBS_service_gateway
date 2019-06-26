package org.cimmyt.srv.sm.model.repo;

import org.cimmyt.srv.sm.model.SampleBatch;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SampleBatchRepository extends JpaRepository<SampleBatch, Integer> {
}
