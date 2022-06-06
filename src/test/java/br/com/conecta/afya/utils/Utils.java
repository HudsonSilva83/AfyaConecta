package br.com.conecta.afya.utils;

import java.text.Normalizer;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Calendar;

public class Utils {

	public static String formataData(Date data) {
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
		String dataFormatada = formato.format(data);
		return dataFormatada;
	}

	public static java.sql.Date converterStringDate(String date) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		return new java.sql.Date(sdf.parse(date).getTime());
	}

	// M�todo para formatar um valor
	public static String formatarMoeda(double vlr) {
		java.text.DecimalFormat df = new java.text.DecimalFormat("###,###,##0.00");
		return df.format(vlr);
	}

	public static String removerAcentos(String valorAcentuado) {
		return Normalizer.normalize(valorAcentuado, Normalizer.Form.NFD).replaceAll("[^\\p{ASCII}]", "");
	}

	public static String obterDataHoraAtual() {
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat formato = new SimpleDateFormat("ddMMyyyy");
		String dataFormatada = formato.format(calendar.getTime());
		return dataFormatada;
	}
	
	public static String adicionarHora(Date data, int qtd) {
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.HOUR, qtd);
		SimpleDateFormat formato = new SimpleDateFormat("HH:mm");
		String dataFormatada = formato.format(calendar.getTime());
		return dataFormatada;
	}
}
