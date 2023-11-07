package fr.iut.editeur.commande;

import fr.iut.editeur.document.Document;
public class CommandeRemplacer extends CommandeDocument {
    public CommandeRemplacer(Document document, String[] parameters) {
        super(document, parameters);
    }
    @Override
    public void executer() {
        if(parameters.length < 4) {
            System.err.println("Format attendu : remplacer;nombre;nombre;texte");
            return;
        }
        String texte = parameters[3];
        int para1 = Integer.parseInt(parameters[1]);
        int para2 = Integer.parseInt(parameters[2]);
        this.document.remplacer(para1, para2,texte);
        super.executer();
    }

}
