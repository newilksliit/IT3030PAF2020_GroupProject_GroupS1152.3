package com;

import model.PharmCust_PresOrder;

//For REST Service
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.xml.bind.DatatypeConverter;

import com.sun.jersey.multipart.FormDataParam;
import com.sun.jersey.core.header.FormDataContentDisposition;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLDecoder;
import java.net.URLEncoder;

//For JSON
import com.google.gson.*;

import org.apache.commons.io.IOUtils;

@Path("/PharmCust_PresOrder")
public class PharmCust_PresOrderService {

	PharmCust_PresOrder orderObj = new PharmCust_PresOrder();

	//////
	/// Prescription Orders - Upload Prescription - Customer ////
	////////////////////////////////////////////////////////////
	@POST
	@Path("/image")
	@Consumes(MediaType.MULTIPART_FORM_DATA)
	@Produces(MediaType.TEXT_PLAIN)
	public String uploadPrescription(@FormDataParam("prescriptionImage") InputStream inputStream,
			@FormDataParam("prescriptionImage") FormDataContentDisposition fileDetail)
			throws IOException, URISyntaxException {

		///// "D:\\git-remote\\IT3030PAF2020_GroupProject_GroupS1152.3\\Pharmacy_Service\\WebContent\\images_prescription";

		String SAVE_DIRECTORY = "C:\\Prescription_Images"; // Can change the path

		if (inputStream != null || fileDetail != null) {

			createFolderIfNotExists(SAVE_DIRECTORY);

			String uploadedFileLocation = SAVE_DIRECTORY + "\\" + fileDetail.getFileName();

			try {
				saveToFile(inputStream, uploadedFileLocation);

				String status = orderObj.insertPrescriptionImages(fileDetail.getFileName(), SAVE_DIRECTORY);

				if (status.equals("Successful"))
					return "Successful";
				else
					return "Unsuccessful__1";
			} catch (IOException ex) {
				ex.printStackTrace();

				return "Unsuccessful__2";
			}
		} else {
			return "Empty Data";
		}
	}

	private void saveToFile(InputStream inputStream, String target) throws IOException {
		int read = 0;
		byte[] bytes = new byte[1024];
		OutputStream outputStream = null;

		outputStream = new FileOutputStream(new File(target));

		while ((read = inputStream.read(bytes)) != -1) {
			outputStream.write(bytes, 0, read);
		}

		outputStream.flush();
		outputStream.close();
	}

	private void createFolderIfNotExists(String directoryName) throws SecurityException {
		File file = new File(directoryName);
		if (!file.exists()) {
			file.mkdir();
		}
	}
	
	
	//////
	///////// Prescription Orders
	///////// Read Prescription Order ////////////////
	@GET
	@Path("/Invoice")
	@Produces(MediaType.APPLICATION_JSON)
	public String buyPresOrder() {
		return orderObj.buyPresOrder();
	}


	
}
