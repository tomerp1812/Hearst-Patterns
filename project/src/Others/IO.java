package Others;

import Setup.SentenceSetup;
import StructureData.HyperTree;

import java.io.BufferedReader;
import java.io.PrintWriter;
import java.io.InputStreamReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.FileOutputStream;
import java.io.File;
import java.util.Locale;

/**
 * @author Tomer Peisikov <\tomerp1812@gmail.com>
 * ID 209549542
 * @version ass7.
 * @since 2022/06/06.
 */
public class IO {
    private PrintWriter os;
    private BufferedReader is;
    private SentenceSetup sentenceSetup;
    private HyperTree hyperTree;
    private File dir;
    private String[] fileNames;
    private String outPutFile;

    /**
     * first constructor of IO.
     *
     * @param sentenceSetup1 a sentenceSetup reference.
     * @param ht             hyperTree reference.
     * @param strDir         the directory of the corpus.
     * @param output         the output directory.
     */
    public IO(SentenceSetup sentenceSetup1, HyperTree ht, String strDir, String output) {
        setDir(strDir);
        setFileNames(dir.list());
        outPutFile = output;
        this.sentenceSetup = sentenceSetup1;
        this.hyperTree = ht;
    }

    /**
     * second constructor of IO.
     *
     * @param sentenceSetup1 a sentenceSetup reference.
     * @param strDir         the directory to the corpus.
     */
    public IO(SentenceSetup sentenceSetup1, String strDir) {
        setDir(strDir);
        setFileNames(dir.list());
        setSentence(sentenceSetup1);
    }

    /**
     * setter of the directory.
     *
     * @param strDir string of the directory of the corpus.
     */
    public void setDir(String strDir) {
        this.dir = new File(strDir);
    }

    /**
     * setter of FileNames.
     *
     * @param fileNames array of all the files in the corpus.
     */
    public void setFileNames(String[] fileNames) {
        this.fileNames = fileNames;
    }

    /**
     * setter of SentenceSetup.
     *
     * @param sentenceSetup a sentenceSetup.
     */
    public void setSentence(SentenceSetup sentenceSetup) {
        this.sentenceSetup = sentenceSetup;
    }

    /**
     * the function opens and reads all files, breaks each file to all it's lines and calls
     * configure function of the reference sentenceSetup.
     */
    public void inputFiles() {
        try {
            String line;
            //runs on all the files.
            for (String fileName : fileNames) {
                //creates new file with the directory.
                File f = new File(dir, fileName);
                is = new BufferedReader((new InputStreamReader(new FileInputStream(f))));
                while ((line = (is.readLine())) != null) {
                    sentenceSetup.configure(line.toLowerCase(Locale.ROOT));
                }
            }
        } catch (IOException e) {
            System.out.println(" Something went wrong while reading !");
        } finally {
            if (is != null) {
                try {
                    is.close();
                } catch (IOException e) {
                    System.out.println(" Failed closing the file !");
                }
            }
        }
    }

    /**
     * opens if needed a new file and writes there the output.
     */
    public void outPutFiles() {
        try {
            os = new PrintWriter(new OutputStreamWriter(new FileOutputStream(outPutFile)));
            //runs on all the keys of the hyperTree and prints them.
            for (String s1 : hyperTree.getHyperTree().keySet()) {
                //prints only those who has more than 2 hypoNym.
                if (hyperTree.getHyperTree().get(s1).getHypoList().size() > 2) {
                    os.print(s1 + ": ");
                    os.println(hyperTree.toString(s1));
                }
            }
        } catch (IOException e) {
            System.out.println("Something went wrong while writing!");
        } finally {
            if (os != null) {
                os.close();
            }
        }
    }
}
