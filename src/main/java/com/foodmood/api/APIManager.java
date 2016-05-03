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
public class APIManager extends DefaultHandler {
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
			
			SAXParser parser = SAXParserFactory.newInstance().newSAXParser();
			parser.parse(xmlFile, this);
			
			
			//DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
			//DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();		
			//Document xmlDocument = documentBuilder.parse(xmlFile);
			
			//Element rootNode = xmlDocument.getDocumentElement();
			//NodeList nodes = rootNode.getElementsByTagName("artikel");		
			//String value = getValuesFromArticleNumber(nodes, "7599701");
			
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
	/*	
	private Node getNode(String tagName, Node node) {
		NodeList nodeList = node.getChildNodes();
		Node nodeValue = null;
	    for ( int x = 0; x < nodeList.getLength(); x++ ) {	    	
	        nodeValue = nodeList.item(x);     
	    }	 
	    return nodeValue;
	} */
	
	
	private String getValuesFromArticleNumber(NodeList nodes, String articleNumber) {
		Node nodeValue;
		
		for (int i = 0; i < nodes.getLength(); i++) {
			Node n = nodes.item(i).getFirstChild();
			System.out.println(n.getTextContent());
		}
	
		return "";
	} 
	

    @Override
    public void startDocument() throws SAXException {
    }

    @Override
    public void endDocument() throws SAXException {
    }

    @Override
    public void startElement(String uri, String localName, String qName,
            Attributes attributes) throws SAXException {
    }

    @Override
    public void endElement(String uri, String localName, String qName)
            throws SAXException {
    }

    // To take specific actions for each chunk of character data (such as
    // adding the data to a node or buffer, or printing it to a file).
    @Override
    public void characters(char ch[], int start, int length)
            throws SAXException {
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
