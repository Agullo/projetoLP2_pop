package core;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import util.FabricaDePost;
import easyaccept.EasyAccept;
import exception.AtualizaPerfilException;
import exception.CadastraUsuarioException;
import exception.CriaPostException;
import exception.ErroNaConsultaDePopsException;
import exception.FechaSistemaException;
import exception.LoginException;
import exception.LogoutException;
import exception.PostOutOfRangeException;
import exception.SemNotificacaoException;
import exception.SenhaProtegidaException;
import exception.SolicitacaoNaoEnviadaException;
import exception.UsuarioNaoExisteException;
import exception.UsuarioNaoLogadoException;

/**
 * Alexandre Gullo .Thiago Henrique
 */

public class Facade {

	private Controller controllerPop;

	public Facade() {
		controllerPop = new Controller();
	}

	public static void main(String[] args) throws CriaPostException {

		args = new String[] {

		};
		EasyAccept.main(args);
	}

	public void iniciaSistema() {

	}

	public int getQtdAmigos() throws UsuarioNaoLogadoException {
		return controllerPop.getQtdAmigos();
	}

	public String getPopularidade() throws Exception {
		return controllerPop.getPopularidade();
	}

	public int getPopsPost(int post) throws PostOutOfRangeException {
		return controllerPop.getPopsPost(post);
	}

	public int getPopsUsuario(String usuario) throws UsuarioNaoExisteException,
			ErroNaConsultaDePopsException {
		return controllerPop.getPopsUsuario(usuario);
	}

	public int getPopsUsuario() throws UsuarioNaoLogadoException {
		return controllerPop.getPopsUsuario();
	}

	public int getNotificacoes() throws UsuarioNaoLogadoException {
		return this.controllerPop.getNotificacoes();
	}

	public String getProxNotificacao() throws UsuarioNaoLogadoException,
			SemNotificacaoException {
		return this.controllerPop.getNextNotificacao();
	}

	public String cadastrarUsuario(String nome, String email, String senha,
			String dataNasc, String imagem) throws CadastraUsuarioException {
		return controllerPop.cadastraUsuario(nome, email, senha, dataNasc,
				imagem);
	}

	public String cadastrarUsuario(String nome, String email, String senha,
			String dataNasc) throws CadastraUsuarioException {
		return controllerPop
				.cadastraUsuario(nome, email, senha, dataNasc, null);
	}

	public String getUsuarioInfo(String atributo, String usuario)
			throws SenhaProtegidaException, UsuarioNaoExisteException {
		return controllerPop.getUsuarioInfo(atributo, usuario);
	}

	public String getUsuarioInfo(String atributo)
			throws SenhaProtegidaException, UsuarioNaoExisteException,
			UsuarioNaoLogadoException {
		return controllerPop.getInfoUsuario(atributo);
	}

	public String getPost(String atributo, int post)
			throws SenhaProtegidaException, UsuarioNaoExisteException,
			UsuarioNaoLogadoException {
		return controllerPop.getPost(atributo, post);
	}

	public String getPost(int post) throws SenhaProtegidaException,
			UsuarioNaoExisteException, UsuarioNaoLogadoException {
		return controllerPop.getPost(post);
	}

	public String getConteudoPost(int indice, int post) throws Exception {
		return controllerPop.getConteudoPost(indice, post);
	}

	public void login(String email, String senha) throws LoginException {
		controllerPop.login(email, senha);
	}

	public void logout() throws LogoutException {
		controllerPop.logout();
	}

	public void removerUsuario(String usuario) throws UsuarioNaoExisteException {
		controllerPop.removeUsuario(usuario);
	}

	public void fecharSistema() throws FechaSistemaException {
		controllerPop.fechaSistema();
	}

	public void atualizarPerfil(String atributo, String valor)
			throws AtualizaPerfilException {
		controllerPop.atualizaPerfil(atributo, valor);
	}

	public void atualizarPerfil(String atributo, String valor, String velhaSenha)
			throws AtualizaPerfilException {
		controllerPop.atualizaPerfil(atributo, valor, velhaSenha);
	}

	public void criarPost(String mensagem, String dataHora)
			throws CriaPostException, UsuarioNaoLogadoException {
		controllerPop.criaPost(mensagem, dataHora);
	}

	public void adicionarAmigo(String amigoEmail)
			throws UsuarioNaoLogadoException, UsuarioNaoExisteException {
		this.controllerPop.adicionaAmigo(amigoEmail);
	}

	public void rejeitarAmizade(String usuario)
			throws UsuarioNaoExisteException, SolicitacaoNaoEnviadaException,
			UsuarioNaoLogadoException {
		controllerPop.rejeitaAmizade(usuario);
	}

	public void aceitarAmizade(String usuario)
			throws UsuarioNaoExisteException, SolicitacaoNaoEnviadaException,
			UsuarioNaoLogadoException {

		controllerPop.aceitaAmizade(usuario);
	}

	public void curtirPost(String amigo, int post)
			throws UsuarioNaoExisteException, UsuarioNaoLogadoException,
			PostOutOfRangeException {
		controllerPop.curtirPost(amigo, post);
	}

	public void removerAmigo(String usuario) throws UsuarioNaoExisteException,
			UsuarioNaoLogadoException {

		controllerPop.removeAmigo(usuario);
	}

	public void adicionarPops(int pops) throws Exception {
		controllerPop.adicionaPops(pops);
	}

	public void rejeitarPost(String amigoEmail, int post)
			throws UsuarioNaoExisteException, UsuarioNaoLogadoException,
			PostOutOfRangeException {
		controllerPop.rejeitarPost(amigoEmail, post);
	}

	public int qtdCurtidasDePost(int post) throws PostOutOfRangeException {
		return controllerPop.qtdCurtidasDePost(post);
	}

	public int qtdRejeicoesDePost(int post) throws PostOutOfRangeException {
		return controllerPop.qtdRejeicoesDePost(post);
	}

	public String atualizaRanking() {
		return controllerPop.atualizaRanking();
	}

	public String atualizaTrendingTopics() {
		return controllerPop.atualizaTrendingTopics();
	}

}
