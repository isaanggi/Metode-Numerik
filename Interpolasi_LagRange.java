import java.util.Scanner;
public class Interpolasi_LagRange {
    public static void main(String[] args) {
        Scanner masuk = new Scanner(System.in);
        // NIM               : 215411037
        // Nama 	          : ISA ANGGIE ALFIANTO
        // Mata Kuliah : METODE NUMERIK
        // Deskripsi variabel
        int n; // n = ordo
        int a, b; // Untuk iterasi
        double x = 0; // x = nilai yang dipakai untuk pencarian
        double y = 0; // y = nilai yang akan ditemukan, y = f(x)
        double atas, bawah; // Untuk perhitungan dalam iterasi
        double [] Xarray = new double[10]; // Array untuk xi
        double [] Yarray = new double[10]; // Array untuk yi atau f(xi)
        System.out.println("PROGRAM INTERPOLASI LAGRANGE");
        System.out.println("============================");
        // Input Ordo
        System.out.print("Masukan ordo (n): ");
        n = masuk.nextInt();
        // Input xi
        for(a = 0; a <= n; a++) {
            System.out.print("Masukan nilai x" + a + ": ");
            Xarray[a] = masuk.nextDouble();
        }
        // Input yi atau f(xi)
        for(a = 0; a <= n; a++) {
            System.out.print("Masukan nilai f(x" + a + "): ");
            Yarray[a] = masuk.nextDouble();
        }
        // Input x
        System.out.print("Masukan nilai x untuk mencari f(x): ");
        x = masuk.nextFloat();
        // Iterasi perhitungan
        for(a = 0; a <= n; a++) {
            atas = 1; bawah = 1;
            for(b = 0; b <= n; b++) {
                if (b != a) {
                    atas = atas * (x - Xarray[b]);
                    bawah = bawah * (Xarray[a] - Xarray[b]);
                }
            }
            y = y + (atas/bawah) * Yarray[a];
        }
        // Output Hasil
        System.out.println("Maka y atau f("+x+") = " +  y);
    }
}
