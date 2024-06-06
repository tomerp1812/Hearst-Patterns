package Conjunctions;

import StructureData.HyperTree;
import StructureData.DiscoverTree;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Tomer Peisikov <\tomerp1812@gmail.com>
 * ID 209549542
 * @version ass7.
 * @since 2022/06/06.
 */
public class Conjunction implements Regex {
    private Boolean isFirst;
    private Pattern textPattern;
    private Matcher textMatcher;
    private Pattern linePattern;
    private Matcher lineMatcher;
    private HyperTree hyperTree;
    private DiscoverTree discoverTree;
    private String hypo;
    private Boolean isHypernymDatabase;

    /**
     * first protected constructor of Conjunction.
     *
     * @param ht reference to HyperTree.
     */
    protected Conjunction(HyperTree ht) {
        setHyperTree(ht);
        setFirst(true);
        setIsHypernymDatabase(true);
    }

    /**
     * second protected constructor of Conjunction.
     *
     * @param t reference to DiscoverTree.
     * @param s the lemma.
     */
    protected Conjunction(DiscoverTree t, String s) {
        setDiscoverTree(t);
        setFirst(true);
        setHypo(s);
        setIsHypernymDatabase(false);
    }

    /**
     * setter of isHypernymDatabase.
     *
     * @param isHypernymDatabase true if creating a data base of hypernyms.
     */
    public void setIsHypernymDatabase(Boolean isHypernymDatabase) {
        this.isHypernymDatabase = isHypernymDatabase;
    }

    /**
     * getter of isHypernymDatabase.
     *
     * @return true if we create database of hypernyms.
     */
    public Boolean getIsHypernymDatabase() {
        return isHypernymDatabase;
    }

    /**
     * setter of first hypernym.
     *
     * @param first to know if to add hypernym or hypoNym.
     */
    public void setFirst(Boolean first) {
        isFirst = first;
    }

    /**
     * getter of First.
     *
     * @return boolean.
     */
    public Boolean getFirst() {
        return isFirst;
    }

    /**
     * setter of text pattern.
     *
     * @param textPattern sets Pattern for the text.
     */
    public void setTextPattern(Pattern textPattern) {
        this.textPattern = textPattern;
    }

    /**
     * getter of TextPattern.
     *
     * @return Pattern.
     */
    public Pattern getTextPattern() {
        return textPattern;
    }

    /**
     * setter of textMatcher.
     *
     * @param textMatcher set matcher.
     */
    public void setTextMatcher(Matcher textMatcher) {
        this.textMatcher = textMatcher;
    }

    /**
     * getter of text matcher.
     *
     * @return Matcher.
     */
    public Matcher getTextMatcher() {
        return textMatcher;
    }

    /**
     * setter of linePattern.
     *
     * @param linePattern setter of Pattern.
     */
    public void setLinePattern(Pattern linePattern) {
        this.linePattern = linePattern;
    }

    /**
     * getter of Pattern.
     *
     * @return Pattern.
     */
    public Pattern getLinePattern() {
        return linePattern;
    }

    /**
     * setter of lineMatcher.
     *
     * @param lineMatcher sets the line matcher.
     */
    public void setLineMatcher(Matcher lineMatcher) {
        this.lineMatcher = lineMatcher;
    }

    /**
     * getter of LineMatcher.
     *
     * @return Matcher.
     */
    public Matcher getLineMatcher() {
        return lineMatcher;
    }

    /**
     * setter of hyperTree.
     *
     * @param hyperTree a reference to hyperTree.
     */
    public void setHyperTree(HyperTree hyperTree) {
        this.hyperTree = hyperTree;
    }

    /**
     * getter of HyperTree.
     *
     * @return a reference to hyperTree.
     */
    public HyperTree getHyperTree() {
        return hyperTree;
    }

    /**
     * setter of DiscoverTree.
     *
     * @param tree reference to DiscoverTree.
     */
    public void setDiscoverTree(DiscoverTree tree) {
        this.discoverTree = tree;
    }

    /**
     * getter of DiscoverTree.
     *
     * @return a reference to DiscoverTree.
     */
    public DiscoverTree getDiscoverTree() {
        return discoverTree;
    }

    /**
     * setter of Hypo.
     *
     * @param hypo lemma.
     */
    public void setHypo(String hypo) {
        this.hypo = hypo;
    }

    /**
     * getter of Hypo.
     *
     * @return String.
     */
    public String getHypo() {
        return hypo;
    }

    @Override
    public void checkRegex(String line) {
        //sets the line pattern.
        setLinePattern(Pattern.compile("<np>([^<]+)</np>"));
        setTextMatcher(getTextPattern().matcher(line));
        String hypernym = "";
        List<String> hypoList = new ArrayList<>();
        //while text matcher finds the pattern.
        while (getTextMatcher().find()) {
            //sets the lineMatcher to cut the line.
            setLineMatcher(getLinePattern().matcher(getTextMatcher().group(0)));
            setFirst(true);
            //while the line matcher finds patterns.
            while (getLineMatcher().find()) {
                if (getFirst()) {
                    hypernym = getLineMatcher().group(1);
                } else {
                    hypoList.add(getLineMatcher().group(1));
                }
                setFirst(false);
            }
            if (!hypernym.equals("")) {
                //if we work on the database assignment.
                if (getIsHypernymDatabase()) {
                    //add member to hyperTree.
                    getHyperTree().addMember(hypernym, hypoList);
                    //if we work on discovering Hypernym.
                } else {
                    for (String s : hypoList) {
                        if (getHypo().equals(s)) {
                            //add member to the discoverTree.
                            getDiscoverTree().addMember(hypernym);
                        }
                    }
                }
            }
        }
    }
}
