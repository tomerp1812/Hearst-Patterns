package Setup;

import Conjunctions.As;
import Conjunctions.SuchAsIncEsp;
import Conjunctions.WhichIs;
import StructureData.HyperTree;
import StructureData.DiscoverTree;

/**
 * @author Tomer Peisikov <\tomerp1812@gmail.com>
 * ID 209549542
 * @version ass7.
 * @since 2022/06/06.
 */
public class SentenceSetup {
    private As as;
    private SuchAsIncEsp suchAsIncEsp;
    private WhichIs whichIs;
    private HyperTree hyperTree;
    private DiscoverTree tree;
    private String hypo;

    /**
     * first constructor of SentenceSetup.
     * @param ht a reference to HyperTree.
     */
    public SentenceSetup(HyperTree ht) {
        this.hyperTree = ht;
        this.as = new As(hyperTree);
        this.suchAsIncEsp = new SuchAsIncEsp(hyperTree);
        this.whichIs = new WhichIs(hyperTree);
    }

    /**
     * second constructor of SentenceSetup.
     * @param t a reference to the DiscoverTree.
     * @param s the lemma.
     */
    public SentenceSetup(DiscoverTree t, String s) {
        tree = t;
        hypo = s;
        this.as = new As(tree, hypo);
        this.suchAsIncEsp = new SuchAsIncEsp(tree, hypo);
        this.whichIs = new WhichIs(tree, hypo);
    }

    /**
     * the configure checks if a conjunction is being contained
     * in the line, if yes it calls the checkRegex method.
     * if hypo isn't null we know that it means we run the DiscoverHypernym
     * program and so we need to check if the lemma is in the line, if not
     * just return from the method.
     * @param line a line we check.
     */
    public void configure(String line) {
        if (hypo != null) {
            if (!line.contains(hypo)) {
                return;
            }
        }
        //only if the line contains one of those conjunctions we call the checkRegex method.
        if (line.contains("such as") || line.contains("including") || line.contains("especially")) {
            suchAsIncEsp.checkRegex(line);
        }
        if (line.contains("as") && line.contains("such")) {
            as.checkRegex(line);
        }
        if (line.contains("which is")) {
            whichIs.checkRegex(line);
        }

    }
}
