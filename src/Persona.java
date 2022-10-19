import java.io.*;
import org.w3c.dom.*;
import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.*;
import javax.xml.transform.stream.*;


public class Persona {

	public static void main(String[] args) throws IOException {
		File fitxer = new File("AleatoriTreb.dat");
		RandomAccessFile fitxerLectura = new RandomAccessFile(fitxer, "r");
		
			
		
		int id, edat, posicio=0; 
		Double salari;
		char cognom[] = new char[10], auxCognom;
		char dni[] = new char[9], auxDni;
		char nom[] = new char[10], auxNom;
		
		
		
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		
		try {
			DocumentBuilder builder = factory.newDocumentBuilder();
			DOMImplementation implementation = builder.getDOMImplementation();
			Document document = implementation.createDocument(null, "empleados", null);
			document.setXmlVersion("1.0");
			
			for(;;) {
				fitxerLectura.seek(posicio);
				id=fitxerLectura.readInt();
				for (int i = 0; i < nom.length; i++) {
					auxNom = fitxerLectura.readChar();
					nom[i] = auxNom;
				}
				String nomS = new String(nom);
				
				for (int i = 0; i <cognom.length; i++) {
					auxCognom = fitxerLectura.readChar();
					cognom[i] = auxCognom;
				}
				String cognomS = new String(cognom);
				
				for (int i = 0; i<dni.length; i++) {
					auxDni = fitxerLectura.readChar();
					dni[i] = auxDni;
				}
				String dniS = new String(dni);
				
				edat = fitxerLectura.readInt();
				salari = fitxerLectura.readDouble();
				System.out.println("ID: " + id + " Nom: " + nomS + " Cognom: " + cognomS + " DNI: " + dniS + " Edat: " + edat + " Salari: " + salari);

				
				if(id>0) {
					Element raiz = document.createElement("empleado");
					
					document.getDocumentElement().appendChild(raiz);
					CrearElemento("id", Integer.toString(id), raiz, document);
					CrearElemento("noms", nomS.trim(), raiz, document);
					CrearElemento("cognom", cognomS.trim(), raiz, document);
					CrearElemento("dni", dniS.trim(), raiz, document);
					CrearElemento("edad", Integer.toString(edat), raiz, document);
					CrearElemento("salario", Double.toString(salari), raiz, document);
				}
				posicio= posicio+74;
				if(fitxerLectura.getFilePointer() == fitxerLectura.length()) break;
			}
			
			Source source = new DOMSource(document);
			Result result = new StreamResult(new java.io.File("Empleados.xml"));
			Transformer transformer = TransformerFactory.newInstance().newTransformer();
			transformer.transform(source, result);
		}catch (Exception e) { 
			System.out.println("Error: "+e);
		}
		fitxerLectura.close();
	}
	
	static void CrearElemento(String datoEmple, String valor, 
			Element raiz, Document document) {
		Element elem = document.createElement(datoEmple);
		Text text = document.createTextNode(valor);
		raiz.appendChild(elem);
		elem.appendChild(text);
	}
}
