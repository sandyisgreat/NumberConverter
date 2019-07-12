package com.virtusa.codeTest;

import java.io.File;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class BasicXmlParser {
	private volatile File xmlFile;
	private static final String XML_OPENER = "<";
	private static final String XML_CLOSER = "</";
	private static final String XML_END = ">";
	Map<String, Object> mapData;

	public BasicXmlParser() {
		mapData = new HashMap<String, Object>();
	}

	public BasicXmlParser(File file) {
		xmlFile = file;
		if (xmlFile.exists() && xmlFile.isFile()) {
			if (!xmlFile.canExecute())
				xmlFile.setExecutable(true);
		}
		mapData = new HashMap<String, Object>();
	}

	public BasicXmlParser(String xmlString) {
		mapData = new HashMap<String, Object>();
	}

	private String getXmlKey(String line) {
		String temp = "";
		if (line.contains(XML_OPENER)) {
			temp = line.substring(1, line.indexOf(XML_END));
		}
		return temp;
	}

	private String getXmlVal(String key, String line) {
		String temp = "";
		if (line.contains(XML_CLOSER)) {
			line = line.substring(line.indexOf(XML_END) + 1);
			temp = line.substring(0, line.indexOf(XML_CLOSER));
		}
		return temp;
	}

	public Map<String, Object> parse(File param) throws Exception {
		String fileString = new String(Files.readAllBytes(Paths.get(param.toURI())), StandardCharsets.UTF_8);
		return parse(fileString);
	}

	public Map<String, Object> parse(String xmlString) throws Exception {
		Scanner scan = new Scanner(xmlString);
		String singleLine = "";
		while (scan.hasNextLine()) {
			singleLine = scan.nextLine();
			HashMap<String, Object> single = null;
			singleLine = singleLine.trim();
			if (singleLine.startsWith(XML_CLOSER)|| singleLine.isEmpty())
				continue;
			single = new HashMap<String, Object>();
			String key = getXmlKey(singleLine);
			System.out.println("key >> " + key);
			String val = getXmlVal(key, singleLine);
			System.out.println("val >> " + val);
			single.put(key, val);
			if (!single.isEmpty())
				mapData.putAll(single);
		}
		scan.close();
		return mapData;
	}
	
	public static void main(String[] args) throws Exception {
		BasicXmlParser parser = new BasicXmlParser();
		parser.parse("<person>\r\n" + 
				"<first_name>John</first_name>\r\n" + 
				"\r\n" + 
				"<last_name> Doe</last_name>\r\n" + 
				"</person>");
//		HashMap<String, Object> map  = new HashMap<String, Object>();
//		map.keySet().stream().forEach(System.out::println);
//		map.values().stream().forEach(System.out::println);
	}
}
