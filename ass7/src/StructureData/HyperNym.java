package StructureData;

import Others.Counter;

/**
 * @author Tomer Peisikov <\tomerp1812@gmail.com>
 * ID 209549542
 * @version ass7.
 * @since 2022/06/06.
 */
public class HyperNym implements Comparable<HyperNym> {
    private String hyperNym;
    private Counter counter;

    /**
     * constructor of hyperNym.
     * @param s the string of the hypernym.
     * @param c the amount of time the hypoNym appeared according to the hyper.
     */
    public HyperNym(String s, Counter c) {
        counter = c;
        hyperNym = s;
    }

    /**
     * getter of counter.
     * @return the amount of time the hypoNym appeared according to the hyper.
     */
    public Counter getCounter() {
        return counter;
    }

    /**
     * getter of string of hypernym.
     * @return a string.
     */
    public String getHyperNym() {
        return hyperNym;
    }

    @Override
    public int compareTo(HyperNym o) {
        if (o.getCounter().getValue() > this.getCounter().getValue()) {
            return 1;
        } else if (o.getCounter().getValue() < this.getCounter().getValue()) {
            return -1;
        } else {
            return this.getHyperNym().compareTo(o.getHyperNym());
        }
    }
}
