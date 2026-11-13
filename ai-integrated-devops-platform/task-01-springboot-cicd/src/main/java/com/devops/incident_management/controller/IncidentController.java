
package com.devops.incident_management.controller;

import com.devops.incident_management.model.Incident;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@RestController
public class IncidentController {

    private final List<Incident> incidents = new ArrayList<>();
    private final AtomicLong counter = new AtomicLong(1);

    @GetMapping("/")
    public String home() {
        return "Smart Incident Management Platform is Running!";
    }

    @PostMapping("/api/incidents")
    public Incident createIncident(@RequestBody Incident incident) {

        incident.setId(counter.getAndIncrement());
        incident.setStatus("OPEN");

        incidents.add(incident);

        return incident;
    }

    @GetMapping("/api/incidents")
    public List<Incident> getAllIncidents() {
        return incidents;
    }
}