package Conjunctions;

/**
 * @author Tomer Peisikov <\tomerp1812@gmail.com>
 * ID 209549542
 * @version ass7.
 * @since 2022/06/06.
 */
public interface Regex {
    /**
     * checks all the regexes in all the lines. if one matches it goes to check and see
     * what words to add. and to where to add it.
     * @param line a line we check.
     */
    void checkRegex(String line);
}
