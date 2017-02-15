import java.util.Scanner;
import java.lang.Math;

/* this code is ment to calculate ship statistics based on stats we have now.
credit goes to Klorn and dseehafer for the datamined math*/

public class ShipCalculator{
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		//hello constants :)
		double bbrate = 1.1812;
		double carate = 1.8631;
		double ddrate = 4.4907;
		double cvrate = 0.7311;
		double bbcon = 10837.0;
		double cacon = 9859.4;
		double ddcon = 3435.5;
		double cvcon = 28253.0;
		double apdmgcon = 21.088;
		double apdmgexp = 0.4695;
		double pencon = 0.5561613;
		double mvexp = 1.1;
		double massexp = 0.55;
		double calexp = 0.65;
		double heburncon = 5.3435;
		double heburnexp = 0.4489;
		double hedmgcon = 926.1;
		double hedmgexp = 0.1612;
		double apm = 0;
		double hp = 0;
		double apmv = 0;
		double hem = 0;
		double hebc = 0;
		double cal = 0;
		double apdmg = 0.0;
		double appen = 0.0;
		double hedmg = 0.0;
		double fire = 0.0;
		// a long list of constants used in the maths below.
		System.out.println("what is the ship displacement in metric tons? ");
		double d = in.nextDouble();
		// max displacement of the ship in metric tonnes.
		System.out.println("what is the ship class? 1 = BB, 2 = CA, 3 = DD, 4 = CV. ");
		int a = in.nextInt();
		// Identifies the next part of the code that is needed.
		if (a == 4){
			// Carriers
			hp = (cvrate * d) + cvcon;
			System.out.println("HP is: " + hp);
		}else{
			System.out.println("What is the AP Shell mass? ");
			apm = in.nextDouble();
			System.out.println("what is the AP muzzle velosity? ");
			apmv = in.nextDouble();
			System.out.println("What is the HE Shell mass? ");
			hem = in.nextDouble();
			System.out.println("What is the HE burst charge mass? ");
			hebc = in.nextDouble();
			System.out.println("what is the caliber? ");
			cal = in.nextDouble();
			apdmg = apdmgcon * Math.pow((apm * apmv), apdmgexp);
			// Max AP Damage.
			appen = (pencon * Math.pow(apmv, mvexp) * Math.pow(apm, massexp)) / Math.pow(cal, calexp);
			// AP pen at 0m.
			hedmg = hedmgcon * Math.pow((hem * hebc), hedmgexp);
			// Max AP Damage.
			fire = heburncon * Math.pow(hebc, heburnexp);
			// HE firechance.
			// You'll need these values if the ship isn't a CV, reguardless of class. Torps to be added.
			if (a == 1){
				hp = (d * bbrate) + bbcon;
				System.out.println("HP is: " + hp);
				System.out.println("AP damage is: " + apdmg);
				System.out.println("AP pen is: " + appen + "mm @ 0m.");
				System.out.println("HE damage is: " + hedmg);
				System.out.println("HE fire chance is: " + fire + "%");
			}else if (a == 2){
				hp = (d * carate) + cacon;
				System.out.println("HP is: " + hp);
				System.out.println("AP damage is: " + apdmg);
				System.out.println("AP pen is: " + appen + "mm @ 0m.");
				System.out.println("HE damage is: " + hedmg);
				System.out.println("HE fire chance is: " + fire + "%");
			}else if (a == 3){
				hp = (d * ddrate) + ddcon;
				System.out.println("HP is: " + hp);
				System.out.println("AP damage is: " + apdmg);
				System.out.println("AP pen is: " + appen + "mm @ 0m.");
				System.out.println("HE damage is: " + hedmg);
				System.out.println("HE fire chance is: " + fire + "%");
			}
		}	
	}
}
