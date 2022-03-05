package work;

import jade.core.Agent;
import jade.core.behaviours.OneShotBehaviour;

public class LinearRegressionAgent extends Agent { 
  LinearRegressionFormulas linearRegressionFormulas;
  Object[] args;
  Double x;

  protected void setup() {
    args = getArguments();
    x = Double.parseDouble(args[0].toString());
    System.out.println("Agent "+getLocalName()+" started.");
    addBehaviour(new MyLinearRegressionAgent());
  } 
  
  private class MyLinearRegressionAgent extends OneShotBehaviour {
    
    public void action() {
      linearRegressionFormulas = new LinearRegressionFormulas();
      linearRegressionFormulas.getY(x);
      System.out.println("Agent's action method executed");
    }
    
    public int onEnd() {
      myAgent.doDelete();   
      return super.onEnd();
    } 
  }    // END of inner class ...Behaviour
}
