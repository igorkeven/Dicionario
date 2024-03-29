import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class DicionarioTest {
    @Test
    public void deveTraduzirCarroELivroDoInglesParaPortuguesEDoPortuguesParaOIngles() {
        Dicionario dicionario = new Dicionario();
        dicionario.adicionarPalavra("Carro", "Car", Dicionario.TipoDicionario.INGLES);
        dicionario.adicionarPalavra("Livro", "Book", Dicionario.TipoDicionario.INGLES);
        dicionario.adicionarPalavra("Tiger", "Tigre", Dicionario.TipoDicionario.PORTUGUES);
        dicionario.adicionarPalavra("Paper", "Papel", Dicionario.TipoDicionario.PORTUGUES);

        assertEquals("Car", dicionario.traduzir("carro", Dicionario.TipoDicionario.INGLES));
        assertEquals("Book", dicionario.traduzir("lIVRO", Dicionario.TipoDicionario.INGLES));

        assertEquals("Papel", dicionario.traduzir("pApEr", Dicionario.TipoDicionario.PORTUGUES));
        assertEquals("Tigre", dicionario.traduzir("TIGER", Dicionario.TipoDicionario.PORTUGUES));
    }

    @Test(expected = PalavraNaoEncontradaException.class)
    public void deveLancarExceptionQuandoUmaPalavraNaoForEncontrada() {
        Dicionario dicionario = new Dicionario();
        dicionario.adicionarPalavra("Carro", "Car", Dicionario.TipoDicionario.INGLES);
        dicionario.adicionarPalavra("Livro", "Book", Dicionario.TipoDicionario.INGLES);

        String traducao = dicionario.traduzir("Caneta", Dicionario.TipoDicionario.INGLES);
    }
}
