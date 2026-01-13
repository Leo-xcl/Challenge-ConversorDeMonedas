import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Conversor {


    public Moneda convierteMoneda(String monedaBase, String monedaParaConvertir){
        URI direccion = URI.create("https://v6.exchangerate-api.com/v6/bd2d72a291164addb88e0ece/pair/"
                + monedaBase + "/" + monedaParaConvertir);

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(direccion)
                .build();

        try {
            HttpResponse<String>response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
            return new Gson().fromJson(response.body(), Moneda.class);
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}
