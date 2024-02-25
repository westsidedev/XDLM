package com.xdlmanager;
import java.util.InputMismatchException;
import java.util.MissingFormatArgumentException;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		try {
			switch (args[0]) {
				case "-D","--download":
					System.out.println("hello");
					break;
				default :
					System.out.println("xD");
				}
			} catch (IndexOutOfBoundsException I) {
				System.out.println("-H, --help Exibe essa mensagem\n-D, --download Use para baixar arquivos");
			}
	}
}
