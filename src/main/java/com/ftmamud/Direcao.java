package com.ftmamud;

public enum Direcao {
	N {
		@Override
		Direcao virar90GrausEsquerda() { return W; }

		@Override
		Direcao virar90GrausDireita() { return E; }
	}, 
	
	E {
		@Override
		Direcao virar90GrausEsquerda() { return N; }

		@Override
		Direcao virar90GrausDireita() {	return S; }
	}, 
	
	S {
		@Override
		Direcao virar90GrausEsquerda() { return E; }

		@Override
		Direcao virar90GrausDireita() {	return W; }
	}, 
	
	W {
		@Override
		Direcao virar90GrausEsquerda() { return S; }

		@Override
		Direcao virar90GrausDireita() {	return N; }
	};
	
	abstract Direcao virar90GrausEsquerda();
	abstract Direcao virar90GrausDireita();
	
	public static boolean isDirecao(String direcao) {
		boolean isDirecao = true;
		try {
			Direcao.valueOf(direcao);
		} catch (IllegalArgumentException ex) {
			isDirecao = false;
		} 
		
		return isDirecao;
	}
}