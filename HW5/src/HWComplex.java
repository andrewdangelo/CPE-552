public class HWComplex {
    private double real;
    private double imaginary;

    /**
     * @brief Implement a constructor that takes two parameters (real and imaginary parts) to initialize the complex number.
     * @param real real number value
     * @param imaginary imaginary number value
     */
    public HWComplex(double real, double imaginary) {
        this.real = real;
        this.imaginary = imaginary;
    }

    // Getter and Setter methods for real and imaginary parts
    public double getReal() {
        return real;
    }

    public void setReal(double real) {
        this.real = real;
    }

    public double getImaginary() {
        return imaginary;
    }

    public void setImaginary(double imaginary) {
        this.imaginary = imaginary;
    }

    /**
     * @brief Implement the add method that adds the current complex number to another complex number
     * @param x new number
     * @return a new complex number
     */
    public HWComplex add(HWComplex x) {
        return new HWComplex(this.real + x.real, this.imaginary + x.imaginary);
    }

    /**
     * @brief Implement the mul method that multiplies the current complex number with another complex number
     * @param x new number
     * @return new complex number
     */
    public HWComplex mul(HWComplex x) {
        return new HWComplex(this.real * x.real - this.imaginary * x.imaginary, this.real * x.imaginary + this.imaginary * x.real);
    }

    
     /**
      * @brief toString method to print complex numbers in the form "a + bi" as a result
      */
    public String toString() {
        return String.format("%f + %fi", real, imaginary);
    }

    public static void main(String[] args) throws Exception {
        HWComplex c1 = new HWComplex(2.5, 1.2);

        HWComplex c2 = new HWComplex(2.4, 1.1);

        // Test addition

        HWComplex c3 = c1.add(c2);

        System.out.println("Addition Result: " + c3);

        HWComplex c4 = new HWComplex(2.5, 1.2);

        HWComplex c5 = new HWComplex(2.4, 1.1);

        // Test multiplication 
        HWComplex c6 = c4.mul(c5);

        System.out.println("Multiplication Result: " + c6);
    }
}
