package fr.iut.editeur.document;

public class Document {

    private String texte;

    public Document() {
        this.texte = "";
    }
	
    public String getTexte() {
        return texte;
    }

    public void setTexte(String texte) {
        this.texte = texte;
    }

    public void ajouter(String texte) {
        this.texte += texte;
    }

    @Override
    public String toString() {
        return this.texte;
    }
    public void remplacer(int start, int end, String remplacement) {
        String leftPart = texte.substring(0, start);
        String rightPart = texte.substring(end);
        texte = leftPart + remplacement + rightPart;
    }
    public void majuscules(int start, int end){
        String t = texte.substring(start, end);
        t = t.toUpperCase();
        remplacer(start,end,t);
    }
    public void supprimer(int start, int end){
        remplacer(start, end, "");
    }
    public void clear(){
        supprimer(0, texte.length());
    }
}
