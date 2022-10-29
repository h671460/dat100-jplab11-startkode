package no.hvl.dat100.jplab11.oppgave3;

import no.hvl.dat100.jplab11.common.TODO;

import no.hvl.dat100.jplab11.oppgave1.*;
import no.hvl.dat100.jplab11.oppgave2.*;

public class Blogg {

	// TODO: objektvariable
	private Innlegg[] innleggtabell;
	private int nesteledig;

	public Blogg() {

		innleggtabell = new Innlegg[20];
		nesteledig = 0;

	}

	public Blogg(int lengde) {

		innleggtabell = new Innlegg[lengde];
		nesteledig = 0;

	}

	public int getAntall() {

		return nesteledig;

	}

	public Innlegg[] getSamling() {

		return innleggtabell;
	}

	public int finnInnlegg(Innlegg innlegg) {

		for (int i = 0; i < nesteledig; i++) {

			if (innleggtabell[i].erLik(innlegg)) {
				return i;
			}

		}
		return -1;
	}

	public boolean finnes(Innlegg innlegg) {

		return finnInnlegg(innlegg) >= 0;

	}

	public boolean ledigPlass() {

		if (nesteledig < innleggtabell.length) {
			return true;
		} else {
			return false;
		}

	}

	public boolean leggTil(Innlegg innlegg) {
		if (finnes(innlegg) != true && ledigPlass()) {
			innleggtabell[nesteledig] = innlegg;
			nesteledig++;
			return true;
		}

		else {
			return false;
		}

	}

	public String toString() {

		String taut = "" + nesteledig + "\n";

		for (int i = 0; i < nesteledig; i++) {

			taut += innleggtabell[i].toString();

		}
		return taut;

	}

	// valgfrie oppgaver nedenfor

	public void utvid() {

		Innlegg[] t = new Innlegg[innleggtabell.length * 2];

		for (int i = 0; i < innleggtabell.length; i++) {

			t[i] = innleggtabell[i];

		}

		innleggtabell = t;

	}

	public boolean leggTilUtvid(Innlegg innlegg) {
		if (nesteledig == innleggtabell.length) {

			utvid();
			leggTil(innlegg);
			return true;

		}

		else {
			return false;
		}

	}

	public boolean slett(Innlegg innlegg) {

		if (finnes(innlegg) == true) {
			int nr = finnInnlegg(innlegg);
			innleggtabell[nr] = innleggtabell[nesteledig - 1];
			innleggtabell[nesteledig - 1] = null;
			nesteledig--;
			return true;

		} else {
			return false;
		}

	}

	public int[] search(String keyword) {

		int[] ider = new int[nesteledig];
		int ii = 0;

		for (int i = 0; i < nesteledig; i++) {

			if (keyword == ((Tekst)innleggtabell[i]).getTekst()) {

				ider[ii] = innleggtabell[i].getId();
				ii++;

			}

		}

		return ider;

	}
}