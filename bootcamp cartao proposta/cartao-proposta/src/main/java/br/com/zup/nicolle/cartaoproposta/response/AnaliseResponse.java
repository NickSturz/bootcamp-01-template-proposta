package br.com.zup.nicolle.cartaoproposta.response;

import javax.persistence.Enumerated;
import javax.validation.constraints.NotBlank;

public class AnaliseResponse {
	
	@NotBlank
	private String documento;
	@NotBlank
	private String nome;
	
	@Enumerated
	private ResultadoSolicitacao resultadoSolicitacao;
	@NotBlank
	private String idProposta;
	
	@Deprecated
	public AnaliseResponse() {}

	public AnaliseResponse(@NotBlank String documento, @NotBlank String nome,
			ResultadoSolicitacao resultadoSolicitacao, @NotBlank String idProposta) {
		super();
		this.documento = documento;
		this.nome = nome;
		this.resultadoSolicitacao = resultadoSolicitacao;
		this.idProposta = idProposta;
	}
	
	public enum ResultadoSolicitacao{
		COM_RESTRICAO,
		SEM_RESTRICAO
	}

	public String getDocumento() {
		return documento;
	}

	public void setDocumento(String documento) {
		this.documento = documento;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getIdProposta() {
		return idProposta;
	}

	public void setIdProposta(String idProposta) {
		this.idProposta = idProposta;
	}

	public ResultadoSolicitacao getResultadoSolicitacao() {
		return resultadoSolicitacao;
	}

	public void setResultadoSolicitacao(ResultadoSolicitacao resultadoSolicitacao) {
		this.resultadoSolicitacao = resultadoSolicitacao;
	}


	
	
	
	
	
	

}
