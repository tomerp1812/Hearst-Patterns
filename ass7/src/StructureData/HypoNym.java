package StructureData;

import Others.Counter;

/**
 * @author Tomer Peisikov <\tomerp1812@gmail.com>
 * ID 209549542
 * @version ass7.
 * @since 2022/06/06.
 */
public class HypoNym implements Comparable<HypoNym> {
    private Counter counter;
    private String hypoNym;

    /**
     * constructor of HypoNym.
     * @param str the string of the hypoNym.
     */
    public HypoNym(String str) {
        counter = new Counter(1);
        hypoNym = str;
    }

    /**
     * getter of string of hypoNym.
     * @return a string of hypoNym.
     */
    public String getHypoNym() {
        return hypoNym;
    }

    /**
     * getter of counter.
     * @return the amount of times the hypoNym is being appeared in relation to hypernym.
     */
    public Counter getCounter() {
        return counter;
    }

    /**
     * adds to the counter 1.
     * @param counter adds to the counter by 1.
     */
    public void addCount(Counter counter) {
        counter.setValue(counter.getValue() + 1);
    }

    @Override
    public int compareTo(HypoNym o) {
        if (o.getCounter().getValue() > this.getCounter().getValue()) {
            return 1;
        } else if (o.getCounter().getValue() < this.getCounter().getValue()) {
            return -1;
        } else {
            return this.getHypoNym().compareTo(o.getHypoNym());
        }
    }
}
