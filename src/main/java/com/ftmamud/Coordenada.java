package com.ftmamud;

public class Coordenada {
	
	private int x, y;

	public Coordenada(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public static Coordenada valueOf(int x, int y) {
		return new Coordenada(x, y);
	}
	
	public Coordenada movimentar(Direcao direcao) {
		Coordenada novaCoordenada = null;
		switch (direcao) {
			case N: 
				novaCoordenada = Coordenada.valueOf(x, y + 1); break;
			case S: 
				novaCoordenada = Coordenada.valueOf(x, y - 1); break;
			case W: 
				novaCoordenada = Coordenada.valueOf(x - 1, y); break;
			case E: 
				novaCoordenada = Coordenada.valueOf(x + 1, y); break;
			default: novaCoordenada = this;
		}
		return novaCoordenada;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}
	
	@Override
	public String toString() {
		return String.format("%d %d", x, y);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + x;
		result = prime * result + y;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Coordenada other = (Coordenada) obj;
		if (x != other.x)
			return false;
		if (y != other.y)
			return false;
		return true;
	}
}