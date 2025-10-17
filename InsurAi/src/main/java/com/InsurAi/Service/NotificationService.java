
package com.InsurAi.Service;

import org.springframework.stereotype.Service;

// Handles notifications to user and agent.
 // Currently prints to console, can be replaced with email/SMS integration.

@Service
public class NotificationService {

    public void sendNotification(String email, String subject, String message) {
        // For now, just print the notification
        System.out.println("Notification to: " + email);
        System.out.println("Subject: " + subject);
        System.out.println("Message: " + message);
    }
}
