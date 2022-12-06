/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package examples.clips.agents;
import jade.core.Agent;
import jade.core.AID;
import jade.core.behaviours.OneShotBehaviour;
import jade.lang.acl.ACLMessage;
import net.sf.clipsrules.jni.*;

public class EmisorA extends Agent {
    protected void setup() {
        addBehaviour(new OneShotBehaviour() {
            public void action() {
                System.out.println("La paciente Ana llegó a revisión con los sintomas: Tos, Hackecka y Nauseas, su diagnostico es el siguiente...");
                ACLMessage msg = new ACLMessage(ACLMessage.INFORM);
                msg.setContent("(paciente (nombre Ana)(sintoma1 Tos) (sintoma2 Hackeka) (sintoma3 Nauseas))");
                msg.addReceiver(new AID("doctor",AID.ISLOCALNAME));
                send(msg);
            }
        });
    }
    
}
