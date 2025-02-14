package no.hvl.dat100.jplab11.oppgave2;

import no.hvl.dat100.jplab11.common.TODO;
import no.hvl.dat100.jplab11.oppgave1.*;

public class Tekst extends Innlegg {

	// TODO: objektvariable
	private String tekst;

	public Tekst() {
		tekst = "";

	}

	public Tekst(int id, String bruker, String dato, String tekst) {

		super(id, bruker, dato);
		this.tekst = tekst;

	}

	public Tekst(int id, String bruker, String dato, int likes, String tekst) {

		super(id, bruker, dato, likes);
		this.tekst = tekst;

	}

	public String getTekst() {
		return tekst;

	}

	public void setTekst(String tekst) {
		this.tekst = tekst;
	}

	@Override
	public String toString() {

		String str = "TEKST\n" + super.toString() + tekst + "\n";

		return str;

	}

	// Metoden nedenfor er kun for valgfri oppgave 6
	@Override
	public String toHTML() {

		String str = "TEKST\n" + super.toString() + "<p>" + tekst + "</p>" + "\n" + "<hr>";

		return str;

	}
}
