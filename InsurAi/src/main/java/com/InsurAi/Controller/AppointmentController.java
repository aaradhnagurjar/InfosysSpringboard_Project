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

   // 1. Book appointment with notifications
    @PostMapping("/book")
    public Appointment bookAppointment(@RequestBody AppointmentRequest request) {
        return appointmentService.createAppointment(request);
    }

    // 2. Get all appointments
    @GetMapping("/all")
    public List<Appointment> getAllAppointments() {
        return appointmentService.getAllAppointments();
    }

    // 3. Get appointment by ID
    @GetMapping("/{id}")
    public Appointment getAppointmentById(@PathVariable Long id) {
        return appointmentService.getAppointmentById(id);
    }

    // 4. Get appointments by agent email
    @GetMapping("/agent")
    public List<Appointment> getAppointmentsByAgentEmail(@RequestParam String agentEmail) {
        return appointmentService.getAppointmentsByAgentEmail(agentEmail);
    }

    // 5. Get appointments by user email
    @GetMapping("/user")
    public List<Appointment> getAppointmentsByUserEmail(@RequestParam String userEmail) {
        return appointmentService.getAppointmentsByUserEmail(userEmail);
    }

    // 6. Cancel by user (triggers notification)
    @PutMapping("/cancel/user/{id}")
    public Appointment cancelByUser(@PathVariable Long id, @RequestParam String reason) {
        return appointmentService.cancelByUser(id, reason);
    }

    // 7. Cancel by agent (triggers notification)
    @PutMapping("/cancel/agent/{id}")
    public Appointment cancelByAgent(@PathVariable Long id, @RequestParam String reason) {
        return appointmentService.cancelByAgent(id, reason);
    }

    // 8. Delete appointment
    @DeleteMapping("/{id}")
    public String deleteAppointment(@PathVariable Long id) {
        appointmentService.deleteAppointment(id);
        return "Appointment deleted successfully.";
    }
}
