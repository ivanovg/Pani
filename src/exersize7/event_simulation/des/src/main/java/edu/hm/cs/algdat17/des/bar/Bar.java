package exersize7.event_simulation.des.src.main.java.edu.hm.cs.algdat17.des.bar;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Panteha on 5/16/2017.
 */
public class Bar {

    private static final Logger LOG = LoggerFactory.getLogger(Bar.class);

    // Zaehler fuer die Kunden, die ein Bier bekommen haben
    private int customersServed = 0;

    // Gesamtwartezeit
    private double waitTime = 0;

    // Zeitpunkt als das Bier bestellt ist
    private List<Double> orderTimes = new ArrayList<Double>();

    private double timeToTap = 420;


    /**
     * Liefert die durchschnittliche Wartezeit.
     *
     * @return Die durchschnittliche Wartezeit.
     */
    int getAverageTime() {
        return (int)waitTime/customersServed;
    }


    /**
     * Fuegt den Bestellzeitpunkt in der Liste mit allen Zeiten
     *
     * @param time Bestellzeitpunkt
     */
    public void orderBier(double time) {
        orderTimes.add(time);
    }

    /**
     * Addiert die Gesammtwartezeit
     *
     * @param time Zeitpunkt, wenn das Bier fetig gezapft ist
     */
    public void receiveBier(double time) {
        waitTime += (time - orderTimes.get(customersServed));
        if (orderTimes.get(customersServed) < customersServed * timeToTap)
            waitTime += customersServed * timeToTap - orderTimes.get(customersServed);
        customersServed++;
    }
}
