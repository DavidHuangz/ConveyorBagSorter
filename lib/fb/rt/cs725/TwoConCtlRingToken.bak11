/* Copyright (c)2021 Rockwell Automation. All rights reserved. */
package fb.rt.cs725;
import fb.datatype.*;
import fb.rt.*;
import fb.rt.events.*;
/** FUNCTION_BLOCK TwoConCtlRingToken
  * @author JHC
  * @version 20211022/JHC
  */
public class TwoConCtlRingToken extends FBInstance
{
/** VAR Candidate */
  public BOOL Candidate = new BOOL();
/** VAR Block */
  public BOOL Block = new BOOL();
/** VAR EnterPE */
  public BOOL EnterPE = new BOOL();
/** VAR TokenIn */
  public BOOL TokenIn = new BOOL();
/** VAR ExitPE */
  public BOOL ExitPE = new BOOL();
/** VAR MotoRotate1 */
  public BOOL MotoRotate1 = new BOOL();
/** VAR MotoRotate2 */
  public BOOL MotoRotate2 = new BOOL();
/** VAR BlockCon */
  public BOOL BlockCon = new BOOL();
/** VAR TokenOut */
  public BOOL TokenOut = new BOOL();
/** Initialization Request */
 public EventOutput INIT = new EventOutput();
/** Normal Execution Request */
 public EventOutput REQ = new EventOutput();
/** EVENT START */
 public EventOutput START = new EventOutput();
/** EVENT STOP */
 public EventOutput STOP = new EventOutput();
/** EVENT Token_Input */
 public EventOutput Token_Input = new EventOutput();
/** Initialization Confirm */
 public EventOutput INITO = new EventOutput();
/** Execution Confirmation */
 public EventOutput CNF = new EventOutput();
/** EVENT Token_Output */
 public EventOutput Token_Output = new EventOutput();
/** {@inheritDoc}
* @param s {@inheritDoc}
* @return {@inheritDoc}
*/
  public EventServer eiNamed(String s){
    if("INIT".equals(s)) return INIT;
    if("REQ".equals(s)) return REQ;
    if("START".equals(s)) return START;
    if("STOP".equals(s)) return STOP;
    if("Token_Input".equals(s)) return Token_Input;
    return super.eiNamed(s);}
/** {@inheritDoc}
* @param s {@inheritDoc}
* @return {@inheritDoc}
*/
  public EventOutput eoNamed(String s){
    if("INITO".equals(s)) return INITO;
    if("CNF".equals(s)) return CNF;
    if("Token_Output".equals(s)) return Token_Output;
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
    if("TokenIn".equals(s)) return TokenIn;
    if("ExitPE".equals(s)) return ExitPE;
    return super.ivNamed(s);}
/** {@inheritDoc}
* @param s {@inheritDoc}
* @return {@inheritDoc}
* @throws FBRManagementException {@inheritDoc}
*/
  public ANY ovNamed(String s) throws FBRManagementException{
    if("MotoRotate1".equals(s)) return MotoRotate1;
    if("MotoRotate2".equals(s)) return MotoRotate2;
    if("BlockCon".equals(s)) return BlockCon;
    if("TokenOut".equals(s)) return TokenOut;
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
    else if("TokenIn".equals(ivName)) connect_TokenIn((BOOL)newIV);
    else if("ExitPE".equals(ivName)) connect_ExitPE((BOOL)newIV);
    else super.connectIV(ivName, newIV);
    }
/** Connect the given variable to the input variable Candidate
  * @param newIV The variable to connect
  * @throws FBRManagementException An internal connection failed.
 */
  public void connect_Candidate(BOOL newIV) throws FBRManagementException{
    Candidate = newIV;
    RingToken.connectIVNoException("Candidate",Candidate);
    }
/** Connect the given variable to the input variable Block
  * @param newIV The variable to connect
  * @throws FBRManagementException An internal connection failed.
 */
  public void connect_Block(BOOL newIV) throws FBRManagementException{
    Block = newIV;
    RingToken.connectIVNoException("Block",Block);
    }
/** Connect the given variable to the input variable EnterPE
  * @param newIV The variable to connect
  * @throws FBRManagementException An internal connection failed.
 */
  public void connect_EnterPE(BOOL newIV) throws FBRManagementException{
    EnterPE = newIV;
    RingToken.connectIVNoException("EnterPE",EnterPE);
    }
/** Connect the given variable to the input variable TokenIn
  * @param newIV The variable to connect
  * @throws FBRManagementException An internal connection failed.
 */
  public void connect_TokenIn(BOOL newIV) throws FBRManagementException{
    TokenIn = newIV;
    RingToken.connectIVNoException("TokenIn",TokenIn);
    }
/** Connect the given variable to the input variable ExitPE
  * @param newIV The variable to connect
  * @throws FBRManagementException An internal connection failed.
 */
  public void connect_ExitPE(BOOL newIV) throws FBRManagementException{
    ExitPE = newIV;
    RingToken.connectIVNoException("ExitPE",ExitPE);
    }
/** FB FC11 */
  protected ConveyorCTL FC11 = new ConveyorCTL() ;
/** FB RingToken */
  protected RingToken RingToken = new RingToken() ;
/** The default constructor. */
public TwoConCtlRingToken(){
    super();
    INIT.connectTo(FC11.INIT);
    REQ.connectTo(FC11.REQ);
    RingToken.STOP.connectTo(FC11.CAS_STOP);
    RingToken.START.connectTo(FC11.CAS_START);
    RingToken.INITO.connectTo(INITO);
    FC11.INITO.connectTo(RingToken.INIT);
    REQ.connectTo(RingToken.REQ);
    STOP.connectTo(RingToken.CAS_STOP);
    START.connectTo(RingToken.CAS_START);
    Token_Input.connectTo(RingToken.Token_Input);
    RingToken.Token_Output.connectTo(Token_Output);
    MotoRotate1 = (BOOL)FC11.ovNamedNoException("MotoRotate");
    MotoRotate2 = (BOOL)RingToken.ovNamedNoException("MotoRotate");
    BlockCon = (BOOL)RingToken.ovNamedNoException("BlockCon");
    TokenOut = (BOOL)RingToken.ovNamedNoException("TokenOut");
    RingToken.connectIVNoException("EnterPE",EnterPE);
    RingToken.connectIVNoException("Block",Block);
    RingToken.connectIVNoException("Candidate",Candidate);
    RingToken.connectIVNoException("TokenIn",TokenIn);
    RingToken.connectIVNoException("ExitPE",ExitPE);
    FC11.PE.initializeNoException("0");
    FC11.Block.initializeNoException("0");
    FC11.Candidate.initializeNoException("0");
  }
/** {@inheritDoc}
 * @param fbName {@inheritDoc}
 * @param r {@inheritDoc}
 * @throws FBRManagementException {@inheritDoc} */
  public void initialize(String fbName, Resource r)
  throws FBRManagementException{
    super.initialize(fbName,r);
    FC11.initialize("FC11",r);
    RingToken.initialize("RingToken",r);
}
/** Start the FB instances. */
public void start( ){
  FC11.start();
  RingToken.start();
}
/** Stop the FB instances. */
public void stop( ){
  FC11.stop();
  RingToken.stop();
}
}
