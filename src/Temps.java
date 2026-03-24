public class Temps {
    int temps;
    int cycles;
    int limite;
    boolean comb;



    public Temps() {
        this.temps = 0;
        this.cycles = 0;
        this.limite = 0;
    }

    public void incTemps() {
        if (temps > 4) {
            cycles++;
            temps = 0;
        }else if (comb = false) {
            temps++;
        } else if (comb =true) {
        }
    }

    public void resetTemps() {
        temps = 0;
        cycles = 0;
        limite+=2;
        comb = false;
    }

    public boolean Temps() {
        return comb;
    }

    public int getTemps() {
        return temps;
    }

    private void setTemps(int temps) {
        if (temps < 0) {
            temps = 0;
        }
        if (temps > 4) {
            cycles++;
            this.temps = 0;
        }else{
            this.temps = temps;
        }
    }

    public int getLimite() {
        return limite;
    }

    public void setLimite(int limite) {
        this.limite = limite;
    }

    public int getCycles() {
        return cycles;
    }

    public void setCycles(int cycles) {
        if (cycles < 0) {
            cycles = 0;
        }
        if (cycles > getLimite()) {
            comb = true;
        }else{
            this.cycles = cycles;
    }
    }
}
