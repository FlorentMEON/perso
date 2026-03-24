public abstract class Entite {
    protected String nom;
    protected int pointsDeVie;
    protected int pvmax;
    protected int armure;
    protected int damage;

    public Entite(String nom, int pvmax, int armure, int damage) {
        this.nom = nom;
        this.pointsDeVie = pvmax;
        this.pvmax = pvmax;
        this.armure = armure;
        this.damage = damage;
    }

    public void attaquer(Entite cible) {
        System.out.println(nom + " attaque " + cible.nom + " !");
        cible.subirDegats(damage);
    }

    public void subirDegats(int degats) {
        int dmg = Math.max(0, degats - armure);
        pointsDeVie -= dmg;
        if (pointsDeVie < 0) pointsDeVie = 0;

        System.out.println(nom + " subit " + dmg + " dégâts. PV restants : " + pointsDeVie);
    }

    public boolean ko() {
        return pointsDeVie <= 0;
    }

    public String getNom() { return nom; }
    public int getPointsDeVie() { return pointsDeVie; }

    public void setPvmax(int pvmax) {
        this.pvmax = pvmax;
    }

    public int getPvmax() {
        return pvmax;
    }

    public void setPointsDeVie(int pointsDeVie) {
        if (pointsDeVie < 0) pointsDeVie = 0;
        if (this.pointsDeVie >this.getPvmax()) this.pointsDeVie = this.getPvmax();
        else this.pointsDeVie = pointsDeVie;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getArmure() {
        return armure;
    }

    public void setArmure(int armure) {
        this.armure = armure;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
}
