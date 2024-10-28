import Exceps.ExceptionPersonalizado;
import com.google.gson.Gson;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsomeAPI {

    public static double obterTaxa(String moedaOrigem, String moedaDestino){

        String API_URL = "https://v6.exchangerate-api.com/v6/a80415eab6896e3d2f573760/pair/";
        String endereco = API_URL + moedaOrigem +"/"+ moedaDestino;
        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(endereco))
                    .build();
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());

            String json = response.body();

            Gson gson = new Gson();
            TaxaConversao taxaConversao = gson.fromJson(json,TaxaConversao.class);
            System.out.println(taxaConversao);
            return taxaConversao.conversion_rate();

        } catch (ExceptionPersonalizado e){
            System.out.println(e.getMessage());

        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return 0.0;
    }
}
