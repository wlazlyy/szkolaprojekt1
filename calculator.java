import java.util.Scanner;

public class calculator {

    private static final char DODAWANIE = '+';
    private static final char ODEJMOWANIE = '-';
    private static final char MNOŻENIE = '*';
    private static final char DZIELENIE = '/';
    private static final char POTĘGOWANIE = '^';
    private static final char PRZELICZENIE_JEDNOSTEK = 'u';

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Wybierz opcję:");
        System.out.println("1. Działanie matematyczne (+, -, *, /, ^)");
        System.out.println("2. Przeliczenie jednostek");


        char opcja = scanner.next().charAt(0);

        switch (opcja) {
            case '1':
                wykonajDziałanieMatematyczne(scanner);
                break;
            case '2':
                wykonajPrzeliczenieJednostek(scanner);
                break;
            default:
                System.out.println("Niepoprawna opcja!");
                break;
        }
    }

    private static void wykonajDziałanieMatematyczne(Scanner scanner) {
        System.out.println("Podaj pierwszą liczbę: ");
        double pierwszaLiczba = poprawZnaki(scanner);

        System.out.println("Podaj drugą liczbę: ");
        double drugaLiczba = poprawZnaki(scanner);

        System.out.println("Wybierz operację (+, -, *, /, ^): ");
        char matematycznaOperacja = scanner.next().charAt(0);

        double rezultat = obliczWynik(pierwszaLiczba, drugaLiczba, matematycznaOperacja);

        System.out.println("Wynik: " + rezultat);
    }

    private static void wykonajPrzeliczenieJednostek(Scanner scanner) {
        System.out.println("Wybierz typ przeliczenia:");
        System.out.println("a. Długość");
        System.out.println("b. Prędkość");
        System.out.println("c. Temperatura");

        char typPrzeliczenia = scanner.next().charAt(0);

        switch (typPrzeliczenia) {
            case 'a':
                przeliczDługość(scanner);
                break;
            case 'b':
                przeliczPrędkość(scanner);
                break;
            case 'c':
                przeliczTemperaturę(scanner);
                break;
            default:
                System.out.println("Niepoprawny typ przeliczenia!");
                break;
        }
    }

    private static void przeliczDługość(Scanner scanner) {
        System.out.println("Wybierz jednostkę wejściową:");
        System.out.println("1. Metry");
        System.out.println("2. Centymetry");
        System.out.println("3. Cale");

        int jednostkaWejściowa = scanner.nextInt();
        System.out.println("Podaj wartość:");

        double wartość = scanner.nextDouble();
        double wynik = 0;

        System.out.println("Wybierz jednostkę wyjściową:");
        int jednostkaWyjściowa = scanner.nextInt();

        if (jednostkaWejściowa == 1) {
            if (jednostkaWyjściowa == 2) {
                wynik = wartość * 100;
            } else if (jednostkaWyjściowa == 3) {
                wynik = wartość * 39.3701;
            } else {
                System.out.println("Niepoprawna jednostka wyjściowa!");
                return;
            }
        } else if (jednostkaWejściowa == 2) {
            if (jednostkaWyjściowa == 1) {
                wynik = wartość / 100;
            } else if (jednostkaWyjściowa == 3) {
                wynik = wartość / 2.54;
            } else {
                System.out.println("Niepoprawna jednostka wyjściowa!");
                return;
            }
        } else if (jednostkaWejściowa == 3) {
            if (jednostkaWyjściowa == 1) {
                wynik = wartość * 0.0254;
            } else if (jednostkaWyjściowa == 2) {
                wynik = wartość * 2.54;
            } else {
                System.out.println("Niepoprawna jednostka wyjściowa!");
                return;
            }
        } else {
            System.out.println("Niepoprawna jednostka wejściowa!");
            return;
        }

        System.out.println("Wynik: " + wynik);
    }

    private static void przeliczPrędkość(Scanner scanner) {
        System.out.println("Wybierz jednostkę wejściową:");
        System.out.println("1. Kilometry na godzinę (km/h)");
        System.out.println("2. Mile na godzinę (mph)");

        int jednostkaWejściowa = scanner.nextInt();
        System.out.println("Podaj wartość:");

        double wartość = scanner.nextDouble();
        double wynik = 0;

        System.out.println("Wybierz jednostkę wyjściową:");
        int jednostkaWyjściowa = scanner.nextInt();

        if (jednostkaWejściowa == 1) {
            if (jednostkaWyjściowa == 2) {
                wynik = wartość * 0.621371;
            } else {
                System.out.println("Niepoprawna jednostka wyjściowa!");
                return;
            }
        } else if (jednostkaWejściowa == 2) {
            if (jednostkaWyjściowa == 1) {
                wynik = wartość * 1.60934;
            } else {
                System.out.println("Niepoprawna jednostka wyjściowa!");
                return;
            }
        } else {
            System.out.println("Niepoprawna jednostka wejściowa!");
            return;
        }

        System.out.println("Wynik: " + wynik);
    }

    private static void przeliczTemperaturę(Scanner scanner) {
        System.out.println("Wybierz skalę temperatury:");
        System.out.println("1. Celsiusza na Fahrenheit");
        System.out.println("2. Fahrenheit na Celsiusza");

        int skala = scanner.nextInt();
        System.out.println("Podaj wartość:");

        double wartość = scanner.nextDouble();
        double wynik = 0;

        switch (skala) {
            case 1:
                wynik = (wartość * 9/5) + 32;
                break;
            case 2:
                wynik = (wartość - 32) * 5/9;
                break;
            default:
                System.out.println("Niepoprawna skala!");
                return;
        }

        System.out.println("Wynik: " + wynik);
    }

    private static double poprawZnaki(Scanner scanner) {
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
