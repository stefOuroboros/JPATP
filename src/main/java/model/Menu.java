package model;

import java.util.Scanner;

public class Menu {

	public static void menu() {
		Scanner sc = new Scanner(System.in);
		System.out.println("1) Gestion des vols \n"
				+ "2) Gestion des r�servations \n"
				+ "3) Quitter \n\n   Entrez votre choix :");
		int menu = sc.nextInt();
		if (menu == 1) {
			System.out.println("1) Cr�ation d'un vol \n"
					+ "2) Liste des vols \n"
					+ "3) ../ \n\n   Entrez votre choix :");
		} else if (menu == 2) {
			System.out.println("1) Cr�ation d'une r�servation \n"
					+ "2) Liste des r�servations \n"
					+ "3) ../ \n\n   Entrez votre choix :");
		}
		System.out.println("ok");
		sc.close();
	}
	
}
