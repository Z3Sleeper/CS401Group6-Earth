package crm;

import java.util.function.Predicate;

public class Rule {
    private String name;
    private Predicate<PlayerBoard> p1Predicate;

    public String getName(){
        return name;
    }

    public Rule(String name, Predicate<PlayerBoard> p1Predicate) {
        this.name = name;
        this.p1Predicate = p1Predicate;
    }

    public boolean pointsGained(PlayerBoard p1) {
        return p1Predicate.test(p1);
    }
}