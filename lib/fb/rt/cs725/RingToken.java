/* Copyright (c)2021 Rockwell Automation. All rights reserved. */
package fb.rt.cs725;
import fb.datatype.*;
import fb.rt.*;
import fb.rt.events.*;
/** FUNCTION_BLOCK RingToken
  * @author JHC
  * @version 20211022/JHC
  */
public class RingToken extends FBInstance
{
/** Input event qualifier */
  public BOOL EnterPE = new BOOL();
/** VAR Block */
  public BOOL Block = new BOOL();
/** VAR Candidate */
  public BOOL Candidate = new BOOL();
/** VAR TokenIn */
  public BOOL TokenIn = new BOOL();
/** VAR ExitPE */
  public BOOL ExitPE = new BOOL();
/** Output event qualifier */
  public BOOL MotoRotate = new BOOL();
/** VAR BlockCon */
  public BOOL BlockCon = new BOOL();
/** VAR TokenOut */
  public BOOL TokenOut = new BOOL();
/** VAR lastPE */
  public BOOL lastPE = new BOOL();
/** VAR lastBlock */
  public BOOL lastBlock = new BOOL();
/** Initialization Request */
 public EventServer INIT = new EventInput(this);
/** Normal Execution Request */
 public EventServer REQ = new EventInput(this);
/** EVENT CAS_STOP */
 public EventServer CAS_STOP = new EventInput(this);
/** EVENT CAS_START */
 public EventServer CAS_START = new EventInput(this);
/** EVENT Token_Input */
 public EventServer Token_Input = new EventInput(this);
/** Initialization Confirm */
 public EventOutput INITO = new EventOutput();
/** Execution Confirmation */
 public EventOutput CNF = new EventOutput();
/** EVENT STOP */
 public EventOutput STOP = new EventOutput();
/** EVENT START */
 public EventOutput START = new EventOutput();
/** EVENT Token_Output */
 public EventOutput Token_Output = new EventOutput();
/** {@inheritDoc}
* @param s {@inheritDoc}
* @return {@inheritDoc}
*/
  public EventServer eiNamed(String s){
    if("INIT".equals(s)) return INIT;
    if("REQ".equals(s)) return REQ;
    if("CAS_STOP".equals(s)) return CAS_STOP;
    if("CAS_START".equals(s)) return CAS_START;
    if("Token_Input".equals(s)) return Token_Input;
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
    if("Token_Output".equals(s)) return Token_Output;
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
    if("TokenIn".equals(s)) return TokenIn;
    if("ExitPE".equals(s)) return ExitPE;
    return super.ivNamed(s);}
/** {@inheritDoc}
* @param s {@inheritDoc}
* @return {@inheritDoc}
* @throws FBRManagementException {@inheritDoc}
*/
  public ANY ovNamed(String s) throws FBRManagementException{
    if("MotoRotate".equals(s)) return MotoRotate;
    if("BlockCon".equals(s)) return BlockCon;
    if("TokenOut".equals(s)) return TokenOut;
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
    else if("TokenIn".equals(ivName)) connect_TokenIn((BOOL)newIV);
    else if("ExitPE".equals(ivName)) connect_ExitPE((BOOL)newIV);
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
/** Connect the given variable to the input variable TokenIn
  * @param newIV The variable to connect
 */
  public void connect_TokenIn(BOOL newIV){
    TokenIn = newIV;
    }
/** Connect the given variable to the input variable ExitPE
  * @param newIV The variable to connect
 */
  public void connect_ExitPE(BOOL newIV){
    ExitPE = newIV;
    }
private static final int index_START = 0;
private void state_START(){
  eccState = index_START;
  alg_RELEASE_TOKEN();
  Token_Output.serviceEvent(this);
}
private static final int index_INIT = 1;
private void state_INIT(){
  eccState = index_INIT;
  alg_INIT();
  INITO.serviceEvent(this);
  CNF.serviceEvent(this);
state_START();
}
private static final int index_AWAITING_TOKEN = 2;
private void state_AWAITING_TOKEN(){
  eccState = index_AWAITING_TOKEN;
  alg_STOP();
  STOP.serviceEvent(this);
  CNF.serviceEvent(this);
  alg_TOKENUSE();
}
private static final int index_HAS_TOKEN = 3;
private void state_HAS_TOKEN(){
  eccState = index_HAS_TOKEN;
  alg_USING_TOKEN();
  Token_Output.serviceEvent(this);
}
private static final int index_CRITICAL_SECTION = 4;
private void state_CRITICAL_SECTION(){
  eccState = index_CRITICAL_SECTION;
  alg_START();
  START.serviceEvent(this);
  CNF.serviceEvent(this);
}
private static final int index_FINISHED_CRITICAL = 5;
private void state_FINISHED_CRITICAL(){
  eccState = index_FINISHED_CRITICAL;
}
private static final int index_STOP_OTHER_BAGS = 6;
private void state_STOP_OTHER_BAGS(){
  eccState = index_STOP_OTHER_BAGS;
  alg_STOP();
  STOP.serviceEvent(this);
  CNF.serviceEvent(this);
}
private static final int index_LEAVING_CRITICAL = 7;
private void state_LEAVING_CRITICAL(){
  eccState = index_LEAVING_CRITICAL;
  alg_TOKENRELEASE();
}
private static final int index_CAS_STOP = 8;
private void state_CAS_STOP(){
  eccState = index_CAS_STOP;
  alg_STOP();
  STOP.serviceEvent(this);
  CNF.serviceEvent(this);
state_START();
}
private static final int index_CAS_START = 9;
private void state_CAS_START(){
  eccState = index_CAS_START;
  alg_START();
  START.serviceEvent(this);
  CNF.serviceEvent(this);
state_START();
}
private static final int index_CAS_STOP_1 = 10;
private void state_CAS_STOP_1(){
  eccState = index_CAS_STOP_1;
  alg_STOP();
  STOP.serviceEvent(this);
  CNF.serviceEvent(this);
}
/** The default constructor. */
public RingToken(){
    super();
    lastPE.initializeNoException("1");
    lastBlock.initializeNoException("0");
  }
/** {@inheritDoc}
* @param e {@inheritDoc} */
  public void serviceEvent(EventServer e){
    if (e == INIT) service_INIT();
    else if (e == REQ) service_REQ();
    else if (e == CAS_STOP) service_CAS_STOP();
    else if (e == CAS_START) service_CAS_START();
    else if (e == Token_Input) service_Token_Input();
  }
/** Services the INIT event. */
  public void service_INIT(){
    if ((eccState == index_START)) state_INIT();
  }
/** Services the REQ event. */
  public void service_REQ(){
    if ((eccState == index_START) && (!EnterPE.value)) state_AWAITING_TOKEN();
    else if ((eccState == index_HAS_TOKEN) && (!EnterPE.value)) state_CRITICAL_SECTION();
    else if ((eccState == index_HAS_TOKEN) && (EnterPE.value)) state_START();
    else if ((eccState == index_CRITICAL_SECTION) && (EnterPE.value)) state_FINISHED_CRITICAL();
    else if ((eccState == index_FINISHED_CRITICAL) && (!EnterPE.value)) state_STOP_OTHER_BAGS();
    else if ((eccState == index_FINISHED_CRITICAL) && (!ExitPE.value)) state_LEAVING_CRITICAL();
    else if ((eccState == index_STOP_OTHER_BAGS) && (!ExitPE.value)) state_LEAVING_CRITICAL();
    else if ((eccState == index_LEAVING_CRITICAL) && (ExitPE.value)) state_START();
  }
/** Services the CAS_STOP event. */
  public void service_CAS_STOP(){
    if ((eccState == index_START)) state_CAS_STOP();
    else if ((eccState == index_CRITICAL_SECTION)) state_CAS_STOP_1();
  }
/** Services the CAS_START event. */
  public void service_CAS_START(){
    if ((eccState == index_START)) state_CAS_START();
    else if ((eccState == index_CAS_STOP_1)) state_CRITICAL_SECTION();
  }
/** Services the Token_Input event. */
  public void service_Token_Input(){
    if ((eccState == index_AWAITING_TOKEN) && (TokenIn.value)) state_CRITICAL_SECTION();
    else if ((eccState == index_START) && (TokenIn.value)) state_HAS_TOKEN();
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
  /** ALGORITHM USING_TOKEN IN ST*/
public void alg_USING_TOKEN(){
TokenOut.value=false;
}
  /** ALGORITHM RELEASE_TOKEN IN ST*/
public void alg_RELEASE_TOKEN(){
TokenOut.value=true;
}
  /** ALGORITHM TOKENUSE IN ST*/
public void alg_TOKENUSE(){
System.out.println("Ring Token is being used");
}
  /** ALGORITHM TOKENRELEASE IN ST*/
public void alg_TOKENRELEASE(){
System.out.println("Ring Token has been released");
}
}
