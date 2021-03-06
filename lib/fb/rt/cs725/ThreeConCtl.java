/* Copyright (c)2021 Rockwell Automation. All rights reserved. */
package fb.rt.cs725;
import fb.datatype.*;
import fb.rt.*;
import fb.rt.events.*;
/** FUNCTION_BLOCK ThreeConCtl
  * @author JHC
  * @version 20211022/JHC
  */
public class ThreeConCtl extends FBInstance
{
/** VAR Candidate */
  public BOOL Candidate = new BOOL();
/** VAR Block */
  public BOOL Block = new BOOL();
/** VAR EnterPE */
  public BOOL EnterPE = new BOOL();
/** VAR PE8 */
  public BOOL PE8 = new BOOL();
/** VAR PE14 */
  public BOOL PE14 = new BOOL();
/** VAR TokenIn */
  public BOOL TokenIn = new BOOL();
/** VAR ExitPE */
  public BOOL ExitPE = new BOOL();
/** VAR ClockIn */
  public INT ClockIn = new INT();
/** VAR ID */
  public BOOL ID = new BOOL();
/** VAR MotoRotate1 */
  public BOOL MotoRotate1 = new BOOL();
/** VAR MotoRotate2 */
  public BOOL MotoRotate2 = new BOOL();
/** VAR MotoRotate3 */
  public BOOL MotoRotate3 = new BOOL();
/** VAR BlockCon */
  public BOOL BlockCon = new BOOL();
/** VAR TokenOut */
  public BOOL TokenOut = new BOOL();
/** VAR ClockOut */
  public INT ClockOut = new INT();
/** Initialization Request */
 public EventOutput INIT = new EventOutput();
/** Normal Execution Request */
 public EventOutput REQ = new EventOutput();
/** EVENT REPLY_IN */
 public EventOutput REPLY_IN = new EventOutput();
/** EVENT REQUEST_IN */
 public EventOutput REQUEST_IN = new EventOutput();
/** EVENT Token_Input */
 public EventOutput Token_Input = new EventOutput();
/** Initialization Confirm */
 public EventOutput INITO = new EventOutput();
/** Execution Confirmation */
 public EventOutput CNF = new EventOutput();
/** EVENT START */
 public EventOutput START = new EventOutput();
/** EVENT STOP */
 public EventOutput STOP = new EventOutput();
/** EVENT REPLY_OUT */
 public EventOutput REPLY_OUT = new EventOutput();
/** EVENT REQUEST_OUT */
 public EventOutput REQUEST_OUT = new EventOutput();
/** EVENT Token_Output */
 public EventOutput Token_Output = new EventOutput();
/** EVENT Cascade_Stop */
 public EventOutput Cascade_Stop = new EventOutput();
/** EVENT Cascade_Start */
 public EventOutput Cascade_Start = new EventOutput();
/** {@inheritDoc}
* @param s {@inheritDoc}
* @return {@inheritDoc}
*/
  public EventServer eiNamed(String s){
    if("INIT".equals(s)) return INIT;
    if("REQ".equals(s)) return REQ;
    if("REPLY_IN".equals(s)) return REPLY_IN;
    if("REQUEST_IN".equals(s)) return REQUEST_IN;
    if("Token_Input".equals(s)) return Token_Input;
    return super.eiNamed(s);}
/** {@inheritDoc}
* @param s {@inheritDoc}
* @return {@inheritDoc}
*/
  public EventOutput eoNamed(String s){
    if("INITO".equals(s)) return INITO;
    if("CNF".equals(s)) return CNF;
    if("START".equals(s)) return START;
    if("STOP".equals(s)) return STOP;
    if("REPLY_OUT".equals(s)) return REPLY_OUT;
    if("REQUEST_OUT".equals(s)) return REQUEST_OUT;
    if("Token_Output".equals(s)) return Token_Output;
    if("Cascade_Stop".equals(s)) return Cascade_Stop;
    if("Cascade_Start".equals(s)) return Cascade_Start;
    return super.eoNamed(s);}
/** {@inheritDoc}
* @param s {@inheritDoc}
* @return {@inheritDoc}
* @throws FBRManagementException {@inheritDoc}
*/
  public ANY ivNamed(String s) throws FBRManagementException{
    if("Candidate".equals(s)) return Candidate;
    if("Block".equals(s)) return Block;
    if("EnterPE".equals(s)) return EnterPE;
    if("PE8".equals(s)) return PE8;
    if("PE14".equals(s)) return PE14;
    if("TokenIn".equals(s)) return TokenIn;
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
    if("MotoRotate1".equals(s)) return MotoRotate1;
    if("MotoRotate2".equals(s)) return MotoRotate2;
    if("MotoRotate3".equals(s)) return MotoRotate3;
    if("BlockCon".equals(s)) return BlockCon;
    if("TokenOut".equals(s)) return TokenOut;
    if("ClockOut".equals(s)) return ClockOut;
    return super.ovNamed(s);}
/** {@inheritDoc}
* @param ivName {@inheritDoc}
* @param newIV {@inheritDoc}
* @throws FBRManagementException {@inheritDoc} */
  public void connectIV(String ivName, ANY newIV)
    throws FBRManagementException{
    if("Candidate".equals(ivName)) connect_Candidate((BOOL)newIV);
    else if("Block".equals(ivName)) connect_Block((BOOL)newIV);
    else if("EnterPE".equals(ivName)) connect_EnterPE((BOOL)newIV);
    else if("PE8".equals(ivName)) connect_PE8((BOOL)newIV);
    else if("PE14".equals(ivName)) connect_PE14((BOOL)newIV);
    else if("TokenIn".equals(ivName)) connect_TokenIn((BOOL)newIV);
    else if("ExitPE".equals(ivName)) connect_ExitPE((BOOL)newIV);
    else if("ClockIn".equals(ivName)) connect_ClockIn((INT)newIV);
    else if("ID".equals(ivName)) connect_ID((BOOL)newIV);
    else super.connectIV(ivName, newIV);
    }
/** Connect the given variable to the input variable Candidate
  * @param newIV The variable to connect
  * @throws FBRManagementException An internal connection failed.
 */
  public void connect_Candidate(BOOL newIV) throws FBRManagementException{
    Candidate = newIV;
    FC111.connectIVNoException("Candidate",Candidate);
    }
/** Connect the given variable to the input variable Block
  * @param newIV The variable to connect
  * @throws FBRManagementException An internal connection failed.
 */
  public void connect_Block(BOOL newIV) throws FBRManagementException{
    Block = newIV;
    FC111.connectIVNoException("Block",Block);
    }
/** Connect the given variable to the input variable EnterPE
  * @param newIV The variable to connect
  * @throws FBRManagementException An internal connection failed.
 */
  public void connect_EnterPE(BOOL newIV) throws FBRManagementException{
    EnterPE = newIV;
    FC111.connectIVNoException("EnterPE",EnterPE);
    }
/** Connect the given variable to the input variable PE8
  * @param newIV The variable to connect
  * @throws FBRManagementException An internal connection failed.
 */
  public void connect_PE8(BOOL newIV) throws FBRManagementException{
    PE8 = newIV;
    FC12.connectIVNoException("EnterPE",PE8);
    }
/** Connect the given variable to the input variable PE14
  * @param newIV The variable to connect
  * @throws FBRManagementException An internal connection failed.
 */
  public void connect_PE14(BOOL newIV) throws FBRManagementException{
    PE14 = newIV;
    FC12.connectIVNoException("ExitPE",PE14);
    }
/** Connect the given variable to the input variable TokenIn
  * @param newIV The variable to connect
  * @throws FBRManagementException An internal connection failed.
 */
  public void connect_TokenIn(BOOL newIV) throws FBRManagementException{
    TokenIn = newIV;
    FC111.connectIVNoException("TokenIn",TokenIn);
    }
/** Connect the given variable to the input variable ExitPE
  * @param newIV The variable to connect
  * @throws FBRManagementException An internal connection failed.
 */
  public void connect_ExitPE(BOOL newIV) throws FBRManagementException{
    ExitPE = newIV;
    FC111.connectIVNoException("ExitPE",ExitPE);
    }
/** Connect the given variable to the input variable ClockIn
  * @param newIV The variable to connect
  * @throws FBRManagementException An internal connection failed.
 */
  public void connect_ClockIn(INT newIV) throws FBRManagementException{
    ClockIn = newIV;
    FC12.connectIVNoException("ClockIn",ClockIn);
    }
/** Connect the given variable to the input variable ID
  * @param newIV The variable to connect
  * @throws FBRManagementException An internal connection failed.
 */
  public void connect_ID(BOOL newIV) throws FBRManagementException{
    ID = newIV;
    FC12.connectIVNoException("ID",ID);
    }
/** FB FC12 */
  protected ConveyorCTLMulti FC12 = new ConveyorCTLMulti() ;
/** FB FC13 */
  protected ConveyorCTL FC13 = new ConveyorCTL() ;
/** FB FC111 */
  protected RingToken FC111 = new RingToken() ;
/** The default constructor. */
public ThreeConCtl(){
    super();
    FC12.INITO.connectTo(FC13.INIT);
    FC13.INITO.connectTo(INITO);
    FC13.CNF.connectTo(CNF);
    REQ.connectTo(FC12.REQ);
    REQ.connectTo(FC13.REQ);
    FC12.CNF.connectTo(CNF);
    REPLY_IN.connectTo(FC12.REPLY_IN);
    REQUEST_IN.connectTo(FC12.REQUEST_IN);
    FC12.REQUEST_OUT.connectTo(REQUEST_OUT);
    FC12.REPLY_OUT.connectTo(REPLY_OUT);
    FC12.STOP.connectTo(Cascade_Stop);
    FC12.START.connectTo(Cascade_Start);
    FC111.CNF.connectTo(CNF);
    FC111.STOP.connectTo(STOP);
    FC111.START.connectTo(START);
    FC111.Token_Output.connectTo(Token_Output);
    Token_Input.connectTo(FC111.Token_Input);
    REQ.connectTo(FC111.REQ);
    INIT.connectTo(FC111.INIT);
    FC111.INITO.connectTo(FC12.INIT);
    FC12.STOP.connectTo(FC111.CAS_STOP);
    FC12.START.connectTo(FC111.CAS_START);
    MotoRotate3 = (BOOL)FC13.ovNamedNoException("MotoRotate");
    MotoRotate2 = (BOOL)FC12.ovNamedNoException("MotoRotate");
    FC111.connectIVNoException("EnterPE",EnterPE);
    FC111.connectIVNoException("Block",Block);
    FC111.connectIVNoException("Candidate",Candidate);
    FC111.connectIVNoException("TokenIn",TokenIn);
    FC111.connectIVNoException("ExitPE",ExitPE);
    MotoRotate1 = (BOOL)FC111.ovNamedNoException("MotoRotate");
    BlockCon = (BOOL)FC111.ovNamedNoException("BlockCon");
    TokenOut = (BOOL)FC111.ovNamedNoException("TokenOut");
    FC12.connectIVNoException("EnterPE",PE8);
    FC12.connectIVNoException("ExitPE",PE14);
    FC12.connectIVNoException("ID",ID);
    FC12.connectIVNoException("ClockIn",ClockIn);
    ClockOut = (INT)FC12.ovNamedNoException("ClockOut");
    FC12.Block.initializeNoException("0");
    FC12.Candidate.initializeNoException("0");
    FC13.Block.initializeNoException("0");
    FC13.Candidate.initializeNoException("0");
    FC13.PE.initializeNoException("0");
  }
/** {@inheritDoc}
 * @param fbName {@inheritDoc}
 * @param r {@inheritDoc}
 * @throws FBRManagementException {@inheritDoc} */
  public void initialize(String fbName, Resource r)
  throws FBRManagementException{
    super.initialize(fbName,r);
    FC12.initialize("FC12",r);
    FC13.initialize("FC13",r);
    FC111.initialize("FC111",r);
}
/** Start the FB instances. */
public void start( ){
  FC12.start();
  FC13.start();
  FC111.start();
}
/** Stop the FB instances. */
public void stop( ){
  FC12.stop();
  FC13.stop();
  FC111.stop();
}
}
