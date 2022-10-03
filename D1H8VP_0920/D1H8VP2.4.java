package d1h8vp;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class D1H8VP implements Serializable {

	public static void main(String[] args) {

		hf4();
		hf5();
		
	}
	
	private static final long serialVersionUID = 1L;
	String rsz;
	String tipus;
	int ar;

	public D1H8VP(String r, String t, int a) {
		this.rsz = r;
		this.tipus = t;
		this.ar = a;
	}

	public static void hf4() {
		D1H8VP[] autoim = { new D1H8VP("R11", "Opel", 333), new D1H8VP("R12", "Fiat", 233),
				new D1H8VP("R14", "Skoda", 364) };
		try {
			ObjectOutputStream kifile = new ObjectOutputStream(new FileOutputStream("Autok.dat"));
			for (D1H8VP auto : autoim) {
				kifile.writeObject(auto);
			}
			kifile.close();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("File nyitasi hiba");
		}
		System.out.println("OK");
	}

	public static void hf5() {
		D1H8VP ma;
		try {
			File fn = new File("Autok.dat");
			if (fn.exists()) {
				ObjectInputStream kifile = new ObjectInputStream(new FileInputStream("Autok.dat"));
				try {
					while (true) {
						ma = (D1H8VP) kifile.readObject();
						if (ma.ar > 300) {
							System.out.println("rendszam=" + ma.rsz);
						}
					}
				} catch (EOFException ee) {
					ma = null;
				}
				kifile.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("File nyitasi hiba");
		}
		System.out.println("OK2");
	}

}