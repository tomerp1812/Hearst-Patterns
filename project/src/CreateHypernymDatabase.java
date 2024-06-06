import Setup.SetupAndRunDataBase;

/**
 * @author Tomer Peisikov <\tomerp1812@gmail.com>
 * ID 209549542
 * @version ass7.
 * @since 2022/06/06.
 */
public class CreateHypernymDatabase {
    /**
     * setups and runs the program.
     * @param args first string is the path to the directory of the corpus.
     *             second string is the lemma.
     */
    public static void main(String[] args) {
        SetupAndRunDataBase setup = new SetupAndRunDataBase(args);
        setup.run();
    }
}
