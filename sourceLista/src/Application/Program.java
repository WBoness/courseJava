package Application;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


/*
 * Listas
 */
public class Program {

	public static void main(String[] args) {
		
		List<String> lista = new ArrayList<>();
		
		lista.add("Ana");
		lista.add("Maria");
		lista.add("João");
		imprimir(lista); // Método para imprimir lista
		lista.add(2,"Marcos"); // Adiciona elemento na posição 2
		imprimir(lista);
		System.out.println("Lista com "+ lista.size()+" Elementos"); // tamanho da lista
		lista.remove("Marcos"); // Remove o elemento através de comparação de string
		imprimir(lista);
		lista.remove(1); //Remove o elemento da posição '1' (Maria)
		imprimir(lista);
		// Remove elementos que atendam a um predicado (ex. começa com a letra M)
		lista.removeIf(x -> x.charAt(0)=='J'); // Predicado (função lambda)
		imprimir(lista);
		lista.add("Maria");
		lista.add("Joao");
		lista.add("Marcos");
		imprimir(lista);
		System.out.println("O índice de João é: "+ lista.indexOf("Joao")); //Encontrar a posição de um elemento
		System.out.println("O índice de Raul é: "+ lista.indexOf("Raul")); //Retorna -1 se não encontrar o elemento
		lista.removeIf(x -> x.charAt(0)!= 'M');
		imprimir(lista);
		lista.add(2,"Joao");
		lista.add(0,"Ana");
		imprimir(lista);
		// Filtrar lista com nomes que comecem com M (Através de operações de lambda)
		List<String> result = lista.stream().filter(x -> x.charAt(0)== 'M').collect(Collectors.toList());
		/*
		 * Cria uma lista result; transforma em uma stream que recebe o valor do predicado
		 * converte novamente para list
		 */
		imprimir( lista);
		imprimir (result);
		// Encontrar um elemento da lista que atenda a um predicado: 1º elemento da lista que comece com M
		String nome = lista.stream().filter(x -> x.charAt(0)=='M').findFirst().orElse(null);
		System.out.println(nome);
		imprimir(lista); // O Array fica inalterado
		// Se não encontrar
		nome = lista.stream().filter(x -> x.charAt(0)=='W').findFirst().orElse(null);
		System.out.println(nome);
	}
	public static void imprimir(List <String> lista) {
		for (String list: lista) {
			System.out.print(list +"| ");
		}
		System.out.println();
	}
}
