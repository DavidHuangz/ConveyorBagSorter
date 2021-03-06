/* Copyright (c)2021 Rockwell Automation. All rights reserved. */
package fb.rt.net;
import fb.datatype.*;
import fb.rt.*;
import fb.rt.events.*;
/** FUNCTION_BLOCK PUBL_11
  * @author JHC
  * @version 20211021/JHC
  */
public class PUBL_11 extends FBInstance
{
/** Local Group Name-Default is FB Instance Name */
  public WSTRING ID = new WSTRING();
/** Data to Send */
  public ANY SD_1 = new ANYImpl();
/** VAR SD_2 */
  public ANY SD_2 = new ANYImpl();
/** VAR SD_3 */
  public ANY SD_3 = new ANYImpl();
/** VAR SD_4 */
  public ANY SD_4 = new ANYImpl();
/** VAR SD_5 */
  public ANY SD_5 = new ANYImpl();
/** VAR SD_6 */
  public ANY SD_6 = new ANYImpl();
/** VAR SD_7 */
  public ANY SD_7 = new ANYImpl();
/** VAR SD_8 */
  public ANY SD_8 = new ANYImpl();
/** VAR SD_9 */
  public ANY SD_9 = new ANYImpl();
/** VAR SD_10 */
  public ANY SD_10 = new ANYImpl();
/** VAR SD_11 */
  public ANY SD_11 = new ANYImpl();
/** Service Initialization */
 public EventServer INIT = new EventInput(this);
/** Service Request */
 public EventServer REQ = new EventInput(this);
/** Initialization Confirm */
 public EventOutput INITO = new EventOutput();
/** Service Confirmation */
 public EventOutput CNF = new EventOutput();
/** {@inheritDoc}
* @param s {@inheritDoc}
* @return {@inheritDoc}
*/
  public EventServer eiNamed(String s){
    if("INIT".equals(s)) return INIT;
    if("REQ".equals(s)) return REQ;
    return super.eiNamed(s);}
/** {@inheritDoc}
* @param s {@inheritDoc}
* @return {@inheritDoc}
*/
  public EventOutput eoNamed(String s){
    if("INITO".equals(s)) return INITO;
    if("CNF".equals(s)) return CNF;
    return super.eoNamed(s);}
/** {@inheritDoc}
* @param s {@inheritDoc}
* @return {@inheritDoc}
* @throws FBRManagementException {@inheritDoc}
*/
  public ANY ivNamed(String s) throws FBRManagementException{
    if("ID".equals(s)) return ID;
    if("SD_1".equals(s)) return SD_1;
    if("SD_2".equals(s)) return SD_2;
    if("SD_3".equals(s)) return SD_3;
    if("SD_4".equals(s)) return SD_4;
    if("SD_5".equals(s)) return SD_5;
    if("SD_6".equals(s)) return SD_6;
    if("SD_7".equals(s)) return SD_7;
    if("SD_8".equals(s)) return SD_8;
    if("SD_9".equals(s)) return SD_9;
    if("SD_10".equals(s)) return SD_10;
    if("SD_11".equals(s)) return SD_11;
    return super.ivNamed(s);}
/** {@inheritDoc}
* @param ivName {@inheritDoc}
* @param newIV {@inheritDoc}
* @throws FBRManagementException {@inheritDoc} */
  public void connectIV(String ivName, ANY newIV)
    throws FBRManagementException{
    if("ID".equals(ivName)) connect_ID((WSTRING)newIV);
    else if("SD_1".equals(ivName)) connect_SD_1(newIV);
    else if("SD_2".equals(ivName)) connect_SD_2(newIV);
    else if("SD_3".equals(ivName)) connect_SD_3(newIV);
    else if("SD_4".equals(ivName)) connect_SD_4(newIV);
    else if("SD_5".equals(ivName)) connect_SD_5(newIV);
    else if("SD_6".equals(ivName)) connect_SD_6(newIV);
    else if("SD_7".equals(ivName)) connect_SD_7(newIV);
    else if("SD_8".equals(ivName)) connect_SD_8(newIV);
    else if("SD_9".equals(ivName)) connect_SD_9(newIV);
    else if("SD_10".equals(ivName)) connect_SD_10(newIV);
    else if("SD_11".equals(ivName)) connect_SD_11(newIV);
    else super.connectIV(ivName, newIV);
    }
/** Connect the given variable to the input variable ID
  * @param newIV The variable to connect
 */
  public void connect_ID(WSTRING newIV){
    ID = newIV;
    }
/** Connect the given variable to the input variable SD_1
  * @param newIV The variable to connect
 */
  public void connect_SD_1(ANY newIV){
    SD_1 = newIV;
    }
/** Connect the given variable to the input variable SD_2
  * @param newIV The variable to connect
 */
  public void connect_SD_2(ANY newIV){
    SD_2 = newIV;
    }
/** Connect the given variable to the input variable SD_3
  * @param newIV The variable to connect
 */
  public void connect_SD_3(ANY newIV){
    SD_3 = newIV;
    }
/** Connect the given variable to the input variable SD_4
  * @param newIV The variable to connect
 */
  public void connect_SD_4(ANY newIV){
    SD_4 = newIV;
    }
/** Connect the given variable to the input variable SD_5
  * @param newIV The variable to connect
 */
  public void connect_SD_5(ANY newIV){
    SD_5 = newIV;
    }
/** Connect the given variable to the input variable SD_6
  * @param newIV The variable to connect
 */
  public void connect_SD_6(ANY newIV){
    SD_6 = newIV;
    }
/** Connect the given variable to the input variable SD_7
  * @param newIV The variable to connect
 */
  public void connect_SD_7(ANY newIV){
    SD_7 = newIV;
    }
/** Connect the given variable to the input variable SD_8
  * @param newIV The variable to connect
 */
  public void connect_SD_8(ANY newIV){
    SD_8 = newIV;
    }
/** Connect the given variable to the input variable SD_9
  * @param newIV The variable to connect
 */
  public void connect_SD_9(ANY newIV){
    SD_9 = newIV;
    }
/** Connect the given variable to the input variable SD_10
  * @param newIV The variable to connect
 */
  public void connect_SD_10(ANY newIV){
    SD_10 = newIV;
    }
/** Connect the given variable to the input variable SD_11
  * @param newIV The variable to connect
 */
  public void connect_SD_11(ANY newIV){
    SD_11 = newIV;
    }
/** The default constructor. */
public PUBL_11(){
    super();
  }
/** {@inheritDoc}
* @param e {@inheritDoc} */
  public void serviceEvent(EventServer e){
    if (e == INIT) service_INIT();
    else if (e == REQ) service_REQ();
  }
/** Services the INIT event. */
  public void service_INIT(){
  }
/** Services the REQ event. */
  public void service_REQ(){
  }
}
