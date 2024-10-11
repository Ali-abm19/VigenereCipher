import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class vigenerecTest {
	public static void main(String[] args) throws FileNotFoundException {

		Scanner scan= new Scanner(System.in);
		int encOrDec=0;
		System.out.println("if you want to encrypt, write 1, if you want to dycrept, write 2");
		encOrDec= scan.nextInt();
		scan.nextLine();
		
		if(encOrDec==1) {
		System.out.println("write the path to your .txt file: ");
		String pathToTxt = scan.nextLine();
		//"C:\\Users\\hugea\\OneDrive - King Fahd University of Petroleum & Minerals (KFUPM)\\Term202\\ICS254-Dicrete Structures II\\sampleFile2.txt"
		File fileToEnc = new File(pathToTxt);
		String messageToEnc = "";
			try {
				messageToEnc = vigenerecCipher.readFromFileToEncrypt(fileToEnc);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			
			System.out.println("write the path you want to save the produced .dec file as " + "(C:\\Users\\User\\Desktop\\MyEncryptedFile) at: ");
			String desiredPathForDecFile = scan.nextLine();
			// this method is to encrypt
			vigenerecCipher.encryptMessage(messageToEnc, desiredPathForDecFile);
			System.out.println("Done! check: " + desiredPathForDecFile+".dec");
		}
		
		if(encOrDec==2) {
		System.out.println("write the path to your .dec file: ");
		String pathToDec = scan.nextLine();
		//"C:\\Users\hugea\OneDrive - King Fahd University of Petroleum & Minerals (KFUPM)\Term202\ICS254-Dicrete Structures II\MySampleFile.dec"
		File dec = new File(pathToDec);
	
		//"C:\\Users\\hugea\\OneDrive - King Fahd University of Petroleum & Minerals (KFUPM)\\Term202\\ICS254-Dicrete Structures II\\MySampleFile"
		System.out.println("write the encryption key: ");
		String encKey = scan.nextLine();
		// this method is to decrypt:
		vigenerecCipher.decryptFile(dec, encKey);
		System.out.println("Done! " + "this file was saved with the program files");
		}
		
		scan.close();

	}

}
