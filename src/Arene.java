public class Arene {
    Entite e1;
    Entite e2;

    public Arene(Entite e1, Entite e2) {
        this.e1 = e1;
        this.e2 = e2;
    }

    public int combat() throws InterruptedException {
        while (!e1.ko() && !e2.ko()) {
            e1.attaquer(e2);
            Thread.sleep(100);
            if (e2.ko()) break;
            e2.attaquer(e1);
        }

        if (e1.ko()) {
            System.out.println(e1.getNom() + " est mort");
            return 0;
        } else {
            System.out.println(e2.getNom() + " est mort");
            return 1;
        }
    }
}
