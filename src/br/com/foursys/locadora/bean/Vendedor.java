/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.foursys.locadora.bean;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author dmunhoz
 */
@Entity
@Table(name = "vendedor")
public class Vendedor{
    @Id
    @GeneratedValue
    @Basic(optional = false)
    @Column(name = "codigo")
    private Integer codigo;
    @Basic(optional = false)
    @Column(name = "area_venda")
    private String areaVenda;
    @Basic(optional = false)
    @Column(name = "cidade")
    private String cidade;
    @Basic(optional = false)
    @Column(name = "estado")
    private String estado;
    @Basic(optional = false)
    @Column(name = "idade")
    private int idade;
    @Basic(optional = false)
    @Column(name = "nome")
    private String nome;
    @Basic(optional = false)
    @Column(name = "salario")
    private double salario;
    @Basic(optional = false)
    @Column(name = "sexo")
    private String sexo;

    public Vendedor() {
    }

    public Vendedor(Integer codigo) {
        this.codigo = codigo;
    }

    public Vendedor(Integer codigo, String areaVenda, String cidade, String estado, int idade, String nome, double salario, String sexo) {
        this.codigo = codigo;
        this.areaVenda = areaVenda;
        this.cidade = cidade;
        this.estado = estado;
        this.idade = idade;
        this.nome = nome;
        this.salario = salario;
        this.sexo = sexo;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getAreaVenda() {
        return areaVenda;
    }

    public void setAreaVenda(String areaVenda) {
        this.areaVenda = areaVenda;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
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

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
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
        if (!(object instanceof Vendedor)) {
            return false;
        }
        Vendedor other = (Vendedor) object;
        if ((this.codigo == null && other.codigo != null) || (this.codigo != null && !this.codigo.equals(other.codigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.foursys.hibernate.model.Vendedor[ codigo=" + codigo + " ]";
    }
    
}
