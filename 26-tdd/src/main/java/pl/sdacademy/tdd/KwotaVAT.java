package pl.sdacademy.tdd;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Scanner;

public class KwotaVAT {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		BigDecimal index = new BigDecimal("1.0");
		BigDecimal vatValue = new BigDecimal("0.23");
		ArrayList<BigDecimal> resultsQuotaList = new ArrayList<>();
		ArrayList<BigDecimal> vatQuotaList = new ArrayList<>();

		System.out.println("Podaj liczbę: ");
		BigDecimal bigNumber = scanner.nextBigDecimal();

		for(int i = 1; i>0; i++){
			//System.out.println("Podana kwota: " + bigNumber);
			BigDecimal vat = bigNumber.multiply(vatValue);
			//System.out.println("Kwota VAT wynosi: " + vat);
			resultsQuotaList.add(i-1, bigNumber);
			vatQuotaList.add(i-1,vat);

			bigNumber = bigNumber.add(index);

			System.out.println("Kwota: " + resultsQuotaList.get(i-1) + " VAT: " + vatQuotaList.get(i-1));
		}

	}
}
