import java.util.Scanner; 
interface Cipher
{
	String encrypt(String alphabet, String plainText, String key);
	String decrypt(String alphabet, String cipherText, String key);
}
public class CSCI
{
	public static void main(String[] args)
	{
		System.out.println("Cipher Operations:" + "\n" +
			"-------------------------------------" + "\n" +
			"1. Decrypt and verify Caesar cipher" + "\n" +
			"2. Decrypt and verify Vigenere cipher" + "\n" +
			"3. Display this menu again" + "\n" +
			"4. Quit" +"\n");
	
			Scanner choice = new Scanner(System.in);  
			System.out.print("Choice: ");
			int number;
			number = choice.nextInt();
			menu(number);
	}
	public static void menu(int number){
			if (number == 1)
			{	
				Scanner alp = new Scanner(System.in);
				System.out.print ("\n"+"Enter alphabet     :");
				String alph = new String();
				alph = alp.nextLine();

				Scanner cip = new Scanner(System.in);
				System.out.print ("Enter cipher text  :");
				String ciph = new String();
				ciph = cip.nextLine();

				Scanner k = new Scanner(System.in);
				System.out.print ("Enter key          :");
				String ky;
				ky = k.nextLine();
				
				
				Caesar variable = new Caesar();
				
              System.out.println("\n"+"Plain text                               :" + variable.decrypt(alph,ciph,ky));
				String check = new String();
				check = variable.decrypt(alph,ciph,ky);
                   System.out.println("Plain text re-encrypted for verification :" + variable.encrypt(alph,check,ky));
				
				if (variable.encrypt(alph,check,ky).equals(ciph))																					
				{
	           System.out.println("Are cipher text and encrypted text equal :" + true + "\n");
					
				}
				Scanner choice = new Scanner(System.in);  
				System.out.print("Choice:");
				int numberr;
				numberr = choice.nextInt();
				menu(numberr);

			}
			if (number == 2)
			{	
				Scanner alph = new Scanner(System.in);
				System.out.print ("\n"+"Enter alphabet     :");
				String alpha = new String();
				alpha = alph.nextLine();

				Scanner ciph = new Scanner(System.in);
				System.out.print ("Enter cipher text  :");
				String ciphe = new String();
				ciphe = ciph.nextLine();

				Scanner ke = new Scanner(System.in);
				System.out.print ("Enter key          :");
				String kye;
				kye = ke.nextLine();
				
				
				Vigenere varl = new Vigenere();
				
				System.out.println("\n"+"Plain text                               :" + varl.decrypt(alpha,ciphe,kye));
				String checkk = new String();
				checkk = varl.decrypt(alpha,ciphe,kye);
				System.out.println("Plain text re-encrypted for verification :" + 										varl.encrypt(alpha,checkk,kye));
				
				if (varl.encrypt(alpha,checkk,kye).equals(ciphe))																					
				{
				System.out.println("Are cipher text and encrypted text equal :" + true + "\n");
					
				}
				Scanner choice = new Scanner(System.in);  
				System.out.print("Choice:");
				int numberrr;
				numberrr = choice.nextInt();
				menu(numberrr);

			}
			if (number == 3)
			{
				System.out.println("\n"+"CSCI Cipher Operations:" + "\n" +
				"-------------------------------------" + "\n" +
				"1. Decrypt and verify Caesar cipher" + "\n" +
				"2. Decrypt and verify Vigenere cipher" + "\n" +
				"3. Display this menu again" + "\n" +
				"4. Quit" + "\n");
				Scanner choice = new Scanner(System.in);  
				System.out.print("Choice:");
				int numbeer;
				numbeer = choice.nextInt();
				menu(numbeer);
				
				
			}
			if (number > 4 || number < 1)
			{
				System.out.println("\n"+"Invalid choice! Try again." + "\n");
				Scanner choice = new Scanner(System.in);  
				System.out.print("Choice:");
				int numbber;
				numbber = choice.nextInt();
				menu(numbber);
			}
			if(number == 4)
			{
			 	System.out.println("Have a crime-free day!");
				System.exit(0);		
			}
	}
	
}



class Caesar implements Cipher
{
	public String encrypt(String alphabet, String plainText, String key)
	{
		int keyy = Integer.parseInt(key);
		String cipherText = new String();
		for (int i = 0; i < plainText.length(); i++)
		{
			int position = alphabet.indexOf(plainText.charAt(i));
           	 	int value = (keyy + position) % 26;
           	 	char replaceValue = alphabet.charAt(value);
           	 	cipherText += replaceValue;
		}
		return cipherText;
	}
	public String decrypt(String alphabet, String cipherText, String key)
	{
		int keyy = Integer.parseInt(key);
		String plainText = new String();
        	for (int i = 0; i < cipherText.length(); i++)
        	{
            		int position = alphabet.indexOf(cipherText.charAt(i));
            		int value = (position - keyy) % 26;
            		if (value < 0)
            		{
                		value = alphabet.length() + value;
            		}
            		char replaceValue = alphabet.charAt(value);
            		plainText += replaceValue;
        	}
        	return plainText;
	}
}

class Vigenere implements Cipher
{
	public String encrypt(String alphabet, String plainText, String key)
	{
		String cipherText = new String();
		int j = 0;
        	for (int i = 0; i < plainText.length(); i++)
        	{
			int positionPlain = alphabet.indexOf(plainText.charAt(i));
			int positionKey = alphabet.indexOf(key.charAt(j));
			int value = (positionPlain + positionKey) % 26;
			char replaceValue = alphabet.charAt(value);
			cipherText += replaceValue;
			j = ++j % key.length();	
        	}
        	return cipherText;
	}
	public String decrypt(String alphabet, String cipherText, String key)
	{
		
		String plainText = new String();
		int j = 0;
        	for (int i = 0; i < cipherText.length(); i++)
        	{
			int positionCipher = alphabet.indexOf(cipherText.charAt(i));
			int positionKey = alphabet.indexOf(key.charAt(j));
			int value = (positionCipher - positionKey) % 26;
			if (value < 0)
			{
				value = alphabet.length() + value;
			}
			char replaceValue = alphabet.charAt(value);
			plainText += replaceValue;
			j = ++j % key.length();		
        	}
        	return plainText;
	}
}
