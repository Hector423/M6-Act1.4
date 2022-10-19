import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;

public class Persona {

	public static void main(String[] args) throws IOException {
		File fitxer = new File("AleatoriTreb.dat");
		RandomAccessFile fitxerLectura = new RandomAccessFile(fitxer, "r");
		
		int id, dep, posicio=0; 
		Double salari;
		char cognom[] = new char[10], aux;
		
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		
		try {
			DocumentBuilder builder = factory.newDocumentBuilder();
			DOMImplementation implementation = builder.getDOMImplementation();
			Document document = implementation.createDocument(null, "Empleados", null);
			document.setXmlVersion("1.0");
			
			for(;;) {
				fitxerLectura.seek(posicio);
				id=fitxerLectura.readInt();
				for (int i = 0; i <cognom.length; i++) {
					aux = fitxerLectura.readChar();
					
				}
			}
			
			
			
		}catch (Exception e) {
			// TODO: handle exception
		}
		
		
		
		

	}

}
