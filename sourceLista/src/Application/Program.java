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
		lista.add("Jo�o");
		imprimir(lista); // M�todo para imprimir lista
		lista.add(2,"Marcos"); // Adiciona elemento na posi��o 2
		imprimir(lista);
		System.out.println("Lista com "+ lista.size()+" Elementos"); // tamanho da lista
		lista.remove("Marcos"); // Remove o elemento atrav�s de compara��o de string
		imprimir(lista);
		lista.remove(1); //Remove o elemento da posi��o '1' (Maria)
		imprimir(lista);
		// Remove elementos que atendam a um predicado (ex. come�a com a letra M)
		lista.removeIf(x -> x.charAt(0)=='J'); // Predicado (fun��o lambda)
		imprimir(lista);
		lista.add("Maria");
		lista.add("Joao");
		lista.add("Marcos");
		imprimir(lista);
		System.out.println("O �ndice de Jo�o �: "+ lista.indexOf("Joao")); //Encontrar a posi��o de um elemento
		System.out.println("O �ndice de Raul �: "+ lista.indexOf("Raul")); //Retorna -1 se n�o encontrar o elemento
		lista.removeIf(x -> x.charAt(0)!= 'M');
		imprimir(lista);
		lista.add(2,"Joao");
		lista.add(0,"Ana");
		imprimir(lista);
		// Filtrar lista com nomes que comecem com M (Atrav�s de opera��es de lambda)
		List<String> result = lista.stream().filter(x -> x.charAt(0)== 'M').collect(Collectors.toList());
		/*
		 * Cria uma lista result; transforma em uma stream que recebe o valor do predicado
		 * converte novamente para list
		 */
		imprimir( lista);
		imprimir (result);
		// Encontrar um elemento da lista que atenda a um predicado: 1� elemento da lista que comece com M
		String nome = lista.stream().filter(x -> x.charAt(0)=='M').findFirst().orElse(null);
		System.out.println(nome);
		imprimir(lista); // O Array fica inalterado
		// Se n�o encontrar
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
