import Setup.SetupAndRunDiscover;

/**
 * @author Tomer Peisikov <\tomerp1812@gmail.com>
 * ID 209549542
 * @version ass7.
 * @since 2022/06/06.
 */
public class DiscoverHypernym {
    /**
     * setups and runs the program.
     * @param args first args is a directory to the corpus. the second args is the directory to the output file.
     */
    public static void main(String[] args) {
        SetupAndRunDiscover setupAndRunDiscover = new SetupAndRunDiscover(args);
        //if no args.
        if (args[1] == null) {
            System.out.println("The lemma doesn't appear in the corpus.");
        } else {
            setupAndRunDiscover.run();
        }
    }
}
