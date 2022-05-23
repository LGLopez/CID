package knn;

import jade.core.Agent;
import jade.core.behaviours.OneShotBehaviour;

public class KNNAgent extends Agent{
    KNNFormulas knnFormulas;
    Object[] args;
    double length, width;

    protected void setup() {
        knnFormulas = new KNNFormulas();
        args = getArguments();
        // length = Double.parseDouble(args[0].toString());
        // width = Double.parseDouble(args[1].toString());
        System.out.println("Agent "+getLocalName()+" started.");
        addBehaviour(new MyKNNAgent());
    }

    private class MyKNNAgent extends OneShotBehaviour {
        public void action() {
            knnFormulas.main();
            System.out.println("Agent " + getLocalName() + " action method executed");
        }
        public int onEnd() {
            myAgent.doDelete();
            return super.onEnd();
        }
    }    // END of inner class ...Behaviour
}
