package enTriangelOchDessCirklar;

public class  Triangel {

    public static double inskriven(double a, double b, double c) {

        double p = (a + b + c)/2;
        double A = Math.sqrt(p*(p - a)*(p - b)*(p - c));
        double radius = (A/p);
        return radius;
    }

    public static double omskriven(double a, double b, double c){
        double R = (a*b*c)/(Math.sqrt((a+b+c)*(-a+b+c)*(a-b+c)*(a+b-c)));
        return R;
    }



}