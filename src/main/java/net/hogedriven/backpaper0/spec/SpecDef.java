package net.hogedriven.backpaper0.spec;

import java.util.ArrayList;
import java.util.List;
import org.junit.runner.Description;
import org.junit.runner.notification.Failure;
import org.junit.runner.notification.RunNotifier;

public class SpecDef {

    private Spec spec;

    private Description description;

    private List<SpecDef> specDefs = new ArrayList<>();

    public SpecDef(String name, Spec spec) {
        this.spec = spec;
        description = Description.createSuiteDescription(name);
    }

    public void add(SpecDef specDef) {
        specDef.addChildTo(description);
        specDefs.add(specDef);
    }

    public void addChildTo(Description parentDescription) {
        parentDescription.addChild(description);
    }

    public void run(RunNotifier notifier) {
        if (spec != null) {
            notifier.fireTestStarted(description);
            try {
                spec.run();
            } catch (Exception e) {
                Failure failure = new Failure(description, e);
                notifier.fireTestFailure(failure);
            } finally {
                notifier.fireTestFinished(description);
            }
        }
        for (SpecDef specDef : specDefs) {
            specDef.run(notifier);
        }
    }
}
