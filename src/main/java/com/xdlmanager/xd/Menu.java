import java.util.InputMismatchException;
import java.util.MissingFormatArgumentException;
import java.util.Scanner;

public class Menu{
	public static void main(String[] args){
		String red = new Colors().red,yell = new Colors().yell,cian = new Colors().Cian,vd = new Colors().vd,close = new Colors().Close,blue = new Colors().blue;
		try{
    		anim an = new anim();
    		an.clear();
    		an.ss(blue,5); 
    	    an.xdl(vd,2);
    	    an.ss(blue,5);
    	    an.copy(yell,red,cian,close,10);
    	    System.out.print("                                     ");
    	    an.version(red,yell,10);
    	    an.ss(blue,2);
    	    an.opc(yell,vd,blue);
    	    try{
        	    int op = new Scanner(System.in).nextInt();
        	    switch (op){
        	        case 1:
        	            System.out.printf("%s%s%s",anim.clear2("13"),anim.clear2("12"),anim.clear2("11"));
        	            new Download().main(null);
        	            break;
        	        case 2:
        	            System.out.printf("%s%s%s",anim.clear2("13"),anim.clear2("12"),anim.clear2("11"));
        	            new Torrents().main(null);
        	            break;
        	        case 3:
        	            System.out.printf("%s%s%s",anim.clear2("13"),anim.clear2("12"),anim.clear2("11"));
        	            new Gdrive().main(null);
        	            break;
        	        case 4:
        	            System.out.printf("%s%s%s",anim.clear2("13"),anim.clear2("12"),anim.clear2("11"));
        	            new Facebook().main(null);
        	            break;
        	        case 5:
        	            System.out.printf("%s%s%s",anim.clear2("13"),anim.clear2("12"),anim.clear2("11"));
        	            new Instagram().main(null);
        	            break;
        	        case 6:
        	            System.out.printf("%s%s%s",anim.clear2("13"),anim.clear2("12"),anim.clear2("11"));
        	            new Twitter().main(null);
        	            break;
        	        default :
        	            main(null);
        	        
        	    }
    	    }catch(InputMismatchException Imp){
    	       System.out.printf("%s[%sERROR OPTION%s]%s",yell,red,yell,close);
    	       Thread.sleep(1000);
    	       main(null);
    	    }
		}catch(InterruptedException Ie){
		    System.exit(1);
		}
	}
}
