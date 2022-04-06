package com.backend.caisse.service;

import java.util.List;

import com.backend.caisse.entities.Agent;

public interface AgentService {
    
    Agent AjouterAgent(Agent agt);

    Agent ModifierAgent(Agent agt);

    void ActiverAgent(long matricule);

    void DesactiverAgent(long matricule);

    Agent ConsulterAgent(long matricule);

    List<Agent> ListerAgents();

}