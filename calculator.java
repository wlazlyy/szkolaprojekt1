import java.util.Scanner;

public class calculator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Podaj pierwszą liczbę: ");
        double liczba1 = scanner.nextDouble();

        System.out.println("Podaj drugą liczbę: ");
        double liczba2 = scanner.nextDouble();

        System.out.println("Wybierz operację (+, -, *, /, ^): ");
        char operator = scanner.next().charAt(0);

        double wynik = 0;

        switch (operator) {
            case '+':
                wynik = liczba1 + liczba2;
                break;
            case '-':
                wynik = liczba1 - liczba2;
                break;
            case '*':
                wynik = liczba1 * liczba2;
                break;
            case '/':
                if (liczba2 != 0) {
                    wynik = liczba1 / liczba2;
                } else {
                    System.out.println("Nie można dzielić przez zero!");
                    return;
                }
                break;
            case '^':
                wynik = Math.pow(liczba1, liczba2);
                break;
            default:
                System.out.println("Niepoprawny operator!");
                return;
        }

        System.out.println("Wynik: " + wynik);
    }
}
