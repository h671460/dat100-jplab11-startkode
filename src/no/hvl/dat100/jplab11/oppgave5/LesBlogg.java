package no.hvl.dat100.jplab11.oppgave5;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

import no.hvl.dat100.jplab11.common.TODO;
import no.hvl.dat100.jplab11.oppgave1.*;
import no.hvl.dat100.jplab11.oppgave2.*;
import no.hvl.dat100.jplab11.oppgave3.*;

import javax.swing.JOptionPane;

public class LesBlogg {

	private static String TEKST = "TEKST";
	private static String BILDE = "BILDE";

	public static Blogg les(String mappe, String filnavn) {
		try {

			File file = new File(mappe + "/" + filnavn);

			FileReader leser = new FileReader(file);
			BufferedReader breader = new BufferedReader(leser);

			// første linje inneholder antall blogposts i filen
			String line = breader.readLine();
			int antall = java.lang.Integer.parseInt(line);

			// opretter tom blogg med plass til antall blog entries
			Blogg blogg = new Blogg(antall);

			for (int i = 0; i < antall; i++) {

				line = breader.readLine();

				if (line.equals(TEKST)) {

					line = breader.readLine();

					int id = java.lang.Integer.parseInt(line);
					String navn = breader.readLine();
					String dato = breader.readLine();
					int likes = java.lang.Integer.parseInt(breader.readLine());
					String tekst = breader.readLine();

					Tekst tekstinnlegg = new Tekst(id, navn, dato, likes, tekst);
					blogg.leggTil(tekstinnlegg);

				} else if (line.equals(BILDE)) {

					line = breader.readLine();

					int id = java.lang.Integer.parseInt(line);
					String navn = breader.readLine();
					String dato = breader.readLine();
					int likes = java.lang.Integer.parseInt(breader.readLine());
					String tekst = breader.readLine();
					String url = breader.readLine();

					Bilde bildeinnlegg = new Bilde(id, navn, dato, likes, tekst, url);
					blogg.leggTil(bildeinnlegg);

				} else {

					System.out.println("Filen er ikke korrekt" + line);
					return null;
				}

			}
			return blogg;
		}

		catch (IOException e) {
			System.out.println("Feil på disketten " + e);

		}
		return null;

	}

}
