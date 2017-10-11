package main;

import generated.NewDataSet;
import generated.NewDataSet.Holidays;

import java.io.File;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.Unmarshaller;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

public class XMLMain {
	// filename
	public static final String XML_FILE_NAME = "GetHolidaysForYear.xml";

	public static void main(String[] args) {

		try {

			/*  Get an Unmarshaller
			 * 
			 * The Unmarshaller class governs the process of deserializing XML data 
			 * into newly created Java content trees, optionally validating the XML 
			 * data as it is unmarshalled. 
			 */
			JAXBContext jc;
			jc = JAXBContext.newInstance("generated");
			Unmarshaller u = jc.createUnmarshaller();

			// Build a DOM.
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			dbf.setNamespaceAware(true);
			DocumentBuilder db = dbf.newDocumentBuilder();
			Document doc = db.parse(new File(XML_FILE_NAME));

			// Traverse the DOM until 'NewDataSet' is reached.
			Element subtree = doc.getDocumentElement();
			Node node = subtree.getElementsByTagName("NewDataSet")
					.item(0);

			// Unmarshal 'NewDataSet'.
			JAXBElement<NewDataSet> dataSet = u.unmarshal(node,
					NewDataSet.class);

			// Print the holidays.
			List<Holidays> holidays = dataSet.getValue()
					.getHolidays();
			for (Holidays h : holidays) {
				System.out.printf("%30s: %d/%d/%d\n", h.getName(), h.getDate()
						.getMonth(), h.getDate()
						.getDay(), h.getDate()
						.getYear());
			}

		} catch (Exception ex) {
			System.out.println("Caught Exception: " + ex.getMessage());
		}

	}

}
