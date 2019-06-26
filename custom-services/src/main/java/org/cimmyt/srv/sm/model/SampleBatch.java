package org.cimmyt.srv.sm.model;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(schema = "sm", name = "sample_batch")
public class SampleBatch {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    private String description;
    @Column(name = "creation_timestamp")
    private Timestamp creationTimestamp;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Timestamp getCreationTimestamp() {
        return creationTimestamp;
    }

    public void setCreationTimestamp(Timestamp creationTimestamp) {
        this.creationTimestamp = creationTimestamp;
    }

    @Override
    public String toString() {
        return String.format("{SampleBatch %s: %s}",id, description);
    }
}
