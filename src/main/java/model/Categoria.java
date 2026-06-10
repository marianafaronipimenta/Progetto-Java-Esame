package model;

import java.util.Objects;

/**
 * Classe che gestisce le categorie di articoli che vengono inserite nelle liste
 * di articoli
 *
 * @author Gibello
 *
 */

public class Categoria {

	private String nome;

	public Categoria(String nome) {
		
		if (nome == null || nome.isEmpty()) {
			
			throw new IllegalArgumentException("Il nome inserito non può essere nullo o vuoto");
		}

		this.nome = nome;

	}

	public String getNome() {

		return nome;
	}

	public void setNome(String nome) {
		
		if (nome == null || nome.isEmpty()) {
			
			throw new IllegalArgumentException("Il nome inserito non può essere nullo o vuoto");
			
		}
		
		this.nome = nome;
	}

	@Override
	public int hashCode() {
		return Objects.hash(nome);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Categoria other = (Categoria) obj;
		return Objects.equals(nome, other.nome);
	}

}
