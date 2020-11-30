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
@Table(name = "filme")
@NamedQueries({
    @NamedQuery(name = "Filme.findAll", query = "SELECT f FROM Filme f")})
public class Filme implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "codigo")
    private Integer codigo;
    @Basic(optional = false)
    @Column(name = "disponivel")
    private String disponivel;
    @Basic(optional = false)
    @Column(name = "genero")
    private String genero;
    @Basic(optional = false)
    @Column(name = "nome")
    private String nome;
    @Column(name = "promocao")
    private String promocao;
    @Basic(optional = false)
    @Column(name = "valor")
    private double valor;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "valor_promocao")
    private Double valorPromocao;

    public Filme() {
    }

    public Filme(Integer codigo) {
        this.codigo = codigo;
    }

    public Filme(Integer codigo, String disponivel, String genero, String nome, double valor) {
        this.codigo = codigo;
        this.disponivel = disponivel;
        this.genero = genero;
        this.nome = nome;
        this.valor = valor;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getDisponivel() {
        return disponivel;
    }

    public void setDisponivel(String disponivel) {
        this.disponivel = disponivel;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getPromocao() {
        return promocao;
    }

    public void setPromocao(String promocao) {
        this.promocao = promocao;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public Double getValorPromocao() {
        return valorPromocao;
    }

    public void setValorPromocao(Double valorPromocao) {
        this.valorPromocao = valorPromocao;
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
        if (!(object instanceof Filme)) {
            return false;
        }
        Filme other = (Filme) object;
        if ((this.codigo == null && other.codigo != null) || (this.codigo != null && !this.codigo.equals(other.codigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.foursys.hibernate.model.Filme[ codigo=" + codigo + " ]";
    }
    
}
