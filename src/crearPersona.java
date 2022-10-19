import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

public class crearPersona {

	public static void main(String[] args)throws IOException {
		File fitxer = new File("AleatoriTreb.dat");
		RandomAccessFile accesArxiu = new RandomAccessFile(fitxer, "rw");

		int edats[] = {20, 18, 21, 22, 12, 32, 25, 23};
		String noms[] = {"Hector", "Jordi", "Eloy", "Xavier", "Antonio", "Jaume", "Cels", "Marta"};
		String cognoms[] = {"Vallvé", "Ribellas", "Altozano", "Martinez", "Lopez", "Rubio", "Montes", "Cruz"};
		String dnis[] = {"12345678L", "93647586T", "63193574O", "23145674Z", "95138475G", "66882223U", "83648284I", "43385477J"};
		Double salaris[] = {2000.0, 1500.0, 1200.0, 1900.0, 1500.0, 1800.0, 1300.0, 2500.0};
		
		StringBuffer buffer = null;
		int n = cognoms.length;
		
		for(int i=0; i<n; i++) {
			accesArxiu.writeInt(i+1);
			buffer = new StringBuffer(noms[i]);
			buffer.setLength(10);
			accesArxiu.writeChars(buffer.toString());
			buffer = new StringBuffer(cognoms[i]);
			buffer.setLength(10);
			accesArxiu.writeChars(buffer.toString());
			buffer = new StringBuffer(dnis[i]);
			buffer.setLength(9);
			accesArxiu.writeChars(buffer.toString());
			accesArxiu.writeInt(edats[i]);
			accesArxiu.writeDouble(salaris[i]);
		}

		accesArxiu.close();
	}

}
