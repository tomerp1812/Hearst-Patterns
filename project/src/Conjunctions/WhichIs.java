package Conjunctions;

import StructureData.HyperTree;
import StructureData.DiscoverTree;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

/**
 * @author Tomer Peisikov <\tomerp1812@gmail.com>
 * ID 209549542
 * @version ass7.
 * @since 2022/06/06.
 */
public class WhichIs extends Conjunction {
    /**
     * first constructor of WhichIs.
     * @param ht a reference to hyperTree.
     */
    public WhichIs(HyperTree ht) {
        super(ht);
    }

    /**
     * second constructor of WhichIs.
     * @param t a reference to DiscoverTree.
     * @param hypo the lemma.
     */
    public WhichIs(DiscoverTree t, String hypo) {
        super(t, hypo);
    }

    @Override
    public void checkRegex(String line) {
        //the text pattern.
        setTextPattern(Pattern.compile("<np>([^<]+)</np>( ,)? which is"
                + " (an example of |a kind of |a class of )?<np>([^<]+)</np>"));
        setTextMatcher(getTextPattern().matcher(line));
        String hypernym;
        List<String> hypoList = new ArrayList<>();
        //while we find matches.
        while (getTextMatcher().find()) {
            //the first group is the hypernym.
            hypernym = getTextMatcher().group(1);
            //the second match is hypo.
            hypoList.add(getTextMatcher().group(4));
            if (!hypernym.equals("")) {
                if (getHypo() != null) {
                    for (String s : hypoList) {
                        if (getHypo().equals(s)) {
                            //adds to the discover tree a member.
                            getDiscoverTree().addMember(hypernym);
                        }
                    }
                    return;
                }
                //add to the hyperTree a member.
                getHyperTree().addMember(hypernym, hypoList);
            }
        }
    }
}
