package com.InsurAi.Controller;

import com.InsurAi.Dto.AppointmentRequest;
import com.InsurAi.Entity.Appointment;
import com.InsurAi.Service.AppointmentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.*;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:5173") // allow Vite dev server
public class AppointmentController {

    private final AppointmentService appointmentService;

    public AppointmentController(AppointmentService appointmentService) {
        this.appointmentService = appointmentService;
    }

    // Simple in-memory list of agents (demo)
    @GetMapping("/agents")
    public ResponseEntity<List<Map<String, Object>>> getAgents() {
        List<Map<String, Object>> agents = new ArrayList<>();
        agents.add(Map.of("id", 1, "name", "Agent A"));
        agents.add(Map.of("id", 2, "name", "Agent B"));
        agents.add(Map.of("id", 3, "name", "Agent C"));
        return ResponseEntity.ok(agents);
    }

    // Create new appointment
    @PostMapping("/appointments")
    public ResponseEntity<?> createAppointment(@RequestBody AppointmentRequest req) {
        if (req.getAgentName() == null || req.getPreferredDateTime() == null) {
            return ResponseEntity.badRequest().body(Map.of("error", "agentName and preferredDateTime are required"));
        }

        Appointment a = new Appointment();
        a.setAgentId(req.getAgentId());
        a.setAgentName(req.getAgentName());
        a.setPreferredDateTime(req.getPreferredDateTime());
        a.setReason(req.getReason());
        a.setUserId(req.getUserId());
        a.setUserName(req.getUserName());
        a.setStatus("PENDING");
        a.setCreatedAt(LocalDateTime.now());

        Appointment saved = appointmentService.save(a);
        return ResponseEntity.ok(saved);
    }

    // List all appointments
    @GetMapping("/appointments")
    public ResponseEntity<List<Appointment>> listAppointments() {
        return ResponseEntity.ok(appointmentService.findAll());
    }
}
