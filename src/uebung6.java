/*
 * Die Main Methode mit dem Hauptprogramm steht etwas weiter unten, da ich noch Platz für zusätzliche Methoden brauchte.
 * Der Code müsste aber ganz gut lesbar sein - einfach in der Main Methode dem Programmverlauf folgen und die Referenzen in
 * den anderen Klassen suchen.  
 * An einigen Stellen würde es glaub ich einfacher gehen (durch zusätzliche Methoden), aber dafür hatte ich jetzt keinen Nerv mehr.
 */


public class uebung6 {

	//Zuordnung und Ausführung der Rundenentscheidung
	//triggert die entscheiden Methode in der Klasse Auto
	//diese gibt "decision" zurück um im switch Statement
	//die entsprechende Entscheidung zu triggern
	public static void ausfuehren(Auto auto) {
		auto.entscheiden();		
		switch (auto.decision) {
		case 1: auto.fahren(Zufall.getZufallInt(3, 4)); break;
		case 2: auto.tanken( (auto.maxtank - auto.tankinhalt) ); break;
		case 3: auto.reifenwechsel(); break;
		case 4: break;
		}
	}
	
	//Fahrer steigt aus dem Auto aus
	public static void ausstieg(Person fahrer, Auto auto1, Auto auto2, Auto auto3, Auto auto4, Auto auto5) {
		
		switch (fahrer.identifyer) {
		case 1: umsteigen(fahrer, auto1, auto2, auto3, auto4, auto5); 
				auto1.aussteigen(fahrer); 
				break;
		case 2: umsteigen(fahrer, auto1, auto2, auto3, auto4, auto5);
				auto2.aussteigen(fahrer); 
				break;
		case 3: umsteigen(fahrer, auto1, auto2, auto3, auto4, auto5);
				auto3.aussteigen(fahrer); 
				break;
		case 4: umsteigen(fahrer, auto1, auto2, auto3, auto4, auto5);
				auto4.aussteigen(fahrer); 
				break;
		case 5: umsteigen(fahrer, auto1, auto2, auto3, auto4, auto5);
				auto5.aussteigen(fahrer); 
				break;
		
		}
		
	}
	
	//Fahrer steigt in neues Auto ein (Zusätzlich passe ich hier den Identifyer an um dafür zu sorgen, 
	//dass dieser weiterhin der Autonummer entspricht
	public static void umsteigen(Person fahrer, Auto auto1, Auto auto2, Auto auto3, Auto auto4, Auto auto5) {
		if (auto1.fahrbar == false) {
			auto1.einsteigen(fahrer);
			fahrer.identifyer = 1;
		} else if (auto2.fahrbar == false) {
			auto2.einsteigen(fahrer);
			fahrer.identifyer = 2;
		} else if (auto3.fahrbar == false) {
			auto3.einsteigen(fahrer);
			fahrer.identifyer = 3;
		} else if (auto4.fahrbar == false) {
			auto4.einsteigen(fahrer);
			fahrer.identifyer = 4;
		} else if (auto5.fahrbar == false) {
			auto5.einsteigen(fahrer);
			fahrer.identifyer = 5;
		}
	}
	
	//MAIN METHODE MIT PROGRAMDURCHLAUF
	public static void main(String[] args) {

		
		//Initialisierung der Autos und Teilnehmer		
		Auto auto1 = new Auto(1, "1");
		Auto auto2 = new Auto(2, "2");
		Auto auto3 = new Auto(3, "3");
		Auto auto4 = new Auto(4, "4");
		Auto auto5 = new Auto(5, "5");		
		Person fahrer1 = new Person(1, 1990);
		Person fahrer2 = new Person(2, 2000);
		Person fahrer3 = new Person(3, 1990);
		Person fahrer4 = new Person(4, 1990);		
		
		//Autozuweisung (Erfolgt konkret über den fahrer.identifyer)
		//Hier wird einem Fahrer nach dem anderen eine Zufallszahl zugewiesen
		//und sichergestellt, dass kein Identifyer doppelt vorkommt
		fahrer1.identifyer = Zufall.getZufallInt(1, 5);		
		fahrer2.identifyer = Zufall.getZufallInt(1, 5);
		while (fahrer2.identifyer == fahrer1.identifyer) {
			fahrer2.identifyer = Zufall.getZufallInt(1, 5);
		}		
		fahrer3.identifyer = Zufall.getZufallInt(1, 5);
		while ( (fahrer3.identifyer == fahrer1.identifyer) || (fahrer3.identifyer == fahrer2.identifyer) ) {
			fahrer3.identifyer = Zufall.getZufallInt(1, 5);
		}		
		fahrer4.identifyer = Zufall.getZufallInt(1, 5);
		while ( (fahrer4.identifyer == fahrer1.identifyer) || (fahrer4.identifyer == fahrer2.identifyer) || (fahrer4.identifyer == fahrer3.identifyer) ) {
			fahrer4.identifyer = Zufall.getZufallInt(1, 5);
		}

		//Einsteigen vor dem Rennen 
		//Auf Basis des Identifyers wird dem Auto der richtige Fahrer zugewiesen
		switch (fahrer1.identifyer) {
		case 1: auto1.einsteigen(fahrer1); break;
		case 2: auto2.einsteigen(fahrer1); break;
		case 3: auto3.einsteigen(fahrer1); break;
		case 4: auto4.einsteigen(fahrer1); break;
		case 5: auto5.einsteigen(fahrer1); break;
		}		
		switch (fahrer2.identifyer) {
		case 1: auto1.einsteigen(fahrer2); break;
		case 2: auto2.einsteigen(fahrer2); break;
		case 3: auto3.einsteigen(fahrer2); break;
		case 4: auto4.einsteigen(fahrer2); break;
		case 5: auto5.einsteigen(fahrer2); break;
		}		
		switch (fahrer3.identifyer) {
		case 1: auto1.einsteigen(fahrer3); break;
		case 2: auto2.einsteigen(fahrer3); break;
		case 3: auto3.einsteigen(fahrer3); break;
		case 4: auto4.einsteigen(fahrer3); break;
		case 5: auto5.einsteigen(fahrer3); break;
		}		
		switch (fahrer4.identifyer) {
		case 1: auto1.einsteigen(fahrer4); break;
		case 2: auto2.einsteigen(fahrer4); break;
		case 3: auto3.einsteigen(fahrer4); break;
		case 4: auto4.einsteigen(fahrer4); break;
		case 5: auto5.einsteigen(fahrer4); break;
		}
		
		//100 Durchläufe
		//Rennendurchlauf
		for (int i = 1; i <= 100; i++) {
			
			//10 Runden
			//hier wird indirekt die Entscheidungsfunktion getriggert (dies findet in der ausfuehren Methode s.o. statt)
			//Wenn man Einzelschritte nachvollziehen möchte müssen in dieser Schleife entsprechende Outputs gemacht werden.
			for (int j = 1; j <= 10; j++) {
				ausfuehren(auto1);
				ausfuehren(auto2);
				ausfuehren(auto3);
				ausfuehren(auto4);
				ausfuehren(auto5);
			}
			
			//Autowechsel
			//läuft über die ausstieg Methode (s.o.), die dann auch die umsteigen Methode nutzt
			switch ( Zufall.getZufallInt(1, 4) ) {
			case 1: ausstieg(fahrer1, auto1, auto2, auto3, auto4, auto5); break;
			case 2: ausstieg(fahrer2, auto1, auto2, auto3, auto4, auto5); break;
			case 3: ausstieg(fahrer3, auto1, auto2, auto3, auto4, auto5); break;
			case 4: ausstieg(fahrer4, auto1, auto2, auto3, auto4, auto5); break;
			}
			
		}
		
		//Resultatausgabe
		System.out.println("Auto1: " + auto1.kilometer + "km");
		System.out.println("Auto2: " + auto2.kilometer + "km ");
		System.out.println("Auto3: " + auto3.kilometer + "km "); 
		System.out.println("Auto4: " + auto4.kilometer + "km ");
		System.out.println("Auto5: " + auto5.kilometer + "km ");
		
	}

}
