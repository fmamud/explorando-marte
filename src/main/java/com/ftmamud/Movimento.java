package com.ftmamud;

import java.util.Arrays;
import java.util.Iterator;

public class Movimento implements Iterable<String> {
	
	private final Sonda sonda;
	private final String movimento;
	
	private Movimento(Sonda sonda, String movimento) {
		this.sonda = sonda;
		this.movimento = movimento;
	}
	
	public static Movimento valueOf(Sonda sonda, String movimento) {
		return new Movimento(sonda, movimento);
	}

	public Sonda getSonda() {
		return sonda;
	}

	public String getMovimento() {
		return movimento;
	}

	@Override
	public Iterator<String> iterator() {
		return Arrays.asList(movimento.split("(?!^)")).iterator();
	}
	
	public static boolean isEsquerda(String movimento) {
		return "L".equals(movimento);
	}
	
	public static boolean isDireita(String movimento) {
		return "R".equals(movimento);
	}
	
	@Override
	public String toString() {
		return movimento;
	}
}