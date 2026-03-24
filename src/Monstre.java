public class Monstre extends Entite {

    private int val;

    public Monstre(String nom, int pvmax, int armure, int damage) {
        super(nom, pvmax, armure, damage);
        this.val = (pvmax + armure + damage) / 3;
    }

    @Override
    public void attaquer(Entite cible) {
        System.out.println(nom + " attaque !");
        cible.subirDegats(damage);
    }

    @Override
    public void subirDegats(int degats) {
        pointsDeVie -= Math.max(0, degats - armure);
        if (pointsDeVie < 0) pointsDeVie = 0;
    }

    public int getVal() {
        return val;
    }
}
