package com.ftmamud;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Planalto {
	private int largura, altura;
	private List<Sonda> sondas;
	private List<Movimento> movimentos;

	public static Planalto valueOf(int largura, int altura) {
		return new Planalto(largura, altura);
	}
	
	public static Planalto valueOf(String largura, String altura) {
		return new Planalto(Integer.valueOf(largura),
				Integer.valueOf(altura));
	}
	
	private Planalto(int largura, int altura) {
		this.largura = largura;
		this.altura = altura;
		this.sondas = new ArrayList<>();
		this.movimentos = new ArrayList<>();
	}
	
	public boolean adicionaSonda(Sonda sonda) {
		return sondas.add(sonda);
	}

	public int getLargura() {
		return largura;
	}

	public int getAltura() {
		return altura;
	}

	public boolean adicionaMovimento(Movimento movimento) {
		return movimentos.add(movimento);
	}

	public Stream<Sonda> getSondas() {
		return Stream.of((Sonda[]) sondas.toArray());
	}
	
	public Stream<Movimento> getMovimentos() {
		return Stream.of(movimentos.toArray(new Movimento[movimentos.size()]));
	}
}