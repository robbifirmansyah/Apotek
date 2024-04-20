import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        System.out.println("Masukan kapasitas rak obat: ");
        int kapasitasRak = new Scanner(System.in).nextInt();
        Apotek apotek = new Apotek(kapasitasRak);

        apotek.utama();
    }
}
