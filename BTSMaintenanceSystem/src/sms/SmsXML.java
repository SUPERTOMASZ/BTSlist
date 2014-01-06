package sms;

import java.io.IOException;
import java.io.InputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import android.content.res.AssetManager;
import android.util.Log;

public class SmsXML 
{
	private AssetManager manager;
	private InputStream stream;
	private Document doc;
	private static final String xml_entry="enter";
	private static final String xml_exit="exit";
	private static final String xml_alarm="alarms";
	private static final String xml_phoneNumber="number";
	private static final String xml_contain="contain";
	
	public SmsXML(AssetManager manager)
	{
		
        this.manager=manager;
        
        try {
			this.stream = manager.open("sms.xml");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        this.doc=getDocument();
	}
	public Document getDocument() 
	{
        Document document = null;
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder db = factory.newDocumentBuilder();
            InputSource inputSource = new InputSource(stream);
            document = db.parse(inputSource);
        } catch (ParserConfigurationException e) {
            Log.e("Error: ", e.getMessage());
            return null;
        } catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return document;
    }
	private String getDataFromXML(String whichTemplate,String numerOrContain)
	{

         Element root=doc.getDocumentElement();

         NodeList nodeList=root.getElementsByTagName(whichTemplate);
         Node enter =nodeList.item(0);
        NodeList temp=enter.getChildNodes();
         Node result = null;

         for(int i=0;i<temp.getLength();i++)
         {
        	 result=temp.item(i);
        	 if(numerOrContain.contains(result.getNodeName()))
        		 break;
         }
         
		return result.getTextContent();
	}
	public String getPhoneNumFromEntry()
	{
		return getDataFromXML(xml_entry, xml_phoneNumber);
	}
	public String getPhoneNumFromExit()
	{
		return getDataFromXML(xml_exit, xml_phoneNumber);
	}
	public String getPhoneNumFromAlarms()
	{
		return getDataFromXML(xml_alarm, xml_phoneNumber);
	}
	public String getContainFromEntry()
	{
		return getDataFromXML(xml_entry, xml_contain);
	}
	public String getContainFromExit()
	{
		return getDataFromXML(xml_exit, xml_contain);
	}
	public String getContainFromAlarms()
	{
		return getDataFromXML(xml_alarm, xml_contain);
	}
}
