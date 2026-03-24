public class Personnage extends Entite {

    public Personnage(String nom) {
        super(nom, (int)(Math.random()*10)+1, 0, (int)(Math.random()*10));
    }
    public Personnage(String nom,int pv,int degat) {
        super(nom, pv, 0, degat);
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

    public boolean ko() {
        return pointsDeVie <= 0;
    }

    @Override
    public String toString() {
        return "combatant{" +
                "nom='" + nom + '\'' +
                ", pointsDeVie=" + pointsDeVie +
                '}';
    }
}
