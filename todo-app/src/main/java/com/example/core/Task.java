package com.example.core;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Table;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name = "Task")
@NamedQueries({
        @NamedQuery(name = "com.example.core.Task.getAllTasks", query = "SELECT T FROM Task T" +
                " where T.status = :status"),
        @NamedQuery(name = "com.example.core.Task.deleteById", query = "DELETE FROM Task T" + " WHERE T.id = :id")
})

public class Task {
    @Id
    @JsonProperty("id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @JsonProperty("title")
    @Column(name = "title")
    private String title;

    @JsonProperty("description")
    @Column(name = "description")
    private String description;

    @JsonProperty("startDate")
    @Column(name = "startDate", columnDefinition = "DATETIME")
    @Temporal(TemporalType.TIMESTAMP)
    private Date startDate = Timestamp.from(Instant.now());
//
    @JsonProperty("endDate")
    @Column(name = "endDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date endDate;

    @JsonProperty("status")
    @Column(name = "status")
    private String status = "TODO";

    public long getTaskId() {
        return id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }
//
    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public Date getStartDate() {
        return startDate;
    }
//
    public Date getEndDate() {
        return endDate;
    }

    public String getStatus() {
        return status;
    }
}
