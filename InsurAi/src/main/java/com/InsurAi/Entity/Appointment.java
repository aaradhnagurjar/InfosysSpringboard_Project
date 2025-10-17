package com.insurAi.entity;
// This class defines the Appointment entity which represents an appointment record in the database.
// It maps Java object fields to database table columns using JPA (Jakarta Persistence API) annotations.

// Import JPA annotations and LocalDateTime class
import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity // Marks this class as a JPA entity, meaning it maps to a database table
@Table(name = "appointments") // Specifies the database table name as "appointments"
public class Appointment {

    @Id // Marks this field as the primary key of the table
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    // Auto-generates unique values for this field (auto-increment in MySQL)
    private Long id;

    
    private String serviceType; // Type of service booked (e.g., "Health Insurance", "Auto Insurance")
    private String userEmail;// Email of the user
    private String agentEmail;// Email of the agent
    private LocalDateTime appointmentDateTime; // Scheduled date & time
    


    @Enumerated(EnumType.STRING)  // Stores the enum value as a string in the database (e.g., "SCHEDULED")
    private Status status; // Tracks the  appointment status

    private String cancellationReason;  // Reason if canceled

    // Enum representing the possible states of an appointment
    public enum Status {
        SCHEDULED,           // Appointment is created and scheduled
        CANCELLED_BY_USER,   // Appointment was canceled by the user
        CANCELLED_BY_AGENT,  // Appointment was canceled by the agent
        COMPLETED            // Appointment has been completed successfully
    }

    // Getters and Setters
 
    public Long getId() { 
        return id; 
    }

    public void setId(Long id) { 
        this.id = id; 
    }

    public String getServiceType() { 
        return serviceType; 
    }

    public void setServiceType(String serviceType) { 
        this.serviceType = serviceType; 
    }

    public String getUserEmail() { 
        return userEmail; 
    }

    public void setUserEmail(String userEmail) { 
        this.userEmail = userEmail; 
    }

    public String getAgentEmail() { 
        return agentEmail; 
    }

    public void setAgentEmail(String agentEmail) { 
        this.agentEmail = agentEmail; 
    }

    public LocalDateTime getAppointmentDateTime() { 
        return appointmentDateTime; 
    }

    public void setAppointmentDateTime(LocalDateTime appointmentDateTime) { 
        this.appointmentDateTime = appointmentDateTime; 
    }

    public Status getStatus() { 
        return status; 
    }

    public void setStatus(Status status) { 
        this.status = status; 
    }

    public String getCancellationReason() { 
        return cancellationReason; 
    }

    public void setCancellationReason(String cancellationReason) { 
        this.cancellationReason = cancellationReason; 
    } 
}
