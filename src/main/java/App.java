import java.util.HashMap;

import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;

import static spark.Spark.*;

public class App {
  public static void main(String[] args) {
    staticFileLocation("/public");
    String layout = "templates/layout.vtl";

    get("/", (request, response) -> {
      HashMap<String, Object> model = new HashMap<String, Object>();
      model.put("triangle", request.session().attribute("triangle"));

      model.put("template", "templates/home.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    post("/home", (request, response) -> {
      HashMap<String, Object> model = new HashMap<String, Object>();
      Integer sideA = Integer.parseInt(request.queryParams("sideA"));
      Integer sideB = Integer.parseInt(request.queryParams("sideB"));
      Integer sideC = Integer.parseInt(request.queryParams("sideC"));
      Triangle inputTriangle = new Triangle(sideA, sideB, sideC);
      request.session().attribute("triangle", inputTriangle);
      model.put("triangle", inputTriangle);
      model.put("template", "templates/home.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());
  }


}
