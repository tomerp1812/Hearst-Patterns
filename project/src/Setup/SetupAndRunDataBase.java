package Setup;

import Others.IO;
import StructureData.HyperTree;

/**
 * @author Tomer Peisikov <\tomerp1812@gmail.com>
 * ID 209549542
 * @version ass7.
 * @since 2022/06/06.
 */
public class SetupAndRunDataBase {
    private SentenceSetup sentenceSetup;
    private IO io;
    private HyperTree hyperTree;
    private String dir;
    private String outPutFile;

    /**
     * constructor of SetupAndRunDataBase.
     * @param args array of strings, input directory and and output directory.
     */
    public SetupAndRunDataBase(String[] args) {
        dir = args[0];
        outPutFile = args[1];
        hyperTree = new HyperTree();
        sentenceSetup = new SentenceSetup(hyperTree);
        io = new IO(sentenceSetup, hyperTree, dir, outPutFile);
    }

    /**
     * runs on all the files, sorts the list, and prints in file the conclusion.
     */
    public void run() {
        io.inputFiles();
        hyperTree.sortHypoList();
        io.outPutFiles();
    }
}



