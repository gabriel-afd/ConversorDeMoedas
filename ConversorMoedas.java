import Exceps.ExceptionPersonalizado;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;



public class ConversorMoedas {

    List<Conversao> historicoConversoes = new ArrayList<>();

    public void exibeMenu(){
        System.out.println("******************************");

        System.out.println("Seja bem vindo/a ao conversor de moedas");

        System.out.println("1) Dólar =>> Peso Argentino");
        System.out.println("2) Peso Argentino =>> Dólar");
        System.out.println("3) Dólar =>> Real Brasileiro");
        System.out.println("4) Real Brasileiro =>> Dólar");
        System.out.println("5) Dólar =>> Peso Colombiano");
        System.out.println("6) Peso Colombiano =>> Dólar");
        System.out.println("7) Sair");
        System.out.println("Digite uma opção válida: ");
    }

    public void executar(){

        Scanner scanner = new Scanner(System.in);
        boolean continuar = true;
        while (continuar){

            exibeMenu();
            int opcao = scanner.nextInt();
            scanner.nextLine();

            if (opcao ==7){
                continuar = false;
                System.out.println("Você saiu do conversor!");
                break;
            }

            if (opcao < 1 || opcao > 7){
                throw new ExceptionPersonalizado("Você deve escolher um número entre 1 e 7");
            }

            System.out.println("Digite o valor a ser convertido: ");
            double valor = scanner.nextDouble();
            scanner.nextLine();

            String moedaOrigem = obterMoeda(opcao, "origem");
            String moedaDestino = obterMoeda(opcao,"qualquer coisa");

            double taxa = ConsomeAPI.obterTaxa(moedaOrigem,moedaDestino);
            double resultado = valor*taxa;

            Conversao conversao = new Conversao(valor,moedaOrigem,moedaDestino,resultado);
            historicoConversoes.add(conversao);
            System.out.println(historicoConversoes);

            System.out.printf("Resultado da conversão: %.2f %s = %.2f %s%n",valor,moedaOrigem,resultado,moedaDestino);

            JsonWriter.salvarEmJson(historicoConversoes,"historicoConversoes.json");

        }
        scanner.close();


    }

    private String obterMoeda(int opcao, String tipo){
        return switch (opcao){
            case 1 -> tipo.equals("origem") ? "USD":"ARS";
            case 2 -> tipo.equals("origem") ? "ARS":"USD";
            case 3 -> tipo.equals("origem") ? "USD":"BRL";
            case 4 -> tipo.equals("origem") ? "BRL":"USD";
            case 5 -> tipo.equals("origem") ? "USD":"COP";
            case 6 -> tipo.equals("origem") ? "COP":"USD";


            default -> null;
        };
    }


}
