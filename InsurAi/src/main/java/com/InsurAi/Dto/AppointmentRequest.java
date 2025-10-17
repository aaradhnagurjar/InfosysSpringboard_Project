package com.InsurAi.Dto;

import java.time.LocalDateTime;
/**
 * DTO (Data Transfer Object) for creating or updating appointments.
 * This class is used to receive data from frontend requests.
 */
public class AppointmentRequest {

   
    // ID of the agent who will handle the appointment
    private Long agentId;

    // Name of the agent
    private String agentName;

    // Preferred date and time chosen by the user for the appointment
    private LocalDateTime preferredDateTime;

    // Reason for the appointment (optional, can help notifications)
    private String reason;

    // ID of the user booking the appointment
    private Long userId;

    // Name of the user
    private String userName;

    // Getters and Setters
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
}
