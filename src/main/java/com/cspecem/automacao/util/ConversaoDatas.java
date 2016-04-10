package com.cspecem.automacao.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class ConversaoDatas {

	public static void main(String[] args) throws ParseException {
		
		Calendar c = Calendar.getInstance();
		
		Date data = c.getTime();
		
		DateFormat f = DateFormat.getDateInstance();
		
		Date data2 = f.parse("12/01/1995");
		
		System.out.println(data2);

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		System.out.println("Data formatada: " + sdf.format(data));

		// Converte Objetos
		System.out.println("Data convertida: " + sdf.parse("02/08/1970"));
	}

}
