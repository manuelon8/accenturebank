package com.ws.creditcard.service;

import javax.print.Doc;
import javax.print.DocFlavor;
import javax.print.DocPrintJob;
import javax.print.PrintService;
import javax.print.PrintServiceLookup;
import javax.print.SimpleDoc;
import javax.print.attribute.HashPrintRequestAttributeSet;
import javax.print.attribute.PrintRequestAttributeSet;

import com.ws.creditcard.model.Transaccion;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class PrintTest {

	public void imprimirfactura(Transaccion tran) throws IOException {
	FileInputStream inputStream = null;
    try {
        inputStream = new FileInputStream("host:/factura.pdf");
    } catch (FileNotFoundException e) {
        e.printStackTrace();
    }
    if (inputStream == null) {
        return;
    }

    DocFlavor docFormat = DocFlavor.INPUT_STREAM.AUTOSENSE;
    Doc document = new SimpleDoc(tran, docFormat, null);

    PrintRequestAttributeSet attributeSet = new HashPrintRequestAttributeSet();

    PrintService defaultPrintService = PrintServiceLookup.lookupDefaultPrintService();
    		 


    if (defaultPrintService != null) {
        DocPrintJob printJob = defaultPrintService.createPrintJob();
        try {
            printJob.print(document, attributeSet);

        } catch (Exception e) {
            e.printStackTrace();
        }
    } else {
        System.err.println("No existen impresoras instaladas o no hay papel");
    }

    inputStream.close();

}
}
