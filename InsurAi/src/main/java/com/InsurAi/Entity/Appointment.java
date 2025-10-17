// This class defines the Appointment entity which represents an appointment record in the database.
// It maps Java object fields to database table columns using JPA (Jakarta Persistence API) annotations.

package com.InsurAi.Entity;

// Importing JPA annotations for entity mapping and LocalDateTime for date-time storage
import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity  // Marks this class as a JPA Entity — it will be stored in the database as a table
@Table(name = "appointments")  // Specifies the name of the table in the database
public class Appointment {

    // Primary Key 
    @Id  // Specifies this field as the Primary Key of the table
    @GeneratedValue(strategy = GenerationType.IDENTITY)  
    // Auto-generates unique IDs for each appointment using the database's identity (auto-increment)
    private Long id;

    // Agent Details 
    @Column(name = "agent_id")  
    // Maps this field to a column named 'agent_id' in the database
    private Long agentId;

    @Column(name = "agent_name", nullable = false)
    // Stores the agent's name; cannot be null because every appointment must have an assigned agent
    private String agentName;

    // Appointment Details 
    @Column(name = "preferred_datetime", nullable = false)
    // Stores the preferred date and time chosen for the appointment (cannot be null)
    private LocalDateTime preferredDateTime;

    @Column(name = "reason", length = 1000)
    // Stores the reason or purpose of the appointment (max 1000 characters)
    private String reason;

    // User Details 
    @Column(name = "user_id")
    // Stores the ID of the user (customer) who booked the appointment
    private Long userId;

    @Column(name = "user_name")
    // Stores the name of the user who booked the appointment
    private String userName;

    // Status and Timestamps 
    @Column(name = "status")
    // Stores the current status of the appointment (default is "PENDING")
    private String status = "PENDING";

    @Column(name = "created_at")
    // Stores the timestamp when the appointment record was created (set to current time by default)
    private LocalDateTime createdAt = LocalDateTime.now();

    // Getters and Setters 
    // These are public methods that allow reading and updating private fields (Encapsulation principle)

    public Long getId() { 
        return id; 
    }

    public void setId(Long id) { 
        this.id = id; 
    }

    public Long getAgentId() { 
        return agentId; 
    }

    public void setAgentId(Long agentId) { 
        this.agentId = agentId; 
    }

    public String getAgentName() { 
        return agentName; 
    }

    public void setAgentName(String agentName) { 
        this.agentName = agentName; 
    }

    public LocalDateTime getPreferredDateTime() { 
        return preferredDateTime; 
    }

    public void setPreferredDateTime(LocalDateTime preferredDateTime) { 
        this.preferredDateTime = preferredDateTime; 
    }

    public String getReason() { 
        return reason; 
    }

    public void setReason(String reason) { 
        this.reason = reason; 
    }

    public Long getUserId() { 
        return userId; 
    }

    public void setUserId(Long userId) { 
        this.userId = userId; 
    }

    public String getUserName() { 
        return userName; 
    }

    public void setUserName(String userName) { 
        this.userName = userName; 
    }

    public String getStatus() { 
        return status; 
    }

    public void setStatus(String status) { 
        this.status = status; 
    }

    public LocalDateTime getCreatedAt() { 
        return createdAt; 
    }

    public void setCreatedAt(LocalDateTime createdAt) { 
        this.createdAt = createdAt; 
    }
}
