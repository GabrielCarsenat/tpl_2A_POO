package strategie;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import carte.Incendie;
import simulation.DonneesSimulation;
import simulation.Simulateur;

/**
 * Chef pompier abstrait : il n'est pas sur la carte et décide de
 * l'affectation des robots aux incendies..
 */

public abstract class ChefPompier {

    protected final DonneesSimulation donnees;

    protected final Simulateur simulateur;

    protected final Set<Incendie> incendiesAffectes = new HashSet<>();

    protected ChefPompier(DonneesSimulation donnees, Simulateur simulateur) {
        this.donnees = donnees;
        this.simulateur = simulateur;
    }

    public abstract void decider(long date);

    // retourne les incendies encore actifs et non affectés
    protected List<Incendie> incendiesLibres() {
        List<Incendie> libres = new ArrayList<>();
        for (Incendie inc : donnees.getIncendies()) {
            if (!inc.estEteint() && !incendiesAffectes.contains(inc)) {{
                libres.add(inc);
            }
        }
        return libres;
    }

    /**
     * Indique qu'un incendie n'est plus affecté (par exemple s'il reste
     * du feu après la mission d'un robot) pour qu'il soit reproposé.
     * @param inc l'incendie à libérer
     */
    public void liberer(Incendie inc) {
        incendiesAffectes.remove(inc);
    }
}