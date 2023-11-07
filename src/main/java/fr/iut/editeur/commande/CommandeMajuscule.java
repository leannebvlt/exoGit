package fr.iut.editeur.commande;

import fr.iut.editeur.document.Document;
public class CommandeMajuscule extends CommandeDocument {
    public CommandeMajuscule(Document document, String[] parameters) {
        super(document, parameters);
    }
    @Override
    public void executer() {
        if(parameters.length < 3) {
            System.err.println("Format attendu : majuscules;depart;fin");
            return;
        }
        int para1 = Integer.parseInt(parameters[1]);
        int para2 = Integer.parseInt(parameters[2]);
        this.document.majuscules(para1, para2);
        super.executer();
    }
}
