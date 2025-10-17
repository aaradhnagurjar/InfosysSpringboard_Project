package com.InsurAi.Dto;

import java.time.LocalDateTime;
// DTO (Data Transfer Object) for creating or updating appointments.
 // This class is used to receive data from frontend requests.
public class AppointmentRequest {

   
    private Long agentId;  // ID of the agent who will handle the appointment
    private String agentName;
    private String agentEmail; // Added for notification
    private Long userId;
    private String userName;
    private String userEmail; // Added for notification
    private LocalDateTime preferredDateTime;
    private String reason;
    private String serviceType; // Added: Health, Auto, Travel, etc.


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

   public String getAgentEmail() {
      return agentEmail; 
   }
    public void setAgentEmail(String agentEmail) { 
       this.agentEmail = agentEmail;
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

    public String getServiceType() { 
       return serviceType;
    }
    public void setServiceType(String serviceType) { 
       this.serviceType = serviceType; 
    }
}
