import org.junit.*;
import static org.junit.Assert.*;

import java.util.ArrayList;

import org.fluentlenium.adapter.FluentTest;
import org.junit.ClassRule;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

import static org.assertj.core.api.Assertions.assertThat;

public class AppTest extends FluentTest {
  public WebDriver webDriver = new HtmlUnitDriver();
  public WebDriver getDefaultDriver() {
      return webDriver;
  }

  @ClassRule
  public static ServerRule server = new ServerRule();
  // Unit testing

  //Integration testing
  @Test
  public void rootTest() {
    goTo("http://localhost:4567/");
    assertThat(pageSource()).contains("Enter three side lengths");
  }

  @Test
  public void notATriangleTest() {
    goTo("http://localhost:4567/");
    fill("#sideA").with("3");
    fill("#sideB").with("4");
    fill("#sideC").with("8");
    submit(".btn");
    assertThat(pageSource()).contains("is not a valid triangle");
  }

  @Test
  public void triangleTypeTest() {
    goTo("http://localhost:4567/");
    fill("#sideA").with("5");
    fill("#sideB").with("5");
    fill("#sideC").with("5");
    submit(".btn");
    assertThat(pageSource()).contains("A triangle with sides 5, 5, and 5");
  }

  @Test
  public void multipleTriangleTypeTest() {
    goTo("http://localhost:4567/");
    fill("#sideA").with("5");
    fill("#sideB").with("5");
    fill("#sideC").with("5");
    submit(".btn");
    fill("#sideA").with("3");
    fill("#sideB").with("4");
    fill("#sideC").with("5");
    submit(".btn");
    assertThat(pageSource()).contains("A triangle with sides 3, 4, and 5 is a right triangle");
  }
}
