package org.cimmyt.srv.sm.model;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(schema="sm")
public class Request {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private
    int id;
    @ManyToOne
    @JoinColumn(name = "crop_id")
    private
    Crop crop;
    @Column(name = "comments")
    private
    String comments;
    @Column(name = "creation_timestamp")
    private
    Timestamp creation;
    @Column(name = "experiment_name")
    private
    String experimentName;
    @Column(name = "ticket_number")
    private
    String ticketNumber;
    @Column(name = "request_status_id")
    private
    Integer statusId;
    @Column(name = "service_id")
    private
    Integer serviceId;
    @Column(name = "subservice_id")
    private
    Integer subserviceId;
    @Column(name = "user_id")
    private
    Integer userId;
    @Column(name = "sample_batch_id")
    private
    Integer sampleBatchId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Crop getCrop() {
        return crop;
    }

    public void setCrop(Crop crop) {
        this.crop = crop;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public Timestamp getCreation() {
        return creation;
    }

    public void setCreation(Timestamp creation) {
        this.creation = creation;
    }

    public String getExperimentName() {
        return experimentName;
    }

    public void setExperimentName(String experimentName) {
        this.experimentName = experimentName;
    }

    public String getTicketNumber() {
        return ticketNumber;
    }

    public void setTicketNumber(String ticketNumber) {
        this.ticketNumber = ticketNumber;
    }

    public Integer getStatusId() {
        return statusId;
    }

    public void setStatusId(Integer statusId) {
        this.statusId = statusId;
    }

    public Integer getServiceId() {
        return serviceId;
    }

    public void setServiceId(Integer serviceId) {
        this.serviceId = serviceId;
    }

    public Integer getSubserviceId() {
        return subserviceId;
    }

    public void setSubserviceId(Integer subserviceId) {
        this.subserviceId = subserviceId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getSampleBatchId() {
        return sampleBatchId;
    }

    public void setSampleBatchId(Integer sampleBatchId) {
        this.sampleBatchId = sampleBatchId;
    }

    @Override
    public String toString() {
        return String.format("{Request %s: %s, status-%s}", id, ticketNumber, statusId);
    }
}
