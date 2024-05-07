import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);

        System.out.println("Qual o limite do seu cartão");
        double limite = read.nextDouble();

        List<Produto> listaDeCompras = new ArrayList<>();
        int exit = 1;
        while (exit == 1) {
            System.out.println("Digite a descrião da compra:    ");
            String descricao = read.next();
            System.out.println("Digite o valor da compra:   ");
            double preco = read.nextDouble();

            if (preco < limite) {
                limite -= preco;
                Produto produto = new Produto(descricao, preco);
                listaDeCompras.add(produto);

                System.out.println("Digite 0 para sair ou 1 para continuar. ");
                exit = read.nextInt();
            } else if (preco == limite) {
                Produto produto = new Produto(descricao, preco);
                listaDeCompras.add(produto);

                limite = 0;

                System.out.println("limite esgotado!!");
                exit = 0;
            } else {
                System.out.println("Preço acima do limite disponivel ");
                exit = 0;
            }
        }
        System.out.println("""
                ******************************************************
                COMPRAS REALIZADAS:               \s
               \s""");
        Collections.sort(listaDeCompras);
        for(Produto produto: listaDeCompras){
            System.out.println(produto);
        }
        System.out.printf("""
                
                ******************************************************
                
                Saldo do cartão: R$%.1f
                """, limite);
    }
}