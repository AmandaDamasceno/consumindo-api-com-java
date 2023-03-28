import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.List;
import java.util.Map;

public class App {
    public static void main(String[] args) throws Exception {
        
        // Conexão HTTP e consumindo API
        String url = "https://raw.githubusercontent.com/alura-cursos/imersao-java-2-api/main/TopMovies.json";
        URI endereco = URI.create(url);
        var client = HttpClient.newHttpClient();
        var request = HttpRequest.newBuilder(endereco).GET().build();
        HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
        String body = response.body();
    
        // Extraindo os dados de interesse (título, poster, classificação)
        JsonParser parser = new JsonParser();
        List<Map<String, String>> listaDeFilmes = parser.parser(body);

        // Exibindo dados da lista de filmes
        for (Map<String,String> filme : listaDeFilmes) {
            System.out.println("\u001b[1mTitle: " + filme.get( "title") + "\u001b[m");
            System.out.println("\u001b[1mImage: "  + filme.get( "image") + "\u001b[m");
            System.out.println("\u001b[1m \u001B[42mClassification: \u001b[30;1m" + "\u001b[1m" + filme.get( "imDbRating") + "\u001b[m");
            System.out.println("⭐⭐⭐⭐⭐");
            System.out.println("\n");
        }

    }
} 
 