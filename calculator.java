import java.util.Scanner;

public class calculator {

    private static final char DODAWANIE = '+';
    private static final char ODEJMOWANIE = '-';
    private static final char MNOŻENIE = '*';
    private static final char DZIELENIE = '/';
    private static final char POTĘGOWANIE = '^';

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Podaj pierwszą liczbę: ");
        double pierwszaLiczba = PoprawZnaki(scanner);

        System.out.println("Podaj drugą liczbę: ");
        double drugaLiczba = PoprawZnaki(scanner);

        System.out.println("Wybierz operację (+, -, *, /, ^): ");
        char matematycznaOperacja = scanner.next().charAt(0);

        double rezultat = obliczWynik(pierwszaLiczba, drugaLiczba, matematycznaOperacja);

        System.out.println("Wynik: " + rezultat);
    }

    private static double PoprawZnaki(Scanner scanner){
        while (true) {
            if (scanner.hasNextDouble()) {
                return scanner.nextDouble();
            } else {
                System.out.println("To nie jest liczba! Wprowadz poprawna liczbe:");
                scanner.next();
            }
        }
    }



    private static double obliczWynik(double liczba1, double liczba2, char operator) {
        double wynik = 0;

        switch (operator) {
            case DODAWANIE:
                wynik = liczba1 + liczba2;
                break;
            case ODEJMOWANIE:
                wynik = liczba1 - liczba2;
                break;
            case MNOŻENIE:
                wynik = liczba1 * liczba2;
                break;
            case DZIELENIE:
                if (liczba2 != 0) {
                    wynik = liczba1 / liczba2;
                } else {
                    System.out.println("Nie można dzielić przez zero!");
                    System.exit(1);
                }
                break;
            case POTĘGOWANIE:
                wynik = Math.pow(liczba1, liczba2);
                break;
            default:
                System.out.println("Niepoprawny operator!");
                System.exit(1);
        }

        return wynik;
    }
}
