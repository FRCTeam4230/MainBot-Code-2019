package org.team4230.lib.loop;

import edu.wpi.first.wpilibj.Notifier;

import java.util.List;

public class LoopBundle implements Runnable {

    private List<LoopI> _loops;
    private Notifier _notifier;
    private double _period;

    public LoopBundle(double period) {
        _period = period;
        _notifier = new Notifier(execute_loops);
    }

    private Runnable execute_loops = new Runnable() {
        @Override
        public void run() {
            for(LoopI loop : _loops) {
                loop.execute();
            }
        }
    };

    @Override
    public void run() {
        for(LoopI loop : _loops) {
            loop.onStart();
        }
        _notifier.startPeriodic(_period);
    }

    public void add(LoopI loop) {
        _loops.add(loop);
    }
}
