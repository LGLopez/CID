package mlr;

import jade.core.Agent;
import jade.core.behaviours.Behaviour;

public class MultipleRegressionAgent extends Agent {
  MultipleRegressionMath multipleRegressionMath;
  Object[] args;
  Double x1;
  Double x2;

  protected void setup() {
    multipleRegressionMath = new MultipleRegressionMath();
    args = getArguments();
    x1 = Double.parseDouble(args[0].toString());
    x2 = Double.parseDouble(args[1].toString());
    System.out.println("Agent "+getLocalName()+" started.");
    addBehaviour(new MyGenericBehaviour());
  } 

  private class MyGenericBehaviour extends Behaviour {

    int cont=0;

    public void action() {
      multipleRegressionMath.printMLRValue();
      System.out.println(multipleRegressionMath.predictY(x1, x2));
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
