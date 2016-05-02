package com.foodmood.api;
import javax.xml.*;

import java.io.File;
import java.io.IOException;
import java.net.*;
import java.util.HashMap;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

//start of defaulthandler for possible sax xml parser interaction
public class ApiManager extends DefaultHandler {
	private URL newURL;
	private Map<String, String> values = null;
	
	public ApiManager(String url) {
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
    
	public void readXMLData() throws SAXException, IOException {
		try {
			String xmlFile = newURL.toExternalForm();
			File file = new File(xmlFile);
			DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();		
			Document xmlDocument = documentBuilder.parse(file);
			xmlDocument.getDocumentElement().normalize();
			
			NodeList nodes = xmlDocument.getElementsByTagName("Namn");
			
			for (int i = 0; i < nodes.getLength(); i++) {
				Node element = nodes.item(i);
				String nodeName = element.getNodeName();
				String nodeValue = element.getNodeValue();
				values.put(nodeName, nodeValue);
			}
			
		} catch (ParserConfigurationException pcEx) {
			pcEx.printStackTrace();
		}

	}
	
	public JSONObject convertToJSON() throws JSONException {
		StringBuilder stringBuilder = new StringBuilder();
		for (String jsonvalues : values.values()) {
			stringBuilder.append(jsonvalues);
		}
		JSONObject obj = new JSONObject(stringBuilder.toString());		
		return obj;
	}
}
