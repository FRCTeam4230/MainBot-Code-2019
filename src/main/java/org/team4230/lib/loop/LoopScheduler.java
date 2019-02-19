package org.team4230.lib.loop;

import java.util.HashMap;

public class LoopScheduler {

    private HashMap<Double, LoopBundle> loopBundles;

    public LoopScheduler() {
        loopBundles = new HashMap<Double, LoopBundle>();
    }

    public void addLoop(LoopI loop, double period) {
        if(loopBundles.containsKey(period)) {
            loopBundles.get(period).add(loop);
        } else {
            LoopBundle bundle = new LoopBundle(period);
            bundle.add(loop);
            loopBundles.put(period, bundle);
        }
    }
}
