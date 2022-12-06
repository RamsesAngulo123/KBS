/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package examples.clips.agents;
import jade.core.behaviours.Behaviour;
import net.sf.clipsrules.jni.*;
import jade.core.Agent;

public class PatologyA extends Agent {
     Environment clips;
         boolean Aviso = false;
         
    protected void setup() {
        try {
            clips = new Environment();
        } catch (Exception e) {
        }
        addBehaviour(new TellBehaviour());
        addBehaviour(new AskBehaviour());
    }
        private class TellBehaviour extends Behaviour {
        boolean Aviso = false;
        public void action() {
            System.out.println("En ejecucion...");
            try {
                clips.clear();
                clips.load("src/clips/patologias/templates.clp");
                clips.load("src/clips/patologias/facts.clp");
                clips.load("src/clips/patologias/rules.clp");
                clips.reset();
                clips.eval("(facts)");
            } catch (Exception e) {
            }
            Aviso = true;
        }
        public boolean done(){
            if(Aviso)
                return true;
            else
                return false;
        }
    }
                private class AskBehaviour extends Behaviour {

            boolean Bandera = false;

            public void action() {
                System.out.println("En ejecucion...");
                try {
                    clips.run();
                    clips.clear();
                } catch (Exception e) {
                }
                Bandera = true;
            }
            public boolean done() {
                if (Bandera) {
                    return true;
                } else {
                    return false;
                }

            }

            public int onEnd() {
                myAgent.doDelete();
                return super.onEnd();
            }
        }
    
}
