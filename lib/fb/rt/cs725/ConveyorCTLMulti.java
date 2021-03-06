/* Copyright (c)2021 Rockwell Automation. All rights reserved. */
package fb.rt.cs725;
import fb.datatype.*;
import fb.rt.*;
import fb.rt.events.*;
/** FUNCTION_BLOCK ConveyorCTLMulti
  * @author JHC
  * @version 20211022/JHC
  */
public class ConveyorCTLMulti extends FBInstance
{
/** Input event qualifier */
  public BOOL EnterPE = new BOOL();
/** VAR Block */
  public BOOL Block = new BOOL();
/** VAR Candidate */
  public BOOL Candidate = new BOOL();
/** VAR ExitPE */
  public BOOL ExitPE = new BOOL();
/** VAR ClockIn */
  public INT ClockIn = new INT();
/** VAR ID */
  public BOOL ID = new BOOL();
/** Output event qualifier */
  public BOOL MotoRotate = new BOOL();
/** VAR BlockCon */
  public BOOL BlockCon = new BOOL();
/** VAR ClockOut */
  public INT ClockOut = new INT();
/** VAR lastPE */
  public BOOL lastPE = new BOOL();
/** VAR lastBlock */
  public BOOL lastBlock = new BOOL();
/** VAR StoreEmit */
  public BOOL StoreEmit = new BOOL();
/** VAR CLOCK */
  public INT CLOCK = new INT();
/** VAR Priority */
  public BOOL Priority = new BOOL();
/** Initialization Request */
 public EventServer INIT = new EventInput(this);
/** Normal Execution Request */
 public EventServer REQ = new EventInput(this);
/** EVENT CAS_STOP */
 public EventServer CAS_STOP = new EventInput(this);
/** EVENT CAS_START */
 public EventServer CAS_START = new EventInput(this);
/** EVENT REPLY_IN */
 public EventServer REPLY_IN = new EventInput(this);
/** EVENT REQUEST_IN */
 public EventServer REQUEST_IN = new EventInput(this);
/** Initialization Confirm */
 public EventOutput INITO = new EventOutput();
/** Execution Confirmation */
 public EventOutput CNF = new EventOutput();
/** EVENT STOP */
 public EventOutput STOP = new EventOutput();
/** EVENT START */
 public EventOutput START = new EventOutput();
/** EVENT REPLY_OUT */
 public EventOutput REPLY_OUT = new EventOutput();
/** EVENT REQUEST_OUT */
 public EventOutput REQUEST_OUT = new EventOutput();
/** {@inheritDoc}
* @param s {@inheritDoc}
* @return {@inheritDoc}
*/
  public EventServer eiNamed(String s){
    if("INIT".equals(s)) return INIT;
    if("REQ".equals(s)) return REQ;
    if("CAS_STOP".equals(s)) return CAS_STOP;
    if("CAS_START".equals(s)) return CAS_START;
    if("REPLY_IN".equals(s)) return REPLY_IN;
    if("REQUEST_IN".equals(s)) return REQUEST_IN;
    return super.eiNamed(s);}
/** {@inheritDoc}
* @param s {@inheritDoc}
* @return {@inheritDoc}
*/
  public EventOutput eoNamed(String s){
    if("INITO".equals(s)) return INITO;
    if("CNF".equals(s)) return CNF;
    if("STOP".equals(s)) return STOP;
    if("START".equals(s)) return START;
    if("REPLY_OUT".equals(s)) return REPLY_OUT;
    if("REQUEST_OUT".equals(s)) return REQUEST_OUT;
    return super.eoNamed(s);}
/** {@inheritDoc}
* @param s {@inheritDoc}
* @return {@inheritDoc}
* @throws FBRManagementException {@inheritDoc}
*/
  public ANY ivNamed(String s) throws FBRManagementException{
    if("EnterPE".equals(s)) return EnterPE;
    if("Block".equals(s)) return Block;
    if("Candidate".equals(s)) return Candidate;
    if("ExitPE".equals(s)) return ExitPE;
    if("ClockIn".equals(s)) return ClockIn;
    if("ID".equals(s)) return ID;
    return super.ivNamed(s);}
/** {@inheritDoc}
* @param s {@inheritDoc}
* @return {@inheritDoc}
* @throws FBRManagementException {@inheritDoc}
*/
  public ANY ovNamed(String s) throws FBRManagementException{
    if("MotoRotate".equals(s)) return MotoRotate;
    if("BlockCon".equals(s)) return BlockCon;
    if("ClockOut".equals(s)) return ClockOut;
    return super.ovNamed(s);}
/** {@inheritDoc}
* @param ivName {@inheritDoc}
* @param newIV {@inheritDoc}
* @throws FBRManagementException {@inheritDoc} */
  public void connectIV(String ivName, ANY newIV)
    throws FBRManagementException{
    if("EnterPE".equals(ivName)) connect_EnterPE((BOOL)newIV);
    else if("Block".equals(ivName)) connect_Block((BOOL)newIV);
    else if("Candidate".equals(ivName)) connect_Candidate((BOOL)newIV);
    else if("ExitPE".equals(ivName)) connect_ExitPE((BOOL)newIV);
    else if("ClockIn".equals(ivName)) connect_ClockIn((INT)newIV);
    else if("ID".equals(ivName)) connect_ID((BOOL)newIV);
    else super.connectIV(ivName, newIV);
    }
/** Connect the given variable to the input variable EnterPE
  * @param newIV The variable to connect
 */
  public void connect_EnterPE(BOOL newIV){
    EnterPE = newIV;
    }
/** Connect the given variable to the input variable Block
  * @param newIV The variable to connect
 */
  public void connect_Block(BOOL newIV){
    Block = newIV;
    }
/** Connect the given variable to the input variable Candidate
  * @param newIV The variable to connect
 */
  public void connect_Candidate(BOOL newIV){
    Candidate = newIV;
    }
/** Connect the given variable to the input variable ExitPE
  * @param newIV The variable to connect
 */
  public void connect_ExitPE(BOOL newIV){
    ExitPE = newIV;
    }
/** Connect the given variable to the input variable ClockIn
  * @param newIV The variable to connect
 */
  public void connect_ClockIn(INT newIV){
    ClockIn = newIV;
    }
/** Connect the given variable to the input variable ID
  * @param newIV The variable to connect
 */
  public void connect_ID(BOOL newIV){
    ID = newIV;
    }
private static final int index_START = 0;
private void state_START(){
  eccState = index_START;
}
private static final int index_INIT = 1;
private void state_INIT(){
  eccState = index_INIT;
  alg_INIT();
  INITO.serviceEvent(this);
  CNF.serviceEvent(this);
state_START();
}
private static final int index_CAS_START = 2;
private void state_CAS_START(){
  eccState = index_CAS_START;
  alg_START();
  START.serviceEvent(this);
  CNF.serviceEvent(this);
state_START();
}
private static final int index_CAS_STOP = 3;
private void state_CAS_STOP(){
  eccState = index_CAS_STOP;
  alg_STOP();
  STOP.serviceEvent(this);
  CNF.serviceEvent(this);
state_START();
}
private static final int index_SEND_REQUEST = 4;
private void state_SEND_REQUEST(){
  eccState = index_SEND_REQUEST;
  alg_REQUEST_SENDING();
  REQUEST_OUT.serviceEvent(this);
  alg_STOP();
  STOP.serviceEvent(this);
  CNF.serviceEvent(this);
}
private static final int index_ENTER_CRITICAL = 5;
private void state_ENTER_CRITICAL(){
  eccState = index_ENTER_CRITICAL;
  alg_UPDATE_CLOCK();
  alg_START();
  START.serviceEvent(this);
  CNF.serviceEvent(this);
}
private static final int index_FINISH_CRITICAL = 6;
private void state_FINISH_CRITICAL(){
  eccState = index_FINISH_CRITICAL;
}
private static final int index_EXIT_CRITICAL = 7;
private void state_EXIT_CRITICAL(){
  eccState = index_EXIT_CRITICAL;
state_START();
}
private static final int index_REQUEST_RECEIVED = 8;
private void state_REQUEST_RECEIVED(){
  eccState = index_REQUEST_RECEIVED;
  alg_REQUEST_RECEIVED();
}
private static final int index_SEND_REPLY = 9;
private void state_SEND_REPLY(){
  eccState = index_SEND_REPLY;
  alg_SEND_REPLY();
  REPLY_OUT.serviceEvent(this);
state_START();
}
private static final int index_REQ = 10;
private void state_REQ(){
  eccState = index_REQ;
  alg_REQ();
  CNF.serviceEvent(this);
state_START();
}
private static final int index_REQUEST_RECEIVED_2 = 11;
private void state_REQUEST_RECEIVED_2(){
  eccState = index_REQUEST_RECEIVED_2;
  alg_REQUEST_RECEIVED();
}
private static final int index_SEND_REPLY_2 = 12;
private void state_SEND_REPLY_2(){
  eccState = index_SEND_REPLY_2;
  alg_SEND_REPLY();
  REPLY_OUT.serviceEvent(this);
state_FINISH_CRITICAL();
}
private static final int index_ANOTHER_BAG = 13;
private void state_ANOTHER_BAG(){
  eccState = index_ANOTHER_BAG;
  alg_ANOTHER_BAG_WAIT();
}
private static final int index_REQUEST_RECEIVED_3 = 14;
private void state_REQUEST_RECEIVED_3(){
  eccState = index_REQUEST_RECEIVED_3;
  alg_REQUEST_RECEIVED();
state_COMPARE_CLOCKS();
}
private static final int index_COMPARE_CLOCKS = 15;
private void state_COMPARE_CLOCKS(){
  eccState = index_COMPARE_CLOCKS;
  alg_COMPARE_CLOCK();
}
/** The default constructor. */
public ConveyorCTLMulti(){
    super();
    lastPE.initializeNoException("1");
    lastBlock.initializeNoException("0");
    StoreEmit.initializeNoException("0");
  }
/** {@inheritDoc}
* @param e {@inheritDoc} */
  public void serviceEvent(EventServer e){
    if (e == INIT) service_INIT();
    else if (e == REQ) service_REQ();
    else if (e == CAS_STOP) service_CAS_STOP();
    else if (e == CAS_START) service_CAS_START();
    else if (e == REPLY_IN) service_REPLY_IN();
    else if (e == REQUEST_IN) service_REQUEST_IN();
  }
/** Services the INIT event. */
  public void service_INIT(){
    if ((eccState == index_START)) state_INIT();
  }
/** Services the REQ event. */
  public void service_REQ(){
    if ((eccState == index_START) && (!EnterPE.value)) state_SEND_REQUEST();
    else if ((eccState == index_ENTER_CRITICAL) && (!ExitPE.value)) state_FINISH_CRITICAL();
    else if ((eccState == index_FINISH_CRITICAL) && (ExitPE.value)) state_EXIT_CRITICAL();
    else if ((eccState == index_REQUEST_RECEIVED) && (EnterPE.value)) state_SEND_REPLY();
    else if ((eccState == index_START) && (Candidate.value)) state_REQ();
    else if ((eccState == index_REQUEST_RECEIVED_2) && (!ExitPE.value)) state_SEND_REPLY_2();
    else if ((eccState == index_ENTER_CRITICAL) && (!EnterPE.value)) state_ANOTHER_BAG();
    else if ((eccState == index_ANOTHER_BAG) && (!ExitPE.value)) state_SEND_REQUEST();
    else if ((eccState == index_COMPARE_CLOCKS) && (!ExitPE.value&Priority.value)) state_SEND_REQUEST();
    else if ((eccState == index_COMPARE_CLOCKS) && (!ExitPE.value)) state_SEND_REPLY_2();
  }
/** Services the CAS_STOP event. */
  public void service_CAS_STOP(){
    if ((eccState == index_START)) state_CAS_STOP();
  }
/** Services the CAS_START event. */
  public void service_CAS_START(){
    if ((eccState == index_START)) state_CAS_START();
  }
/** Services the REPLY_IN event. */
  public void service_REPLY_IN(){
    if ((eccState == index_SEND_REQUEST)) state_ENTER_CRITICAL();
  }
/** Services the REQUEST_IN event. */
  public void service_REQUEST_IN(){
    if ((eccState == index_START)) state_REQUEST_RECEIVED();
    else if ((eccState == index_ENTER_CRITICAL)) state_REQUEST_RECEIVED_2();
    else if ((eccState == index_ANOTHER_BAG)) state_REQUEST_RECEIVED_3();
  }
  /** ALGORITHM INIT IN ST*/
public void alg_INIT(){
MotoRotate.value=true;
Block.value=false;
}
  /** ALGORITHM REQ IN ST*/
public void alg_REQ(){
if(Candidate.value){
if(lastPE.value!=EnterPE.value){
if(!EnterPE.value){
BlockCon.value=true;
System.out.println("BlockCon = true");
}
else{
BlockCon.value=false;
System.out.println("BlockCon = false");
}
lastPE.value=EnterPE.value;
}
if(lastBlock.value!=Block.value){
if(Block.value){
STOP.serviceEvent(this);
MotoRotate.value=false;
System.out.println("Cas Stop");
}
else{
START.serviceEvent(this);
MotoRotate.value=true;
System.out.println("Cas Start");
}
lastBlock.value=Block.value;
}
}
}
  /** ALGORITHM START IN ST*/
public void alg_START(){
MotoRotate.value=true;
}
  /** ALGORITHM STOP IN ST*/
public void alg_STOP(){
MotoRotate.value=false;
}
  /** ALGORITHM REQUEST_SENDING IN Java*/
public void alg_REQUEST_SENDING(){
System.out.println("Requesting for Multicast");

}
  /** ALGORITHM ANOTHER_BAG_WAIT IN Java*/
public void alg_ANOTHER_BAG_WAIT(){
System.out.println("Another bag is wating for multicast");

}
  /** ALGORITHM REQUEST_RECEIVED IN Java*/
public void alg_REQUEST_RECEIVED(){
System.out.println("Multicast received a new request");

}
  /** ALGORITHM SEND_REPLY IN Java*/
public void alg_SEND_REPLY(){
System.out.println("Replied to Multicast request");

}
  /** ALGORITHM DIFFERENT_REQUEST IN Java*/
public void alg_DIFFERENT_REQUEST(){
System.out.println("Request from another conveyer received");

}
  /** ALGORITHM COMPARE_CLOCK IN Java*/
public void alg_COMPARE_CLOCK(){
System.out.println("Comparing clocks");
if(ClockIn.value>CLOCK.value){
Priority.value=true;
}
else {
Priority.value=false;
}

}
  /** ALGORITHM UPDATE_CLOCK IN Java*/
public void alg_UPDATE_CLOCK(){
CLOCK.value++;
ClockOut.value = CLOCK.value;
System.out.printf("Clock value updated = %d%n",CLOCK.value);

}
}
