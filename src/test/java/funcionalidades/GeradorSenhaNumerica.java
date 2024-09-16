package funcionalidades;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GeradorSenhaNumerica {
    private static final int TAMANHO_SENHA = 6;
    private static final int MAX_TENTATIVAS = 10; // Número máximo de tentativas para encontrar um dígito válido

    public static String gerarSenhaNumerica(String cpf) {
        List<Integer> cpfDigits = new ArrayList<>();
        for (char c : cpf.toCharArray()) {
            cpfDigits.add(Character.getNumericValue(c));
        }

        List<Integer> senhaDigits = new ArrayList<>();
        Random random = new Random();

        while (senhaDigits.size() < TAMANHO_SENHA) {
            int attempts = 0;
            boolean foundValidDigit = false;

            while (attempts < MAX_TENTATIVAS) {
                int randomDigit = random.nextInt(10);
                if (validarRequisitos(senhaDigits, randomDigit, cpfDigits)) {
                    senhaDigits.add(randomDigit);
                    foundValidDigit = true;
                    break;
                }
                attempts++;
            }

            if (!foundValidDigit) {
                // Não foi possível encontrar um dígito válido após várias tentativas
                // Tenta gerar a senha novamente desde o início
                senhaDigits.clear();
            }
        }

        StringBuilder senha = new StringBuilder();
        for (int digit : senhaDigits) {
            senha.append(digit);
        }

        return senha.toString();
    }

    static boolean validarRequisitos(List<Integer> senhaDigits, int novoDigit, List<Integer> cpfDigits) {
        if (senhaDigits.contains(novoDigit)) {
            return false;
        }
        if (senhaDigits.size() > 0) {
            int ultimoDigit = senhaDigits.get(senhaDigits.size() - 1);
            if (novoDigit == ultimoDigit + 1) {
                return false;
            }
        }
        for (int cpfDigit : cpfDigits) {
            if (senhaDigits.contains(cpfDigit * 10 + cpfDigit)) {
                return false;
            }
        }
        for (int i = 0; i < senhaDigits.size() - 1; i++) {
            int pair = senhaDigits.get(i) * 10 + senhaDigits.get(i + 1);
            if (cpfDigits.contains(pair)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String cpf = "473807233011";
        String senha = gerarSenhaNumerica(cpf);
        String senha1 = gerarSenhaNumerica(cpf);
        String senha2 = gerarSenhaNumerica(cpf);
        String senha3 = gerarSenhaNumerica(cpf);
        String senha4 = gerarSenhaNumerica(cpf);
        String senha5 = gerarSenhaNumerica(cpf);
        String senha6 = gerarSenhaNumerica(cpf);
        String senha7 = gerarSenhaNumerica(cpf);
        String senha8 = gerarSenhaNumerica(cpf);
        String senha9 = gerarSenhaNumerica(cpf);
        System.out.println("Senha gerada: " + senha);
        System.out.println("Senha gerada: " + senha1);
        System.out.println("Senha gerada: " + senha2);
        System.out.println("Senha gerada: " + senha3);
        System.out.println("Senha gerada: " + senha4);
        System.out.println("Senha gerada: " + senha5);
        System.out.println("Senha gerada: " + senha6);
        System.out.println("Senha gerada: " + senha7);
        System.out.println("Senha gerada: " + senha8);
        System.out.println("Senha gerada: " + senha9);
    }
}
