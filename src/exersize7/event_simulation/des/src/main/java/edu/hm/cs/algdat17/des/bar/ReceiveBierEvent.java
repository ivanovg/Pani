package exersize7.event_simulation.des.src.main.java.edu.hm.cs.algdat17.des.bar;

import exersize7.event_simulation.des.src.main.java.edu.hm.cs.algdat17.des.generic.AbstractSimulator;
import exersize7.event_simulation.des.src.main.java.edu.hm.cs.algdat17.des.generic.TimedEvent;

/**
 * Created by Panteha on 5/16/2017.
 */
public class ReceiveBierEvent extends TimedEvent<Bar> {

    public ReceiveBierEvent(double time) {
        super(time);
    }

    @Override
    protected void execute(AbstractSimulator<Bar> simulator, Bar bar) {
        bar.receiveBier(getTime());
    }
}
