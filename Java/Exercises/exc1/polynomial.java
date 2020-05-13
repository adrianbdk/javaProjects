import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class pylonomial
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader =
                new BufferedReader(new InputStreamReader(System.in));
        try{
            float a, b, c;
            System.out.print("A: ");
            a = Float.parseFloat(reader.readLine());

            System.out.print("B: ");
            b = Float.parseFloat(reader.readLine());

            System.out.print("C: ");
            c = Float.parseFloat(reader.readLine());

            if(a==0){
                if(b == 0 || c == 0)
                    System.out.println("error");
                else
                    System.out.println("A = 0, miejsce zerowe: " +(-c/b));
            }
            else {

                float delta = b*b - 4*a*c;

                if (delta < 0) {
                    System.out.println("Delta mniejsza od 0");
                }
                else {
                    System.out.println("Delta: " + delta);

                    double x1 = (-b - Math.sqrt(delta)) / (2 * a);
                    System.out.println("x1: " + x1);

                    double x2 = (-b + Math.sqrt(delta)) / (2 * a);
                    System.out.println("x2: " + x2);
                }
            }
        }
        catch(NumberFormatException nfe){
            System.out.println("BLEDNE DANE -> "+nfe);
        }

    }
}
