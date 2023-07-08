
import java.util.Scanner;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        //exercicio 1
        System.out.println("Digite uma frase: ");
        String exerc1 = teclado.nextLine(); // entrada da string
        String[] separador = exerc1.split(" "); // split para dividir a frase em palavras, toda vez que tiver um espaço e armazena-las
        StringBuilder sb1 = new StringBuilder(); // stringbuilder para construir (builder) a frase invertida.

        for (int i = separador.length - 1; i >= 0; i--) { // vai percorrer as palavras armazenada no "separador" (split), de trás para frente.
            sb1.append(separador[i]).append(" "); // vai "construir" a frase, colocando do final para o ínicio
        }

        System.out.println("Essa String invertida é: " + sb1.toString()); // vai imprimir a string invertida na tela (.toString para converte o que tiver dentro do stringbuilder em string)


        //exercicio 2
        System.out.println("Digite uma frase: ");
        String exerc2 = teclado.nextLine(); //entrada da string
        StringBuilder sb2 = new StringBuilder(); // Para armazenar os caracteres unicos da String
        for (int i = 0; i < exerc2.length(); i++) { // vai percorrer cada caractere da String de entrada (exerc2)
            char ch = exerc2.charAt(i); // vai armazenar na variavel ch, o caractere presente na posição i
            if (sb2.indexOf(String.valueOf(ch)) == -1) { // vai verificar se o caractere que foi armazenado na variavel ch, nessa posição i, já está ou não presente no StringBuilder, se retornar -1 é porque não está presente.
                sb2.append(ch); // SE caso ele não estiver presente, o append irá adicionar o caractere ao final do stringbuilder.
            }
        }

        System.out.println("Essa string sem os caracteres duplicados é: " + sb2.toString()); // Printa na tela a frase em os caracteres duplicadas (.toString para converter o que tiver no stringbuildr para string)


        //exercicio 3
        System.out.println("Digite uma palavra: ");
        String exerc3 = teclado.nextLine(); //entrada da string
        String maior = ""; //String que vai armazenar a substring

        for (int i = 0; i < exerc3.length(); i++) { // vai percorrer cada caractere da String de entrada (exerc3).
            int max = 0; //Para acompanhar o tamanho da substring palindroma
            for (int j = 0; j < exerc3.length(); j++) { // vai percorrer todos os indices iniciais das substrings
                for (int k = j + 1; k <= exerc3.length(); k++) { // vai percorrer todos os indices finais das substrings
                    String sub = exerc3.substring(j, k); //Extrai a substring, a partir da String (exerc3)
                    String rev = new StringBuffer(sub).reverse().toString(); // vai inverter a substring
                    if (sub.equals(rev)) { //compara a versão invertida da substring com a versão normal, para ver se são iguais
                        if (max < exerc3.substring(j, k).length()) { // verifica se o tamanho da substring atual é maior que o tamanho da maior substring palindrômica encontrada até o momento
                            max = exerc3.substring(j, k).length(); // se for sim, irá atualizar a variável max com o novo tamanho e,
                            maior = exerc3.substring(j, k); // irá atualizar essa variável com a maior substring.
                        }
                    }
                }
            }
        }

        System.out.println("A maior substring polindroma dessa string é: " + maior); // printa na tela a maior substring palindroma


        //exercicio 4
        System.out.println("Digite uma frase: ");
        String exerc4 = teclado.nextLine(); //entrada da string
        String[] separador2 = exerc4.split(""); // dividir e armazenar a string por caractere

        StringBuilder sb3 = new StringBuilder(exerc4); // utilização do stringbuilder para manipular melhor a string
        for (int i = 0; i < separador2.length; i++) { // vai percorrer cada caractere
            char ch = exerc4.charAt(i); // obtem o caractere que está na posiçao i
            if (separador2[i].equals("!") || separador2[i].equals(".") || separador2[i].equals("?")) { // verifica SE o caractere naquela posição é algum desses 3 pontos.
                if (i + 2 < sb3.length()) { // Verifica SE o caractere que está na posicao i+2 está dentro dos limites de tamanho da String sb3
                    sb3.setCharAt(i + 2, Character.toUpperCase(sb3.charAt(i + 2))); // caso SIM, irá converter o caractere para maiusculo.

                }


            }
            sb3.setCharAt(0, Character.toUpperCase(sb3.charAt(0))); //Para que a primeira letra da String seja maiuscula, já que não tem nenhum ponto antes dela
        }

        System.out.println("Essa String com a primeira letra de cada frase maiúscula é: " + sb3.toString()); // converter novamente para String e printar na tela.


        //exercicio 5
        System.out.println("Digite uma palavra: ");
        String exerc5 = teclado.nextLine(); // entrada da String
        HashSet<Character> set = new HashSet<>(); // vai criar uma coleção sem repetir os caracteres da string
        int count = 0; // um contador para ver a quantidade de caracteres unicos na string

        for(int i = 0; i < exerc5.length(); i++){ //um loop para ler cada caractere da string
            if(set.add(exerc5.charAt(i))){ // vai adicionar o caractere atual (na posiçao i) para a collection do Hashset, retornando verdadeiro para caso não esteja na collection e falso caso ele já esteja.
                count++; //SE ele não tiver na collection vai somar +1 no contador, pois tem um caractere unico na string.
            }
            else{
                count--; //caso ele já esteja na collection, irá subtrair -1 do contador
                set.remove((exerc5.charAt(i))); // irá remover o atual caractere da collection, já que ele não é mais unico
            }

        }
        boolean resultado = count < 2; // verificar se o nosso contador final é <2, caso seja, irá retorna verdadeiro e caso não seja irá retornar falso.
                                         // Pois uma palavra palidromica pode ter apenas uma letra que apareça uma quantidade ímpar de vezes.

        System.out.println(resultado); // printa na tela se ele é ou um não um anagrama de um palindromo.




        teclado.close();
    }
}





