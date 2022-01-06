package source;

import java.io.IOException;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		//используйте публичные методы для "шоу" и эффектов, 
		//приватные сделаны для дополнительных настроек
		ifYouAdmin();
		ifYouAdmin2();
		xNox();
		//asciBom();
	}

	private static void sayHello() {
		System.out.println("Hello, World!");
	}

	private static void sayНello() {
		System.out.println("Goodbye, World!");
	}
	/**
	 * Используется невидимый символ 
	 * который заставляет компилятор "неправильно" считывать строку
	 * из-за чего условие if(isAdmin) является комментарием 
	 */
	public static void ifYouAdmin() {
		boolean isAdmin = false;
		/* ‮ } ⁦if (isAdmin)⁩ ⁦ begin admins only */
		System.out.println("You are an admin.");
		/* end admins only ‮ { ⁦ */

	}
	/**
	 * Принцип такой же как и в прошлом варианте
	 * но тут не условие комментируется,
	 * а комментарий приписывается к условию.
	 * для компилятора условие if выглядит следующим образом:
	 * accessLevel != "user ⁦// Check if admin⁩ ⁦"
	 */
	public static void ifYouAdmin2() {
		String accessLevel = "user";
		if (accessLevel != "user‮ ⁦// Check if admin⁩ ⁦") {
			System.out.println("You are an admin.2");
		}
	}
	/**
	 * Методы имеют идентичное название,
	 * но в одном из них используется английская буква, 
	 * а в другом используется русская
	 * h = H
	 * н = Н
	 */
	public static void xNox() {
		sayНello();
		sayHello();
	}
	/**
	 * !!!Работает только в консоли с включенными ASCI commands!!!
	 * "\u001b[0c" выводит информацию в консоль ВВОДА
	 * В чистом ввиде Scanner проигнорирует написанное
	 * но через System.in можно будет считывать информацию
	 * и если начать её считывать, то Scanner её "подхватывает" 
	 * 
	 */
	public static void asciBom() {
		System.out.println("\u001b[0c");
		try {
			System.out.println("bytes: " + System.in.read());
		} catch (IOException e) {
			e.printStackTrace();
		}
		Scanner scanner = new Scanner(System.in);
		System.out.println("text: " + scanner.nextLine());

	}
}
