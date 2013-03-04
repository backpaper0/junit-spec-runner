package net.hogedriven.backpaper0.spec;

import org.junit.runner.Description;
import org.junit.runner.Runner;
import org.junit.runner.notification.RunNotifier;

public class SpecRunner extends Runner {

    private final Specs specs;

    public SpecRunner(Class<? extends Specs> specsClass) throws InstantiationException, IllegalAccessException {
        specs = specsClass.newInstance();
    }

    @Override
    public Description getDescription() {
        Description description = Description.createSuiteDescription(specs.getClass());
        for (SpecDef specDef : specs.specDefs) {
            specDef.addChildTo(description);
        }
        return description;
    }

    @Override
    public void run(RunNotifier notifier) {
        for (SpecDef specDef : specs.specDefs) {
            specDef.run(notifier);
        }
    }
}
