/* Copyright (c)2021 Rockwell Automation. All rights reserved. */
package fb.rt.cs725;
import fb.datatype.*;
import fb.rt.*;
import fb.rt.events.*;
/** FUNCTION_BLOCK Server
  * @author JHC
  * @version 20211020/JHC
  */
public class Server extends FBInstance
{
/** EVENT Req1 */
 public EventServer Req1 = new EventInput(this);
/** Normal Execution Request */
 public EventServer Req3 = new EventInput(this);
/** EVENT Release1 */
 public EventServer Release1 = new EventInput(this);
/** EVENT Release3 */
 public EventServer Release3 = new EventInput(this);
/** EVENT Grant1 */
 public EventOutput Grant1 = new EventOutput();
/** EVENT Grant3 */
 public EventOutput Grant3 = new EventOutput();
/** {@inheritDoc}
* @param s {@inheritDoc}
* @return {@inheritDoc}
*/
  public EventServer eiNamed(String s){
    if("Req1".equals(s)) return Req1;
    if("Req3".equals(s)) return Req3;
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
}
private static final int index_INIT = 1;
private void state_INIT(){
  eccState = index_INIT;
  alg_INIT();
  Grant1.serviceEvent(this);
state_START();
}
private static final int index_REQ = 2;
private void state_REQ(){
  eccState = index_REQ;
  alg_REQ();
  Grant3.serviceEvent(this);
state_START();
}
/** The default constructor. */
public Server(){
    super();
  }
/** {@inheritDoc}
* @param e {@inheritDoc} */
  public void serviceEvent(EventServer e){
    if (e == Req1) service_Req1();
    else if (e == Req3) service_Req3();
    else if (e == Release1) service_Release1();
    else if (e == Release3) service_Release3();
  }
/** Services the Req1 event. */
  public void service_Req1(){
    if ((eccState == index_START)) state_INIT();
  }
/** Services the Req3 event. */
  public void service_Req3(){
    if ((eccState == index_START)) state_REQ();
  }
/** Services the Release1 event. */
  public void service_Release1(){
  }
/** Services the Release3 event. */
  public void service_Release3(){
  }
  /** ALGORITHM INIT IN ST*/
public void alg_INIT(){
}
  /** ALGORITHM REQ IN ST*/
public void alg_REQ(){
}
}
