package core;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

/**
 * Alexandre Gullo Thiago Henrique
 */

public class Post {

	private List<String> conteudos;
	private List<String> hashtags;
	private int popularidade;
	private LocalDate data;
	private LocalTime hora;
	private int curtidas;
	private int rejeicoes;

	public Post(List<String> conteudo, List<String> hashtags, LocalDate data,
			LocalTime time) {

		this.conteudos = conteudo;
		this.hashtags = hashtags;
		this.data = data;
		this.hora = time;
		this.popularidade = 0;
		this.curtidas = 0;
		this.rejeicoes = 0;

	}

	public int getPopularidade() {
		return popularidade;
	}

	public int getCurtidas() {
		return curtidas;
	}

	public int getRejeicoes() {
		return rejeicoes;
	}

	public int getTamanhoConteudo() {
		return this.conteudos.size();
	}

	public String getAudios() {
		String audios = "";
		for (String conteudo : conteudos) {
			if (conteudo.contains("<audio>")) {
				audios += conteudo.substring(7, conteudo.indexOf("</audio>"));
			}
		}
		return audios;
	}

	public String getImagens() {
		String imagens = "";
		for (String conteudo : conteudos) {
			if (conteudo.contains("<imagem>")) {
				imagens += conteudo.substring(8, conteudo.indexOf("</imagem>"));
			}
		}
		return imagens;
	}

	public String getConteudo() {
		StringBuilder sb = new StringBuilder();
		sb.append(this.conteudos.get(0).trim());
		for (int i = 1; this.conteudos.size() > i; i++) {
			sb.append(" ");
			sb.append(this.conteudos.get(i));
		}
		return sb.toString().trim();
	}

	public String getConteudoPost(int indice) {
		String conteudo = this.conteudos.get(indice).trim();
		if (conteudo.contains("<audio>")) {
			return "$arquivo_audio:"
					+ conteudo.substring(7, conteudo.indexOf("</audio>"));
		} else if (conteudo.contains("<imagem>")) {
			return "$arquivo_imagem:"
					+ conteudo.substring(8, conteudo.indexOf("</imagem>"));
		} else {
			return conteudo;
		}
	}

	public String getStringHashtags() {
		StringBuilder sb = new StringBuilder();
		sb.append(this.hashtags.get(0));
		for (int i = 1; this.hashtags.size() > i; i++) {
			sb.append(",");
			sb.append(this.hashtags.get(i));
		}
		return sb.toString().trim();
	}

	public String getDataHora() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
		return data + " " + hora.format(formatter);
	}

	public List<String> getHashtags() {
		return this.hashtags;
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(getConteudo());
		for (int i = 0; this.hashtags.size() > i; i++) {
			sb.append(" ");
			sb.append(this.hashtags.get(i).trim());
		}
		sb.append(" (");
		sb.append(getDataHora());
		sb.append(")");
		return sb.toString();
	}

	public void addPopularidade(int popularidade) {
		this.popularidade += popularidade;
	}

	public void setCurtidas(int curtidas) {
		this.curtidas = curtidas;
	}

	public void setRejeicoes(int rejeicoes) {
		this.rejeicoes = rejeicoes;
	}

	public void removePopularidade(int popularidade) {
		this.popularidade -= popularidade;
	}

	public boolean recente() {
		LocalDate hoje = LocalDate.now();
		return data.compareTo(hoje) == 0;
	}

	public void addHashTag(String hashtag) {
		this.hashtags.add(hashtag);
	}

	public LocalDate getData() {
		return data;
	}

	public LocalTime getHora() {
		return hora;
	}

	public int compareTempo(Post other) {
		if (data.compareTo(other.getData()) != 0)
			return -data.compareTo(other.getData());
		return -hora.compareTo(other.getHora());
	}

	public String toFileFormat() {
		String out = "";
		String endl = System.getProperty("line.separator");
		out += "Conteúdo:" + endl + getConteudo() + endl + getImagens() + endl
				+ getAudios() + endl;
		for (String hashtag : hashtags) {
			out += hashtag + " ";
		}
		out += "+Pop: " + getPopularidade() + endl;
		return out;
	}

}