public class nain extends Entite {

    public nain(String nom, int pvmax, int armure, int damage) {
        super( nom, pvmax, armure,damage);

    }

    public nain() {
        super("Billy",25,1,3);

    }


    public void attaquer(Entite cible) {
        System.out.println(getNom() + " attaque !");
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
        // Le goblin ne gagne que 50% de l’augmentation
        int gainReel = (int)(augmentation * 0.5);
        int nouveau = ancien + gainReel;
        this.pvmax = nouveau;
        // Ajuster les PV actuels si besoin
        if (pointsDeVie > nouveau) {
            pointsDeVie = nouveau;
        }
    }

    @Override
    public void setDamage(int damage) {
        int ancien = this.damage;

        // Si pas d'augmentation, on ne fait rien
        if (damage <= ancien) {
            return;
        }
        int augmentation = damage - ancien;
        // Le goblin ne gagne que 50% de l’augmentation
        int gainReel = (int)(augmentation * 2);
        int nouveau = ancien + gainReel;
        this.damage = nouveau;
        // Ajuster les PV actuels si besoin
        if (damage > nouveau) {
            damage = nouveau;
        }
    }
}
