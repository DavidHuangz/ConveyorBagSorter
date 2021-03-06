/* Copyright (c)2021 Rockwell Automation. All rights reserved. */
package fb.rt.cs725;
import fb.datatype.*;
import fb.rt.*;
import fb.rt.events.*;
/** FUNCTION_BLOCK CentralServer
  * @author JHC
  * @version 20211022/JHC
  */
public class CentralServer extends FBInstance
{
/** Initialization Request */
 public EventServer Request1 = new EventInput(this);
/** dab */
 public EventServer Request3 = new EventInput(this);
/** EVENT Release1 */
 public EventServer Release1 = new EventInput(this);
/** EVENT Release3 */
 public EventServer Release3 = new EventInput(this);
/** Initialization Confirm */
 public EventOutput Grant1 = new EventOutput();
/** Execution Confirmation */
 public EventOutput Grant3 = new EventOutput();
/** {@inheritDoc}
* @param s {@inheritDoc}
* @return {@inheritDoc}
*/
  public EventServer eiNamed(String s){
    if("Request1".equals(s)) return Request1;
    if("Request3".equals(s)) return Request3;
    if("Release1".equals(s)) return Release1;
    if("Release3".equals(s)) return Release3;
    return super.eiNamed(s);}
/** {@inheritDoc}
* @param s {@inheritDoc}
* @return {@inheritDoc}
*/
  public EventOutput eoNamed(String s){
    if("Grant1".equals(s)) return Grant1;
    if("Grant3".equals(s)) return Grant3;
    return super.eoNamed(s);}
private static final int index_START = 0;
private void state_START(){
  eccState = index_START;
  alg_NOREQUEST();
}
private static final int index_GRANT_1 = 1;
private void state_GRANT_1(){
  eccState = index_GRANT_1;
  alg_GRANT_1();
  Grant1.serviceEvent(this);
}
private static final int index_GRANT_3 = 2;
private void state_GRANT_3(){
  eccState = index_GRANT_3;
  alg_GRANT_3();
  Grant3.serviceEvent(this);
}
private static final int index_QUEUE_3 = 3;
private void state_QUEUE_3(){
  eccState = index_QUEUE_3;
  alg_QUEUE_3();
}
private static final int index_QUEUE_1 = 4;
private void state_QUEUE_1(){
  eccState = index_QUEUE_1;
  alg_QUEUE_1();
}
/** The default constructor. */
public CentralServer(){
    super();
  }
/** {@inheritDoc}
* @param e {@inheritDoc} */
  public void serviceEvent(EventServer e){
    if (e == Request1) service_Request1();
    else if (e == Request3) service_Request3();
    else if (e == Release1) service_Release1();
    else if (e == Release3) service_Release3();
  }
/** Services the Request1 event. */
  public void service_Request1(){
    if ((eccState == index_START)) state_GRANT_1();
    else if ((eccState == index_GRANT_3)) state_QUEUE_1();
  }
/** Services the Request3 event. */
  public void service_Request3(){
    if ((eccState == index_START)) state_GRANT_3();
    else if ((eccState == index_GRANT_1)) state_QUEUE_3();
  }
/** Services the Release1 event. */
  public void service_Release1(){
    if ((eccState == index_GRANT_1)) state_START();
    else if ((eccState == index_QUEUE_3)) state_GRANT_3();
  }
/** Services the Release3 event. */
  public void service_Release3(){
    if ((eccState == index_GRANT_3)) state_START();
    else if ((eccState == index_QUEUE_1)) state_GRANT_1();
  }
  /** ALGORITHM GRANT_1 IN Java*/
public void alg_GRANT_1(){
System.out.println("Token granted to FC1");

}
  /** ALGORITHM GRANT_3 IN Java*/
public void alg_GRANT_3(){
System.out.println("Token granted to FC3");

}
  /** ALGORITHM NOREQUEST IN Java*/
public void alg_NOREQUEST(){
System.out.println("No request");

}
  /** ALGORITHM QUEUE_3 IN Java*/
public void alg_QUEUE_3(){
System.out.println("FC3 waiting for token");

}
  /** ALGORITHM QUEUE_1 IN Java*/
public void alg_QUEUE_1(){
System.out.println("FC1 waiting for token");

}
}
