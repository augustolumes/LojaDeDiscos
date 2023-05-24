package main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import model.CD;
import model.DVDFilme;
import model.Disco;
import utils.Utils;

public class Loja {
    private static Scanner input = new Scanner(System.in);
    private static Scanner inputLine = new Scanner(System.in);
    private static ArrayList<Disco> discos;
    private static Map<Disco, Integer> carrinho;

    public static void main(String[] args) {
        discos = new ArrayList<>();
        carrinho = new HashMap<>();
        menu();
    }

    private static void menu() {
        System.out.println("\n--------------------------------------");
        System.out.println("------ Bem-vindo a loja de CD's ------");
        System.out.println("--------------------------------------");
        System.out.println("_____Selecione uma opção____");
        System.out.println("|    Opção 1 - Cadastrar   |");
        System.out.println("|    Opção 2 - Listar      |");
        System.out.println("|    Opção 3 - Comprar     |");
        System.out.println("|    Opção 4 - Carrinho    |");
        System.out.println("|    Opção 5 - Sair        |");

        int option = input.nextInt(); // não pode letra apenas número;

        switch (option) {
            case 1:
                System.out.println("\nTipo de disco (filme, cd): ");
                String tipo = input.next();
                switch (tipo) {
                    case "filme":
                        cadastrarFilme();
                        break;

                    case "cd":
                        cadastrarCD();
                        break;
                }

                break;

            case 2:
                listarDiscos();
                break;

            case 3:
                comprarDiscos();
                break;

            case 4:
                verCarrinho();
                break;

            case 5:
                System.out.println("Volte sempre!");
                System.exit(0);

            default:
                System.out.println("Opção invalida, por favor digite o número da operação");
                menu();
                break;
        }
    }

    private static void cadastrarFilme() {
        System.out.println("Título do filme: ");
        String nome = inputLine.nextLine();
        System.out.println("Nome do diretor: ");
        String diretor = inputLine.nextLine();
        System.out.println("Nota do filme: ");
        Double nota = input.nextDouble();
        System.out.println("Preço do produto(utilize virgula): ");
        Double preco = input.nextDouble();

        Disco produto = new DVDFilme(nome, nota, diretor, preco);
        discos.add(produto);

        System.out.println(produto.getNome() + " cadastrado com sucesso");
        menu();
    }

    private static void cadastrarCD() {
        System.out.println("Título do CD: ");
        String nome = inputLine.nextLine();
        System.out.println("Nome do Artista: ");
        String artista = inputLine.nextLine();
        System.out.println("Número de faixas: ");
        int numFaixa = input.nextInt();
        System.out.println("Preço do produto(utilize virgula): ");
        Double preco = input.nextDouble();

        Disco produto = new CD(nome, preco, numFaixa, artista);
        discos.add(produto);

        System.out.println(produto.getNome() + " cadastrado com sucesso");
        menu();
    }

    private static void listarDiscos() {
        if (discos.size() > 0) {
            System.out.println("Lista de discos! \n");

            for (Disco p : discos) {
                System.out.println(p);
                System.out.println("-------------------");
            }
        } else {
            System.out.println("Nenhum produto cadastrado");
        }

        menu();
    }

    private static void comprarDiscos() {
        if (discos.size() > 0) {

            System.out.println("\n------ Discos disponíveis ------");
            for (Disco p : discos) {
                System.out.println(p + "\n");
            }
            System.out.print("Código do produto: ");
            int id = Integer.parseInt(input.next());
            boolean jaTem = false;

            boolean encontrou = false;
            Disco p = null;
            for (Disco d : discos) {
                if (d.getId() == id) {
                    encontrou = true;
                    p = d;
                }
            }
            if (encontrou) {
                int qtd = 0;
                try {
                    qtd = carrinho.get(p);
                    carrinho.put(p, qtd + 1);
                } catch (NullPointerException e) {
                    carrinho.put(p, 1);
                }
                System.out.println(p.getNome() + " adicionado ao carrinho ");
                jaTem = true;

                if (jaTem) {
                    System.out.println("\nDeseja adicionar outro produto ao carrinho? (s/n)");
                    String opcao = input.next();

                    if (opcao == "s") {
                        comprarDiscos();
                    } else {
                        finalizarCompra();
                    }
                }
            } else {
                System.out.println("Produto não encontrado");
                menu();
            }
        } else {
            System.out.println("Não existem discos cadastrados!");
            menu();
        }
    }

    private static void verCarrinho() {
        System.out.println("---- Discos no seu carrinho ----");
        if (carrinho.size() > 0) {
            for (Disco p : carrinho.keySet()) {
                System.out.println("Produto: " + p + "\nQuanditade: " + carrinho.get(p));
            }
        } else {
            System.out.println("Carrinho vazio");
        }
        menu();
    }

    private static void finalizarCompra() {
        Double valorDaCompra = 0.0;
        System.out.println("\nSeus discos");

        for (Disco p : carrinho.keySet()) {
            int qtd = carrinho.get(p);
            valorDaCompra += p.getPreco() * qtd;
            System.out.println(p);
            System.out.println("Quatidade: " + qtd);
            System.out.println("-------------------------");
        }

        System.out.println("Valor da sua compra: " + Utils.doubleToString(valorDaCompra));
        carrinho.clear();
        System.out.println("Deseja voltar ao menu? (s/n)");
        String opcao = input.next();
        if (opcao == "s") {
            menu();
        } else {
            System.out.println("Volte sempre!");
            System.exit(0);
        }

    }
}
