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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author pbido
 */
@Entity
@Table(name = "locacao")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Locacao.findAll", query = "SELECT l FROM Locacao l"),
    @NamedQuery(name = "Locacao.findByCodigo", query = "SELECT l FROM Locacao l WHERE l.codigo = :codigo"),
    @NamedQuery(name = "Locacao.findByNomeCliente", query = "SELECT l FROM Locacao l WHERE l.nomeCliente = :nomeCliente"),
    @NamedQuery(name = "Locacao.findByNomeFilme", query = "SELECT l FROM Locacao l WHERE l.nomeFilme = :nomeFilme"),
    @NamedQuery(name = "Locacao.findByValorFilme", query = "SELECT l FROM Locacao l WHERE l.valorFilme = :valorFilme"),
    @NamedQuery(name = "Locacao.findByDataLocacao", query = "SELECT l FROM Locacao l WHERE l.dataLocacao = :dataLocacao")})
public class Locacao implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "codigo")
    private Integer codigo;
    @Basic(optional = false)
    @Column(name = "nome_cliente")
    private String nomeCliente;
    @Basic(optional = false)
    @Column(name = "nome_filme")
    private String nomeFilme;
    @Basic(optional = false)
    @Column(name = "valor_filme")
    private double valorFilme;
    @Basic(optional = false)
    @Column(name = "data_locacao")
    private String dataLocacao;

    public Locacao() {
    }

    public Locacao(Integer codigo) {
        this.codigo = codigo;
    }

    public Locacao(Integer codigo, String nomeCliente, String nomeFilme, double valorFilme, String dataLocacao) {
        this.codigo = codigo;
        this.nomeCliente = nomeCliente;
        this.nomeFilme = nomeFilme;
        this.valorFilme = valorFilme;
        this.dataLocacao = dataLocacao;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public String getNomeFilme() {
        return nomeFilme;
    }

    public void setNomeFilme(String nomeFilme) {
        this.nomeFilme = nomeFilme;
    }

    public double getValorFilme() {
        return valorFilme;
    }

    public void setValorFilme(double valorFilme) {
        this.valorFilme = valorFilme;
    }

    public String getDataLocacao() {
        return dataLocacao;
    }

    public void setDataLocacao(String dataLocacao) {
        this.dataLocacao = dataLocacao;
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
        if (!(object instanceof Locacao)) {
            return false;
        }
        Locacao other = (Locacao) object;
        if ((this.codigo == null && other.codigo != null) || (this.codigo != null && !this.codigo.equals(other.codigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gerarmodel.Locacao[ codigo=" + codigo + " ]";
    }
    
}
