package org.alo.greenride;

import java.util.Optional;
import java.util.ArrayList;
import java.util.List;

/**
 * Eine Verleihstation von GreenRide.
 *
 *   Station  1 -------- 0..*  Fahrrad
 */
public class Station {

    private String name;
    private String adresse;

    private List<Fahrrad> fahrraeder = new ArrayList<>();

    public Station(String name, String adresse) {
        this.name = name;
        this.adresse = adresse;
    }

    /**
     * Nimmt ein Fahrrad an dieser Station auf.
     * Traegt die Beziehung in beiden Objekten ein - nur hier, nirgends sonst.
     */
    public void fahrradAufnehmen(Fahrrad fahrrad) {
        fahrraeder.add(fahrrad);
        fahrrad.setStation(this);
    }

    public void fahrraederAusgeben() {
        System.out.println("Fahrraeder an Station " + name + ":");
        for (Fahrrad f : fahrraeder) {
            System.out.println("  " + f.getKennung() + " (" + f.getModell() + ")");
        }
    }

    /**
     * @param kennung findet das Fahrrad anhand der kennung
     *
     * @return optional das Fahrrad oder null
     *
     * @throws IllegalArgumentException gibt Optional.empty zurrück
     * */
    public Optional<Fahrrad> findeFahrrad(String kennung) {
        for (Fahrrad f : fahrraeder) {
            if (f.getKennung().equals(kennung)) {
                return Optional.of(f);   //gibt Fahrradkennung zurück
            }
        }
        return Optional.empty();    //gibt NULL zurück
    }


    /**
     *
     * @param modell
     * @return ein List von typ Fahrrad
     */
    public List<Fahrrad> findeFahrraederNachModell(String modell) {
        List<Fahrrad> gefunden = new ArrayList<>();
        for (Fahrrad f : fahrraeder) {
            if (f.getModell().equals(modell)) {
                gefunden.add(f);
            }
        }
        return gefunden;
    }

    public String getName()    { return name; }
    public String getAdresse() { return adresse; }

    public List<Fahrrad> getFahrraeder() { return fahrraeder; }
}
