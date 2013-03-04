package net.hogedriven.backpaper0.spec;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import org.junit.runner.RunWith;

@RunWith(SpecRunner.class)
public abstract class Specs {

    private final Deque<SpecDef> stack = new LinkedList<>();

    List<SpecDef> specDefs = new ArrayList<>();

    protected void it(String name, Spec spec) {
        SpecDef specDef = new SpecDef(name, spec);
        SpecDef parent = stack.peek();
        if (parent != null) {
            parent.add(specDef);
        } else {
            specDefs.add(specDef);
        }
    }

    protected void describe(String name, Runnable r) {
        SpecDef parent = stack.peek();
        SpecDef specDef = new SpecDef(name, null);
        if (parent != null) {
            parent.add(specDef);
        } else {
            specDefs.add(specDef);
        }
        stack.push(specDef);
        r.run();
        stack.pop();
    }
}
