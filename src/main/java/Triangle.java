public class Triangle {

  private int mSideA;
  private int mSideB;
  private int mSideC;

  public Triangle(int sideA, int sideB, int sideC) {
    mSideA = sideA;
    mSideB = sideB;
    mSideC = sideC;
  }

  public boolean isTriangle() {
    if (mSideA + mSideB <= mSideC || mSideB + mSideC <= mSideA || mSideA + mSideC <= mSideB) {
      return false;
    }
    return true;
  }

  public String triangleType() {
    if (isTriangle() == false){
      return "false";
    }
    if (mSideA == mSideB && mSideB == mSideC) {
      return "equilateral";
    }
    if (mSideA == mSideB || mSideA == mSideC || mSideB == mSideC) {
      return "isosceles";
    }
    return "scalene";
  }
}
