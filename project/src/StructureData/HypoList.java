package StructureData;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Tomer Peisikov <\tomerp1812@gmail.com>
 * ID 209549542
 * @version ass7.
 * @since 2022/06/06.
 */
public class HypoList {
    private List<HypoNym> hypoList;
    private boolean isInList;

    /**
     * contructor of HypoList.
     * @param list list of strings to be added to the hypernym.
     */
    public HypoList(List<String> list) {
        hypoList = new ArrayList<>();
        addMultipleMembers(list);
    }

    /**
     * getter of hypoList.
     * @return a list of hypoNym.
     */
    public List<HypoNym> getHypoList() {
        return hypoList;
    }

    /**
     * sorts the list in descending order of amount of times
     * each hypoNym appeared in the list, and then by lexicographic order.
     */
    public void sortList() {
        hypoList = hypoList.stream().sorted().collect(Collectors.toList());
    }

    /**
     * adds multiple members to the list.
     * @param list list of strings.
     * @return an updated list.
     */
    public HypoList addMultipleMembers(List<String> list) {
        isInList = false;
        //if the hypoList is empty add to the list all the strings.
        if (hypoList.isEmpty()) {
            for (String s : list) {
                HypoNym hypoNym = new HypoNym(s);
                hypoList.add(hypoNym);
            }
        } else {
            //runs on all the members of the list and checks if they already exist in the hypoList
            for (String s : list) {
                for (HypoNym hn : hypoList) {
                    if (hn.getHypoNym().equals(s)) {
                        hn.addCount(hn.getCounter());
                        isInList = true;
                        break;
                    }
                }
                //if we the string is not in the hypoList we add him.
                if (!isInList) {
                    HypoNym hypoNym = new HypoNym(s);
                    hypoList.add(hypoNym);
                }
                isInList = false;
            }
        }
        return this;
    }


}