package mlr;

import jade.core.Agent;
import jade.core.behaviours.Behaviour;

public class MultipleRegressionAgent extends Agent {
  DataHelperMatrix dataHelperMatrix;
  protected void setup() {
    System.out.println("Agent "+getLocalName()+" started.");
    addBehaviour(new MyGenericBehaviour());
  } 

  private class MyGenericBehaviour extends Behaviour {

    int cont=0;

    public void action() {
        dataHelperMatrix = new DataHelperMatrix();
        System.out.println("Agent's action method is executed");
        cont+=1;
    } 
    
    public boolean done() {
      if (cont > 0)
        return true;
      else
	      return false;
    }
   
    public int onEnd() {
      myAgent.doDelete();
      return super.onEnd();
    } 
  }    // END of inner class ...Behaviour
}
