import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class JsonWriter extends ConversorMoedas{

    public static void salvarEmJson(List<Conversao> historicoConversoes, String caminho) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String json = gson.toJson(historicoConversoes);

        try {
            FileWriter escrita = new FileWriter(caminho);
            escrita.write(json);
            escrita.close();

        } catch (IOException e) {
            System.out.println("Erro ao escrever o arquivo" + e.getMessage());
        }

    }
}
