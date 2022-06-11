import java.util.Scanner;

public class Game {

    public static void main(String[] args) {
        Scanner hyrja = new Scanner(System.in);// hyrjes standarde
        System.out.println("Loje e thjeshte me letra bixhozi.");
        System.out.println("Qelloni letren e ardhshme, me e vogel apo me madhe.");
        System.out.println();

        int loje = 0;
        double poena = 0;

        boolean luajPrap = false;
        Deck tuba = new Deck();
        do {
            int rezultatiPerKeteLoje = lojeERe(hyrja, tuba);
            poena += rezultatiPerKeteLoje;
            loje++;
            System.out.println("Luaj prap (shtyp P ose J)? ");
            String luajPrapCmd = hyrja.nextLine().toUpperCase();
            luajPrap = luajPrapCmd.startsWith("P");
        } while (luajPrap);
        System.out.println("Keni fituar " + poena + " poena ne " + loje + " loje.");

    }

    private static int lojeERe(Scanner hyrja, Deck tuba) {
        tuba.shuffle();

        Card letraAktuale = tuba.nextCard();
        Card letraEArdhshme;

        int teQelluara = 0;
        char qelloChar;

        System.out.println("Letra është " + letraAktuale);

        while (true) {
            System.out.print("Letra e ardhshme me e vogel (V) apo me e madhe (M) ? ");

            do {

                String qelloCmd = hyrja.nextLine();
                qelloChar = ' ';
                if (qelloCmd.length() > 0) {

                    qelloChar = qelloCmd.toUpperCase().charAt(0);// MADHE

                }
                if (qelloChar != 'V' && qelloChar != 'M') {
                    System.out.println("Shtyp M ose V: ");

                }
            } while (qelloChar != 'V' && qelloChar != 'M');

            letraEArdhshme = tuba.nextCard();

            System.out.println("Letra e ardhshme është " + letraEArdhshme);

            if (letraEArdhshme.getValue() == letraAktuale.getValue()) {
                System.out.println("Vlera është eshte e njejte me letren e kaluar.");

                break;
            } else if (letraEArdhshme.getValue() > letraAktuale.getValue()) {

                if (qelloChar == 'M') {
                    System.out.println("Keni qelluar.");
                    teQelluara++;

                } else {
                    System.out.println("Nuk e keni qelluar.");
                    break;

                }
            } else {

                if (qelloChar == 'V') {
                    System.out.println("Keni qelluar.");
                    teQelluara++;

                } else {
                    System.out.println("Nuk e keni qelluar.");
                    break;

                }

            }
            letraAktuale = letraEArdhshme;
            System.out.println();
            System.out.println("Letra është " + letraAktuale);

        }

        System.out.println();
        System.out.println("Loja mbaroi");
        System.out.println("Ju keni qelluar " + teQelluara + " here.");
        System.out.println();
        return teQelluara;

    }


}