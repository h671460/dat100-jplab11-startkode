package no.hvl.dat100.jplab11.oppgave4;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

import no.hvl.dat100.jplab11.common.TODO;
import no.hvl.dat100.jplab11.oppgave3.*;

public class SkrivBlogg {

	public static boolean skriv(Blogg samling, String mappe, String filnavn) {

		try {
			
			FileWriter file = new FileWriter(mappe + "/" + filnavn);
			file.write(samling.toString());
			file.close();

			return true;

		}

		catch (IOException e) {
			System.out.println("Ikke filnavn finnes: " + e);

		}

		return false;

	}

}
