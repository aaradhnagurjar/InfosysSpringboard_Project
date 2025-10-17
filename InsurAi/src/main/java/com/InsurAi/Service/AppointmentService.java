package com.InsurAi.Service;

import com.InsurAi.Dto.AppointmentRequest;
import com.InsurAi.Entity.Appointment;
import com.InsurAi.Repository.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AppointmentService {

    @Autowired
    private AppointmentRepository appointmentRepository;

    @Autowired
    private NotificationService notificationService;

    // Create Appointment
    public Appointment createAppointment(AppointmentRequest request) {
        Appointment appointment = new Appointment();
        appointment.setAgentEmail(request.getAgentEmail());
        appointment.setUserEmail(request.getUserEmail());
        appointment.setServiceType(request.getServiceType());
        appointment.setAppointmentDateTime(request.getPreferredDateTime());
        appointment.setStatus(Appointment.Status.SCHEDULED);
        Appointment saved = appointmentRepository.save(appointment);

        // Notify agent
        notificationService.sendNotification(
            request.getAgentEmail(),
            "New Appointment Scheduled",
            "You have a new " + request.getServiceType() + " appointment with " + request.getUserName() +
            " on " + request.getPreferredDateTime()
        );

        return saved;
    }

    // Cancel Appointment by User
    public Appointment cancelByUser(Long appointmentId, String reason) {
        Appointment appointment = appointmentRepository.findById(appointmentId).orElseThrow();
        appointment.setStatus(Appointment.Status.CANCELLED_BY_USER);
        appointment.setCancellationReason(reason);
        appointmentRepository.save(appointment);

        // Notify agent automatically
        notificationService.sendNotification(
            appointment.getAgentEmail(),
            "Appointment Cancelled by User",
            "The user has cancelled the " + appointment.getServiceType() + " appointment." +
            " Reason: " + reason
        );

        return appointment;
    }

    
    // Cancel Appointment by Agent
    public Appointment cancelByAgent(Long appointmentId, String reason) {
        Appointment appointment = appointmentRepository.findById(appointmentId).orElseThrow();
        appointment.setStatus(Appointment.Status.CANCELLED_BY_AGENT);
        appointment.setCancellationReason(reason);
        appointmentRepository.save(appointment);

        // Notify user automatically
        notificationService.sendNotification(
            appointment.getUserEmail(),
            "Appointment Cancelled by Agent",
            "Your " + appointment.getServiceType() + " appointment has been cancelled by the agent." +
            " Reason: " + reason
        );

        return appointment;
    }
    // Fetch all appointments
    public List<Appointment> getAllAppointments() {
        return appointmentRepository.findAll();
    }

    public Appointment getAppointmentById(Long id) {
        return appointmentRepository.findById(id).orElseThrow();
    }

    public List<Appointment> getAppointmentsByUserEmail(String email) {
        return appointmentRepository.findByUserEmail(email);
    }

    public List<Appointment> getAppointmentsByAgentEmail(String email) {
        return appointmentRepository.findByAgentEmail(email);
    }

    public void deleteAppointment(Long id) {
        appointmentRepository.deleteById(id);
    }
}
