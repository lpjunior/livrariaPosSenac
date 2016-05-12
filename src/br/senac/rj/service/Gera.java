package br.senac.rj.service;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Gera {

	public static String nome() {
		DateTimeFormatter format = DateTimeFormatter.ofPattern("hh-mm-ss");
		String nome =  "img-" + LocalTime.now().format(format) + (int)Math.random();
		return nome;
	}
	
	public static void main(String[] args) {
		System.out.println(Gera.nome());
	}
}
