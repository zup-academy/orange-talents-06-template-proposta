package br.com.zup.proposta.proposta.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
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

import br.com.zup.proposta.proposta.dto.AvisoDTO;
import br.com.zup.proposta.proposta.dto.BloqueioDTO;
import br.com.zup.proposta.proposta.dto.CarteiraDTO;
import br.com.zup.proposta.proposta.dto.ParcelaDTO;
import br.com.zup.proposta.proposta.dto.RenegociacaoDTO;
import br.com.zup.proposta.proposta.dto.VencimentoDTO;

@Entity
public class Cartao {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@JsonFormat(pattern = "yyyy-MM-dd@HH:mm:ss", shape = Shape.STRING)
	private LocalDateTime emitidoEm;
	
	@NotBlank
	private String titular;
	
	@NotNull
	@Valid
	@OneToMany(mappedBy = "cartao", cascade = CascadeType.MERGE)
	private Set<Bloqueio> bloqueios = new HashSet<>();
	
	@NotNull
	@Valid
	@OneToMany(mappedBy = "cartao", cascade = CascadeType.MERGE)
	private Set<Aviso> avisos = new HashSet<>();
	
	@NotNull
	@Valid
	@OneToMany(mappedBy = "cartao", cascade = CascadeType.MERGE)
	private Set<Carteira> carteiras = new HashSet<>();
	
	@NotNull
	@Valid
	@OneToMany(mappedBy = "cartao", cascade = CascadeType.MERGE)
	private Set<Parcela> parcelas = new HashSet<>();
	
	@NotNull
	@Valid
	@OneToMany(mappedBy = "cartao", cascade = CascadeType.MERGE)
	private Set<Biometria> biometrias = new HashSet<>();

	@NotNull
	private BigDecimal limite;
	
	@Valid
	@OneToOne(mappedBy = "cartao", cascade = CascadeType.MERGE)
	private Renegociacao renegociacao;
	
	@Valid
	@OneToOne(mappedBy = "cartao", cascade = CascadeType.MERGE)
	private Vencimento vencimento;
	
	@NotNull
	@Valid
	@OneToOne
	private Proposta idProposta;
	

	public Cartao() {
		super();
	}

	public Cartao(LocalDateTime emitidoEm, String titular, Collection<BloqueioDTO> bloqueios, Collection<AvisoDTO> avisos, 
			Collection<CarteiraDTO> carteiras, Collection<ParcelaDTO> parcelas, BigDecimal limite, 
			RenegociacaoDTO renegociacao, VencimentoDTO vencimento, Proposta idProposta) {
		super();
		this.emitidoEm = emitidoEm;
		this.titular = titular;
		Set<Bloqueio> novoBloqueio = bloqueios.stream().map(bloqueio -> bloqueio.toModel(this)).collect(Collectors.toSet());
		this.bloqueios.addAll(novoBloqueio);
		Set<Aviso> novoAviso = avisos.stream().map(aviso -> aviso.toModel(this)).collect(Collectors.toSet());
		this.avisos.addAll(novoAviso);
		Set<Carteira> novaCarteira = carteiras.stream().map(aviso -> aviso.toModel(this)).collect(Collectors.toSet());
		this.carteiras.addAll(novaCarteira);
		Set<Parcela> novaParcela= parcelas.stream().map(parcela -> parcela.toModel(this)).collect(Collectors.toSet());
		this.parcelas.addAll(novaParcela);
		this.limite = limite;
		if(renegociacao != null) {
			this.renegociacao = renegociacao.toModel(this);
		}
		this.vencimento = vencimento.toModel(this);
		this.idProposta = idProposta;
	}

	public Long getId() {
		return id;
	}

	public LocalDateTime getEmitidoEm() {
		return emitidoEm;
	}

	public String getTitular() {
		return titular;
	}

	public Set<Bloqueio> getBloqueios() {
		return bloqueios;
	}

	public Set<Aviso> getAvisos() {
		return avisos;
	}

	public Set<Carteira> getCarteiras() {
		return carteiras;
	}

	public Set<Parcela> getParcelas() {
		return parcelas;
	}

	public BigDecimal getLimite() {
		return limite;
	}

	public Renegociacao getRenegociacao() {
		return renegociacao;
	}

	public Vencimento getVencimento() {
		return vencimento;
	}

	public Proposta getIdProposta() {
		return idProposta;
	}

	public Set<Biometria> getBiometrias() {
		return biometrias;
	}
	
	public void adicionarBiometria(@Valid Biometria biomeria) {
		this.biometrias.add(biomeria);
	}
}
