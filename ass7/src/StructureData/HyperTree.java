package StructureData;


import java.util.List;
import java.util.TreeMap;

/**
 * @author Tomer Peisikov <\tomerp1812@gmail.com>
 * ID 209549542
 * @version ass7.
 * @since 2022/06/06.
 */
public class HyperTree {
    private TreeMap<String, HypoList> hyperTree;
    private StringBuilder stringBuilder;

    /**
     * constructor of hyperTree.
     */
    public HyperTree() {
        hyperTree = new TreeMap<>();
        stringBuilder = new StringBuilder();
    }

    /**
     * getter of hyperTree.
     *
     * @return a full treemap.
     */
    public TreeMap<String, HypoList> getHyperTree() {
        return hyperTree;
    }

    /**
     * adds member to the tree.
     *
     * @param key the key to add to the tree.
     * @param hl  a list that is the value of the key.
     */
    public void addMember(String key, List<String> hl) {
        //if the key is already in the tree.
        if (hyperTree.containsKey(key)) {
            hyperTree.replace(key, hyperTree.get(key).addMultipleMembers(hl));
        } else {
            HypoList hypoList = new HypoList(hl);
            hyperTree.put(key, hypoList);
        }
    }

    /**
     * returns the list of the hypernym as a long string that will be printed.
     *
     * @param key the key that we want all his values.
     * @return a string.
     */
    public String toString(String key) {
        //we clean the stringBuilder.
        stringBuilder.setLength(0);
        for (int i = 0; i < hyperTree.get(key).getHypoList().size(); i++) {
            //appends each value to the string.
            stringBuilder.append(hyperTree.get(key).getHypoList().get(i).getHypoNym());
            stringBuilder.append(" (")
                    .append(hyperTree.get(key).getHypoList().get(i).getCounter().getValue()).append("), ");
        }
        //the last 2 characters is ", " which are unnecessary.
        return stringBuilder.substring(0, stringBuilder.length() - 2);
    }

    /**
     * sorts all the lists of all the keys.
     */
    public void sortHypoList() {
        for (String s : hyperTree.keySet()) {
            hyperTree.get(s).sortList();
        }
    }
}
