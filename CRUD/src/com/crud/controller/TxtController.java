package com.crud.controller;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class TxtController {

	public static void gravaProduto(String nome) throws IOException {
		FileWriter arq = new FileWriter("dataClient.txt", true);
		//BufferedWriter bw = new BufferedWriter(arq);
		PrintWriter gravarArq = new PrintWriter(arq);
		
		gravarArq.printf(nome + "\n");
		arq.close();
	}
	
	public static void gravaItem(String item) throws IOException {
		FileWriter arq = new FileWriter("dataItem.txt", true);
		//BufferedWriter bw = new BufferedWriter(arq);
		PrintWriter gravarArq = new PrintWriter(arq);
		
		gravarArq.printf(item + "\n");
		arq.close();
	}
	
	public static void gravaUser(String user) throws IOException {
		FileWriter arq = new FileWriter("dataUser.txt", true);
		//BufferedWriter bw = new BufferedWriter(arq);
		PrintWriter gravarArq = new PrintWriter(arq);
		
		gravarArq.printf(user + "\n");
		arq.close();
	}
}
