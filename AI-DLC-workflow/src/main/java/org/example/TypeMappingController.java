package org.example;

import java.util.Locale;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TypeMappingController {

    @PostMapping("/types/{type}")
    public String mapType(@PathVariable("type") String type) {
        return switch (type.toUpperCase(Locale.ROOT)) {
            case "HMS" -> "HMS-enhanced";
            case "OKA" -> "OKA-lina PM";
            case "UTA" -> "UTA-BAE";
            case "RAS" -> "RAS-enhanced KO";
            default -> throw new UnsupportedTypeException(type);
        };
    }

    @ExceptionHandler(UnsupportedTypeException.class)
    public ResponseEntity<String> handleUnsupportedType(UnsupportedTypeException exception) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .contentType(MediaType.TEXT_PLAIN)
                .body("Unknown type: " + exception.type());
    }

    private static final class UnsupportedTypeException extends RuntimeException {

        private static final long serialVersionUID = 1L;

        private final String type;

        private UnsupportedTypeException(String type) {
            this.type = type;
        }

        private String type() {
            return type;
        }
    }
}
