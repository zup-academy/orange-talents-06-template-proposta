package br.com.zup.proposta.proposta.dto;

import java.math.BigDecimal;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;

import br.com.zup.proposta.proposta.config.validation.CPFouCNPJ;
import br.com.zup.proposta.proposta.model.Proposta;

public class PropostaDTO {

	@NotBlank
	@CPFouCNPJ
	private String cpfOuCnpj;

	@NotBlank
	@Email
	private String email;

	@NotBlank
	private String nome;

	@NotBlank
	private String endereco;

	@NotNull
	@PositiveOrZero
	private BigDecimal salario;

	public PropostaDTO(@NotEmpty String cpfOuCnpj, @NotEmpty @Email String email, @NotEmpty String nome,
			@NotEmpty String endereco, @NotNull @PositiveOrZero BigDecimal salario) {
		super();
		this.cpfOuCnpj = cpfOuCnpj;
		this.email = email;
		this.nome = nome;
		this.endereco = endereco;
		this.salario = salario;
	}

	public String getCpfOuCnpj() {
		return cpfOuCnpj;
	}

	public String getEmail() {
		return email;
	}

	public String getNome() {
		return nome;
	}

	public String getEndereco() {
		return endereco;
	}

	public BigDecimal getSalario() {
		return salario;
	}

	public Proposta toModel() {
		return new Proposta(cpfOuCnpj, email, nome, endereco, salario);
	}
}
