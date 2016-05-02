package com.foodmood.api;
import javax.xml.*;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.*;
import java.util.HashMap;
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
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
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
    
	public Map<String, String> readXMLData() {
		InputStream xmlFile = null;
		String value = "";
		long articleID = 0;
		try {
			xmlFile = newURL.openStream();
			//File file = new File(xmlFile);
			DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();		
			Document xmlDocument = documentBuilder.parse(xmlFile);
			xmlDocument.getDocumentElement().normalize();
			
			NodeList rootNode = xmlDocument.getChildNodes();
			
			Node root = getNode(rootNode, "artiklar");
			Node childNode = getNode(root.getChildNodes(), "artikel");
			String t = getValuesFromArticleID(childNode, 1000005);
			xmlFile.close();
		} catch (IOException ioEx) {
			ioEx.printStackTrace();	
		} catch (ParserConfigurationException pcEx) {
			pcEx.printStackTrace();
		} catch (SAXException saxEx) {
			saxEx.printStackTrace();
		}
		return values;
	}
	
	private Node getNode(NodeList nodes, String tagName) {
		Node node = null;
		for (int i = 0; i < nodes.getLength(); i++) {	
			node = nodes.item(i);
			if (node.getNodeName().equalsIgnoreCase(tagName)) {
				return node;
			}
		}
		return null;
	}
	

	private String getValuesFromArticleID(Node node, long id) {
		StringBuffer buf = new StringBuffer();
	    NodeList children = node.getChildNodes();
	   
	    for (int i = 0; i < children.getLength(); i++) {
	        Node textChild = children.item(i);
	        if (textChild.getNodeType() != Node.TEXT_NODE) {
	            System.err.println("Mixed content! Skipping child element " + textChild.getNodeName());
	            continue;
	        }
	        buf.append(textChild.getNodeValue());
	    }
	    return buf.toString();
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
