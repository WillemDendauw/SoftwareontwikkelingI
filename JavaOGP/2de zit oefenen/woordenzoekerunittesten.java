@Test (expected = FileNotFoundException.class)
public void testConstructorOnbestaandBestand() throws FileNotFoundException {
	WoordenZoeker zoeker = new WoordenZoeker("onbestaandBestand.txt");
}

@Test
public void testAantal() throws FileNotFoundException {
	WoordenZoeker zoeker = new WoordenZoeker("simpel.txt");
	Assert.assertEquals("Aantal verschillende woorden niet juist geteld", 6, zoeker.aantalVerschillendeWoorden());
}

@Test
public void testAantalEnInlezenEnBewaren() throws FileNotFoundException {
	WoordenZoeker zoeker = new WoordenZoeker("symbolen.txt");
	Assert.assertEquals("Elk stukje teskst (witruimte als scheiding) moet als String ingelzen worden",5,zoeker.aantalVerschillendeWoorden());
	WoordenZoeker zoeker2 = new WoordenZoeker("kleineEnGroteLetters.txt");
	Assert.assertEquals("Gorte letters als kleine behandeldé",1,zoeker2.aantalVerschillendeWoorden());
}

@Test
public void testAlfabetischEersteWoord() throws FileNotFoundException {
	WoordenZoeker zoeker = new WoordenZoeker("woorden.txt");
	Assert.assertEquals("eerste woord (volgens alfabetische volgorde) is niet juist","a",zoeker.alfabetischEersteWoord());
}

@Test
public void testAlfabetischEersteWoordVanLengte() throws FileNotFoundException {
	WoordenZoeker zoeker = new WoordenZoeker("woorden.txt");
	String[] oplossingen = {null,"a","am","age","able","along","action","confess","changing","attribute","consistent","development","fundamentals",null};
	for (int i = 0; i< 13; i++){
		Assert.assertEquals("Eerste woord (volgens alfa volgorde) van lengte "+i+" is niet juist","oplossingen[i],zoeker.alfabetischEersteWoordVanLengte(i));
	}
}