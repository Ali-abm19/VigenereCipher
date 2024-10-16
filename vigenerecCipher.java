import java.io.*;
import java.util.*;

public class vigenerecCipher {
	static String writing = "";
	static String reading = "";
	static String key = " "; // this is the original key, taken from the file

	public static int charToInt(char c) {
		switch (c) {
		case 'A':
			return 0;
		case 'B':
			return 1;
		case 'C':
			return 2;
		case 'D':
			return 3;
		case 'E':
			return 4;
		case 'F':
			return 5;
		case 'G':
			return 6;
		case 'H':
			return 7;
		case 'I':
			return 8;
		case 'J':
			return 9;
		case 'K':
			return 10;
		case 'L':
			return 11;
		case 'M':
			return 12;
		case 'N':
			return 13;
		case 'O':
			return 14;
		case 'P':
			return 15;
		case 'Q':
			return 16;
		case 'R':
			return 17;
		case 'S':
			return 18;
		case 'T':
			return 19;
		case 'U':
			return 20;
		case 'V':
			return 21;
		case 'W':
			return 22;
		case 'X':
			return 23;
		case 'Y':
			return 24;
		case 'Z':
			return 25;
		case 'a':
			return 26;
		case 'b':
			return 27;
		case 'c':
			return 28;
		case 'd':
			return 29;
		case 'e':
			return 30;
		case 'f':
			return 31;
		case 'g':
			return 32;
		case 'h':
			return 33;
		case 'i':
			return 34;
		case 'j':
			return 35;
		case 'k':
			return 36;
		case 'l':
			return 37;
		case 'm':
			return 38;
		case 'n':
			return 39;
		case 'o':
			return 40;
		case 'p':
			return 41;
		case 'q':
			return 42;
		case 'r':
			return 43;
		case 's':
			return 44;
		case 't':
			return 45;
		case 'u':
			return 46;
		case 'v':
			return 47;
		case 'w':
			return 48;
		case 'x':
			return 49;
		case 'y':
			return 50;
		case 'z':
			return 51;
		case '0':
			return 52;
		case '1':
			return 53;
		case '2':
			return 54;
		case '3':
			return 55;
		case '4':
			return 56;
		case '5':
			return 57;
		case '6':
			return 58;
		case '7':
			return 59;
		case '8':
			return 60;
		case '9':
			return 61;
		case ',':
			return 62;
		case '.':
			return 63;
		case '?':
			return 64;
		case '!':
			return 65;
		case '\s':
			return 66;
		}
		return -1;
	}

	public static char intToChar(int intg) {
		switch (intg) {
		case 0:
			return 'A';

		case 1:
			return 'B';

		case 2:
			return 'C';

		case 3:
			return 'D';

		case 4:
			return 'E';

		case 5:
			return 'F';

		case 6:
			return 'G';

		case 7:
			return 'H';

		case 8:
			return 'I';

		case 9:
			return 'J';

		case 10:
			return 'K';

		case 11:
			return 'L';

		case 12:
			return 'M';

		case 13:
			return 'N';

		case 14:
			return 'O';

		case 15:
			return 'P';

		case 16:
			return 'Q';

		case 17:
			return 'R';

		case 18:
			return 'S';

		case 19:
			return 'T';

		case 20:
			return 'U';

		case 21:
			return 'V';

		case 22:
			return 'W';

		case 23:
			return 'X';

		case 24:
			return 'Y';

		case 25:
			return 'Z';

		case 26:
			return 'a';

		case 27:
			return 'b';

		case 28:
			return 'c';

		case 29:
			return 'd';

		case 30:
			return 'e';

		case 31:
			return 'f';

		case 32:
			return 'g';

		case 33:
			return 'h';

		case 34:
			return 'i';

		case 35:
			return 'j';

		case 36:
			return 'k';

		case 37:
			return 'l';

		case 38:
			return 'm';

		case 39:
			return 'n';

		case 40:
			return 'o';

		case 41:
			return 'p';

		case 42:
			return 'q';

		case 43:
			return 'r';

		case 44:
			return 's';

		case 45:
			return 't';

		case 46:
			return 'u';

		case 47:
			return 'v';

		case 48:
			return 'w';

		case 49:
			return 'x';

		case 50:
			return 'y';

		case 51:
			return 'z';

		case 52:
			return '0';

		case 53:
			return '1';

		case 54:
			return '2';

		case 55:
			return '3';

		case 56:
			return '4';

		case 57:
			return '5';

		case 58:
			return '6';

		case 59:
			return '7';

		case 60:
			return '8';

		case 61:
			return '9';

		case 62:
			return ',';

		case 63:
			return '.';

		case 64:
			return '?';

		case 65:
			return '!';

		case 66:
			return '\s';
		}
		return '$';
	}

	public static String readFromFileToEncrypt(File f) throws FileNotFoundException {
		reading = "";
		Scanner fileScanner = new Scanner(f);
		key = fileScanner.nextLine(); // for reading the key
		while (fileScanner.hasNextLine()) {
			String line = fileScanner.nextLine();
			Scanner lineScanner = new Scanner(line).useDelimiter("\n");
			while (lineScanner.hasNext()) {
				if (lineScanner.hasNext())
					reading += lineScanner.next();
				// do whatever needs to be done with token
			}
			lineScanner.close();
			// you're at the end of the line here. Do what you have to do.
			reading += "_";
		}
		fileScanner.close();
		// System.out.println("readFromFileToEncrypt:" + reading);
		return reading;
	}

	public static String readFromFileToDyc(File f) throws FileNotFoundException {
		Scanner fileScanner = new Scanner(f);
		while (fileScanner.hasNextLine()) {
			String line = fileScanner.nextLine();

			Scanner lineScanner = new Scanner(line).useDelimiter("\n");
			while (lineScanner.hasNext()) {
				reading += lineScanner.next();
			}
			lineScanner.close();
			reading += "_";
		}
		fileScanner.close();
		// System.out.println("readFromFileToDyc: " + reading);
		return reading;
	}

	public static void writeIntoFile(char charToBeWritten, String name) {
		try {
			FileWriter write = new FileWriter(name);
			write.write(writing + charToBeWritten);
			write.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		writing += charToBeWritten;
		return;
	}

	public static void encryptMessage(String messageToEnc, String fileName) {
		char encryptedchar;
		int j = 0;
		for (int i = 0; i < messageToEnc.length(); i++) {
			if (messageToEnc.charAt(i) == '_') {
				writeIntoFile('\n', fileName + ".dec");
				j = j - 1;
			}

			else {
				encryptedchar = intToChar(
						(charToInt(messageToEnc.charAt(i)) + charToInt(key.charAt((i + j) % key.length()))) % 67);
				writeIntoFile(encryptedchar, fileName + ".dec");
			}

			// this block was used for testing
			/*
			 * System.out.print("(original char) " + reading.charAt(i) + "=" +
			 * charToInt(reading.charAt(i))); System.out.print(" (added key) " +
			 * intToChar(charToInt(key.charAt((i+j) % key.length()))) + "=" +
			 * (charToInt(key.charAt((i+j) % key.length()))));
			 * System.out.print(" (result char) " + intToChar(((charToInt(reading.charAt(i))
			 * + charToInt(key.charAt((i+j) % key.length())))) % 67) + "=" +
			 * (charToInt(reading.charAt(i)) + charToInt(key.charAt((i+j) % key.length())))
			 * % 67); System.out.println(); if ((i) % key.length() == 0)
			 * System.out.println();
			 */
		}
	}

	public static void decryptFile(File fileToDycrypt, String encKey) {
		reading = "";
		String decKey = "";
		String fileName="";
		int j = 0;
		char decryptedchar;
		

		fileName = fileToDycrypt.getName().substring(0, fileToDycrypt.getName().indexOf('.')) + ".txt";
		
		try {
			reading = readFromFileToDyc(fileToDycrypt);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		for (int i = 0; i < encKey.length(); i++) { // this (for) statement is to print the key into the dycrepted
													// file
			decKey += intToChar((67 - charToInt(encKey.charAt(i))) % 67);
			writeIntoFile(decKey.charAt(i), fileName);
		}
		writeIntoFile('\n', fileName); // this is just to print a new line

		for (int i = 0; i < reading.length(); i++) {
			if (reading.charAt(i) == '_') {
				writeIntoFile('\n', fileName);
				j = j - 1;
			} else {
				decryptedchar = intToChar(
						((charToInt(reading.charAt(i)) + charToInt(decKey.charAt((i + j) % decKey.length())))) % 67);
				writeIntoFile(decryptedchar, fileName);

			}
			// this block was used for testing
			/*
			 * System.out.print("(original char) " + reading.charAt(i) + "=" +
			 * charToInt(reading.charAt(i))); System.out.print(" (added key) " +
			 * intToChar(charToInt(decKey.charAt(i % decKey.length()))) + "=" +
			 * (charToInt(decKey.charAt(i % decKey.length()))));
			 * System.out.print(" (result char) " + intToChar(
			 * ((charToInt(reading.charAt(i)) + charToInt(decKey.charAt(i %
			 * decKey.length())))) % 67) + "=" + (charToInt(reading.charAt(i)) +
			 * charToInt(decKey.charAt(i % decKey.length()))) % 67); System.out.println();
			 */
		}

	}
}