import org.junit.*;
import static org.junit.Assert.*;

public class TriangleTest {

  @Test
  public void newTriangle_instantiatesCorrectly() {
    Triangle testTriangle = new Triangle(3, 3, 3);
    assertEquals(true, testTriangle instanceof Triangle);
  }

  @Test
  public void isTriangle_sideLengthsAreNotTriangle_false() {
    Triangle testTriangle = new Triangle(2, 2, 5);
    assertEquals(false, testTriangle.isTriangle());
  }

  @Test
  public void triangleType_sideLengthsAreNotTriangle_false() {
    Triangle testTriangle = new Triangle(2, 2, 5);
    assertEquals("false", testTriangle.triangleType());
  }

  @Test
  public void triangleType_sideLengthsAreEqual_equilateral() {
    Triangle testTriangle = new Triangle (4, 4, 4);
    assertEquals("equilateral", testTriangle.triangleType());
  }

  @Test
  public void triangleType_twoSideLengthsAreEqual_isosceles() {
    Triangle testTriangle = new Triangle (4, 4, 6);
    assertEquals("isosceles", testTriangle.triangleType());
  }

  @Test
  public void triangleType_noSideLenghtsAreEqual_scalene() {
    Triangle testTriangle = new Triangle (2, 3, 4);
    assertEquals("scalene", testTriangle.triangleType());
  }

  @Test
  public void triangleType_sideLengthsPassPythagoras_rightTriangle() {
    Triangle testTriangle = new Triangle (97, 72, 65);
    assertEquals("right", testTriangle.triangleType());
  }
}
