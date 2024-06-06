package Conjunctions;

import StructureData.HyperTree;
import StructureData.DiscoverTree;

import java.util.regex.Pattern;

/**
 * @author Tomer Peisikov <\tomerp1812@gmail.com>
 * ID 209549542
 * @version ass7.
 * @since 2022/06/06.
 */
public class SuchAsIncEsp extends Conjunction {
    /**
     * first constructor of SuchAsIncEsp.
     * @param ht reference to HyperTree.
     */
    public SuchAsIncEsp(HyperTree ht) {
        super(ht);
    }

    /**
     * second constructor of SuchAsIncEsp.
     * @param t reference to DiscoverTree.
     * @param hypo the lemma.
     */
    public SuchAsIncEsp(DiscoverTree t, String hypo) {
        super(t, hypo);
    }

    /**
     * checks if the regex is in the line.
     * @param line a line.
     */
    public void checkRegex(String line) {
        setTextPattern(Pattern.compile("<np>([^<]*)</np>( ,)?\\s(such as|including|especially)\\s"
                + "<np>([^<]+)</np>\\s(, <np>([^<]+)</np> )*((, )?(and |or )<np>([^<]+)</np>)?"));
        super.checkRegex(line);
    }

}

