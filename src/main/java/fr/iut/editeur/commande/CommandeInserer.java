package fr.iut.editeur.commande;
import fr.iut.editeur.document.Document;
public class CommandeInserer extends CommandeDocument{
    public CommandeInserer(Document document, String[] parameters) {
        super(document, parameters);
    }
    @Override
    public void executer() {
        if(parameters.length < 3) {
            System.err.println("Format attendu : inserer;debut;texte");
            return;
        }
        int debut = Integer.parseInt(parameters[1]); //index debut
        String texte = parameters[2]; //index fin
        this.document.inserer(debut, texte);
        super.executer();
    }
}
