package sms;

import station.DisplayStation;
import android.telephony.SmsManager;
import android.util.Log;
import android.widget.Toast;

public class SmsSend 
{
	private SmsXML xml;
	public SmsSend(SmsXML xml)
	{
		this.xml=xml;
	}
	private boolean sendSms(String phoneNo,String contain)
	{
			
	  try {
		  Log.i("Sms numer ",phoneNo);
		  Log.i("Sms zawartosc",contain);
		SmsManager smsManager = SmsManager.getDefault();
		smsManager.sendTextMessage(phoneNo, null, contain, null, null);
		
	  }
	  catch(IllegalArgumentException e)
	  {
		  return false;
	  }

	return true;
	}
	public boolean sendEntrySms(DisplayStation station)
	{
		String phoneNum=xml.getPhoneNumFromEntry();
		String contain=xml.getContainFromEntry();
		contain=convert(contain, station);
		return sendSms(phoneNum,contain);
	}
	public boolean sendExitSms(DisplayStation station)
	{
		String phoneNum=xml.getPhoneNumFromExit();
		String contain=xml.getContainFromExit();
		contain=convert(contain, station);
		return sendSms(phoneNum,contain);
	}
	public boolean sendAlarmSms(DisplayStation station)
	{
		String phoneNum=xml.getPhoneNumFromAlarms();
		String contain=xml.getContainFromAlarms();
		contain=convert(contain, station);
		return sendSms(phoneNum,contain);
	}
	private String convert(String in,DisplayStation station)
	{
		
		String statNum=station.getStationNum();
		statNum=statNum.replaceAll(" ", "");
		String NetNum=station.getNetWorksNum();
		NetNum=NetNum.replaceAll(" ", "");
		String PTCNum=station.getPTCNum();
		PTCNum=PTCNum.replaceAll(" ", "");
		String PTKNum=station.getPTKNum();
		PTKNum=PTKNum.replaceAll(" ", "");
		
		in=in.replaceAll("#nrStacji#", statNum);
		in=in.replaceAll("#nrNET#", NetNum);
		in=in.replaceAll("#nrPTC#",PTCNum);
		in=in.replaceAll("#nrPTK#", PTKNum);
		return in;
		
	}
}


