package gd;

import jade.core.behaviours.OneShotBehaviour;
import jade.core.Agent;

public class GradientDescentAgent extends Agent{
    GradientDescentFormulas gdFormulas;
    Object[] args;
    Double x;

    protected void setup() {
        System.out.println("Agent "+getLocalName()+" started.");
        addBehaviour(new MyGradientDescentAgent());
    } 
    
    private class MyGradientDescentAgent extends OneShotBehaviour {
        
        public void action() {
            gdFormulas = new GradientDescentFormulas();
            gdFormulas.main();
            System.out.println("Agent " + getLocalName() + " action method executed");
        }
        
        public int onEnd() {
        myAgent.doDelete();   
        return super.onEnd();
        } 
    }    // END of inner class ...Behaviour
}
