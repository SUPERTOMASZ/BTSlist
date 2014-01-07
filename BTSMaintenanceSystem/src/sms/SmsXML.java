package sms;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import android.content.Context;
import android.content.res.AssetManager;
import android.util.Log;

public class SmsXML 
{
	private AssetManager manager;
	private InputStream streamIn;
	private OutputStream streamOut;
	private Document doc;
	private Context context;
	private InputStream stream2;
	private File file;
	public static final String xml_entry="enter";
	public static final String xml_exit="exit";
	public static final String xml_alarm="alarms";
	public static final String xml_phoneNumber="number";
	public static final String xml_contain="contain";
	
	public SmsXML(Context context,AssetManager manager)
	{
		
			this.context=context;
              
              try {
            	  this.file = new File(context.getApplicationInfo().dataDir+"/xml/sms.xml");
            	  Log.i("smsXml",file.length()+" wazy");
            	this.stream2=new FileInputStream(context.getApplicationInfo().dataDir+"/xml/sms.xml");

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
            InputSource inputSource = new InputSource(stream2);
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
	public void editXML(String contatin,String whichTemplate,String contatinOrNumber)
	{
		Element root=doc.getDocumentElement();

        NodeList nodeList=root.getElementsByTagName(whichTemplate);
        Node template=nodeList.item(0);
       NodeList listAtr=template.getChildNodes();
        Node contatinNode = null ;
        
        for(int i=0;i<listAtr.getLength();i++)
        {
        	contatinNode=listAtr.item(i);
       	 if(contatinOrNumber.contains(contatinNode.getNodeName()))
       		 break;
        }
        contatinNode.setTextContent(contatin);
        
      
		try {
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			DOMSource source = new DOMSource(doc);
			StreamResult result = new StreamResult(file);
			transformer.transform(source, result);
			Log.i("XML","Wpisalem");
		} catch (TransformerException e) {
			// TODO Auto-generated catch block
			Log.i("XML","failed");
			e.printStackTrace();
		}
	}
	public void editPhonoNo(String contatin,String whichTemplate)
	{
		editXML(contatin, whichTemplate, xml_phoneNumber);
	}
	public void editContatin(String contatin,String whichTemplate)
	{
		editXML(contatin, whichTemplate, xml_contain);
	}
	
	
}
