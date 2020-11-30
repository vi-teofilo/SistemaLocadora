/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.foursys.locadora.bean;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author dmunhoz
 */
@Entity
@Table(name = "cliente")
@NamedQueries({
    @NamedQuery(name = "Cliente.findAll", query = "SELECT c FROM Cliente c")})
public class Cliente implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "codigo")
    private Integer codigo;
    @Basic(optional = false)
    @Column(name = "bairro")
    private String bairro;
    @Basic(optional = false)
    @Column(name = "cep")
    private String cep;
    @Basic(optional = false)
    @Column(name = "cidade")
    private String cidade;
    @Basic(optional = false)
    @Column(name = "cpf")
    private String cpf;
    @Basic(optional = false)
    @Column(name = "data_nascimento")
    private String dataNascimento;
    @Basic(optional = false)
    @Column(name = "estado")
    private String estado;
    @Basic(optional = false)
    @Column(name = "idade")
    private int idade;
    @Basic(optional = false)
    @Column(name = "logradouro")
    private String logradouro;
    @Basic(optional = false)
    @Column(name = "nome")
    private String nome;
    @Basic(optional = false)
    @Column(name = "numero_logradouro")
    private int numeroLogradouro;
    @Basic(optional = false)
    @Column(name = "rg")
    private String rg;
    @Basic(optional = false)
    @Column(name = "sexo")
    private String sexo;
    @Basic(optional = false)
    @Column(name = "telefone")
    private String telefone;

    public Cliente() {
    }

    public Cliente(Integer codigo) {
        this.codigo = codigo;
    }

    public Cliente(Integer codigo, String bairro, String cep, String cidade, String cpf, String dataNascimento, String estado, int idade, String logradouro, String nome, int numeroLogradouro, String rg, String sexo, String telefone) {
        this.codigo = codigo;
        this.bairro = bairro;
        this.cep = cep;
        this.cidade = cidade;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
        this.estado = estado;
        this.idade = idade;
        this.logradouro = logradouro;
        this.nome = nome;
        this.numeroLogradouro = numeroLogradouro;
        this.rg = rg;
        this.sexo = sexo;
        this.telefone = telefone;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getNumeroLogradouro() {
        return numeroLogradouro;
    }

    public void setNumeroLogradouro(int numeroLogradouro) {
        this.numeroLogradouro = numeroLogradouro;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigo != null ? codigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cliente)) {
            return false;
        }
        Cliente other = (Cliente) object;
        if ((this.codigo == null && other.codigo != null) || (this.codigo != null && !this.codigo.equals(other.codigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.foursys.hibernate.model.Cliente[ codigo=" + codigo + " ]";
    }
    
}
