package org.example;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class TypeMappingControllerIT {

    @Value("${local.server.port}")
    private int port;

    private final HttpClient httpClient = HttpClient.newHttpClient();

    @Test
    void mapsAllSupportedTypes() throws IOException, InterruptedException {
        assertMapping("HMS", "HMS-enhanced");
        assertMapping("OKA", "OKA-lina PM");
        assertMapping("UTA", "UTA-BAE");
        assertMapping("RAS", "RAS-enhanced KO");
    }

    @Test
    void matchesTypesWithoutCaseSensitivity() throws IOException, InterruptedException {
        assertMapping("oka", "OKA-lina PM");
        assertMapping("rAs", "RAS-enhanced KO");
    }

    @Test
    void returnsNotFoundForUnsupportedType() throws IOException, InterruptedException {
        HttpResponse<String> response = post("unknown");

        assertEquals(404, response.statusCode());
        assertEquals("Unknown type: unknown", response.body());
        assertTrue(response.headers().firstValue("Content-Type").orElse("").startsWith("text/plain"));
    }

    @Test
    void preservesExistingHomeEndpoint() throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder(uri("/home"))
                .GET()
                .build();

        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

        assertEquals(200, response.statusCode());
        assertEquals("Home page", response.body());
    }

    private void assertMapping(String type, String expectedBody) throws IOException, InterruptedException {
        HttpResponse<String> response = post(type);

        assertEquals(200, response.statusCode(), type);
        assertEquals(expectedBody, response.body(), type);
    }

    private HttpResponse<String> post(String type) throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder(uri("/types/" + type))
                .POST(HttpRequest.BodyPublishers.noBody())
                .build();

        return httpClient.send(request, HttpResponse.BodyHandlers.ofString());
    }

    private URI uri(String path) {
        return URI.create("http://localhost:" + port + path);
    }
}
