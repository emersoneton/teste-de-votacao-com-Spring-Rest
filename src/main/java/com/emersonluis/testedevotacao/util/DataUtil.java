package com.emersonluis.testedevotacao.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DataUtil {

	public String formatLocalDataTimeToDatabaseStyle(LocalDateTime localDatatime) {
		return DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").format(localDatatime);
	}
	
	
}
