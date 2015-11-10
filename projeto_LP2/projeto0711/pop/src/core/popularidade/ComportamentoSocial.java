package core.popularidade;

import java.util.List;

import core.Post;

public interface ComportamentoSocial {

	public void curtir(Post post);

	public void rejeitar(Post post);

	public List<Post> compartilhar(List<Post> posts);

}
