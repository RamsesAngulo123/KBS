package examples.handson;

import java.util.logging.Level;
import java.util.logging.Logger;

import jade.core.Agent;
import jade.core.behaviours.Behaviour;
import java.io.FileNotFoundException;
import net.sf.clipsrules.jni.*;

public class Handson34 extends Agent {
    private Environment Clp;

    protected void setup(){
        Clp = new Environment();
        addBehaviour(new Personas());
        addBehaviour(new Productos());
        addBehaviour(new Market());
    }
    private class Personas extends Behaviour{
        boolean done = false;

        public void action(){
            try {
                System.out.println("Reading...");
                Clp.load("src/examples/handson/clips/persons/load-persons.clp");
                Clp.load("src/examples/handson/clips/persons/run-persons.clp");

                Clp.eval("(reset)");
                Clp.eval("(rules)");
                Clp.eval("(facts)");
                System.out.println("----------------------------------");
                Clp.eval("(clear)");

                done = true;
            } catch (CLIPSException e) {
                // TODO: handle exception
                Logger.getLogger(ClipsAgent.class.getName()).log(Level.SEVERE, msg:null, e);
            }
        }
        
        public boolean done(){
            return done;
        }

    }
    private class Productos extends Behaviour{
        boolean done = false;
        
        public void action(){
            try {
                System.out.println("Reading...");
                Clp.load("src/examples/handson/clips/prodcust/load-prod-cust.clp");
                Clp.load("src/examples/handson/clips/prodcust/load-prodcust-rules.clp");

                Clp.eval("(reset)");
                Clp.eval("(rules)");
                Clp.eval("(facts)");
                System.out.println("----------------------------------");
                Clp.eval("(clear)");

                done = true;
            } catch (CLIPSException e) {
                // TODO: handle exception
                Logger.getLogger(ClipsAgent.class.getName()).log(Level.SEVERE, msg:null, e);
            }
        }
        public boolean done(){
            return done;
        }
    }
    private class Market extends Behaviour{
        boolean done;

        public void action(){
            try {
                System.out.println("Reading...");
                Clp.load("src/examples/handson/clips/market/facts.clp");
                Clp.load("src/examples/handson/clips/market/rules.clp");

                Clp.eval("(reset)");
                Clp.eval("(rules)");
                Clp.eval("(facts)");
                System.out.println("----------------------------------");
                Clp.eval("(clear)");

                done = true;
            } catch (CLIPSException e) {
                // TODO: handle exception
                Logger.getLogger(ClipsAgent.class.getName()).log(Level.SEVERE, msg:null, e);
            }
        }
        public boolean done(){
            return done;
        }
        public int onEnd() {
            myAgent.doDelete();
            return super.onEnd();
        }
    }
}