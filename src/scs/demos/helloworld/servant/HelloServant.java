package scs.demos.helloworld.servant;

import scs.core.servant.ComponentContext;
import scs.demos.helloworld.HelloPOA;

public class HelloServant extends HelloPOA {

  private String name = "World";
  private ComponentContext context;

  public HelloServant(ComponentContext context) {
    super( );
    this.context = context;
  }

  public void setName(String name) {
    this.name = name;
  }

  //@Override
  public void sayHello() {
    System.out.println("Hello " + name + "!");
  }

  //@Override
  public org.omg.CORBA.Object _get_component() {
    return context.getIComponent();
  }
}
