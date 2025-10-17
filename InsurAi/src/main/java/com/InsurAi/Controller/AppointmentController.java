// This controller handles all HTTP requests related to Appointment management.
// It connects the frontend (React) with the backend (Spring Boot) service layer.

package com.InsurAi.Controller;

import com.InsurAi.Entity.Appointment;
import com.InsurAi.Service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController  // Marks this class as a REST controller (returns JSON responses)
@RequestMapping("/api/appointments")  // Base URL for all appointment-related endpoints
public class AppointmentController {

    // Dependency Injection 
    @Autowired
    // Automatically injects the AppointmentService to handle business logic
    private AppointmentService appointmentService;

    // 1 Create Appointment 
    @PostMapping("/book")
    // This endpoint handles POST requests at /api/appointments/book
    // It creates a new appointment in the database
    public Appointment bookAppointment(@RequestBody Appointment appointment) {
        // @RequestBody converts incoming JSON (from frontend) into a Java object
        return appointmentService.bookAppointment(appointment);
        // Calls the service layer to save appointment in DB and returns saved record
    }

    // 2 Get All Appointments 
    @GetMapping("/all")
    // This endpoint handles GET requests at /api/appointments/all
    // Used by admin/agents to view all appointments
    public List<Appointment> getAllAppointments() {
        return appointmentService.getAllAppointments();
    }

    // 3 Get Appointment by ID 
    @GetMapping("/{id}")
    // Fetches a specific appointment using its unique ID
    public Appointment getAppointmentById(@PathVariable Long id) {
        // @PathVariable binds the {id} value from the URL
        return appointmentService.getAppointmentById(id);
    }

    // 4 Get Appointments by Agent ID 
    @GetMapping("/agent/{agentId}")
    // Fetches all appointments assigned to a specific agent
    public List<Appointment> getAppointmentsByAgentId(@PathVariable Long agentId) {
        return appointmentService.getAppointmentsByAgentId(agentId);
    }

    // 5 Get Appointments by User ID
    @GetMapping("/user/{userId}")
    // Fetches all appointments booked by a specific user
    public List<Appointment> getAppointmentsByUserId(@PathVariable Long userId) {
        return appointmentService.getAppointmentsByUserId(userId);
    }

    // 6 Update Appointment Status 
    @PutMapping("/{id}/status")
    // Updates the status (e.g., PENDING → APPROVED / REJECTED)
    public Appointment updateAppointmentStatus(@PathVariable Long id, @RequestParam String status) {
        // @RequestParam reads the status value from URL parameters
        return appointmentService.updateAppointmentStatus(id, status);
    }

    // 7 Delete Appointment 
    @DeleteMapping("/{id}")
    // Deletes an appointment record using its ID
    public String deleteAppointment(@PathVariable Long id) {
        appointmentService.deleteAppointment(id);
        return "Appointment deleted successfully.";
    }
}
