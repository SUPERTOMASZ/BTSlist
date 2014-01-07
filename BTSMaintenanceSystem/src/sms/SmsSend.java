package sms;

import station.Station;
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
	public boolean sendEntrySms(Station station)
	{
		String phoneNum=xml.getPhoneNumFromEntry();
		String contain=xml.getContainFromEntry();
		//contain to convert
		return sendSms(phoneNum,contain);
	}
	public boolean sendExitSms(Station station)
	{
		String phoneNum=xml.getPhoneNumFromExit();
		String contain=xml.getContainFromExit();
		//contain to convert
		return sendSms(phoneNum,contain);
	}
	public boolean sendAlarmSms(Station station)
	{
		String phoneNum=xml.getPhoneNumFromAlarms();
		String contain=xml.getContainFromAlarms();
		//contain to convert
		return sendSms(phoneNum,contain);
	}
}


