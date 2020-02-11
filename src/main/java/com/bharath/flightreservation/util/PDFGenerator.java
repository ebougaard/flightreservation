package com.bharath.flightreservation.util;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.bharath.flightreservation.entities.Reservation;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

@Component
public class PDFGenerator {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(PDFGenerator.class);


	public void generateItinerary(Reservation reservation, String filePath) {
		LOGGER.info("generateItinerary()");
		Document document = new Document();

		try {
			PdfWriter.getInstance(document, new FileOutputStream(filePath));

			document.open();

			document.add(generateTable(reservation));

			document.close();

		} catch (FileNotFoundException | DocumentException e) {
			LOGGER.error("Exception in generateItinerary " +e);
		}

	}

	private PdfPTable generateTable(Reservation reservation) {
		PdfPTable table = new PdfPTable(2);

		PdfPCell cell;

		cell = new PdfPCell(new Phrase("Alt Health"));
		cell.setColspan(2);
		table.addCell(cell);

		cell = new PdfPCell(new Phrase("Appointment Details"));
		cell.setColspan(2);
		table.addCell(cell);



		table.addCell("Address");
		table.addCell(reservation.getAppointment().getLocation());


		table.addCell("Time Of Appointment");
		table.addCell(reservation.getAppointment().getTime());

		table.addCell("Date Of Appointment ");
		table.addCell(reservation.getAppointment().getDateOfAppointment().toString());

		cell = new PdfPCell(new Phrase("Patient Details"));
		cell.setColspan(2);
		table.addCell(cell);

		table.addCell("First Name");
		table.addCell(reservation.getPassenger().getFirstName());

		table.addCell("Last Name");
		table.addCell(reservation.getPassenger().getLastName());

		table.addCell("Email");
		table.addCell(reservation.getPassenger().getEmail());

		table.addCell("Phone");
		table.addCell(reservation.getPassenger().getPhone());

		return table;
	}

}
