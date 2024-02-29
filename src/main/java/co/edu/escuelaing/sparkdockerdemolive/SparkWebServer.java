package co.edu.escuelaing.sparkdockerdemolive;

import spark.Spark;

import static spark.Spark.*;

public class SparkWebServer {

    //java -cp "target/classes;target/dependency/*" co.edu.escuelaing.sparkdockerdemolive.SparkWebServer
    public static void main(String... args){
        Spark.staticFiles.location("/public");
        port(getPort());
        get("hello", (req,res)->"Hello Docker!");

        // Servicio REST para calcular el seno
        get("/sin/:value", (req, res) -> {
            double value = Double.parseDouble(req.params(":value"));
            return Math.sin(value);
        });

        // Servicio REST para calcular el coseno
        get("/cos/:value", (req, res) -> {
            double value = Double.parseDouble(req.params(":value"));
            return Math.cos(value);
        });

        // Servicio REST para determinar si una cadena es un palíndromo
        get("/isPal/:word", (req, res) -> {
            String word = req.params(":word");
            return isPalindrome(word);
        });

        // Servicio REST para retornar la magnitud de un vector de dos dimensiones
        get("/mag/:x/:y", (req, res) -> {
            double x = Double.parseDouble(req.params(":x"));
            double y = Double.parseDouble(req.params(":y"));
            return Math.sqrt(x * x + y * y);
        });
    }

    private static boolean isPalindrome(String word) {
        String cleanWord = word.replaceAll("\\s+", "").toLowerCase();
        int length = cleanWord.length();
        for (int i = 0; i < length / 2; i++) {
            if (cleanWord.charAt(i) != cleanWord.charAt(length - i - 1)) {
                return false;
            }
        }
        return true;
    }

    private static int getPort() {
        if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 4567;
    }

}
