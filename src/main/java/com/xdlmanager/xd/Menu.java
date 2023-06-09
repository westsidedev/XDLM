public class Menu{
	public static void main(String[] args) throws InterruptedException{
		String red = new Colors().red,yell = new Colors().yell,cian = new Colors().Cian,vd = new Colors().vd,close = new Colors().Close;
		anim an = new anim();
		an.clear();
		an.ss(yell,5); 
	    an.xdl(red,2);
	    an.ss(yell,5);
	    an.copy(vd,red,cian,close,10);
	    System.out.print("                                     ");
	    an.version(red,yell,10);
	    an.ss(yell,2);
	}
}
