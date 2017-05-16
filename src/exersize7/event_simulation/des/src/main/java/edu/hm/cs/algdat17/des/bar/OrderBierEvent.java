package exersize7.event_simulation.des.src.main.java.edu.hm.cs.algdat17.des.bar;

import exersize7.event_simulation.des.src.main.java.edu.hm.cs.algdat17.des.generic.AbstractSimulator;
import exersize7.event_simulation.des.src.main.java.edu.hm.cs.algdat17.des.generic.TimedEvent;

/**
 * Created by Panteha on 5/16/2017.
 */
public class OrderBierEvent extends TimedEvent<Bar> {

    public OrderBierEvent(double time) {
        super(time);
    }

    @Override
    protected void execute(AbstractSimulator<Bar> simulator, Bar bar) {
        // Aenderung am Zustand: Kunde bestellt Bier
        bar.orderBier(getTime());

        // Kunde bekommt Bier erzeugen (nach 7 Minuten = 420 Sekunden)
        simulator.insert(new ReceiveBierEvent(getTime() + 420));

        // Bestellen von naechstes Bier (nach durchschnittlich 8 Minuten, normalverteilt, Standardabweichung 2 Minuten)
        simulator.insert(new OrderBierEvent(getTime() + (simulator.getRandom().nextGaussian() * 120 + 480)));
    }
}
