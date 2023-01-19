package csd;

class App {
	public static void main(String [] args)
	{
		AtmApp.run(3);
	}
}

class AtmApp {
	public static void doSuccess(AtmCard atmCard, java.util.Scanner kb) 
	{
		System.out.println("-----------------------------------------------");
		System.out.println("Giriş Başarılı");
		System.out.println("-----------------------------------------------");
	}
	
	public static void doFail(AtmCard atmCard, java.util.Scanner kb) 
	{
		System.out.println("-----------------------------------------------");
		System.out.println("Giriş başarısız!... Artık deneme hakkınız bitti!...");
		System.out.println("-----------------------------------------------");
	}
	
	public static void doWorkForAtmCard(AtmCard atmCard, java.util.Scanner kb, int tryNum)
	{
		int i = 0;
		
		for (; i < tryNum; ++i) {
			System.out.print("Kullanıcı adını giriniz:");
			String username = kb.nextLine();
			System.out.print("Şifreyi giriniz:");
			String password = kb.nextLine();
			
			if (atmCard.isValid(username, password))
				break;
			
			if (i != tryNum - 1)
				System.out.printf("Giriş başarısız!... %d deneme hakkınız kaldı!...%n", tryNum - 1 - i);
		}
		
		if (i != tryNum)
			doSuccess(atmCard, kb);
		else
			doFail(atmCard, kb);
	}
	
	public static void run(int tryNum)
	{
		java.util.Scanner kb = new java.util.Scanner(System.in);
		
		for (;;) {
			System.out.println("Hoş geldiniz:");
			AtmCard atmCard = new AtmCard(); 
			
			doWorkForAtmCard(atmCard, kb, tryNum);
		}
	}
}

class AtmCard {
	public String username;
	public String password;
	
	public AtmCard()
	{
		username = "csd";
		password = "1993";
	}
	
	public boolean isValid(String uname, String passwd)
	{
		return uname.equals(username) && passwd.equals(password);
	}
	
}
