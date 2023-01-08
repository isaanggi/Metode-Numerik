import java.util.Scanner;
public class aprok_error_iterasi {
	public static void main(String[] args) {
		Scanner masuk = new Scanner(System.in);
    
		// Deskripsi
		// n 		= angka signifikan
		// err_aprok 	= Error Aproksimasi (Ea) %
		// err_persen 	= Error Relative Persen (Et) %
		// Es 		= Error Sebenarnya sebagai pembanding Ea
		// faktor 	= Nilai yang digunakan pada Iterasi Faktorial
		// faktorial 	= nilai hasil faktorial dari faktor

		// Deklarasi Awal
		double iterasi=1, faktor=1, hasil=1;
		double e, n, Es, nilai_benar, hasil2;
		double err_persen=0, err_aprok=0;
		double E = 2.71828183; // Nilai baku e

		// Input yang ingin dicari
		System.out.print("Masukan pangkat e: ");
		e = masuk.nextDouble();
		System.out.print("Masukan angka signifikan (n): ");
		n = masuk.nextDouble();

		// Proses Perhitungan Awal
		Es = (0.5*Math.pow(10, 2-n));
		nilai_benar = Math.pow(E, e);
		System.out.println("Es (%): "+Es);
		System.out.println("Nilai sebenarnya: "+nilai_benar);
		System.out.println("==================");
		// Iterasi Aproksimasi Error dengan DO WHILE
		do {
			// Deklarasi untuk Faktorial
			double faktorial = 1;

			// Output awal
			System.out.println("Iterasi: "+iterasi);
			System.out.println("Hasil: "+hasil);
			System.out.println("Et (%):	"+err_persen);
			System.out.println("Ea (%):	"+err_aprok);
			System.out.println("==================");
			System.out.println("Faktor: "+faktor);

      // Iterasi Faktorial dengan FOR
			for(double i=0;i<faktor;i++) {
				//Mendapatkan angka perkalian untuk faktorial
				double temp=faktor-i;
				//Penghitungan faktorial
				faktorial=faktorial*temp;
		  }

			// Mencari Hasil
		  hasil2 = hasil+(Math.pow(e, iterasi))/faktorial;

		  // Mencari Error Relative Persen (Et)
			err_persen = nilai_benar-hasil2;
			err_persen = err_persen/nilai_benar;
			err_persen = err_persen*100;

			// Mencari Error Aproksimasi (Ea)
			err_aprok = hasil2 - hasil;
			err_aprok = err_aprok/hasil2;
			err_aprok = err_aprok*100;

			// Input ulang hasil dengan nilai baru  dari hasil2
			hasil = hasil2;

			// Penambahan untuk Iterasi
      faktor++;
			iterasi++;

		}  while (err_aprok > Es); // Syarat, berjalan bila Ea > Es dan berhenti bila Ea < Es

		// Output nilai akhir Iterasi
		System.out.println("Iterasi: "+iterasi);
		System.out.println("Hasil: "+hasil);
		System.out.println("Et (%):	"+err_persen);
		System.out.println("Ea (%):	"+err_aprok);
		System.out.println("==================");

		// Kesimpulan
    System.out.println("Pada iterasi ke-"+iterasi+" diperoleh hasil "+hasil+" dengan error aproksimasi "+err_aprok+" (Kurang dari "+Es+" %)");
	}
}
