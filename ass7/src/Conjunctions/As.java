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
public class As extends Conjunction {
    /**
     * first constructor of As.
     * As extends Conjunction.
     *
     * @param ht reference to the HyperTree.
     */
    public As(HyperTree ht) {
        super(ht);
    }

    /**
     * second constructor of As.
     * As extends conjunction.
     *
     * @param t    reference to the DiscoverTree.
     * @param hypo the lemma.
     */
    public As(DiscoverTree t, String hypo) {
        super(t, hypo);
    }

    /**
     * @param line a line to check.
     */
    public void checkRegex(String line) {
        // a regex of such + NP + as .
        setTextPattern(Pattern.compile("such <np>([^<]+)</np> as <np>([^<]+)</np> "
                + "(, <np>([^<]+)</np> )*((, )?(and |or )<np>([^<]+)</np>)?"));
        //does the job in Conjunction.
        super.checkRegex(line);
    }
}

