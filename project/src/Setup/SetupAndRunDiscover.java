package Setup;

import Others.IO;
import StructureData.DiscoverTree;

import java.util.Locale;

/**
 * @author Tomer Peisikov <\tomerp1812@gmail.com>
 * ID 209549542
 * @version ass7.
 * @since 2022/06/06.
 */
public class SetupAndRunDiscover {
    private String dir;
    private String hypo;
    private DiscoverTree tree;
    private SentenceSetup sentenceSetup;
    private IO io;

    /**
     * constructor of SetupAndRunDiscover.
     *
     * @param args array of strings. directory and lemma.
     */
    public SetupAndRunDiscover(String[] args) {
        dir = args[0];
        hypo = args[1].toLowerCase(Locale.ROOT);
        tree = new DiscoverTree();
        sentenceSetup = new SentenceSetup(tree, hypo);
        io = new IO(sentenceSetup, dir);
    }

    /**
     * runs all the input files. if the tree is still empty print that
     * the lemma doesn't exist in the corpus. otherwise sort and print all the appearances.
     */
    public void run() {
        io.inputFiles();
        if (tree.getTreeMap().size() == 0) {
            System.out.println("The lemma doesn't appear in the corpus.");
        } else {
            tree.sortTree();
            for (int i = 0; i < tree.getTreeList().size(); i++) {
                //prints all the hypernyms and the amount times the lemma is appeared in this hyper.
                System.out.println((tree.getTreeList().get(i).getHyperNym() + ": ("
                        + tree.getTreeList().get(i).getCounter().getValue() + ")"));
            }
        }
    }
}
