
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import static spark.Spark.*;
import spark.ModelAndView;
import spark.template.freemarker.FreeMarkerEngine;
import freemarker.template.Configuration;

public class Main {
    public static void main(String[] args) {
        Configuration viewDir = new Configuration();
        viewDir.setClassForTemplateLoading(Main.class, "/");

        get("/hello", (req, res) -> "Hello World");

        get("/htmltest", (request, response) -> {
            Map<String, Object> attributes = new HashMap<>();
            attributes.put("message", "Hello World!");
            return new ModelAndView(attributes, "test.ftl");
        }, new FreeMarkerEngine(viewDir));

        get("/dbtest", (req, res) -> {
            Optional<Database> db = Database.Connect("test");
            if (db.isPresent()) {
                return "Yes!";
            } else {
                return "Nope :(";
            }
        });

    }
}
