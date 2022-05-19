package lesson4;

public class Triangle {
    public static double CalculateSumTriangleBySides(int firstSide, int secondSide, int thirdSide) throws Exception {
        if ((firstSide < (secondSide + thirdSide)) && (secondSide < (firstSide + thirdSide)) && (thirdSide < (firstSide + secondSide))) {
            double semiPerimeter = ((double)(firstSide + secondSide + thirdSide) / 2);
            return Math.sqrt(semiPerimeter * ((semiPerimeter - (double)firstSide) * (semiPerimeter - (double)secondSide) * (semiPerimeter - (double)thirdSide)));
        }
        throw new WrongSidesException();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(CalculateSumTriangleBySides(1,1,1));
        System.out.println(CalculateSumTriangleBySides(3,3,5));
        System.out.println(CalculateSumTriangleBySides(100,110,120));
    }
}