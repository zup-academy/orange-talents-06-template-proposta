package br.com.zup.proposta.proposta.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

import br.com.zup.proposta.proposta.model.Cartao;
import br.com.zup.proposta.proposta.model.Proposta;

public class CartaoDTO {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String id;

	@JsonFormat(pattern = "yyyy-MM-dd@HH:mm:ss", shape = Shape.STRING)
	private LocalDateTime emitidoEm;

	@NotBlank
	private String titular;

	@NotNull
	@Valid
	@OneToMany(mappedBy = "cartao", cascade = CascadeType.MERGE)
	private List<BloqueioDTO> bloqueios = new ArrayList<>();

	@NotNull
	@Valid
	@OneToMany(mappedBy = "cartao", cascade = CascadeType.MERGE)
	private List<AvisoDTO> avisos = new ArrayList<>();

	@NotNull
	@Valid
	@OneToMany(mappedBy = "cartao", cascade = CascadeType.MERGE)
	private List<CarteiraDTO> carteiras = new ArrayList<>();

	@NotNull
	@Valid
	@OneToMany(mappedBy = "cartao", cascade = CascadeType.MERGE)
	private List<ParcelaDTO> parcelas = new ArrayList<>();

	@NotNull
	private BigDecimal limite;

	@Valid
	@OneToOne(mappedBy = "cartao", cascade = CascadeType.MERGE)
	private RenegociacaoDTO renegociacao;

	@Valid
	@OneToOne(mappedBy = "cartao", cascade = CascadeType.MERGE)
	private VencimentoDTO vencimento;

	public CartaoDTO(String id, LocalDateTime emitidoEm, String titular, Collection<BloqueioDTO> bloqueios,
			Collection<AvisoDTO> avisos, Collection<CarteiraDTO> carteiras, Collection<ParcelaDTO> parcelas,
			BigDecimal limite, RenegociacaoDTO renegociacao, VencimentoDTO vencimento) {
		super();
		this.id = id;
		this.emitidoEm = emitidoEm;
		this.titular = titular;
		this.bloqueios.addAll(bloqueios);
		this.avisos.addAll(avisos);
		this.carteiras.addAll(carteiras);
		this.parcelas.addAll(parcelas);
		this.limite = limite;
		this.renegociacao = renegociacao;
		this.vencimento = vencimento;
	}

	public Cartao toModel(Proposta proposta) {
		return new Cartao(emitidoEm, titular, bloqueios, avisos, carteiras, parcelas, limite, renegociacao, vencimento,
				proposta);
	}
}
