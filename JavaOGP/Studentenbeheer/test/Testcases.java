/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.FileNotFoundException;
import java.util.Set;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import studentenbeheer.*;
/**
 *
 * @author tiwi
 */
public class Testcases {
    
    public Testcases() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    
    @Test
    public void testBestandInlezenSpecifiekeCursus() throws FileNotFoundException {
        StudentenDAO dao = new StudentenDAO("cursussen.txt");
        Cursus c = dao.getCursus("Signalen en systemen");
        assertEquals("cursus 'Signalen en systemen' niet ingelezen?","Signalen en systemen",c.getNaam());
        assertEquals("cursus 'Signalen en systemen' niet ingelezen?",6,c.getAantalStudiepunten());
    }
    
    @Test
    public void testBestandInlezenAlleCursussen() throws FileNotFoundException {
        StudentenDAO dao = new StudentenDAO("cursussen.txt");
        int lengteAlleCursusnamen = dao.getCursussenToString().length();
        assertTrue("cursusnamen allemaal juist?", 540 <= lengteAlleCursusnamen && lengteAlleCursusnamen <= 580);
    }

    @Test
    public void testDocentZoekenOpNaam() throws FileNotFoundException {
        StudentenDAO dao = new StudentenDAO("cursussen.txt");
        Docent docentGevonden = dao.getDocent("Joris Moreau");
        Docent docentGezocht = new Docent("Joris", "Moreau");
        assertEquals("Docent werd niet herkend op naam en voornaam.", docentGezocht, docentGevonden);
    }
    
    @Test
    public void testInfoCursussenEnDocentenGelinkt() throws FileNotFoundException {
        StudentenDAO dao = new StudentenDAO("cursussen.txt");
        Set<Cursus> cursussen = dao.getCursussenVanDocent("Joris Moreau");
        assertEquals("docent is cursussen kwijt?",4,cursussen.length);
    }
    
    @Test
    public void testBeveiliging() throws FileNotFoundException {
        StudentenDAO dao = new StudentenDAO("cursussen.txt");
        Set<Cursus> cursussen = dao.getCursussenVanDocent("Paul Devos");
        assertEquals("docent Paul Devos geeft 1 cursus",1,cursussen.size());
        cursussen[0].setDocent(new Docent("Anonymous","Ickx"));
        Set<Cursus> cursussenNaAanpassing = dao.getCursussenVanDocent("Paul Devos");
        String docentVanCursusVanPaulDevos = cursussenNaAanpassing[0].getDocent().getAchternaam();
        assertEquals("docent Paul Devos gaf 1 cursus - na aanpassing niet meer?","Devos",docentVanCursusVanPaulDevos);        
    }
    
}
