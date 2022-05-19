package lr;

import jade.core.behaviours.OneShotBehaviour;
import jade.core.Agent;

public class LogisticRegressionAgent extends Agent{
    LogisticRegressionFormulas lr;
    Object[] args;
    Double x;

    protected void setup() {
        lr = new LogisticRegressionFormulas();
        System.out.println("Agent "+getLocalName()+" started.");
        addBehaviour(new MyLogisticRegressionAgent());
    } 
    
    private class MyLogisticRegressionAgent extends OneShotBehaviour {
        
        public void action() {
            lr.generateModel();
            System.out.println("Agent " + getLocalName() + " action method executed");
        }
        
        public int onEnd() {
        myAgent.doDelete();   
        return super.onEnd();
        } 
    }    // END of inner class ...Behaviour
}
