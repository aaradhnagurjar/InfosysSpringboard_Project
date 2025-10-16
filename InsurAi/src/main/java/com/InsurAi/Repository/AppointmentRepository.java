package com.InsurAi.Repository;

import com.InsurAi.Entity.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Long> {

    // find appointments by user ID
    List<Appointment> findByUserId(Long userId);

    // find appointments by agent ID
    List<Appointment> findByAgentId(Long agentId);
}
