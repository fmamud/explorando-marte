package com.ftmamud;

public class Sonda {
	private Coordenada posicao;
	private Direcao direcao;

	private Sonda(Coordenada posicao, Direcao direcao) {
		this.posicao = posicao;
		this.direcao = direcao;
	}

	public static Sonda valueOf(int x, int y, String direcao) {
		return new Sonda(Coordenada.valueOf(x, y), Direcao.valueOf(direcao));
	}
	
	public static Sonda valueOf(String x, String y, String direcao) {
		return new Sonda(
				Coordenada.valueOf(Integer.valueOf(x), Integer.valueOf(y)), 
				Direcao.valueOf(direcao));
	}
	
	public Sonda movimentar(Movimento movimento) {
		for (String mov : movimento) {
			if (Movimento.isEsquerda(mov)) {
				setDirecao(direcao.virar90GrausEsquerda());
			} else if (Movimento.isDireita(mov)) {
				setDirecao(direcao.virar90GrausDireita());
			} else {
				setPosicao(posicao.movimentar(direcao));
			}
		}
		return this;
	}
	
	public Direcao getDirecao() {
		return direcao;
	}
	
	private void setDirecao(Direcao direcao) {
		this.direcao = direcao;
	}

	public Coordenada getPosicao() {
		return posicao;
	}

	private void setPosicao(Coordenada posicao) {
		this.posicao = posicao;
	}
	
	@Override
	public String toString() {
		return String.format("%s %s", posicao, direcao);
	}
}