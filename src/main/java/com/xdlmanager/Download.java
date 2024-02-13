package com.xdlmanager;
import java.util.Scanner;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import java.net.URL;
import java.net.UnknownHostException;
import java.security.SecureRandom;
import java.security.cert.X509Certificate;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.net.ConnectException;
import java.net.HttpURLConnection;
import java.net.SocketException;

public class Download {
	public static final String path = "Download/";
	public static long lc(String nm) {
		long rbp = 0;
		try {
			boolean a = new File(path).isDirectory();
			if (a) {
				boolean b = new File(path + nm).isFile();
				if (b) {
					rbp = new File(path + nm).length();
				}
			} else {
				File dir = new File(path);
				dir.mkdir();
				File fl = new File(path + nm);
				fl.createNewFile();
				rbp = 0;
			}
		} catch (IOException e) {
			System.exit(1);
		}
		return rbp;
	}

	public static void download(URL lk, String nm) {
		String red = new Colors().red, vd = new Colors().vd, yell = new Colors().yell, close = new Colors().Close;
		try {
			long a = lc(nm);
			File xd = new File(path + nm);
			HttpURLConnection http = (HttpURLConnection)lk.openConnection();
			http.setRequestProperty("Range", "bytes=" + a + "-");
			long tm = http.getContentLength();
			double b = (double)tm / Math.pow(1024, 2);
			InputStream in = http.getInputStream();
			RandomAccessFile raf = new RandomAccessFile(xd, "rw");
			raf.seek(a);
			System.out.printf("%s[%sARCHIVE%s]:%s%s\n", yell, vd, yell, close, nm);
			byte[] bf = new byte[4096];
			int bfr = 0;
			long tbrd = 0;
			while ((bfr = in.read(bf)) != -1) {
				raf.write(bf, 0, bfr);
				tbrd += bfr;
				double c = (double)tbrd / Math.pow(1024, 2);
				System.out.printf("%s[%sDOWNLOADING %.2f/%s%.2f%s]%s", yell, red, c, vd, b, yell, close);
				System.out.print("\033[K\r");
			}
			raf.close();
			in.close();
			http.disconnect();
			System.out.print("\033[K\r");
			System.out.printf("%s[%sDOWNLOAD FINISHED%s]%s", yell, vd, yell, close);
			Thread.sleep(2500);
		} catch (Exception e) {
			System.exit(1);
		}

	}
	public static void main(String[] args) {
		String vd = new Colors().vd, red = new Colors().red, yell = new Colors().yell, close = new Colors().Close;
		TrustManager[] trustAllCerts = new TrustManager[] {new X509TrustManager() {
				public X509Certificate[] getAcceptedIssuers() {
					return null;
				}
				public void checkClientTrusted(X509Certificate[] certs, String authType) {
				}
				public void checkServerTrusted(X509Certificate[] certs, String authType) {
				}
			}
		};

		try {
			SSLContext sslContext = SSLContext.getInstance("SSL");
			sslContext.init(null, trustAllCerts, new SecureRandom());
			HttpsURLConnection.setDefaultSSLSocketFactory(sslContext.getSocketFactory());
			System.out.printf("%s[%sLINK%s]%s>%s", yell, vd, yell, red, close);
			try {
				URL url = new URL(new Scanner(System.in).nextLine());
				HttpURLConnection http = (HttpURLConnection)url.openConnection();
				if (http.getResponseCode() == 200) {
					String nmlk = url.getPath();
					File fl = new File(nmlk);
					String nm = fl.getName();
					boolean dir = new File(path).isDirectory(), arq = new File(path + nm).isFile();
					if (dir & arq) {
						long tm = http.getContentLength(), tm2 = new File(path + nm).length();
						if (tm == tm2) {
							System.out.printf("%s[%sDOWNLOAD FINISHED%s]%s\n%s[%sDO YOU WANT TO DELETE?%s]:%s", yell, vd, yell, close, yell, vd, yell, close);
							String del = new Scanner(System.in).nextLine();
							if (del.equals("y") || del.equals("Y")) {
								System.out.printf("%s%s%s%s", anim.clear2("14"), anim.clear2("13"), anim.clear2("12"), anim.clear2("11"));
								new File(path + nm).delete();
								main(null);
							} else if (del.equals("n") || del.equals("N")) {
								System.out.printf("%s%s%s%s", anim.clear2("14"), anim.clear2("13"), anim.clear2("12"), anim.clear2("11"));
								main(null);
							}
						} else {
							System.out.printf("%s%s", anim.clear2("12"), anim.clear2("11"));
							download(url, nm);
						}
					} else {
						long tm = http.getContentLength();
						double tmf = (double)tm / Math.pow(1024, 2);
						System.out.printf("%s[%sARCHIVE%s]:%s%s\n%s[%sSIZE%s]:%s%.2f\n%s[%sDO YOU WANT TO CHANGE THE NAME?%s]:%s", yell, vd, yell, close, nm, yell, vd, yell, close, tmf, yell, vd, yell, close);
						Scanner s = new Scanner(System.in);
						String opc;
						opc = s.nextLine();
						if (opc.equals("y") || opc.equals("Y")) {
							String nm2;
							System.out.printf("%s[%sWRITE%s]:%s", yell, vd, yell, close);
							nm2 = s.nextLine();

							System.out.printf("%s%s%s%s%s%s", anim.clear2("16"), anim.clear2("15"), anim.clear2("14"), anim.clear2("13"), anim.clear2("12"), anim.clear2("11"));
							download(url, nm2);
						} else if (opc.equals("n") || opc.equals("N")) {
							System.out.printf("%s%s%s%s%s", anim.clear2("15"), anim.clear2("14"), anim.clear2("13"), anim.clear2("12"), anim.clear2("11"));
							download(url, nm);
						}
					}
				} else {
					System.out.printf("%s%s", anim.clear2("13"), anim.clear2("11"));
					System.out.printf("%s[%sERROR%s]:%s", yell, red, yell, red, http.getResponseCode());
					Thread.sleep(1500);
					System.out.printf("%s%s", anim.clear2("13"), anim.clear2("11"));
					main(null);
				}
			} catch (ConnectException s) {
				System.out.printf("%s%s", anim.clear2("13"), anim.clear2("11"));
				System.out.printf("%s[%sERROR CONNECTION TIME OUT%s]%s", yell, red, yell, close);
				Thread.sleep(1500);
				System.out.printf("%s%s", anim.clear2("13"), anim.clear2("11"));
				main(null);
			} catch (UnknownHostException u) {
				System.out.printf("%s%s", anim.clear2("13"), anim.clear2("11"));
				System.out.printf("%s[%sERROR NO CONNECTION%s]%s", yell, red, yell, close);
				Thread.sleep(1500);
				System.out.printf("%s%s", anim.clear2("13"), anim.clear2("11"));
				main(null);
			} catch (SocketException ce) {
				System.out.printf("%s%s", anim.clear2("13"), anim.clear2("11"));
				System.out.printf("%s[%sERROR CONNECTION CLOSE%s]%s", yell, red, yell, close);
				Thread.sleep(1500);
				System.out.printf("%s%s", anim.clear2("13"), anim.clear2("11"));
				main(null);
			}
		} catch (Exception e) {
			new Main().main(null);
		}
	}
}
