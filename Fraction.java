public class Fraction {
        private int numerator;
        private int denominator;

        public Fraction(int numerator, int denominator) {
            if (denominator == 0) {
                throw new IllegalArgumentException("The denominator cannot be 0.");
            }
            else if (denominator < 0) {
                this.numerator = -numerator;
                this.denominator = -denominator;
            }
            else {
                this.numerator = numerator;
                this.denominator = denominator;
            }
        }

        public Fraction(int value) {
            this.numerator = value;
            this.denominator = 1;
        }

        public Fraction() {
            this.numerator = 0;
            this.denominator = 1;
        }

        public int getNumerator() {
            return this.numerator;
        }

        public int getDenominator() {
            return this.denominator;
        }

        public String toString() {
            return this.numerator + "/" + this.denominator;
        }

        public double toDouble() {
            double result = (double) numerator/denominator;
            return result;
        }

        public Fraction add(Fraction other) {
            int resultNumerator;
            int resultDenominator;
            if (this.denominator == other.denominator) {
                resultNumerator = this.numerator + other.numerator;
                resultDenominator = this.denominator;
            }
            else {
                resultNumerator = this.numerator * other.denominator + other.numerator * this.denominator;
                resultDenominator = this.denominator * other.denominator;
            }
            Fraction result = new Fraction(resultNumerator, resultDenominator);
            result.toLowestTerms();
            return result;
        }

        public Fraction subtract(Fraction other) {
            int resultNumerator, resultDenominator;
            if (this.denominator == other.denominator) {
                resultNumerator = this.numerator - other.numerator;
                resultDenominator = this.denominator;
            }
            else {
                resultNumerator = this.numerator * other.denominator - other.numerator * this.denominator;
                resultDenominator = this.denominator * other.denominator;
            }
            Fraction result = new Fraction(resultNumerator, resultDenominator);
            result.toLowestTerms();
            return result;
        }

        public Fraction multiply(Fraction other) {
            int resultNumerator = this.numerator * other.numerator;
            int resultDenominator = this.denominator * other.denominator;
            Fraction result = new Fraction(resultNumerator, resultDenominator);
            result.toLowestTerms();
            return result;
        }

        public Fraction divide(Fraction other) {
            int resultNumerator = this.numerator * other.denominator;
            int resultDenominator = this.denominator * other.numerator;
            Fraction result = new Fraction(resultNumerator, resultDenominator);
            result.toLowestTerms();
            return result;
        }

        public boolean equals(Object other) {
            if (other instanceof Fraction) {
                if ((Fraction) other.numerator/other.denominator == this.numerator/this.denominator)
                    return true;
            }
            else return false;
        }

        public void toLowestTerms() {
            int gcd = gcd(this.numerator, this.denominator);
            numerator = this.numerator / gcd;
            denominator = this.denominator / gcd;
        }

        public static int gcd(int num, int den) {
            while (num != 0 && den != 0) {
                int remainder = num % den;
                num = den;
                den = remainder;
            }
            return num;
        }
    }