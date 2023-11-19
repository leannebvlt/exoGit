package fr.iut.editeur.document;

import fr.iut.editeur.commande.CommandeDocument;
import junit.framework.TestCase;

public class DocumentTest extends TestCase {
    public void testcommandeMajuscule(){
        Document doc = new Document();
        doc.ajouter("coucou");
        doc.majuscules(2, 4);
        assertEquals("coUCou",doc.getTexte());
    }

    public void testcommandeRemplacer(){
        Document doc = new Document();
        doc.ajouter("coucou");
        doc.remplacer(2,4, "toi");
        assertEquals("cotoiou",doc.getTexte());
    }

    public void testcommandeSupprimer(){
        Document doc = new Document();
        doc.ajouter("coucou toi");
        doc.supprimer(6, 9);
        assertEquals("coucoui",doc.getTexte());
    }
}


