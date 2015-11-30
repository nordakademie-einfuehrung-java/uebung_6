
public class Auto {
	
	//Initialisierung der Variablen
	public int identifyer;
	public double kilometer;
	public double tankinhalt;
	public double originalverbrauch;
	public double verbrauch;
	public double maxtank;
	public double profiltiefeReifen;
	public String wagenname;
	public double neureifenProfil;
	public double originalabnutzung;
	public double abnutzung;
	public int decision;
	public boolean fahrbar;
	public Person fahrer;
	
	
	//Initialisierungsfunktion
	//Hier können alle autospezifischen Simulationswerte angepasst werden
	public Auto(int id, String wn) {
		identifyer = id;
		kilometer = 0;
		tankinhalt = 20;
		originalverbrauch = 0.1;
		verbrauch = originalverbrauch;
		maxtank = 40;
		neureifenProfil = 4;
		profiltiefeReifen = neureifenProfil;
		wagenname = wn;	
		originalabnutzung = 0.01;
		abnutzung = originalabnutzung;
	}
	
	//Hier wird dem Auto ein Fahrer zugewiesen und das Auto dadurch fahrbar gemacht
	//fahrbar ist eine wichtige Überprüfungsvariable, da man durch sie weiß, ob ein Fahrer im Auto sitzt
	public void einsteigen(Person fahrer) {
		
		//Überprüfungsvariable für das Fahren freischalten
		fahrbar = true;
		
		//Anpassung der Verbrauchswerte bei jungen und alten Fahrern
		if (fahrer.alter <= 20) {
			verbrauch = verbrauch + (verbrauch * 0.1);
			abnutzung = abnutzung + (abnutzung * 0.05);
		} else if (fahrer.alter >= 60) {
			verbrauch = verbrauch - (verbrauch * 0.1);
			abnutzung = abnutzung - (abnutzung * 0.05);
		}
		
	}
	
	//Anpassung der fahrbar Variable und Reset der Verbrauchswerte für den konkreten Wagen
	public void aussteigen(Person fahrer) {
		
		//Überprüfungsvariable für das Fahren freischalten
		fahrbar = false;
		
		//Anpassung der Verbrauchswerte bei jungen und alten Fahrern
		if ( (fahrer.alter <= 20) || (fahrer.alter >= 60) ) {
			verbrauch = originalverbrauch;
			abnutzung = originalabnutzung;
		}
		
	}
	
	
	//Fahrerfunktion
	public void fahren(int strecke) {
		
		//Abfrage, ob Fahrer in Auto
		if (fahrbar == true) {
			//Abfrage, ob Reifen geplättet wird 
			if ( (strecke * abnutzung) > (profiltiefeReifen - 3) ) {
				//Kein Fahren	
			} else {
				//Abfrage, ob Tank leergefahren
				if ( (strecke * verbrauch) > tankinhalt ) {
					kilometer = kilometer + (tankinhalt / verbrauch);
					tankinhalt = 0;
					profiltiefeReifen = profiltiefeReifen - (abnutzung * (tankinhalt / verbrauch) );
				} else {
					kilometer = kilometer + strecke;
					tankinhalt = tankinhalt - (strecke * verbrauch);
					profiltiefeReifen = profiltiefeReifen - (strecke * abnutzung);
				}			
			}			
		}
				
	}
	
	
	//Tankfunktion
	public void tanken(double liter) {
		
		//Abfrage ob Tank überläuft
		if ( (tankinhalt + liter) > maxtank) {
			tankinhalt = maxtank;
		} else {
			tankinhalt = tankinhalt + liter;
		}
			
	}
	
	
	//Reifenwechselfunktion
	public void reifenwechsel() {
		profiltiefeReifen = neureifenProfil;
	}
	
	
	//Entscheidungsbaum (könnte noch vorausschauender sein, spielt jedoch in dieser Simulation keine Rolle)
	public void entscheiden() {
		
		if (fahrbar == true) {
			if ( tankinhalt > (4 * verbrauch) ) {
				if ( profiltiefeReifen > ((4 * abnutzung) + 3) ) {
					decision = 1; //Fahren
				} else {
					decision = 3; //Reifenwechsel
				}
			} else {
				decision = 2; //Tanken
			}
		} else {
			decision = 4; //Nichts tun
		}
		
					
	}
	
	
	
}

