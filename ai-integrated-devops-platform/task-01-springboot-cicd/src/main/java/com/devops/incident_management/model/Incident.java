package com.devops.incident_management.model;

public class Incident {

    private Long id;
    private String title;
    private String description;
    private String type;
    private String status;

    public Incident() {
    }

    public Incident(Long id, String title, String description, String type, String status) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.type = type;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}