public class anim {
	public static void clear(){
	    System.out.print("\033[H\033[2J");
	}
	public static String clear2(String cle){
	    String clear = "\033["+cle+"H\033[K";
	    return clear;
	}
	public static void opc(String c,String c2,String c3) throws InterruptedException{
        System.out.printf("\n%s[%s1%s]%sSIMPLE_DOWNLOAD     %s[%s2%s]%sTORRENTS     %s[%s3%s]%sGDRIVE%s\n[%s4%s]%sFACEBOOK            %s[%s5%s]%sINSTAGRAM    %s[%s6%s]%sTWITTER\n%s[%s•%s]>",c,c2,c,c3,c,c2,c,c3,c,c2,c,c3,c,c2,c,c3,c,c2,c,c3,c,c2,c,c3,c,c2,c);
	}
    public static void xdl(String c,int t) throws InterruptedException{
        int i = 0;
        String[] xdl = {"\n","_","_","  ","_","_","_","_","_","_","  ","_","     ","_","_","  ","_","_","\n",
                            "\\"," ","\\","/"," ","/","  ","_"," ","\\","|"," ","|","   ","|","  ","\\","/","  ","|"," ","_","_"," ","_"," ","_"," ","_","_","   ","_","_"," ","_","  ","_","_"," ","_","  ","_","_","_"," ","_"," ","_","_",
                            "\n"," ","\\","  ","/","|"," ","|"," ","|"," ","|"," ","|","   ","|"," ","|","\\","/","|"," ","|","/"," ","_","`"," ","|"," ","'","_"," ","\\"," ","/"," ","_","`"," ","|","/","  ","`"," ","|","/"," ","_"," ","\\"," ","'","_","_","|",
                            "\n"," ","/","  ","\\","|"," ","|","_","|"," ","|"," ","|","_","_","_","|"," ","|","  ","|"," ","|"," ","(","_","|"," ","|"," ","|"," ","|"," ","|"," ","(","_","|"," ","|"," ","(","_","|"," ","|","  ","_","_","/"," ","|",
                               "\n","/","_","/","\\","_","\\","_","_","_","_","/","|","_","_","_","_","_","|","_","|","  ","|","_","|","\\","_","_",",","_","|","_","|"," ","|","_","|","\\","_","_",",","_","|","\\","_","_",","," ","|","\\","_","_","_","|","_","|",
                               "\n","                                           ","|","_","_","_","/","\n"};
        while(i < xdl.length){
            System.out.print(c+xdl[i]);
            i += 1;
            Thread.sleep(t);
        }
    }
	public static void ss(String c,int t) throws InterruptedException{
	    int i = 0;
	    while(i < 60){
	        System.out.printf("%s=",c);
	        i += 1;
	        Thread.sleep(t);
	    }
	}
	public static void copy(String c,String c2,String c3,String c4,int t) throws InterruptedException{
	    String[] copy = {"\n",c,"(",c2,"B","y"," ",c3,"@","W","e","s","t","S","i","d","e","D","e","v",c,")",c4};
	    int i = 0;
	    while(i < copy.length){
	        System.out.print(copy[i]);
	        i += 1;
	        Thread.sleep(t);
	    }
	}
	public static void version(String c,String c2,int t) throws InterruptedException{
	    String[] version = {c,"v",c2,"[",c,"1",".","1",c2,"]","\n"};
	    int i = 0;
	    while(i < version.length){
	        System.out.print(version[i]);
	        i += 1;
	        Thread.sleep(t);
	    }
	}
}