package com.company;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<Integer> notas = Arrays.asList(100, 50, 20, 10, 5, 2, 1);
        HashMap<String, Integer> produtos = new HashMap<>();
        Scanner scan = new Scanner(System.in);
        Integer contador = 0;


        System.out.println("---Cadastro de produtos---");
        System.out.println("Opções:");
        System.out.println("1 - Cadastrar");
        System.out.println("2 - Sair");

        Integer opcao = scan.nextInt();

        while(opcao == 1 && produtos.size() <=10){
            System.out.println("Informe o produto");
            String nomeProduto = scan.next();

            System.out.println("Informe o valor do produto");
            Integer valor = scan.nextInt();

            produtos.put(nomeProduto, valor);

            System.out.println("Deseja adicionar mais produtos?");
            System.out.println("1 - Sim");
            System.out.println("2 - Não");
            opcao = scan.nextInt();

        }
        System.out.println("***Carrinho de Compras***");
        Integer valorTotal = produtos.values().stream().mapToInt(value -> value).sum();
        produtos.forEach((Key, value) -> {
            System.out.println("Produto: "+ Key +" - valor: R$"+ value);
        });

        System.out.println("Valor total da compra: R$" + valorTotal);

        while(valorTotal != 0){
            for (Integer valor : notas){
                while (valorTotal - valor >= 0){
                    valorTotal -= valor;
                    contador++;
                }
            }

        }

        System.out.println("Mínimo de notas necessárias para o pagamento: " + contador + " notas.");
    }


}