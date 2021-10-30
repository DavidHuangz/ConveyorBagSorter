/* Copyright (c)2021 Rockwell Automation. All rights reserved. */
package fb.rt.student;
import fb.datatype.*;
import fb.rt.*;
import fb.rt.events.*;
/** FUNCTION_BLOCK MY_X2Y2_J
  * @author JHC
  * @version 20210922/JHC
  */
public class MY_X2Y2_J extends FBInstance
{
/** VAR X */
  public REAL X = new REAL();
/** VAR Y */
  public REAL Y = new REAL();
/** VAR Z */
  public REAL Z = new REAL();
/** VAR OUT */
  public REAL OUT = new REAL();
/** VAR OUT2 */
  public REAL OUT2 = new REAL();
/** EVENT REQ */
 public EventServer REQ = new EventInput(this);
/** EVENT XYZ */
 public EventServer XYZ = new EventInput(this);
/** EVENT CNF */
 public EventOutput CNF = new EventOutput();
/** EVENT CNF2 */
 public EventOutput CNF2 = new EventOutput();
/** {@inheritDoc}
* @param s {@inheritDoc}
* @return {@inheritDoc}
*/
  public EventServer eiNamed(String s){
    if("REQ".equals(s)) return REQ;
    if("XYZ".equals(s)) return XYZ;
    return super.eiNamed(s);}
/** {@inheritDoc}
* @param s {@inheritDoc}
* @return {@inheritDoc}
*/
  public EventOutput eoNamed(String s){
    if("CNF".equals(s)) return CNF;
    if("CNF2".equals(s)) return CNF2;
    return super.eoNamed(s);}
/** {@inheritDoc}
* @param s {@inheritDoc}
* @return {@inheritDoc}
* @throws FBRManagementException {@inheritDoc}
*/
  public ANY ivNamed(String s) throws FBRManagementException{
    if("X".equals(s)) return X;
    if("Y".equals(s)) return Y;
    if("Z".equals(s)) return Z;
    return super.ivNamed(s);}
/** {@inheritDoc}
* @param s {@inheritDoc}
* @return {@inheritDoc}
* @throws FBRManagementException {@inheritDoc}
*/
  public ANY ovNamed(String s) throws FBRManagementException{
    if("OUT".equals(s)) return OUT;
    if("OUT2".equals(s)) return OUT2;
    return super.ovNamed(s);}
/** {@inheritDoc}
* @param ivName {@inheritDoc}
* @param newIV {@inheritDoc}
* @throws FBRManagementException {@inheritDoc} */
  public void connectIV(String ivName, ANY newIV)
    throws FBRManagementException{
    if("X".equals(ivName)) connect_X((REAL)newIV);
    else if("Y".equals(ivName)) connect_Y((REAL)newIV);
    else if("Z".equals(ivName)) connect_Z((REAL)newIV);
    else super.connectIV(ivName, newIV);
    }
/** Connect the given variable to the input variable X
  * @param newIV The variable to connect
 */
  public void connect_X(REAL newIV){
    X = newIV;
    }
/** Connect the given variable to the input variable Y
  * @param newIV The variable to connect
 */
  public void connect_Y(REAL newIV){
    Y = newIV;
    }
/** Connect the given variable to the input variable Z
  * @param newIV The variable to connect
 */
  public void connect_Z(REAL newIV){
    Z = newIV;
    }
private static final int index_START = 0;
private void state_START(){
  eccState = index_START;
}
private static final int index_REQ = 1;
private void state_REQ(){
  eccState = index_REQ;
  alg_REQ();
  CNF.serviceEvent(this);
state_START();
}
private static final int index_XYZ_S = 2;
private void state_XYZ_S(){
  eccState = index_XYZ_S;
  alg_XYZ_COMP();
  CNF2.serviceEvent(this);
state_START();
}
/** The default constructor. */
public MY_X2Y2_J(){
    super();
  }
/** {@inheritDoc}
* @param e {@inheritDoc} */
  public void serviceEvent(EventServer e){
    if (e == REQ) service_REQ();
    else if (e == XYZ) service_XYZ();
  }
/** Services the REQ event. */
  public void service_REQ(){
    if ((eccState == index_START)) state_REQ();
  }
/** Services the XYZ event. */
  public void service_XYZ(){
    if ((eccState == index_START)) state_XYZ_S();
  }
  /** ALGORITHM REQ IN Java*/
public void alg_REQ(){
OUT.value = X.value*X.value+Y.value*Y.value;

}
  /** ALGORITHM XYZ_COMP IN Java*/
public void alg_XYZ_COMP(){
OUT2.value = X.value + Y.value + Z.value;
System.out.println("This is in algorithm XYZ");

}
}
