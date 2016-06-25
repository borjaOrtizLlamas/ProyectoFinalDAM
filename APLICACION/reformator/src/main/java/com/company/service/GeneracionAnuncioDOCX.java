package com.company.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.apache.poi.xwpf.usermodel.XWPFTableCell;
import org.apache.poi.xwpf.usermodel.XWPFTableRow;

import com.company.model.Anuncio;


public class GeneracionAnuncioDOCX {
	public String replaceTextFound(Anuncio a) throws IOException {


		String realContextPath = "/datos/";

		String inputfilepath = realContextPath + "/plantillaAnuncio.docx";

		String outputfilepath = realContextPath + "/temp/";

		File folder = new File(outputfilepath);

		if (!folder.isDirectory())	folder.mkdirs();
		
		
		
		//AQUI ERROR IMPORTANTE 
		outputfilepath = outputfilepath + "/anuncio_impreso.docx";

		InputStream fs = new FileInputStream(inputfilepath);
		XWPFDocument doc = new XWPFDocument(fs);

		for (XWPFParagraph p : doc.getParagraphs()) {
			List<XWPFRun> runs = p.getRuns();
			if (runs != null) {
				for (XWPFRun r : runs) {
					String text = r.getText(0);
					if (text != null && !text.equals("")) {
						
						if (text.contains("$NOMBRE_EMPRESA")) {
							text = text.replace("$NOMBRE_EMPRESA", a.getNombreEmpresa());
							r.setText(text, 0);
						}		
						
						if (text.contains("$TIPO_PROFESIONAL")) {
							text = text.replace("$TIPO_PROFESIONAL", a.getTipoProfesional());
							r.setText(text, 0);
						}	
						
						if (text.contains("$TEXTO")) {
							text = text.replace("$TEXTO", a.getTexto());
							r.setText(text, 0);
						}		
						
						if (text.contains("$NUMERO_TELEFONO")) {
							text = text.replace("$NUMERO_TELEFONO", a.getTitulo());
							r.setText(text, 0);
						}
						
						if (text.contains("$NUMERO_TELEFONO1")) {
							text = text.replace("$NUMERO_TELEFONO1", a.getTitulo());
							r.setText(text, 0);
						}
						
						if (text.contains("$TITULO")) {
							text = text.replace("$TITULO", a.getTitulo());
							r.setText(text, 0);
						}
					}
				}
			}
		}

		FileOutputStream out = new FileOutputStream(outputfilepath);
		doc.write(out);
		out.close();

		return outputfilepath;
	}

}
