import java.util.*;

public class text {
Scanner sc=new Scanner(System.in);
    public void intro(){
        System.out.println("tout le monde a une vie definie des la naissance certain seront des hero d'autre des criminel");
        pause(400);
        System.out.println("et vous vous etes un investisseur votre travail mettre des piece sur des combatant et voir qui survit et qui disparaitra");
        pause(400);
        System.out.println("bon tien prend .... lui la billy il sera parfait comme premier combattant pour toi");
        pause(400);
        System.out.println("bon t'attend quoi fonce je croix en toi ");
        this.pointpointpoint();
        System.out.println("bon j'ai compris tu sais pas quoi faire ");
        pause(400);
        System.out.println("pour t'expliquer les base chaque combattant peut se battre pour cela il suffit d'aller a l'arene tu devra y passez souvent pour faire les combat obligatoire ");
        pause(400);
        System.out.println("ensuite chaque combattant peut évoluer en le faisant s'entrainer mais il ne seront pas tous aussi competent  ");
        pause(400);
        System.out.println(" exemple ton goblin attaque deux fois par tour mais est beaucoup moins doué pour encaisser et prendra plus de temps a augmenter sa vie ");
        pause(400);
        System.out.println("en comparaison un kajhite auras énormément de dégât mais sera encores pire que ton goblin pour se renforcer");
        pause(400);
        System.out.println("bref, tu as surement compris les base fait juste attention tu peut acheter de l'equipement a t'es combattant ou en acheter des nouveau pour remplacer t'es ancien combattant");
    }

    private void attendre() {

        String input = sc.nextLine();
        while (!input.isEmpty() && !input.equals(" ")) {
            input = sc.nextLine();
        }
    }
    private void pause(int ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void pointpointpoint(){
        pause(400);
        System.out.println(".");
        pause(300);
        System.out.println("..");
        pause(300);
        System.out.println("...");
        attendre();
    }

    public void afficherActions() {
        attendre();
        System.out.println("=== Choisissez une action ===");
        pause(250);
        System.out.println("1 - aller a l'arene");
        pause(250);
        System.out.println("2 - entrainer l'endurance");
        pause(250);
        System.out.println("3 - entrainer la force");
        pause(250);
        System.out.println("4 - soigné");
        pause(250);
        System.out.println("5 - Attaque spéciale");
    }

    public void action(Arene a,Combattant t) throws InterruptedException {
        int choix=sc.nextInt();

        switch (choix) {
            case 1:
                pause(500);
                System.out.println("vous aller a l'arene");
                a.combat();
                break;

            case 2:
                pause(500);
                System.out.println("entrainer l'endurance");
                t.afficherGuerriers();
                System.out.printf("qui voulez vous entrainer");
                t.upendu(sc.nextInt());
                break;

            case 3:
                System.out.println("Action 3 : Utiliser un objet");
                // code pour utiliser un objet
                break;

            case 4:
                System.out.println("Action 4 : Fuir");
                // code pour fuir
                break;

            case 5:
                System.out.println("Action 5 : Spécial");
                // code pour une action spéciale
                break;

            default:
                System.out.println("Choix invalide !");
                break;
        }
    }
}
