public class Rational {

  private final int numerator;
  private final int denominator;

  Rational (int numerator, int denominator) {
    this.numerator = numerator;
    this.denominator = denominator;
  }

  public Rational plus (Rational that) {
    int temp_num = this.numerator * that.denominator + that.numerator * this.denominator;
    int temp_den = this.denominator * that.denominator;
    return new Rational(temp_num, temp_den);
  }

  public Rational minus (Rational that) {
    int temp_num = this.numerator * that.denominator - that.numerator * this.denominator;
    int temp_den = this.denominator * that.denominator;
    return new Rational(temp_num, temp_den);
  }

  public Rational times (Rational that) {
    int temp_num = this.numerator * that.numerator;
    int temp_den = this.denominator * that.denominator;
    return new Rational(temp_num, temp_den);
  }

  public Rational dividedBy (Rational that) {
    int temp_num = this.numerator * that.denominator;
    int temp_den = this.denominator * that.numerator;
    return new Rational(temp_num, temp_den);
  }

  public boolean equals (Rational that) {
    double mx = this.numerator / that.numerator;
    return this.denominator * mx == that.denominator;
  }

  public Rational simplify () {
    int div = Ch_1_1.GCD(this.numerator, this.denominator);
    return new Rational(this.numerator / div, this.denominator / div);
  }

  public String toString() {
    return this.numerator + " / " + this.denominator;
  }

  public static void main (String[] args) {
    // NOTE: to test: java -ea Rational

    Rational tester_1 = new Rational(3, 4);
    Rational tester_2 = new Rational(1, 2);

    Rational tester = tester_1.plus(tester_2);
    assert tester.numerator == 10;
    assert tester.denominator == 8;

    tester = tester_1.minus(tester_2);
    assert tester.numerator == 2;
    assert tester.denominator == 8;

    tester = tester_1.times(tester_2);
    assert tester.numerator == 3;
    assert tester.denominator == 8;

    tester = tester_1.dividedBy(tester_2);
    assert tester.numerator == 6;
    assert tester.denominator == 4;

    tester = tester_1.dividedBy(tester_2).simplify();
    assert tester.numerator == 3;
    assert tester.denominator == 2;

  }

}
