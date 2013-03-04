package net.hogedriven.backpaper0.spec.example;

import static net.hogedriven.backpaper0.spec.Expect.*;
import net.hogedriven.backpaper0.spec.Specs;

public class CalcSpecs extends Specs{{
    
    it("1 足す 2 は 3", () -> {
        expect(() -> 1 + 2).toEqual(3);
    });

    describe("割り算", () -> {
        it("6 割る 3 は 2", () -> {
            expect(() -> 6 / 3).toEqual(2);
        });

        it("1 割る 0 は例外", () -> {
            expect(() -> 1 / 0).toThrow(ArithmeticException.class);
        });
    });

}}
