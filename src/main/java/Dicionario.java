import java.util.*;

public class Dicionario {
    private Map<String, String> portugues = new HashMap<>();
    private Map<String, String> ingles = new HashMap<>();

    public enum TipoDicionario {
        PORTUGUES,
        INGLES
    }

    public void adicionarPalavra(String palavra, String traducao, TipoDicionario dicionario) {
        if (dicionario == TipoDicionario.PORTUGUES) {
            portugues.put(palavra.toLowerCase(), traducao);
        }
        if (dicionario == TipoDicionario.INGLES) {
            ingles.put(palavra.toLowerCase(), traducao);
        }
    }

    public String traduzir(String palavra, TipoDicionario dicionarioDeBusca) {
        String traducao;
        if (dicionarioDeBusca == TipoDicionario.PORTUGUES) {
            traducao = portugues.get(palavra.toLowerCase());
        } else {
            traducao = ingles.get(palavra.toLowerCase());
        }

        if (traducao == null) {
            throw new PalavraNaoEncontradaException();
        }

        return traducao;
    }


}
