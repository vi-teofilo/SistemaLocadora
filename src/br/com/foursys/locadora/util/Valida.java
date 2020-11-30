package br.com.foursys.locadora.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import br.com.caelum.stella.validation.CPFValidator;

public class Valida {
	public static boolean campoVazio(String campo) {
		campo = campo.trim();
		return campo.equals("") || campo.equals(null);
	}

	public static boolean validaCpf(String cpf) {
		CPFValidator cpfValidator = new CPFValidator();
		try {
			cpfValidator.assertValid(cpf);
			return true;
		} catch (Exception e) {

			return false;
		}
	}

	public static boolean validaCPFZero(String cnpj) {
		if (cnpj.equals("000.000.000-00")) {
			return false;
		}
		return true;
	}

	public static boolean validarRg(String rg) {
		return rg.equals("00.000.000");
	}

	public static boolean validarData(String data) {
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");// Formata a data
			sdf.setLenient(false);// Seta para que nγo seja estranha ex:31/02/2019
			sdf.parse(data);// Tenta colocar a string data num objeto date
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
			LocalDate dataVerificada = LocalDate.parse(data, dtf);// Tenta colocar a string data formatada num objeto
																	// datetime
			LocalDate hoje = LocalDate.now();// Verifica se a data ι menor que a data atual
			return dataVerificada.compareTo(hoje) <= 0;
		} catch (ParseException ex) {
			return false;
		}
	}
	

	public static boolean validaNome(String nome) {
		Pattern p = Pattern.compile("^(([a-zA-Z ]|[κιαγνυτσΰ])*)$");
		Matcher m = p.matcher(nome);
		if (m.find()) {
			return false;
		} else {
			return true;
		}
	}
}
