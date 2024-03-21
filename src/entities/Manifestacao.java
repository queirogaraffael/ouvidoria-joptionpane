package entities;

import java.util.Objects;

public class Manifestacao {
	private int codigo;
	private String manifestacao;

	public Manifestacao() {
	}

	public Manifestacao(int codigo, String manifestacao) {
		this.codigo = codigo;
		this.manifestacao = manifestacao;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getManifestacao() {
		return manifestacao;
	}

	public void setManifestacao(String manifestacao) {
		this.manifestacao = manifestacao;
	}

	@Override
	public int hashCode() {
		return Objects.hash(codigo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Manifestacao other = (Manifestacao) obj;
		return codigo == other.codigo;
	}

	@Override
	public String toString() {
		return "Código: " + codigo + ", Manifestação: " + manifestacao;
	}

}
