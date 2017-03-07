package com.hand.BRWStream;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class testDownloadPDFAndCopy {

	public static void main(String[] args) {		
		try {
			URL url = new URL("http://www.madore.org/~david/math/padics.pdf");
			URLConnection conn = url.openConnection();
			InputStream is = conn.getInputStream();
			BufferedInputStream bis = new BufferedInputStream(is);			
			FileOutputStream fos = new FileOutputStream("new_pdf.pdf");
			BufferedOutputStream bos = new BufferedOutputStream(fos);			
			byte[] input = new byte[10];	
			while (bis.read(input)!=-1)			
				bos.write(input);
			bos.close();
			fos.close();
			bis.close();
			is.close();					
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}	
}
