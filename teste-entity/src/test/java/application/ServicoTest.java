package application;

import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import static org.junit.jupiter.api.Assertions.fail;

public class ServicoTest {

    @Test
    public void testCSVColumns() throws IOException {
        // Acesso ao arquivo no classpath do diretório de testes
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream("teste-planilha.csv");

        if (inputStream == null) {
            fail("Arquivo CSV não encontrado no classpath dos testes.");
            return;
        }

        try (BufferedReader br = new BufferedReader(new InputStreamReader(inputStream))) {
            String headerLine = br.readLine();
            String line;
            boolean hasErrors = false;
            StringBuilder errorMessage = new StringBuilder();

            while ((line = br.readLine()) != null) {
                String[] columns = line.split(";");
                if (columns.length != 2) {
                    hasErrors = true;
                    errorMessage.append("Linha com número incorreto de colunas: ").append(line).append("\n");
                }
            }

            if (hasErrors) {
                fail("O CSV deve ter exatamente 2 colunas em todas as linhas. Erros encontrados:\n" + errorMessage.toString());
            } else {
                System.out.println("Teste bem-sucedido: o CSV possui exatamente 2 colunas");
            }
        }
    }
}
