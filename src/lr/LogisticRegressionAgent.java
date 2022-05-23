package lr;

import jade.core.behaviours.OneShotBehaviour;
import jade.core.Agent;

public class LogisticRegressionAgent extends Agent{
    LogisticRegressionFormulas lr;
    Object[] args;
    Double x1 = 0.0, x2 = 0.0;

    protected void setup() {
        lr = new LogisticRegressionFormulas();
        args = getArguments();
        x1 = Double.parseDouble(args[0].toString());
        x2 = Double.parseDouble(args[1].toString());
        System.out.println("Agent "+getLocalName()+" started.");
        addBehaviour(new MyLogisticRegressionAgent());
    } 
    
    private class MyLogisticRegressionAgent extends OneShotBehaviour {
        
        public void action() {
            lr.generateModel();
            lr.predictY(x1, x2);
            System.out.println("Agent " + getLocalName() + " action method executed");
        }
        
        public int onEnd() {
        myAgent.doDelete();   
        return super.onEnd();
        } 
    }    // END of inner class ...Behaviour
}
