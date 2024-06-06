package StructureData;

import Others.Counter;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;
import java.util.stream.Collectors;

/**
 * @author Tomer Peisikov <\tomerp1812@gmail.com>
 * ID 209549542
 * @version ass7.
 * @since 2022/06/06.
 */
public class DiscoverTree {
    private TreeMap<String, HyperNym> treeMap;
    private List<HyperNym> treeList;

    /**
     * constructor of tree.
     */
    public DiscoverTree() {
        treeMap = new TreeMap<>();
        setList(new ArrayList<>());
    }

    /**
     * getter of treeMap.
     * @return the treeMap with string as keys and hypernym as value.
     */
    public TreeMap<String, HyperNym> getTreeMap() {
        return treeMap;
    }

    /**
     * adds member to the tree. if the tree already contains this member
     * just increases the counter by 1.
     * @param s the hypernym we want to add.
     */
    public void addMember(String s) {
        //if the tree contains the hypernym.
        if (treeMap.containsKey(s)) {
            treeMap.get(s).getCounter().increase(1);
        } else {
            //the tree does not contains the hypernym.
            HyperNym hyperNym = new HyperNym(s, new Counter(1));
            treeMap.put(s, hyperNym);
        }
    }

    /**
     * setter of list.
     * @param list list of hypernyms.
     */
    public void setList(List<HyperNym> list) {
        this.treeList = list;
    }

    /**
     * getter of list of hypernyms.
     * @return list of hypernyms.
     */
    public List<HyperNym> getTreeList() {
        return treeList;
    }

    /**
     * sorts the tree, by putting all the members in list and sorting the list.
     */
    public void sortTree() {
        List<HyperNym> list = new ArrayList<>();
        for (String s : treeMap.keySet()) {
            list.add(treeMap.get(s));
        }
        //sorts with a built-in sorting function of java. the comparator is being override.
        setList(list.stream().sorted().collect(Collectors.toList()));
    }

}
