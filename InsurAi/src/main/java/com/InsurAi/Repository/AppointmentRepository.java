package com.InsurAi.Repository;

import com.InsurAi.Entity.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Long> {

    // find appointments by user email
    List<Appointment> findByUserEmail(String userEmail);

    // find appointments by agent email
    List<Appointment> findByAgentEmail(String agentEmail);
}
