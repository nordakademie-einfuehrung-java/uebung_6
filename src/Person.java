
public class Person {
	
	//Variableninitialisierung
	public String vorname;
	public String nachname;
	public int geburtsjahr;
	public int alter;
	public int identifyer;
	
	//Leerinitialisierung
	public Person() {
		vorname = "Max";
		nachname = "Mustermann";
		geburtsjahr = 1998;
		alter = 2015 - geburtsjahr;
	}
	
	//Initialisierung für Teil 3
	public Person(String vn, String nn, int gj) {
		vorname = vn;
		nachname = nn;
		geburtsjahr = gj;
		alter = 2015 - geburtsjahr;
	}
	
	//Initialisierungsfunktion für die Hauptaufgabe
	public Person(int id, int gj) {
		geburtsjahr = gj;
		alter = 2015 - geburtsjahr;
		identifyer = id;
	}
	
}
