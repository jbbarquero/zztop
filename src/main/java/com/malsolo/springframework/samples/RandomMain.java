package com.malsolo.springframework.samples;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Random;

import org.apache.commons.lang3.RandomStringUtils;

public class RandomMain {
	
	private static final String EMPTY_STRING= "";
	private static final String VALID_CHARS = "abcdefghjkmnpqrstuvwxyzABCDEFGHJKMNPQRSTUVWXYZ23456789+@*()_|,.";
	private static final int LENGTH= 10;

	public static void main(String... args) {
		RandomMain randomMain = new RandomMain();
		System.out.println("· Random 1:");
		randomMain.randomOne();
		System.out.println("\n· Random 1 to 9:");
		randomMain.randomOneToNine();
		System.out.println("\n· Random hello world:");
		System.out.println(randomHelloWorld(-229985452) + ' ' + randomHelloWorld(-147909649));
		System.out.println("\n· Truly Random generate:");
		System.out.println(randomMain.generate());
	}

	public void randomOne() {
		Random random = new Random(441287210);
		for(int i=0;i<10;i++)
			System.out.print(random.nextInt(10)+" ");
	}

	public void randomOneToNine() {
		Random random = new Random(-6732303926L);
		for(int i=0;i<10;i++)
			System.out.print(random.nextInt(10)+" ");
	}

	public static String randomHelloWorld(int seed) {
		Random rand = new Random(seed);
		StringBuilder sb = new StringBuilder();
		while (true) {
		//for(int i=0;;i++) {
			int n = rand.nextInt(27);
			if (n == 0) break;
			sb.append((char) ('`' + n));
		}
		return sb.toString();
	}

	/**
	 * See
	 * http://www.cigital.com/justice-league-blog/2009/08/14/proper-use-of-javas-securerandom/ 
	 * http://www-01.ibm.com/support/docview.wss?uid=swg21205388
	 * http://resources.infosecinstitute.com/random-number-generation-java/
	 * @return
	 */
	public String generate() {
		SecureRandom sr = null;
		try {
			sr = SecureRandom.getInstance("SHA1PRNG");
			System.out.println("SHA1PRNG");
		} catch (NoSuchAlgorithmException nsae1) {
			nsae1.printStackTrace();
			try {
				sr = SecureRandom.getInstance("IBMSecureRandom");
				System.out.println("IBMSecureRandom");
			} catch (NoSuchAlgorithmException nsae2) {
				nsae2.printStackTrace();
			}
		}
		String pw = EMPTY_STRING;
		if (sr != null) {
			sr.nextBytes(new byte[LENGTH]);
			for (int i = 0; i < LENGTH; i++) {
				int index = (int) (sr.nextDouble() * VALID_CHARS.length());
				pw += VALID_CHARS.substring(index, index + 1);
			}
		} else {
			pw = RandomStringUtils.randomAlphabetic(LENGTH);
		}
		return pw;
	}
}
