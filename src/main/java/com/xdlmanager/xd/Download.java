import java.util.Scanner;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import java.net.URL;
import java.security.SecureRandom;
import java.security.cert.X509Certificate;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.net.HttpURLConnection;

public class Download {
	public static final String path = "Download/";
	public static long lc(String nm){
	    long rbp = 0;
	    try{
            boolean a = new File(path).isDirectory();
            if (a){
                boolean b = new File(path+nm).isFile();
                if (b){
                    rbp = new File(path+nm).length();
                }
            }else{
                File dir = new File(path);dir.mkdir();
                File fl = new File(path+nm);fl.createNewFile();
                rbp = 0;
            }
	    }catch(IOException e){
	        e.printStackTrace();
	    }
	    return rbp;
    }
        
	public static void download(URL lk,String nm){
	    try{
            long a = lc(nm);
            File xd = new File(path+nm);
            HttpURLConnection http = (HttpURLConnection)lk.openConnection();
            http.setRequestProperty("Range","bytes="+a+"-");
            long tm = http.getContentLength();
            double b = (double)tm / Math.pow(1024,2);
            InputStream in = http.getInputStream();
            RandomAccessFile raf = new RandomAccessFile(xd,"rw");raf.seek(a);
            byte[] bf = new byte[4096];int bfr = 0;long tbrd = 0;
            while((bfr = in.read(bf)) != -1){
                raf.write(bf,0,bfr);
                tbrd += bfr;
                double c = (double)tbrd / Math.pow(1024,2);
                System.out.printf("Baixado %.2f/%.2f",c,b);
                System.out.print("\033[K\r");
            }   
            raf.close();
            in.close();
            http.disconnect();
	    }catch(Exception e){
	      e.printStackTrace();
	    }
       
     }
	public static void main(){
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
    
		try{
		    SSLContext sslContext = SSLContext.getInstance("SSL");
            sslContext.init(null, trustAllCerts, new SecureRandom());
            HttpsURLConnection.setDefaultSSLSocketFactory(sslContext.getSocketFactory());
		    System.out.print("Digite o link:");
		    URL url = new URL(new Scanner(System.in).nextLine());
		    HttpURLConnection http = (HttpURLConnection)url.openConnection();
		    if(http.getResponseCode() == 200){
		        String nmlk = url.getPath();
		        File fl = new File(nmlk);
		        String nm = fl.getName();
		        boolean dir = new File(path).isDirectory(),arq = new File(path+nm).isFile();
		        if(dir & arq){
		            long tm = http.getContentLength(),tm2 = new File(path+nm).length();
		            if(tm == tm2){
		                System.out.print("Download Concluído");
		            }else{
		                download(url,nm);
		            }
		        }else{
		            long tm = http.getContentLength();
		            double tmf = (double)tm / Math.pow(1024,2);
		            System.out.printf("Arquivo:%s\nTamanho:%.2f\nDeseja mudar o nome ?",nm,tmf);
		            Scanner s = new Scanner(System.in);String opc;
		            opc = s.nextLine();
		            if(opc.equals("y")||opc.equals("Y")){
		                String nm2;
		                System.out.print("Digite:");
		                nm2 = s.nextLine();
		                download(url,nm2);
		            }else{
		                download(url,nm);
		            }
		        }
		    }else{
		        System.out.print("Error:"+http.getResponseCode());
		    }
    	}catch (Exception e){
    	    e.printStackTrace();
    	}
	}
}
