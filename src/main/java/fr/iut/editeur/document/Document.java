package fr.iut.editeur.document;

import fr.iut.editeur.commande.CommandeDocument;
import fr.iut.editeur.commande.CommandeMajuscule;

import java.util.ArrayList;
import java.util.List;

/**
 * Description de la classe
 */
public class Document {

    private String texte;
    private final List<String> historique ;
    private List<String> rajouter;

    public Document() {
        this.texte = "";
        this.historique = new ArrayList<>();
        this.rajouter = new ArrayList<>();
    }

    public List<String> getRajouter() {
        return rajouter;
    }

    public List<String> getHistorique() {
        return historique;
    }

    public String getTexte() {
        return texte;
    }

    public void ajoutHistorique(String st) {
        historique.add(st);
    }
    public void ajoutRajouter(String st) {
        rajouter.add(st);
    }

    public void setTexte(String texte) {
        this.texte = texte;
    }

    public void ajouter(String texte) {
        this.texte += texte;
        ajoutHistorique(getTexte());
        rajouter = new ArrayList<>();
    }

    @Override
    public String toString() {
        return this.texte;
    }
    public void remplacer(int start, int end, String remplacement) {
        String leftPart = texte.substring(0, start);
        String rightPart = texte.substring(end);
        texte = leftPart + remplacement + rightPart;
        ajoutHistorique(getTexte());
        rajouter = new ArrayList<>();
    }
    /**
     * Description de la méthode
     * Il peut être intéressant de consulter la méthode {@link CommandeMajuscule#executer()} ()} !
     * @param start début du texte à mettre en majuscule
     * @param end fin du texte à mettre en majuscule
     */
    public void majuscules(int start, int end){
        String t = texte.substring(start, end);
        t = t.toUpperCase();
        remplacer(start,end,t);
        ajoutHistorique(getTexte());
        rajouter = new ArrayList<>();
    }
    public void inserer(int start, String texte){
        String fin = this.texte.substring(start);
        supprimer(start,  this.texte.length());
        ajouter(texte);
        ajouter(fin);
        ajoutHistorique(getTexte());
        rajouter = new ArrayList<>();
    }

    public void supprimer(int start, int end){
        remplacer(start, end, "");
        ajoutHistorique(getTexte());
        rajouter = new ArrayList<>();
    }
    public void clear(){
        supprimer(0, texte.length());
        ajoutHistorique(getTexte());
        rajouter = new ArrayList<>();
    }

    public void undo(){
        if (!historique.isEmpty()) {
            ajoutRajouter(historique.remove(historique.size()-1));
            texte = historique.get(historique.size()-1);
        }
    }

    public void redo(){
        if(!rajouter.isEmpty()) {
            ajoutHistorique(rajouter.remove(rajouter.size() - 1));
            texte = historique.get(historique.size() - 1);
        }
    }
}
