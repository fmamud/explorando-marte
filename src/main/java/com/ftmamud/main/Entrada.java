package com.ftmamud.main;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.List;

import com.ftmamud.Movimento;
import com.ftmamud.Planalto;
import com.ftmamud.Sonda;

public class Entrada {
	private List<String> entrada;

	public static Entrada valueOf(List<String> entrada) {
		return new Entrada(entrada);
	}

	private Entrada(List<String> entrada) {
		this.entrada = entrada;
	}

	public Planalto processar() {
		Iterator<String> iterator = entrada.iterator();

		String malha[] = iterator.next().split("\\s");

		Planalto planalto = Planalto.valueOf(malha[0], malha[1]);

		while (iterator.hasNext()) {
			String[] sondaRaw = iterator.next().split("\\s");

			Sonda sonda = Sonda.valueOf(sondaRaw[0], sondaRaw[1], sondaRaw[2]);

			String movimentoRaw = iterator.next();
			Movimento movimento = Movimento.valueOf(sonda, movimentoRaw);

			planalto.adicionaSonda(sonda);
			planalto.adicionaMovimento(movimento);
		}

		return planalto;
	}

	public static void main(String[] args) throws Exception {
		Entrada entrada = Entrada.valueOf(Files.readAllLines(Paths.get("entrada.txt")));

		Planalto planalto = entrada.processar();
		
		planalto.getMovimentos()
			.map(m -> m.getSonda().movimentar(m))
			.forEach(System.out::println);
	}
}