package com.foodmood.api;
import javax.xml.*;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

//start of defaulthandler for possible sax xml parser interaction
public class APIManager {
	private URL newURL;
	private Map<String, String> values = null;
	
	public APIManager(String url) {
		values = new HashMap<String, String>();
		try {
			newURL = new URL(url);
		} catch (MalformedURLException max) {			
			max.printStackTrace();
		}
	}
			
	public void initializeConnection() {
		try {			
			URLConnection urlConnection = newURL.openConnection();
			urlConnection.connect();
	
		} catch (IOException ioex) {
			ioex.printStackTrace();
		}
	}
    
	public String readXMLData() {
		InputStream xmlFile = null;
		try {
			xmlFile = newURL.openStream();
		
			DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();		
			Document xmlDocument = documentBuilder.parse(xmlFile);
			
			Element rootNode = xmlDocument.getDocumentElement();
			NodeList nodes = rootNode.getElementsByTagName("artikel");		
			Map<String, String> value = getValuesFromArticleNumber(nodes, "101");
			
			//Node childNode = getNode(rootNode.getChildNodes(), "artikel");
			//String test = getValuesFromArticleNumber(numberChildNode, "1000005");
			
			xmlFile.close();
		} catch (IOException ioEx) {
			ioEx.printStackTrace();	
		} catch (ParserConfigurationException pcEx) {
			pcEx.printStackTrace();
		} catch (SAXException saxEx) {
			saxEx.printStackTrace();
		}
		return "";
	}
	
	private Map<String, String> getValuesFromArticleNumber(NodeList nodes, String articleNumber) {
		try {
			//get first 200 articles
			for (int i = 0; i < 200; i++) {
				Element element = (Element)nodes.item(i).getFirstChild();
				if (element.getTextContent().equals(articleNumber)) { //if equal to the entered articleNumber get values starting from parent node
					NodeList nodeList = element.getParentNode().getChildNodes(); 
					for (int j = 0; j < nodeList.getLength(); j++) {
						Element childValues = (Element) nodeList.item(j);
						values.put(childValues.getNodeName(), childValues.getTextContent());
					}
				}
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return values;
	} 

	
	public String convertToJSON(Map<String, String> val) throws JSONException {
		StringBuilder stringBuilder = new StringBuilder();
		for (String jsonvalues : val.values()) {
			stringBuilder.append(jsonvalues);
		}
		JSONObject obj = new JSONObject(stringBuilder.toString());		
		JSONArray jsonarray = new JSONArray();
		return obj.getString(stringBuilder.toString());
	}
}
