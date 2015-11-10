package util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import exception.ConversaoDeDataException;
import exception.FormatoDeDataException;

public class ConversorDeData {

	private static ConversorDeData instance;

	public static synchronized ConversorDeData getInstance() {
		if (instance == null)
			instance = new ConversorDeData();
		return instance;
	}

	DateFormat formatadorDeData;
	private Pattern pattern;

	private static final String DATE_PATTERN = "\\d{2}/{1}\\d{2}/{1}\\d{4}";

	private ConversorDeData() {
		formatadorDeData = new SimpleDateFormat("dd/MM/yyyy");
		formatadorDeData.setLenient(false);
		pattern = Pattern.compile(DATE_PATTERN);
	}

	public Date converterData(String dataNasc) throws ConversaoDeDataException {
		try {
			if (!formatoDataValido(dataNasc))
				throw new FormatoDeDataException();
			return formatadorDeData.parse(dataNasc);
		} catch (ParseException pe) {
			throw new ConversaoDeDataException(pe);
		}
	}

	private boolean formatoDataValido(final String dataNasc) {
		Matcher matcher = pattern.matcher(dataNasc);
		return matcher.matches();
	}
}
