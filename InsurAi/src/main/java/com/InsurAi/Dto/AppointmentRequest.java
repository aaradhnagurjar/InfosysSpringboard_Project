package com.InsurAi.Dto;

import java.time.LocalDateTime;
// DTO (Data Transfer Object) for creating or updating appointments.
 // This class is used to receive data from frontend requests.
public class AppointmentRequest {

    private String agentEmail; // Added for notification
    private String userEmail; // Added for notification
    private LocalDateTime preferredDateTime;
    private String reason;
    private String serviceType; // Added: Health, Auto, Travel, etc.

    // Getters and Setters

   public String getAgentEmail() {
      return agentEmail; 
   }
    public void setAgentEmail(String agentEmail) { 
       this.agentEmail = agentEmail;
    }
   public String getUserEmail() {
      return userEmail;
   }
    public void setUserEmail(String userEmail) { 
     this.userEmail = userEmail; 
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

    public String getServiceType() { 
       return serviceType;
    }
    public void setServiceType(String serviceType) { 
       this.serviceType = serviceType; 
    }
}
