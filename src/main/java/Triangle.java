public class Triangle {

  private int mSideA;
  private int mSideB;
  private int mSideC;

  public Triangle(int sideA, int sideB, int sideC) {
    mSideA = sideA;
    mSideB = sideB;
    mSideC = sideC;
  }

  public String sideLengths() {
    return mSideA + ", " + mSideB + ", and " + mSideC;
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
    } else if(isRightTriangle()) {
      return "right";
    } else if (mSideA == mSideB && mSideB == mSideC) {
      return "equilateral";
    } else if (mSideA == mSideB || mSideA == mSideC || mSideB == mSideC) {
      return "isosceles";
    }
    return "scalene";
  }

  private boolean isRightTriangle() {
    if ((mSideA * mSideA + mSideB * mSideB) == (mSideC * mSideC)) {
      return true;
    } else if ((mSideA * mSideA + mSideC * mSideC) == (mSideB * mSideB)) {
      return true;
    } else if ((mSideC * mSideC + mSideB * mSideB) == (mSideA * mSideA)) {
      return true;
    } else {
      return false;
    }
  }
}
