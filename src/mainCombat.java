public class mainCombat {
    public static void main(String[] args) throws InterruptedException {
        Entite m = new Monstre("Gorbz", 4, 0, 1);
        Entite p = new goblin("Billy", 6,0, 1);
        Combattant c = new Combattant();
        c.ajouterGuerrierFirst(p);
        text t = new text();
        //t.intro();
        while (c.taille()>0){
        t.afficherActions();
        t.action(new Arene(p, m),c);


        }
    }
}

