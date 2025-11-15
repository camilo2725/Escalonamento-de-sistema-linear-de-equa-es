// Importar Scanner para coletar a entrada do usuário:
import java.util.Scanner;

public class Escalonamento {

    // Método principal:
    public static void main(String[] args) throws Exception {

        // Cria o Scanner para coletar a entrada do usuário:
        Scanner Entrada = new Scanner(System.in);

        // Determina o tamanho da matriz:
        int linhas =3; int colunas = 4;

        // Cria a matriz em si. Como ela representa o sistema de equações, seu nome é "Sistema":
        float[][] Sistema = new float[linhas][colunas];
        // DEBUG: float[][] Sistema = {{4,-3,2,-1}, {1,-2,3,-4}, {4,3,2,1}};

        // Começa a entrada dos valores do sistema por parte do usuário:
        System.out.println("-- Entrada das equações do sistema --");
        System.out.print("Primeira equação (Ax + By + Cz = D), insira valor de A: ");
        Sistema[0][0] = Entrada.nextFloat();
        System.out.print("Insira valor de B: ");
        Sistema[0][1] = Entrada.nextFloat();
        System.out.print("Insira valor de C: ");
        Sistema[0][2] = Entrada.nextFloat();
        System.out.print("Insira valor de D: ");
        Sistema[0][3] = Entrada.nextFloat();

        System.out.print("\nSegunda equação (Ax + By + Cz = D), insira valor de A: ");
        Sistema[1][0] = Entrada.nextFloat();
        System.out.print("Insira valor de B: ");
        Sistema[1][1] = Entrada.nextFloat();
        System.out.print("Insira valor de C: ");
        Sistema[1][2] = Entrada.nextFloat();
        System.out.print("Insira valor de D: ");
        Sistema[1][3] = Entrada.nextFloat();

        System.out.print("\nTerceira equação (Ax + By + Cz = D), insira valor de A: ");
        Sistema[2][0] = Entrada.nextFloat();
        System.out.print("Insira valor de B: ");
        Sistema[2][1] = Entrada.nextFloat();
        System.out.print("Insira valor de C: ");
        Sistema[2][2] = Entrada.nextFloat();
        System.out.print("Insira valor de D: ");
        Sistema[2][3] = Entrada.nextFloat();

        // Mostra como ficou o sistema para o usuário, utilizando um método criado com o único objetivo de mostrar sistemas de uma maneira amigavel:
        System.out.println("\nSistema: ");
        mostrarSistema(Sistema);

        // Inicia o algoritmo de escalonamento:
        System.out.println("\nEscalonando: ");

        // Loop for percorre as colunas para ir eliminando cada variavel (neste caso X na primeira coluna e Y na segunda coluna):
        // A subtração por 2 é feita para eliminar as duas últimas colunas, onde se contêm o resultado das equações e a última variável (neste caso o Z):
        for(int j = 0; j < colunas-2; j++) {
            
            // Loop for percorre todas as linhas em uma diagonal para zerar os coeficientes necessários:
            for(int i = j+1; i < linhas; i++) {
                
                // Prosseguir apenas se o coeficiente atual já não for igual a 0:
                if(Sistema[i][j] != 0) {
                    /* O que será feito é uma subtração entre a linha atual e outra linha,
                    portanto é necessário encontrar um valor que, quando multiplicado com essa outra linha,
                    o coeficiente seja zerado. 

                    L2 - L1*n = 0 -> L2 = L1*n -> L2/L1 = n;
                    Será dividido o coeficiente alvo e o coeficiente dessa outra linha.
                    A linha utilizada terá a mesma numeração que a da coluna atual.
                    */

                    float Valor = Sistema[i][j]/Sistema[j][j];
                    
                    // Fazendo a subtração para toda a linha:
                    for(int k = 0; k < colunas; k++) {
                        Sistema[i][k] = Sistema[i][k] - (Sistema[j][k] * Valor);
                    }
                    
                    // Informando o usuário da operação feita:
                    System.out.println("Linha " + (i+1) + " subtraida pela Linha " + (j+1) + " vezes " + Valor + ": ");
                    
                    // Mostrar como ficou o sistema após a modificação:
                    mostrarSistema(Sistema);
                }
            
            }

        }

        // Agora que o sistema está escalonado, começa-se a encontrar o valor das incógnitas:
        System.out.println("\n-- Valor das incógnitas --");
        float x, y, z;

        // Para se encontrar o valor de z, é só dividir o resultado da equação pelo coeficiente.
        // Dividindo:
        z = Sistema[2][3]/Sistema[2][2];
        // Mostrando o passo a passo ao usuário:
        System.out.println("Encontrando valor de z:\n{ "
        + Sistema[2][2] + "z = " + Sistema[2][3] +
        " ->\n{ z = " + Sistema[2][3] + "/" + Sistema[2][2] +
        " ->\n{ z = " + z);

        // Completamos as equações com y e x:

        // Encontrando y:
        System.out.print("Encontrando valor de y:\n{ " + Sistema[1][1] + "y ");
        if(Sistema[1][2] >= 0) {
            System.out.print("+ " + Sistema[1][2]);
        } else {
            System.out.print("- " + (Sistema[1][2]*-1));
        }
        System.out.println("z = " + Sistema[1][3] + " ->");
        // Substitui incógnita z pelo seu valor:
        Sistema[1][2] *= z;
        System.out.print("{ " + Sistema[1][1] + "y ");
        if(Sistema[1][2] >= 0) {
            System.out.print("+ " + Sistema[1][2]);
        } else {
            System.out.print("- " + (Sistema[1][2]*-1));
        }
        System.out.println(" = " + Sistema[1][3] + " ->");
        // Subtrai do resultado:
        Sistema[1][3] -= Sistema[1][2];
        System.out.println("{ " + Sistema[1][1] + "y = " + Sistema[1][3] + " ->");
        // Divide o resultado pelo coeficiente de y:
        y = Sistema[1][3]/Sistema[1][1];
        System.out.println("{ y = " + y);

        // Encontrando o valor de x:
        System.out.print("Encontrando valor de x:\n{ " + Sistema[0][0] + "x ");
        if(Sistema[0][1] >= 0) {
            System.out.print("+ " + Sistema[0][1]);
        } else {
            System.out.print("- " + (Sistema[0][1]*-1));
        }
        System.out.print("y ");
        if(Sistema[0][2] >= 0) {
            System.out.print("+ " + Sistema[0][2]);
        } else {
            System.out.print("- " + (Sistema[0][2]*-1));
        }
        System.out.println("z = " + Sistema[0][3] + " ->");
        // Substitui as incógnitas z e y pelo seus valores:
        Sistema[0][2] *= z; Sistema[0][1] *= y;
        System.out.print("{ " + Sistema[0][0] + "x ");
        if(Sistema[0][1] >= 0) {
            System.out.print("+ " + Sistema[0][1]);
        } else {
            System.out.print("- " + (Sistema[0][1]*-1));
        }
        if(Sistema[0][2] >= 0) {
            System.out.print("+ " + Sistema[0][2]);
        } else {
            System.out.print("- " + (Sistema[0][2]*-1));
        }
        System.out.println(" = " + Sistema[0][3] + " ->");
        // Subtrai do resultado:
        Sistema[0][3] -= Sistema[0][2]; Sistema[0][3] -= Sistema[0][1];
        System.out.println("{ " + Sistema[0][0] + "x = " + Sistema[0][3] + " ->");
        // Divide:
        x = Sistema[0][3]/Sistema[0][0];
        System.out.println("{ x = " + x);

        System.out.println("\nValor das incógnitas: x = " + x + "; y = " + y + "; z = " + z + ";");
    }

    // Método para mostrar um sistema para o usuário:
    static void mostrarSistema(float[][] Matriz) {

        // Loop for percorre todas as linhas da matriz:
        for (int i = 0; i < Matriz.length; i++) {

            // Loop for percorre todas as colunas da matriz:
            for (int j = 0; j < Matriz[i].length; j++) {
                
                // Valor, representa o atual elemento da matriz sendo utilizado pela iteração do Loop:
                float valor = Matriz[i][j];

                if(j == 0) {
                    System.out.print("{");
                }

                if(j == Matriz[i].length-1) {
                    System.out.print("=");
                }

                // Diferencia valores positivos e negativos:
                if(valor < 0 && j < Matriz[i].length-1) {
                    System.out.print("-");
                } else {
                    if(j == 0 || j == Matriz[i].length-1) {
                        System.out.print("");
                    } else {
                        System.out.print("+");
                    }
                }

                // Imprime os coeficientes:
                System.out.print(" ");
                if(j < Matriz[i].length-1 && valor == 1) {
                    System.out.print("");
                } else if(valor < 0 && j < Matriz[i].length-1) {
                    System.out.print(valor*-1);
                } else {
                    System.out.print(valor);
                }

                // Imprime as incógnitas:
                if(valor != 0) {
                    switch (j) {
                    case 0:
                    System.out.print("x");
                    break;

                    case 1:
                    System.out.print("y");
                    break;

                    case 2:
                    System.out.print("z");
                    break;
                    }
                }

                System.out.print(" ");
            }
            System.out.println();
        }

    }

}