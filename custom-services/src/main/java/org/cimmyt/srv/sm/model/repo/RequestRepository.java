package org.cimmyt.srv.sm.model.repo;

import org.cimmyt.srv.sm.model.Request;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.Set;

public interface RequestRepository extends JpaRepository<Request, Integer> {
    /**
     * Updates the Sample Batch this Request is associated to
     * @param batchId to associate with
     * @param sampleRequestIds of the requests to associate to a Batch
     * @return
     */
    @Modifying
    @Query("update Request r set r.sampleBatchId = :batchId, r.statusId = :statusId where id in (:sampleRequestIds)")
    public int updateSampleBatch(int batchId, Set<Integer> sampleRequestIds, int statusId);
}
