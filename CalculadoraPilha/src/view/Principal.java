package view;

import java.util.Scanner;

import model.PilhaInt;

public class Principal {

	public static void main(String[] args) throws Exception {
		 PilhaInt pilha = new PilhaInt();
	        Scanner sc = new Scanner(System.in);

	        System.out.println("Calculadora em Notação Polonesa Reversa (NPR)");
	        System.out.println("Digite números ou operações (+,-,*,/) ou 'q' para sair:");

	        while (true) {
	            String input = sc.nextLine();

	            if (input.equals("q")) {
	                break;
	            }

	            try {
	                int valor = Integer.parseInt(input);
	                pilha.push(valor);
	            } catch (NumberFormatException e) {
	                try {
	                    int b = pilha.pop();
	                    int a = pilha.pop();
	                    int resultado = realizarOperacao(a, b, input);
	                    pilha.push(resultado);
	                } catch (Exception ex) {
	                    System.out.println("Erro: Pilha com valores insuficientes para a operação.");
	                }
	            }
	        }

	        System.out.println("Resultado final: " + pilha.pop());
	        sc.close();
	    }

	    public static int realizarOperacao(int a, int b, String operacao) {
	        switch (operacao) {
	            case "+":
	                return a + b;
	            case "-":
	                return a - b;
	            case "*":
	                return a * b;
	            case "/":
	                if (b != 0) {
	                    return a / b;
	                } else {
	                    System.out.println("Erro: Divisão por zero.");
	                    System.exit(1);
	                }
	        }
	        return 0;
	    }
	    
	}