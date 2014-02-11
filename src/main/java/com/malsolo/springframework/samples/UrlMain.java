package com.malsolo.springframework.samples;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Authenticator;
import java.net.InetSocketAddress;
import java.net.MalformedURLException;
import java.net.PasswordAuthentication;
import java.net.Proxy;
import java.net.URL;
import java.net.URLConnection;

public class UrlMain {

	public static void main(String... args) {
		try {
			URL url = new URL("http://www.elmundo.es");
			System.out.println(url.getHost());
			URL myURL = new URL("http://qwertynoexiste.com");
			System.out.println(myURL.getHost());
			authentication();
			Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress("proxy.indra.es", 8080));
			URLConnection con = url.openConnection(proxy);
			con.connect();
			URLConnection myCon = myURL.openConnection(proxy);
			myCon.connect();
			read(con);
			read(myCon);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static void authentication() {
		Authenticator.setDefault(new Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication("user", "pasword".toCharArray());
			}
		});
	}

	private static void read(URLConnection urlConnection) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(
				urlConnection.getInputStream()));
		String inputLine;
		while ((inputLine = in.readLine()) != null) 
			System.out.println(inputLine);
		in.close();		
	}

}
