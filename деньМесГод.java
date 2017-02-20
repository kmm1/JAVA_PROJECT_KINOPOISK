import java.util.Scanner;

/**
 * Created by icons on 18.2.17.
 */
public class деньМесГод {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        System.out.println("Введите день в формате dd");
        int a = in.nextInt();
        System.out.println("Введите месяц в формате mm");
        int b = in.nextInt();
        System.out.println("Введите год в формате yyyy");
        int c = in.nextInt();

        if (a==31&b==12) {
            System.out.println(a/a+"."+b/b+"."+ ++c);
        } else if (a==31&b!=12) {
            System.out.println(a/a+"."+ ++b +"."+c);
        } else if (a==28&b==2&c%4==0) {
            System.out.println(a/a+"."+ ++b+"."+c); //високосный год
        } else if (a==28&b==2&c%4==0&c%100!=0) {
            System.out.println(a/a+"."+ ++b +"."+c); //високосный год
        } else if (a==28&b==2&c%400!=0) {
            System.out.println(++a +"."+b+"."+c); //не високосный год
        } else if (a==28&b==2&c%4!=0&c%100==0) {
            System.out.println(++a +"."+b+"."+c); //не високосный год

        } else if (a<=29&b<=11&a!=28) {
            System.out.println(++a +"."+b+"."+c);
        } else if (a<=29&b==12&a!=28) {
            System.out.println(++a +"."+b/b+"."+ ++c);
        } else if (a==30&b==4|b==6|b==9|b==11) {
            System.out.println(a/a+"."+ ++b +"."+c);
        } else if (a==30&b==1|b==3|b==5|b==7|b==8|b==10|b==12) {
            System.out.println(++a +"."+b+"."+c);
        }
    }
}

