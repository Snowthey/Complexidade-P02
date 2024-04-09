import java.util.Stack;

public class TorreDeHanoi {

    public static void moveTorreIterativo(int numDiscos, char origem, char destino, char auxiliar, StringBuilder movimentos) {
        Stack<Integer> origemStack = new Stack<>();
        Stack<Integer> destinoStack = new Stack<>();
        Stack<Integer> auxiliarStack = new Stack<>();

        for (int i = numDiscos; i > 0; i--) {
            origemStack.push(i);
        }

        int totalMovimentos = (int) Math.pow(2, numDiscos) - 1;

        if (numDiscos % 2 == 0) {
            char temp = destino;
            destino = auxiliar;
            auxiliar = temp;
        }

        for (int i = 1; i <= totalMovimentos; i++) {
            if (i % 3 == 1) {
                moverDisco(origemStack, destinoStack, origem, destino, movimentos);
            } else if (i % 3 == 2) {
                moverDisco(origemStack, auxiliarStack, origem, auxiliar, movimentos);
            } else if (i % 3 == 0) {
                moverDisco(auxiliarStack, destinoStack, auxiliar, destino, movimentos);
            }
        }
    }

    public static void moveTorreRecursivo(int numDiscos, char origem, char destino, char auxiliar, StringBuilder movimentos) {
        moveTorreRecursivoAux(numDiscos, origem, destino, auxiliar, movimentos);
    }

    private static void moveTorreRecursivoAux(int numDiscos, char origem, char destino, char auxiliar, StringBuilder movimentos) {
        if (numDiscos == 1) {
            movimentos.append("Mover disco de ").append(origem).append(" para ").append(destino).append("\n");
        } else {
            moveTorreRecursivoAux(numDiscos - 1, origem, auxiliar, destino, movimentos);
            movimentos.append("Mover disco de ").append(origem).append(" para ").append(destino).append("\n");
            moveTorreRecursivoAux(numDiscos - 1, auxiliar, destino, origem, movimentos);
        }
    }

    private static void moverDisco(Stack<Integer> origem, Stack<Integer> destino, char origemName, char destinoName, StringBuilder movimentos) {
        if (!origem.isEmpty() && (destino.isEmpty() || origem.peek() < destino.peek())) {
            destino.push(origem.pop());
            movimentos.append("Mover disco de ").append(origemName).append(" para ").append(destinoName).append("\n");
        } else {
            origem.push(destino.pop());
            movimentos.append("Mover disco de ").append(destinoName).append(" para ").append(origemName).append("\n");
        }
    }
}
