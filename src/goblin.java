public class goblin extends Entite {



    public goblin(String nom, int pvmax, int armure, int damage) {
        super( nom,pvmax, armure, damage);

    }

    public goblin() {
        super("Billy",25,1,3);

    }


    public void attaquer(Entite cible) {
        System.out.println(getNom() + " attaque deux fois !");
        cible.subirDegats(getDamage());
        cible.subirDegats(getDamage());
    }


    @Override
    public void setPvmax(int nouveauPvmax) {

        int ancien = this.pvmax;

        // Si pas d'augmentation, on ne fait rien
        if (nouveauPvmax <= ancien) {
            return;
        }
        int augmentation = nouveauPvmax - ancien;
        // Le goblin ne gagne que 80% de l’augmentation
        int gainReel = (int)(augmentation * 0.8);
        int nouveau = ancien + gainReel;
        this.pvmax = nouveau;
        // Ajuster les PV actuels si besoin
        if (pointsDeVie > nouveau) {
            pointsDeVie = nouveau;
        }
}
}

